// instantiated with jti.pl from VectorReferenceToMember
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.actor.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.reference.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.monitoring.*;

import com.sphenon.basics.many.returncodes.*;

public class VectorReferenceToMember_EventListener_ActorChangeEvent__long_
    implements ReferenceToMember_EventListener_ActorChangeEvent__long_ReadOnlyVector_EventListener_ActorChangeEvent__long__
{
    private ReadOnlyVector_EventListener_ActorChangeEvent__long_ vector;
    private long                          index;

    public VectorReferenceToMember_EventListener_ActorChangeEvent__long_ (CallContext context, ReadOnlyVector_EventListener_ActorChangeEvent__long_ vector, long index) {
        this.vector = vector;
        this.index  = index;
        assert vector.canGet(context, this.index) : SystemStateMessage.create(context, MessageText.create(context, "VectorIndex created with invalid index '%(index)'", "index", t.s(index)), ProblemState.ERROR);
    }

    public ReadOnlyVector_EventListener_ActorChangeEvent__long_ getContainer (CallContext context) {
        return this.vector;
    }

    public long getIndex (CallContext context) {
        return this.index;
    }

    public EventListener_ActorChangeEvent_ get (CallContext context) {
            try {
            return vector.get(context, this.index);
        } catch (DoesNotExist dne) {
            CustomaryContext.create(Context.create(context)).throwPreConditionViolation(context, dne, "VectorIndex contains invalid index '%(index)'", "index", t.s(index));
            throw (ExceptionPreConditionViolation) null; // compiler insists
        }
    }

    public boolean equals (Object object) {
        if (object == null) return false;
        if (! (object instanceof VectorReferenceToMember_EventListener_ActorChangeEvent__long_)) return false;
        if (((VectorReferenceToMember_EventListener_ActorChangeEvent__long_) object).vector != this.vector) return false;
        if (((VectorReferenceToMember_EventListener_ActorChangeEvent__long_) object).index  != this.index ) return false;
        return true;
    }

    public int hashCode () {
        return (this.vector.hashCode() ^ (int) this.index);
    }
}
