// instantiated with jti.pl from WriteVector
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface WriteVector_SessionInfo_long_
{
    public SessionInfo set          (CallContext context, long index, SessionInfo item);
    public void     add          (CallContext context, long index, SessionInfo item) throws AlreadyExists;
    public void     prepend      (CallContext context, SessionInfo item);
    public void     append       (CallContext context, SessionInfo item);
    public void     insertBefore (CallContext context, long index, SessionInfo item) throws DoesNotExist;
    public void     insertBehind (CallContext context, long index, SessionInfo item) throws DoesNotExist;
    public SessionInfo replace      (CallContext context, long index, SessionInfo item) throws DoesNotExist;
    public SessionInfo unset        (CallContext context, long index);
    public SessionInfo remove       (CallContext context, long index) throws DoesNotExist;
}

