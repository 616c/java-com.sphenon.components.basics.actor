// instantiated with jti.pl from Set
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

public interface Set_SessionData_
  extends ReadSet_SessionData_,
          WriteSet_SessionData_,
          Navigatable_Iterator_SessionData__,
          OfKnownSize
{
    public boolean contains (CallContext context, SessionData item);

    public void     set     (CallContext context, SessionData item);
    public void     add     (CallContext context, SessionData item) throws AlreadyExists;
    public void     replace (CallContext context, SessionData item) throws DoesNotExist;
    public void     unset   (CallContext context, SessionData item);
    public void     remove  (CallContext context, SessionData item) throws DoesNotExist;

    public Iterator_SessionData_ getNavigator (CallContext context);

    public long     getSize (CallContext context);
}

