// instantiated with jti.pl from Set
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.actor.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public interface Set_WeakReference_EventListener_ActorChangeEvent___
  extends ReadSet_WeakReference_EventListener_ActorChangeEvent___,
          WriteSet_WeakReference_EventListener_ActorChangeEvent___,
          Navigatable_Iterator_WeakReference_EventListener_ActorChangeEvent____,
          OfKnownSize
{
    public boolean contains (CallContext context, WeakReference_EventListener_ActorChangeEvent__ item);

    public void     set     (CallContext context, WeakReference_EventListener_ActorChangeEvent__ item);
    public void     add     (CallContext context, WeakReference_EventListener_ActorChangeEvent__ item) throws AlreadyExists;
    public void     replace (CallContext context, WeakReference_EventListener_ActorChangeEvent__ item) throws DoesNotExist;
    public void     unset   (CallContext context, WeakReference_EventListener_ActorChangeEvent__ item);
    public void     remove  (CallContext context, WeakReference_EventListener_ActorChangeEvent__ item) throws DoesNotExist;

    public Iterator_WeakReference_EventListener_ActorChangeEvent___ getNavigator (CallContext context);

    public long     getSize (CallContext context);
}

