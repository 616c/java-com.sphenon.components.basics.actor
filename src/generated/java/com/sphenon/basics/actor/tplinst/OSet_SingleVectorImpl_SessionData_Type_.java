// instantiated with jti.pl from OSet_SingleVectorImpl

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
import com.sphenon.basics.metadata.*;
import com.sphenon.basics.metadata.tplinst.*;

import com.sphenon.basics.many.returncodes.*;

import java.util.Vector;
import java.util.ListIterator;

public class OSet_SingleVectorImpl_SessionData_Type_
  implements OSet_SessionData_Type_ {
    protected java.util.Vector vector;
    protected Type itemtype;


    public OSet_SingleVectorImpl_SessionData_Type_ (CallContext context) {
        this.vector = new java.util.Vector ();
        this.itemtype = TypeManager.get(context, SessionData.class);
    }

    public OSet_SingleVectorImpl_SessionData_Type_ (CallContext context, java.util.Vector vector) {
        this.vector = vector;
        this.itemtype = TypeManager.get(context, SessionData.class);
    }


    public Set_SessionData_ get     (CallContext context, Type index) throws DoesNotExist {
        Set_SessionData_ result = tryGet(context, index);
        if (result.getSize(context) == 0) DoesNotExist.createAndThrow(context);
        return result;
    }

    public Set_SessionData_ getMany    (CallContext context, Type index) throws DoesNotExist {
        return this.get(context, index);
    }

    public SessionData      getSole    (CallContext context, Type index) throws DoesNotExist, MoreThanOne {
        SessionData result = null;
        for (Object o: vector) {
            if (TypeManager.get(context, o.getClass()).isA(context, index)) {
                if (result != null) MoreThanOne.createAndThrow(context);
                result = (SessionData) o;
            }
        }
        if (result == null) DoesNotExist.createAndThrow(context);
        return result;
    }

    public Set_SessionData_ tryGet  (CallContext context, Type index) {
        Set_SessionData_ result = new SetImpl_SessionData_(context);
        for (Object o: vector) {
            if (TypeManager.get(context, o.getClass()).isA(context, index)) {
                result.set(context, (SessionData) o);
            }
        }
        return result;
    }

    public Set_SessionData_ tryGetMany (CallContext context, Type index) {
        return this.tryGet(context, index);
    }

    public SessionData      tryGetSole (CallContext context, Type index) {
        SessionData result = null;
        for (Object o: vector) {
            if (TypeManager.get(context, o.getClass()).isA(context, index)) {
                if (result != null) return null;
                result = (SessionData) o;
            }
        }
        return result;
    }

    public boolean  canGet  (CallContext context, Type index) {
        for (Object o: vector) {
            if (TypeManager.get(context, o.getClass()).isA(context, index)) {
                return true;
            }
        }
        return false;
    }

    public boolean       canGetMany (CallContext context, Type index) {
        return this.canGet(context, index);
   
    }

    public boolean       canGetSole (CallContext context, Type index) {
        SessionData result = null;
        for (Object o: vector) {
            if (TypeManager.get(context, o.getClass()).isA(context, index)) {
                if (result != null) return false;
                result = (SessionData) o;
            }
        }
        return result == null ? false : true;
    }

    public void     set     (CallContext context, SessionData item) {
        vector.add(item);
    }

    public void     add     (CallContext context, SessionData item) throws AlreadyExists {
        vector.add(item);
    }

    public void     replace (CallContext context, SessionData item) throws DoesNotExist {
    }

    public void     unset   (CallContext context, SessionData item) {
        ListIterator li = vector.listIterator();
        while (li.hasNext()) {
            if (li.next() == item) {
                li.remove();
                return;
            }
        }
    }

    public void     remove  (CallContext context, SessionData item) throws DoesNotExist {
        ListIterator li = vector.listIterator();
        while (li.hasNext()) {
            if (li.next() == item) {
                li.remove();
                return;
            }
        }
        DoesNotExist.createAndThrow(context);
    }

    public Iterator_SessionData_ getNavigator (CallContext context) {
        return new OSet_SingleVector_IteratorImpl_SessionData_Type_(context, this.vector);
    }

    public long     getSize (CallContext context) {
        return this.vector.size();
    }
}
