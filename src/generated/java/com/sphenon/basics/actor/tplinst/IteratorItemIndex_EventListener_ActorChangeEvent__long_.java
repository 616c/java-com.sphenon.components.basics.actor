// instantiated with jti.pl from IteratorItemIndex

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
import com.sphenon.basics.actor.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public interface IteratorItemIndex_EventListener_ActorChangeEvent__long_
  extends Iterator_EventListener_ActorChangeEvent__
    , IteratorItemIndex<EventListener_ActorChangeEvent_>
{
    // returns current index
    public long getCurrentIndex (CallContext context) throws DoesNotExist;

    // like "getCurrentIndex", but returns null instead of throwing exception
    public long tryGetCurrentIndex (CallContext context);
}
