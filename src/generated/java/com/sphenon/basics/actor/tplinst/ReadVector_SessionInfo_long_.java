// instantiated with jti.pl from ReadVector
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface ReadVector_SessionInfo_long_
{
    public SessionInfo                                    get             (CallContext context, long index) throws DoesNotExist;
    public SessionInfo                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_SessionInfo_long_ReadOnlyVector_SessionInfo_long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_SessionInfo_long_ReadOnlyVector_SessionInfo_long__  tryGetReference (CallContext context, long index);
}

