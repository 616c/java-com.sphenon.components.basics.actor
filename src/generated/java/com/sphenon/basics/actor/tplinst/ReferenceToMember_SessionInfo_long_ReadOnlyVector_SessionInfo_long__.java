// instantiated with jti.pl from ReferenceToMember
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.reference.*;
import com.sphenon.basics.many.*;

public interface ReferenceToMember_SessionInfo_long_ReadOnlyVector_SessionInfo_long__
  extends Reference_SessionInfo_
    , ReferenceToMember<SessionInfo,ReadOnlyVector<SessionInfo>>
{
    public ReadOnlyVector_SessionInfo_long_ getContainer(CallContext context);
    public long     getIndex    (CallContext context);
}
