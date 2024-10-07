package com.sphenon.basics.session;

/****************************************************************************
  Copyright 2001-2024 Sphenon GmbH

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
import java.lang.ref.WeakReference;

public class SessionInfo {
    static protected long notification_level;
    static public    long adjustNotificationLevel(long new_level) { long old_level = notification_level; notification_level = new_level; return old_level; }
    static public    long getNotificationLevel() { return notification_level; }
    static { notification_level = NotificationLocationContext.getLevel(RootContext.getInitialisationContext(), "com.sphenon.basics.session.SessionInfo"); };

    protected WeakReference<Session> session_ref;

    public SessionInfo (CallContext context, Session session) {
        this.session_ref = new WeakReference<Session>(session);
    }

    public String getAge(CallContext context) {
        Session session = this.session_ref.get();
        if (session == null) { return ""; }
        long age = (new Date()).getTime() - session.getCreationTime(context).getTime();
        age /= 1000;
        long s = age % 60;
        age -= s;
        age /= 60;
        long m = age % 60;
        age -= m;
        age /= 60;
        long h = age % 24;
        age -= h;
        age /= 24;
        long d = age;
        return String.format("%1$dd %2$02d:%3$02d:%4$02d", d, h, m, s);
    }

    public String getIdleTime(CallContext context) {
        Session session = this.session_ref.get();
        if (session == null) { return ""; }
        long age = (new Date()).getTime() - session.getLastAccessTime(context).getTime();
        age /= 1000;
        long s = age % 60;
        age -= s;
        age /= 60;
        long m = age % 60;
        age -= m;
        age /= 60;
        long h = age % 24;
        age -= h;
        age /= 24;
        long d = age;
        return String.format("%1$dd %2$02d:%3$02d:%4$02d", d, h, m, s);
    }

    public String getState(CallContext context) {
        Session session = this.session_ref.get();
        return session == null ? "finalized" : (session.getClientSessionCount(context) == 0 ? "unused" : "active");
    }

    public int getClientSessionCount (CallContext context) {
        Session session = this.session_ref.get();
        return session == null ? 0 : session.getClientSessionCount(context);
    }

    public String getActor (CallContext context) {
        Session session = this.session_ref.get();
        return session == null ? "" : (session.getActor(context) == null ? "anonymous" : session.getActor(context).getName(context));
    }

    public String getConnection (CallContext context) {
        Session session = this.session_ref.get();
        return session == null ? "" : session.getConnection(context).toString();
    }

    static public Vector_SessionInfo_long_ getCurrentSessions(CallContext context) {
        Vector_SessionInfo_long_ sessions = Factory_Vector_SessionInfo_long_.construct(context);
        for (HashableWeakReference<Session> session_ref : Session.getSessions(context).keySet()) {
            Session session = session_ref.get();
            if (session != null) {
                sessions.append(context, new SessionInfo(context, session));
            }
        }
        return sessions;
    }
}
