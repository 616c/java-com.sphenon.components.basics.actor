// instantiated with jti.pl from ReadOnlyVector
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.actor.*;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public interface ReadOnlyVector_EventListener_ActorChangeEvent__long_
  extends ReadVector_EventListener_ActorChangeEvent__long_,
          ReadOnlyVector<EventListener_ActorChangeEvent_>,
          OfKnownSize
{
    public EventListener_ActorChangeEvent_                                    get             (CallContext context, long index) throws DoesNotExist;
    public EventListener_ActorChangeEvent_                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_EventListener_ActorChangeEvent__long_ReadOnlyVector_EventListener_ActorChangeEvent__long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_EventListener_ActorChangeEvent__long_ReadOnlyVector_EventListener_ActorChangeEvent__long__  tryGetReference (CallContext context, long index);
}

