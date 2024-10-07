// instantiated with jti.pl from ReadOnlyVector
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public interface ReadOnlyVector_SessionInfo_long_
  extends ReadVector_SessionInfo_long_,
          ReadOnlyVector<SessionInfo>,
          OfKnownSize
{
    public SessionInfo                                    get             (CallContext context, long index) throws DoesNotExist;
    public SessionInfo                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_SessionInfo_long_ReadOnlyVector_SessionInfo_long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_SessionInfo_long_ReadOnlyVector_SessionInfo_long__  tryGetReference (CallContext context, long index);
}

