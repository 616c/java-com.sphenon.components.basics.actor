// instantiated with jti.pl from WriteVector
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.actor.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface WriteVector_EventListener_ActorChangeEvent__long_
{
    public EventListener_ActorChangeEvent_ set          (CallContext context, long index, EventListener_ActorChangeEvent_ item);
    public void     add          (CallContext context, long index, EventListener_ActorChangeEvent_ item) throws AlreadyExists;
    public void     prepend      (CallContext context, EventListener_ActorChangeEvent_ item);
    public void     append       (CallContext context, EventListener_ActorChangeEvent_ item);
    public void     insertBefore (CallContext context, long index, EventListener_ActorChangeEvent_ item) throws DoesNotExist;
    public void     insertBehind (CallContext context, long index, EventListener_ActorChangeEvent_ item) throws DoesNotExist;
    public EventListener_ActorChangeEvent_ replace      (CallContext context, long index, EventListener_ActorChangeEvent_ item) throws DoesNotExist;
    public EventListener_ActorChangeEvent_ unset        (CallContext context, long index);
    public EventListener_ActorChangeEvent_ remove       (CallContext context, long index) throws DoesNotExist;
}

