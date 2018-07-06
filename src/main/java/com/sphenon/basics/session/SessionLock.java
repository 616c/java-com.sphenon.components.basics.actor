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
import com.sphenon.basics.metadata.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.session.*;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class SessionLock implements SessionData {

    static final public Class _class = SessionLock.class;

    static protected long notification_level;
    static public    long adjustNotificationLevel(long new_level) { long old_level = notification_level; notification_level = new_level; return old_level; }
    static public    long getNotificationLevel() { return notification_level; }
    static { notification_level = NotificationLocationContext.getLevel(_class); };
  
    ReentrantLock lock = new ReentrantLock();

    public static SessionLock get (CallContext context) {
        CustomaryContext cc = (((notification_level & Notifier.DIAGNOSTICS) != 0) ? CustomaryContext.create((Context) context) : null);
        Session s = Session.get((Context) context);
        synchronized (s) {
            SessionLock session_lock = (SessionLock) s.getSessionData(context, TypeManager.get(context, SessionLock.class));
            if (session_lock == null) {
                session_lock = new SessionLock(context);
                s.setSessionData(context, session_lock);
                if ((notification_level & Notifier.DIAGNOSTICS) != 0) { cc.sendTrace(context, Notifier.DIAGNOSTICS, "Created SessionLock '%(securitysessiondata)' for session '%(session)'", "securitysessiondata", session_lock, "session", s); }
            }
            return session_lock;
        }
    }
    
    static public void aquireSessionLock (CallContext context) {
        SessionLock.get(context).aquireLock(context);
    }

    static public void releaseSessionLock (CallContext context) {
        SessionLock.get(context).releaseLock(context);
    }

    static public boolean tryAquireSessionLock (CallContext context, long millisec) {
        return SessionLock.get(context).tryAquireLock(context, millisec);
    }

    private SessionLock(CallContext call_context) {
    }

    public void notifyClientSessionBegin (CallContext context, int client_sessions) {
    }

    public void notifyClientSessionEnd (CallContext context, int client_sessions) {
    }

    public void aquireLock (CallContext context) {
        this.lock.lock();
    }

    public void releaseLock (CallContext context) {
        this.lock.unlock();
    }      
  
    public boolean tryAquireLock (CallContext context, long millisec) {
        boolean success = false;
        if (millisec == 0) {
            success = this.lock.tryLock();
        } else {
            try {
                success =  this.lock.tryLock(millisec, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                if ((notification_level & Notifier.MONITORING) != 0) {
                    CustomaryContext cc = (((notification_level & Notifier.DIAGNOSTICS) != 0) ? CustomaryContext.create((Context) context) : null);
                    cc.sendTrace(context, Notifier.MONITORING, "Could not obtain SessionLock for Thread %(thread) thread was interrupted before timeout", "thread", Thread.currentThread().getId(), "lock", lock.toString());
                }
            }
        }
        return success;
    }
}
