// instantiated with jti.pl from Vector
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.actor.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

import com.sphenon.ui.annotations.*;

@UIId("")
@UIName("")
@UIClassifier("Vector_EventListener_ActorChangeEvent__")
@UIParts("js:instance.getIterable(context)")
public interface Vector_EventListener_ActorChangeEvent__long_
  extends ReadOnlyVector_EventListener_ActorChangeEvent__long_,
          WriteVector_EventListener_ActorChangeEvent__long_
          , GenericVector<EventListener_ActorChangeEvent_>
          , GenericIterable<EventListener_ActorChangeEvent_>
{
    public EventListener_ActorChangeEvent_                                    get             (CallContext context, long index) throws DoesNotExist;
    public EventListener_ActorChangeEvent_                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_EventListener_ActorChangeEvent__long_ReadOnlyVector_EventListener_ActorChangeEvent__long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_EventListener_ActorChangeEvent__long_ReadOnlyVector_EventListener_ActorChangeEvent__long__  tryGetReference (CallContext context, long index);

    public EventListener_ActorChangeEvent_                                    set             (CallContext context, long index, EventListener_ActorChangeEvent_ item);
    public void                                        add             (CallContext context, long index, EventListener_ActorChangeEvent_ item) throws AlreadyExists;
    public void                                        prepend         (CallContext context, EventListener_ActorChangeEvent_ item);
    public void                                        append          (CallContext context, EventListener_ActorChangeEvent_ item);
    public void                                        insertBefore    (CallContext context, long index, EventListener_ActorChangeEvent_ item) throws DoesNotExist;
    public void                                        insertBehind    (CallContext context, long index, EventListener_ActorChangeEvent_ item) throws DoesNotExist;
    public EventListener_ActorChangeEvent_                                    replace         (CallContext context, long index, EventListener_ActorChangeEvent_ item) throws DoesNotExist;
    public EventListener_ActorChangeEvent_                                    unset           (CallContext context, long index);
    public EventListener_ActorChangeEvent_                                    remove          (CallContext context, long index) throws DoesNotExist;

    public IteratorItemIndex_EventListener_ActorChangeEvent__long_       getNavigator    (CallContext context);

    public long                                        getSize         (CallContext context);

    // for sake of Iterable's
    public java.util.Iterator<EventListener_ActorChangeEvent_>              getIterator_EventListener_ActorChangeEvent__ (CallContext context);
    public java.util.Iterator                          getIterator (CallContext context);
    public VectorIterable_EventListener_ActorChangeEvent__long_          getIterable_EventListener_ActorChangeEvent__ (CallContext context);
    public Iterable<EventListener_ActorChangeEvent_> getIterable (CallContext context);
}
