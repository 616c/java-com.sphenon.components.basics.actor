// instantiated with jti.pl from VectorIterable
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public class VectorIterable_SessionInfo_long_ implements Iterable<SessionInfo>
{
    protected java.util.Iterator<SessionInfo> iterator;

    public VectorIterable_SessionInfo_long_ (CallContext context, Vector_SessionInfo_long_ vector) {
        this.iterator = (vector == null ? (new java.util.Vector<SessionInfo>()).iterator() : vector.getIterator_SessionInfo_(context));
    }

    public java.util.Iterator<SessionInfo> iterator () {
        return this.iterator;
    }
}

