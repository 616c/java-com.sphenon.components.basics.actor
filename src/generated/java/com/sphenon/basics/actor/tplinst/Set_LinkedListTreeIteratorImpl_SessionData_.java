// instantiated with jti.pl from Set_LinkedListTreeIteratorImpl
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.metadata.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;

import com.sphenon.basics.many.returncodes.*;

import java.util.Hashtable;

public class Set_LinkedListTreeIteratorImpl_SessionData_
    implements Iterator_SessionData_
{
    private java.util.LinkedList linked_list;
    private java.util.ListIterator list_iterator;
    Set_LinkedListTreeIteratorImpl_SessionData_ sub_iterator;
    private SessionData current;

    public Set_LinkedListTreeIteratorImpl_SessionData_ (CallContext context, java.util.LinkedList linked_list) {
        this.linked_list = linked_list;
        this.list_iterator = linked_list.listIterator(0);

        this.next(context);
    }

    public void     next          (CallContext context)
    {
        if (sub_iterator != null) {
            sub_iterator.next(context);
            if (sub_iterator.canGetCurrent(context)) {
                this.current = sub_iterator.tryGetCurrent(context);
                return;
            }
            sub_iterator = null;
        }
        if (this.list_iterator.hasNext()) {
            Object o = this.list_iterator.next();
            if (o == null || o instanceof SessionData) {
                this.current = (SessionData) o;
            } else {
                Set_LinkedListTreeImpl_SessionData_ sllti = ((Set_LinkedListTreeImpl_SessionData_)o);
                sub_iterator = (Set_LinkedListTreeIteratorImpl_SessionData_) (sllti.getNavigator(context));
                if (sub_iterator.canGetCurrent(context)) {
                    this.current = sub_iterator.tryGetCurrent(context);
                } else {
                    sub_iterator = null;
                    next(context);
                }
            }
        } else {
            this.current = null;
        }
    }

    public SessionData getCurrent    (CallContext context) throws DoesNotExist
    {
        if (this.current == null) DoesNotExist.createAndThrow(context);
        return this.current;
    }

    public SessionData tryGetCurrent (CallContext context)
    {
        return this.current;
    }

    public boolean  canGetCurrent (CallContext context)
    {
        return (this.current != null) ? true : false;
    }

    public SetIteratorImpl_SessionData_ clone(CallContext context) {
        CustomaryContext.create((Context)context).throwLimitation(context, "cannot clone, Set_LinkedListTreeIteratorImpl is not cloneable");
        throw (ExceptionLimitation) null; // compiler insists
    }
}

