// instantiated with jti.pl from ReadMap
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.metadata.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface ReadMap_Set_SessionData__Type_
{
    // retrieves item at index; item must exist
    public Set_SessionData_ get     (CallContext context, Type index) throws DoesNotExist;

    // retrieves item at index; returns null if item does not exist
    public Set_SessionData_ tryGet  (CallContext context, Type index);

    // returns true if item at index exists, otherwise false
    public boolean  canGet  (CallContext context, Type index);
}

