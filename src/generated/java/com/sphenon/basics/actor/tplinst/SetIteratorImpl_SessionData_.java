// instantiated with jti.pl from SetIteratorImpl

/****************************************************************************
  Copyright 2001-2018 Sphenon GmbH

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations
  under the License.
*****************************************************************************/
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.metadata.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;

import com.sphenon.basics.many.returncodes.*;

import java.util.Hashtable;

public class SetIteratorImpl_SessionData_
    implements Iterator_SessionData_
{
    private java.util.Hashtable map;
    private java.util.Set entry_set;
    private java.util.Iterator iterator;
    private SessionData current;

    public SetIteratorImpl_SessionData_ (CallContext context, java.util.Hashtable map) {
        this.map = map;
        this.entry_set = map.entrySet();
        this.iterator = entry_set.iterator();
        if (this.iterator.hasNext()) {
            java.util.Map.Entry me = (java.util.Map.Entry) this.iterator.next();
            this.current = (SessionData) me.getValue();
        } else {
            this.current = null;
        }
    }

    public void     next          (CallContext context)
    {
        if (this.iterator.hasNext()) {
            java.util.Map.Entry me = (java.util.Map.Entry) this.iterator.next();
            this.current = (SessionData) me.getValue();
        } else {
            this.current = null;
        }
    }

    public SessionData getCurrent    (CallContext context) throws DoesNotExist
    {
        if (this.current == null) DoesNotExist.createAndThrow(context);
        return this.current;
    }

    public SessionData tryGetCurrent (CallContext context)
    {
        return this.current;
    }

    public boolean  canGetCurrent (CallContext context)
    {
        return (this.current != null) ? true : false;
    }

    public SetIteratorImpl_SessionData_ clone(CallContext context) {
        CustomaryContext.create((Context)context).throwLimitation(context, "cannot clone, map entry set iterator is not cloneable");
        throw (ExceptionLimitation) null; // compiler insists
    }
}

