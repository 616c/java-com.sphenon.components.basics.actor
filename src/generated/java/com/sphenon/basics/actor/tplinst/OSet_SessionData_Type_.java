// instantiated with jti.pl from OSet
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.metadata.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public interface OSet_SessionData_Type_
  extends ReadMap_Set_SessionData__Type_,
          WriteSet_SessionData_,
          Navigatable_Iterator_SessionData__,
          OfKnownSize
{
    public Set_SessionData_ get        (CallContext context, Type index) throws DoesNotExist;
    public Set_SessionData_ tryGet     (CallContext context, Type index);
    public boolean       canGet     (CallContext context, Type index);

    public Set_SessionData_ getMany    (CallContext context, Type index) throws DoesNotExist;
    public Set_SessionData_ tryGetMany (CallContext context, Type index);
    public boolean       canGetMany (CallContext context, Type index);

    public SessionData      getSole    (CallContext context, Type index) throws DoesNotExist, MoreThanOne;
    public SessionData      tryGetSole (CallContext context, Type index);
    public boolean       canGetSole (CallContext context, Type index);

    public void          set        (CallContext context, SessionData item);
    public void          add        (CallContext context, SessionData item) throws AlreadyExists;
    public void          replace    (CallContext context, SessionData item) throws DoesNotExist;
    public void          unset      (CallContext context, SessionData item);
    public void          remove     (CallContext context, SessionData item) throws DoesNotExist;

    public Iterator_SessionData_ getNavigator (CallContext context);

    public long          getSize (CallContext context);
}

