// instantiated with jti.pl from VectorImplList
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.debug.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.many.*;

import com.sphenon.basics.many.returncodes.*;

public class VectorImplList_SessionInfo_long_
  implements Vector_SessionInfo_long_, VectorImplList, Dumpable, ManagedResource {
    protected java.util.List vector;

    protected VectorImplList_SessionInfo_long_ (CallContext context) {
        vector = new java.util.ArrayList ();
    }

    static public VectorImplList_SessionInfo_long_ create (CallContext context) {
        return new VectorImplList_SessionInfo_long_(context);
    }

    protected VectorImplList_SessionInfo_long_ (CallContext context, java.util.List vector) {
        this.vector = vector;
    }

    static public VectorImplList_SessionInfo_long_ create (CallContext context, java.util.List vector) {
        return new VectorImplList_SessionInfo_long_(context, vector);
    }

    public SessionInfo get          (CallContext context, long index) throws DoesNotExist {
        try {
            return (SessionInfo) vector.get((int) index);
        } catch (IndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
    }

    public SessionInfo tryGet       (CallContext context, long index) {
        if (index < 0 || index >= vector.size()) {
            return null;
        }
        return (SessionInfo) vector.get((int) index);
    }

    public boolean  canGet       (CallContext context, long index) {
        return (index >= 0 && index < vector.size()) ? true : false;
    }

    public VectorReferenceToMember_SessionInfo_long_ getReference    (CallContext context, long index) throws DoesNotExist {
        if ( ! canGet(context, index)) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
        return new VectorReferenceToMember_SessionInfo_long_(context, this, index);
    }

    public VectorReferenceToMember_SessionInfo_long_ tryGetReference (CallContext context, long index) {
        if ( ! canGet(context, index)) { return null; }
        return new VectorReferenceToMember_SessionInfo_long_(context, this, index);
    }

    public SessionInfo set          (CallContext context, long index, SessionInfo item) {
        while (index > vector.size()) { vector.add(null); }
        if( index == vector.size()) {
            vector.add(item);
            return null;
        } else {
            return (SessionInfo) vector.set((int) index, item);
        }
    }

    public void     add          (CallContext context, long index, SessionInfo item) throws AlreadyExists {
        if (index < vector.size()) { AlreadyExists.createAndThrow (context); }
        set(context, index, item);
    }

    public void     prepend      (CallContext call_context, SessionInfo item) {
        if (vector.size() == 0) {
            vector.add(item);
        } else {
            vector.add(0, item);
        }
    }

    public void     append       (CallContext context, SessionInfo item) {
        vector.add(item);
    }

    public void     insertBefore (CallContext context, long index, SessionInfo item) throws DoesNotExist {
        try {
            vector.add((int) index, item);
        } catch (IndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow(context);
        }
    }

    public void     insertBehind (CallContext context, long index, SessionInfo item) throws DoesNotExist {
        if (index == vector.size() - 1) {
            vector.add(item);
        } else {
            try {
                vector.add((int) index + 1, item);
            } catch (IndexOutOfBoundsException e) {
                DoesNotExist.createAndThrow (context);
            }
        }
    }

    public SessionInfo replace      (CallContext call_context, long index, SessionInfo item) throws DoesNotExist {
        try {
            return (SessionInfo) vector.set((int) index, item);
        } catch (IndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow(call_context);
            throw (DoesNotExist) null;
        }
    }

    public SessionInfo unset        (CallContext context, long index) {
        try {
            return (SessionInfo) vector.remove((int) index);
        } catch (IndexOutOfBoundsException e) {
            // we kindly ignore this exception
            return null;
        }
    }

    public SessionInfo remove       (CallContext context, long index) throws DoesNotExist {
        try {
            return (SessionInfo) vector.remove((int) index);
        } catch (IndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null;
        }
    }

    public IteratorItemIndex_SessionInfo_long_ getNavigator (CallContext context) {
        return new VectorIteratorImpl_SessionInfo_long_ (context, this);
    }

    public long     getSize      (CallContext context) {
        return vector.size();
    }

    // to be used with care
    public java.util.List getImplementationList (CallContext context) {
        return this.vector;
    }

    public java.util.Iterator<SessionInfo> getIterator_SessionInfo_ (CallContext context) {
        return vector.iterator();
    }

    public java.util.Iterator getIterator (CallContext context) {
        return getIterator_SessionInfo_(context);
    }

    public VectorIterable_SessionInfo_long_ getIterable_SessionInfo_ (CallContext context) {
        return new VectorIterable_SessionInfo_long_(context, this);
    }

    public Iterable<SessionInfo> getIterable (CallContext context) {
        return getIterable_SessionInfo_ (context);
    }


    public void release(CallContext context) {
        if (this.vector != null && this.vector instanceof ManagedResource) {
            ((ManagedResource)(this.vector)).release(context);
        }
    }

    public void dump(CallContext context, DumpNode dump_node) {
        int i=1;
        for (Object o : vector) {
            dump_node.dump(context, (new Integer(i++)).toString(), o);
        }
    }
}
