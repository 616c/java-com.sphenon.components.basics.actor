// instantiated with jti.pl from WeakReference
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.actor.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.event.*;

import java.lang.ref.WeakReference;

public class WeakReference_EventListener_ActorChangeEvent__
    extends WeakReference
{
    public WeakReference_EventListener_ActorChangeEvent__ (CallContext context, EventListener_ActorChangeEvent_ t) {
        super(t);
    }

    public EventListener_ActorChangeEvent_ getTyped (CallContext call_context) {
        try {
            return (EventListener_ActorChangeEvent_) this.get();
        } catch (ClassCastException cce) {
            Context context = Context.create(call_context);
            CustomaryContext cc = CustomaryContext.create(context);
            cc.throwProtocolViolation(context, EventStringPool.get(context, "0.1.0" /* Typed WeakReference contains invalid type */));
            throw (ExceptionProtocolViolation) null; // compiler insists
        }
    }

    public boolean equals (Object o) {
        try {
            WeakReference wr = (WeakReference) o;
            Object my_o = this.get();
            return (my_o == null || wr == null ? false : my_o.equals(wr.get()));
        } catch (ClassCastException cce) {
            return false;
        }
    }

    public int hashCode () {
        return this.get().hashCode();
    }
}

