// instantiated with jti.pl from EventListener
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.actor.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

public interface EventListener_ActorChangeEvent_
    extends java.util.EventListener
{
    public void notify(CallContext context);
    public void notify(CallContext context, ActorChangeEvent event);
}

