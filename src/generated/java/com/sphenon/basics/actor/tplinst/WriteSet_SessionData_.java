// instantiated with jti.pl from WriteSet
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.metadata.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface WriteSet_SessionData_
{
    // adds item, may already exist
    public void     set     (CallContext context, SessionData item);

    // adds item, must not already exist
    public void     add     (CallContext context, SessionData item) throws AlreadyExists;

    // replace item, must already exist
    public void     replace (CallContext context, SessionData item) throws DoesNotExist;
    // does this method make any sense?
    // should'nt it be? : 
    // public void     replace (CallContext context, SessionData item, SessionData item) throws DoesNotExist;

    // removes item, need not exist
    public void     unset   (CallContext context, SessionData item);

    // removes item, must exist
    public void     remove  (CallContext context, SessionData item) throws DoesNotExist;
}

