// instantiated with jti.pl from OSet

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

