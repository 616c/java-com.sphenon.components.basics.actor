// instantiated with jti.pl from WriteSet
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.actor.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface WriteSet_WeakReference_EventListener_ActorChangeEvent___
{
    // adds item, may already exist
    public void     set     (CallContext context, WeakReference_EventListener_ActorChangeEvent__ item);

    // adds item, must not already exist
    public void     add     (CallContext context, WeakReference_EventListener_ActorChangeEvent__ item) throws AlreadyExists;

    // replace item, must already exist
    public void     replace (CallContext context, WeakReference_EventListener_ActorChangeEvent__ item) throws DoesNotExist;
    // does this method make any sense?
    // should'nt it be? : 
    // public void     replace (CallContext context, WeakReference_EventListener_ActorChangeEvent__ item, WeakReference_EventListener_ActorChangeEvent__ item) throws DoesNotExist;

    // removes item, need not exist
    public void     unset   (CallContext context, WeakReference_EventListener_ActorChangeEvent__ item);

    // removes item, must exist
    public void     remove  (CallContext context, WeakReference_EventListener_ActorChangeEvent__ item) throws DoesNotExist;
}

