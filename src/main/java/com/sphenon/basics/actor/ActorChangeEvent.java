package com.sphenon.basics.actor;

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

import com.sphenon.basics.context.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.actor.*;

public class ActorChangeEvent {
    protected Actor old_actor;
    protected Actor new_actor;

    public ActorChangeEvent (CallContext context, Actor old_actor, Actor new_actor) {
        this.old_actor = old_actor;
        this.new_actor = new_actor;
    }

    public Actor getOldActor(CallContext context) {
        return this.old_actor;
    }

    public Actor getNewActor(CallContext context) {
        return this.new_actor;
    }
}
