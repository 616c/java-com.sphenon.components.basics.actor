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
import com.sphenon.basics.message.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.actor.tplinst.*;

public class SessionContext extends SpecificContext {

    static protected SessionContext default_singleton;
    protected boolean is_default_singleton;

    static public SessionContext get(Context context) {
        SessionContext session_context = (SessionContext) context.getSpecificContext(SessionContext.class);
        if (session_context != null) {
            return session_context;
        }
        return default_singleton == null ? (default_singleton = new SessionContext(context, true)) : default_singleton;
    }

    static public SessionContext create(Context context) {
        SessionContext session_context = new SessionContext(context, false);
        context.setSpecificContext(SessionContext.class, session_context);
        return session_context;
    }

    protected SessionContext (Context context, boolean is_default_singleton) {
        super(context);
        this.is_default_singleton = is_default_singleton;
        this.session = null;
    }

    protected Session session;

    public void setSession(CallContext context, Session session) {
        if (this.getSession(context) != null) {
            CustomaryContext cc = CustomaryContext.create((Context)context);
            cc.throwPreConditionViolation(context, SessionStringPool.get(context, "0.0.0" /* Context Stack already contains a Session object (session override not allowed) */));
            throw (ExceptionPreConditionViolation) null; // compiler insists
        }
        this.session = session;
    }

    public Session getSession(CallContext cc) {
        if (is_default_singleton) { return null; }
        SessionContext session_context;
        return (this.session != null ?
                     this.session
                  : (session_context = (SessionContext) this.getCallContext(SessionContext.class)) != null ?
                       session_context.getSession(cc)
                     : null
               );
    }
}
