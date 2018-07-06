package com.sphenon.basics.session;

/****************************************************************************
  Copyright 2001-2018 Sphenon GmbH

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations
  under the License.
*****************************************************************************/

import com.sphenon.basics.context.*;
import com.sphenon.basics.context.classes.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.metadata.*;
import com.sphenon.basics.many.*;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.actor.tplinst.*;

import java.util.Date;
import java.util.WeakHashMap;

public class Session {
    static protected long notification_level;
    static public    long adjustNotificationLevel(long new_level) { long old_level = notification_level; notification_level = new_level; return old_level; }
    static public    long getNotificationLevel() { return notification_level; }
    static { notification_level = NotificationLocationContext.getLevel(RootContext.getInitialisationContext(), "com.sphenon.basics.session.Session"); };

    protected OSet_SessionData_Type_ ossd;

    protected Date created;
    protected Date accessed;
    static protected long next_id;
    protected long id;

    public Session (CallContext context) {
        this.ossd = new OSetImpl_SessionData_Type_(context);

        this.created = new Date();
        this.accessed = new Date();
        synchronized (Session.class) {
            this.id = next_id++;
            sessions.put(this, this.id);
        }
    }

    public static Session get(CallContext context) {
        SessionContext sc = SessionContext.get((Context) context);
        Session s = sc.getSession(context);
        if (s != null) { s.touch(context); }
        return s;
    }

    public void touch (CallContext context) {
        this.accessed = new Date();
    }

    public Date getCreationTime (CallContext context) {
        return this.created;
    }

    public Date getLastAccessTime (CallContext context) {
        return this.accessed;
    }

    public long getId (CallContext context) {
        return this.id;
    }

    public void setSessionData(CallContext context, SessionData session_data) {
        this.accessed = new Date();

        synchronized (this.ossd) {
            this.ossd.set(context, session_data);
        }

        if (this.client_sessions > 0) {
            session_data.notifyClientSessionBegin(context, this.client_sessions);
        }
    }

    public SessionData getSessionData(CallContext call_context, Type type) {
        this.accessed = new Date();

        Context context = (Context) call_context;
        Set_SessionData_ ssd;
        synchronized (this.ossd) {
            ssd = this.ossd.tryGet(context, type);
        }
        if (ssd == null || ssd.getSize(context) == 0) {
            return null;
        }
        if (ssd.getSize(context) > 1L) {
            if ((this.notification_level & Notifier.MONITORING) != 0) {
                CustomaryContext.create(context).sendWarning(context, SessionStringPool.get(context, "0.1.0" /* While retrieving session data of type '%(type)' more than one matching object was found; this typically indicates improper use of the session data storage and may cause incoherent behaviour due to mismatching usage of those objects */), "type", type.getName(context));
            }
        }
        Iterator_SessionData_ isd = ssd.getNavigator(context);
        return isd.tryGetCurrent(context);
    }

    protected int client_sessions = 0;

    public int getClientSessionCount (CallContext context) {
        return this.client_sessions;
    }

    public void notifyClientSessionBegin (CallContext context) {
        this.accessed = new Date();

        this.client_sessions++;

        if ((notification_level & Notifier.DIAGNOSTICS) != 0) { CustomaryContext.create(Context.create(context)).sendTrace(context, Notifier.DIAGNOSTICS, "Session: client session begins, now %(count) client sessions", "count", t.s(this.client_sessions)); }

        synchronized (this.ossd) {
            for (Iterator_SessionData_ isd = ossd.getNavigator(context);
                 isd.canGetCurrent(context);
                 isd.next(context)
                ) {
                isd.tryGetCurrent(context).notifyClientSessionBegin(context, this.client_sessions);
            }
        }
    }

    public void notifyClientSessionEnd (CallContext context) {
        this.accessed = new Date();

        this.client_sessions--;

        if ((notification_level & Notifier.DIAGNOSTICS) != 0) { CustomaryContext.create(Context.create(context)).sendTrace(context, Notifier.DIAGNOSTICS, "Session: client session ends, now %(count) client sessions", "count", t.s(this.client_sessions)); }

        synchronized (this.ossd) {
            for (Iterator_SessionData_ isd = ossd.getNavigator(context);
                 isd.canGetCurrent(context);
                 isd.next(context)
                ) {
                isd.tryGetCurrent(context).notifyClientSessionEnd(context, this.client_sessions);
            }
        }
    }

    protected void finalize() throws Throwable {
        CallContext context = RootContext.getDestructionContext();
        if ((notification_level & Notifier.SELF_DIAGNOSTICS) != 0) { CustomaryContext.create(Context.create(context)).sendTrace(context, Notifier.SELF_DIAGNOSTICS, "Session finalized."); }

        // session monitoring
        synchronized (Session.class) {
            sessions.remove(this);
        }
    }

    protected Actor actor;

    public Actor getActor (CallContext context) {
        return this.actor;
    }

    public void setActor (CallContext context, Actor new_actor) {
        Actor old_actor = this.actor;
        this.actor = new_actor;
        if ((notification_level & Notifier.DIAGNOSTICS) != 0) { CustomaryContext.create(Context.create(context)).sendTrace(context, Notifier.DIAGNOSTICS, "Session: actor changed to %(new_actor)", "new_actor", new_actor); }
        if (this.event_dispatcher_actor_change_event != null) {
            if ((notification_level & Notifier.SELF_DIAGNOSTICS) != 0) { CustomaryContext.create(Context.create(context)).sendTrace(context, Notifier.SELF_DIAGNOSTICS, "emitting actor change event..."); }
            this.event_dispatcher_actor_change_event.notify(context, new ActorChangeEvent(context, old_actor, new_actor));
        }
    }

    protected Connection connection;

    public Connection getConnection (CallContext context) {
        return this.connection;
    }

    public void setConnection (CallContext context, Connection new_connection) {
        Connection old_connection = this.connection;
        this.connection = new_connection;
    }

    protected EventDispatcher_ActorChangeEvent_ event_dispatcher_actor_change_event;

    public EventDispatcher_ActorChangeEvent_ getEventDispatcherActorChangeEvent (CallContext context) {
        if (this.event_dispatcher_actor_change_event == null) {
            this.event_dispatcher_actor_change_event = new EventDispatcher_ActorChangeEvent_(context);
        }
        return this.event_dispatcher_actor_change_event;
    }

    // --------------------------------------------------------------------------------------
    // session monitoring

    static protected DoubleWeakHashMap<Session,Long> sessions = new DoubleWeakHashMap<Session,Long>();

    /**
       This function returns the internal cache to get access to the current
       server state for monitoring purposes. CAUTION: care has to be taken
       when using this data, since this is a weak map. The references to the
       respective sessions must not be stored permanently, other wise the
       server will never free them which will cause memory leaks or overflow.
     */
    static public DoubleWeakHashMap<Session,Long> getSessions(CallContext context) {
        return sessions;
    }

    static public Session getById(CallContext context, long id) {
        for (HashableWeakReference<Session> hwr : sessions.keySet()) {
            Session s = (hwr != null ? hwr.get() : null);
            if (s != null && id == s.getId(context)) {
                return s;
            }
        }
        return null;
    }
}
