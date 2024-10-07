// instantiated with jti.pl from VectorIteratorImpl
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.actor.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

import java.util.Hashtable;

public class VectorIteratorImpl_EventListener_ActorChangeEvent__long_
    implements IteratorItemIndex_EventListener_ActorChangeEvent__long_,
               Cloneable
{
    private ReadOnlyVector_EventListener_ActorChangeEvent__long_ vector;
    private long current_index;

    public VectorIteratorImpl_EventListener_ActorChangeEvent__long_ (CallContext context, ReadOnlyVector_EventListener_ActorChangeEvent__long_ vector) {
        this.vector = vector;
        this.current_index = 0;
    }

    public void     next          (CallContext context) {
        // if (this.current_index < this.vector.getSize(context))
           this.current_index++;
    }

    public long getCurrentIndex (CallContext context) throws DoesNotExist {
        return this.current_index;
    }

    public long tryGetCurrentIndex (CallContext context) {
        return this.current_index;
    }

    public EventListener_ActorChangeEvent_ getCurrent    (CallContext context) throws DoesNotExist {
        return vector.get(context, this.current_index);
    }

    public EventListener_ActorChangeEvent_ tryGetCurrent (CallContext context) {
        return vector.tryGet(context, this.current_index);
    }

    public boolean  canGetCurrent (CallContext context) {
        return vector.canGet(context, this.current_index);
    }

    public Reference_EventListener_ActorChangeEvent__ getReferenceToCurrent (CallContext context) throws DoesNotExist {
        return vector.getReference(context, this.current_index);
    }

    public Reference_EventListener_ActorChangeEvent__ tryGetReferenceToCurrent (CallContext context) {
        return vector.tryGetReference(context, this.current_index);
    }

    public VectorIteratorImpl_EventListener_ActorChangeEvent__long_ clone(CallContext context) {
        try {
            return (VectorIteratorImpl_EventListener_ActorChangeEvent__long_) super.clone();
        } catch (CloneNotSupportedException cnse) { return null; }
    }
}
