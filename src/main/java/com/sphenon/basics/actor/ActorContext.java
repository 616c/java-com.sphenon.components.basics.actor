package com.sphenon.basics.actor;

/****************************************************************************
  Copyright 2001-2024 Sphenon GmbH

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
import com.sphenon.basics.actor.tplinst.*;

public class ActorContext extends SpecificContext {

    static public ActorContext get(Context context) {
        ActorContext actor_context = (ActorContext) context.getSpecificContext(ActorContext.class);
        if (actor_context != null) {
            return actor_context;
        }
        return null;
    }

    static public ActorContext create(Context context) {
        ActorContext actor_context = new ActorContext(context, false);
        context.setSpecificContext(ActorContext.class, actor_context);
        return actor_context;
    }

    protected ActorContext (Context context, boolean is_default_singelton) {
        super(context);
    }
}
