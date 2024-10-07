// instantiated with jti.pl from VectorIterable
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.actor.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public class VectorIterable_EventListener_ActorChangeEvent__long_ implements Iterable<EventListener_ActorChangeEvent_>
{
    protected java.util.Iterator<EventListener_ActorChangeEvent_> iterator;

    public VectorIterable_EventListener_ActorChangeEvent__long_ (CallContext context, Vector_EventListener_ActorChangeEvent__long_ vector) {
        this.iterator = (vector == null ? (new java.util.Vector<EventListener_ActorChangeEvent_>()).iterator() : vector.getIterator_EventListener_ActorChangeEvent__(context));
    }

    public java.util.Iterator<EventListener_ActorChangeEvent_> iterator () {
        return this.iterator;
    }
}

