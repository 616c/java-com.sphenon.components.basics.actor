// instantiated with jti.pl from SetImpl
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.actor.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

import java.util.Hashtable;

public class SetImpl_WeakReference_EventListener_ActorChangeEvent___
  implements Set_WeakReference_EventListener_ActorChangeEvent___
{
    private java.util.Hashtable map;

    public SetImpl_WeakReference_EventListener_ActorChangeEvent___ (CallContext context)
    {
    }

    protected void initialise(CallContext context) {
        if (map == null) {
            map = new java.util.Hashtable(4);
        }
    }

    public SetImpl_WeakReference_EventListener_ActorChangeEvent___ (CallContext context, java.util.Hashtable map)
    {
        this.map = map;
    }

    public boolean  contains (CallContext context, WeakReference_EventListener_ActorChangeEvent__ item)
    {
        return (map == null ? false : map.containsKey(item));
    }

    public void     set     (CallContext context, WeakReference_EventListener_ActorChangeEvent__ item)
    {
        initialise(context);
        map.put(item, item);
    }

    public void     add     (CallContext context, WeakReference_EventListener_ActorChangeEvent__ item) throws AlreadyExists
    {
        initialise(context);
        if (map.containsKey(item)) AlreadyExists.createAndThrow (context);
        map.put(item, item);
    }

    public void     replace (CallContext context, WeakReference_EventListener_ActorChangeEvent__ item) throws DoesNotExist
    {
        initialise(context);
        if (!map.containsKey(item)) DoesNotExist.createAndThrow (context);
        map.put(item, item);
    }

    public void     unset   (CallContext context, WeakReference_EventListener_ActorChangeEvent__ item)
    {
        initialise(context);
        map.remove(item);
    }

    public void     remove  (CallContext context, WeakReference_EventListener_ActorChangeEvent__ item) throws DoesNotExist
    {
        initialise(context);
        if (!map.containsKey(item)) DoesNotExist.createAndThrow (context);
        map.remove(item);
    }

    public Iterator_WeakReference_EventListener_ActorChangeEvent___ getNavigator (CallContext context)
    {
        initialise(context);
        return new SetIteratorImpl_WeakReference_EventListener_ActorChangeEvent___ (context, map);
    }

    public long     getSize (CallContext context)
    {
        return (map == null ? 0L : map.size());
    }
}

