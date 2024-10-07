// instantiated with jti.pl from Iterator
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.actor.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface Iterator_WeakReference_EventListener_ActorChangeEvent___
    extends com.sphenon.basics.many.Iterator<WeakReference_EventListener_ActorChangeEvent__>
{
    // advances iterator; if there is no next item iterator becomes invalid
    public void     next          (CallContext context);

    // returns current item; item must exist
    public WeakReference_EventListener_ActorChangeEvent__ getCurrent    (CallContext context) throws DoesNotExist;

    // like "getCurrent", but returns null instead of throwing exception
    public WeakReference_EventListener_ActorChangeEvent__ tryGetCurrent (CallContext context);

    // returns true if there is a current item available
    public boolean  canGetCurrent (CallContext context);

    // creates a clone of this iterator, pointing to exactly
    // the same position as yonder
    public Iterator_WeakReference_EventListener_ActorChangeEvent___ clone(CallContext context);
}
