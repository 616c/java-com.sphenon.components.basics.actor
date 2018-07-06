// instantiated with jti.pl from Vector

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

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

import com.sphenon.ui.annotations.*;

@UIId("")
@UIName("")
@UIClassifier("Vector_SessionInfo_")
@UIParts("js:instance.getIterable(context)")
public interface Vector_SessionInfo_long_
  extends ReadOnlyVector_SessionInfo_long_,
          WriteVector_SessionInfo_long_
          , GenericVector<SessionInfo>
          , GenericIterable<SessionInfo>
{
    public SessionInfo                                    get             (CallContext context, long index) throws DoesNotExist;
    public SessionInfo                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_SessionInfo_long_ReadOnlyVector_SessionInfo_long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_SessionInfo_long_ReadOnlyVector_SessionInfo_long__  tryGetReference (CallContext context, long index);

    public SessionInfo                                    set             (CallContext context, long index, SessionInfo item);
    public void                                        add             (CallContext context, long index, SessionInfo item) throws AlreadyExists;
    public void                                        prepend         (CallContext context, SessionInfo item);
    public void                                        append          (CallContext context, SessionInfo item);
    public void                                        insertBefore    (CallContext context, long index, SessionInfo item) throws DoesNotExist;
    public void                                        insertBehind    (CallContext context, long index, SessionInfo item) throws DoesNotExist;
    public SessionInfo                                    replace         (CallContext context, long index, SessionInfo item) throws DoesNotExist;
    public SessionInfo                                    unset           (CallContext context, long index);
    public SessionInfo                                    remove          (CallContext context, long index) throws DoesNotExist;

    public IteratorItemIndex_SessionInfo_long_       getNavigator    (CallContext context);

    public long                                        getSize         (CallContext context);

    // for sake of Iterable's
    public java.util.Iterator<SessionInfo>              getIterator_SessionInfo_ (CallContext context);
    public java.util.Iterator                          getIterator (CallContext context);
    public VectorIterable_SessionInfo_long_          getIterable_SessionInfo_ (CallContext context);
    public Iterable<SessionInfo> getIterable (CallContext context);
}
