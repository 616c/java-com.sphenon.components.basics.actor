// instantiated with jti.pl from EventDispatcher
// please do not modify this file directly
package com.sphenon.basics.actor.tplinst;

import com.sphenon.basics.actor.*;
import com.sphenon.basics.session.*;
import com.sphenon.basics.actor.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.context.classes.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.function.*;
import com.sphenon.basics.event.*;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.Queue;
import java.util.ArrayDeque;

public class EventDispatcher_ActorChangeEvent_
    implements EventListener_ActorChangeEvent_
{
    static final public Class _class = EventDispatcher_ActorChangeEvent_.class;

    static protected long notification_level;
    static public    long adjustNotificationLevel(long new_level) { long old_level = notification_level; notification_level = new_level; return old_level; }
    static public    long getNotificationLevel() { return notification_level; }
    static { notification_level = NotificationLocationContext.getLevel(_class); };

    private WeakHashMap<EventListener_ActorChangeEvent_,Long> listeners;
    private long processcount = 0L;
    private String id;
    private boolean silenced;

    public EventDispatcher_ActorChangeEvent_ (CallContext context) {
        this.listeners = null;
        this.id = null;
        this.silenced = false;
    }

    public EventDispatcher_ActorChangeEvent_ (CallContext context, String id) {
        this.listeners = null;
        this.id = id;
        this.silenced = false;
    }

    public boolean getSilenced (CallContext context) {
        return this.silenced;
    }

    public void setSilenced (CallContext context, boolean silenced) {
        this.silenced = silenced;
    }

    protected WeakHashMap<EventListener_ActorChangeEvent_,Long> getListeners(CallContext context) {
        if (this.listeners == null) {
            listeners = new WeakHashMap<EventListener_ActorChangeEvent_,Long>();
        }
        return this.listeners;
    }

    public boolean hasListeners(CallContext context) {
        return (this.listeners != null && this.listeners.size() != 0);
    }

    public synchronized void addListener(CallContext context, EventListener_ActorChangeEvent_ listener) {
        if ((notification_level & Notifier.DIAGNOSTICS) != 0) { NotificationContext.sendDiagnostics(context, "Dispatcher '%(id)', adding listener '%(listener)'", "id", this.id, "listener", listener); }
        if (this.isProcessing()) {
            this.createCopyOfListeners();
        }
        this.getListeners(context).put(listener, 1L);
    }

    public synchronized void removeListener(CallContext context, EventListener_ActorChangeEvent_ listener) {
        if ((notification_level & Notifier.DIAGNOSTICS) != 0) { NotificationContext.sendDiagnostics(context, "Dispatcher '%(id)', removing listener '%(listener)'", "id", this.id, "listener", listener); }
        if (this.isProcessing()) {
            this.createCopyOfListeners();
        }   
        this.getListeners(context).remove(listener);
    }

    private boolean isProcessing(){
        return this.processcount > 0 ? true : false;
    }

    private void createCopyOfListeners(){
        WeakHashMap<EventListener_ActorChangeEvent_,Long> hash = new WeakHashMap<EventListener_ActorChangeEvent_,Long>();       
        hash.putAll( this.listeners );
        this.listeners = hash;
    } 

    static protected ActorChangeEvent null_event;

    protected synchronized WeakHashMap<EventListener_ActorChangeEvent_,Long> startProcessingWithEvent(CallContext context, ActorChangeEvent event) {
        if (this.event_queue != null) {
            if (event == null) {
                if (null_event == null) {
                    null_event = new ActorChangeEvent(context);
                }
                event = null_event;
            }
            this.event_queue.offer(event);
            return null;
        } else {
            WeakHashMap<EventListener_ActorChangeEvent_,Long> local_listeners = this.getListeners(context);
            this.processcount++;
            return local_listeners;
        }
    }

    protected synchronized WeakHashMap<EventListener_ActorChangeEvent_,Long> startProcessingForQueue(CallContext context) {
        WeakHashMap<EventListener_ActorChangeEvent_,Long> local_listeners = this.getListeners(context);
        this.processcount++;
        return local_listeners;
    }

    protected synchronized void endProcessing(CallContext context) {
        this.processcount--;
    }

    protected PreProcessor<ActorChangeEvent> pre_processor;

    public PreProcessor<ActorChangeEvent> getPreProcessor (CallContext context) {
        return this.pre_processor;
    }

    public void setPreProcessor (CallContext context, PreProcessor<ActorChangeEvent> pre_processor) {
        this.pre_processor = pre_processor;
    }

    public void notify(CallContext context, ActorChangeEvent event) {
        if (this.silenced) { return; }

        if (this.pre_processor != null) {
            event = this.pre_processor.preprocess(context, event);
        }

        if ((notification_level & Notifier.DIAGNOSTICS) != 0) { NotificationContext.sendDiagnostics(context, "Dispatcher '%(id)' received '%(event)'", "id", this.id, "event", (event != null ? ContextAware.ToString.convert(context, event) : "_notify_")); }
        WeakHashMap<EventListener_ActorChangeEvent_,Long> local_listeners = this.startProcessingWithEvent(context, event);
        if (local_listeners != null) {
           this.doNotify(context, event, local_listeners);
        }
        this.endProcessing(context);
    }

    protected void doNotify(CallContext context, ActorChangeEvent event, WeakHashMap<EventListener_ActorChangeEvent_,Long> local_listeners) {
        for (EventListener_ActorChangeEvent_ elet : local_listeners.keySet()) {
            if (elet != null) {
                if ((notification_level & Notifier.DIAGNOSTICS) != 0) { NotificationContext.sendDiagnostics(context, "Dispatching event '%(event)' from '%(id)' to '%(listener)'", "event", (event != null ? ContextAware.ToString.convert(context, event) : "_notify_"), "id", this.id, "listener", elet); }
                if (event != null) {
                    elet.notify(context, event);
                } else {
                    elet.notify(context);
                }
            } else {
                NotificationContext.sendNotice(context,EventStringPool.get(context, "0.0.0" /* EventListener vanished */));
            }
        }
    }

    public void notify(CallContext context) {
        notify(context, null);
    }

    protected Queue<ActorChangeEvent> event_queue;
    protected int buffer_level;

    public synchronized void enableBuffering(CallContext context) {
        if (this.buffer_level == 0 && this.event_queue == null) {
            this.event_queue = new ArrayDeque<ActorChangeEvent>(8);
        }
        this.buffer_level++;
    }

    protected boolean is_flushing;

    protected synchronized Queue<ActorChangeEvent> getEventsToFlush(CallContext context, boolean initial_check) {
        boolean flush = false;
        if (initial_check) {
            if (this.buffer_level > 0) {
                this.buffer_level--;
                if (this.buffer_level == 0) {
                    if (this.is_flushing == false) {
                        flush = true;
                        is_flushing = true;
                    }
                }
            }
        } else {
            flush = true;
        }
        if (flush) {
            if (this.event_queue != null && this.event_queue.size() > 0) {
                Queue<ActorChangeEvent> events_to_flush = event_queue;
                event_queue = new ArrayDeque<ActorChangeEvent>(8);
                return events_to_flush;
            } else {
                this.event_queue = null;
            }
        }
        return null;
    }

    protected synchronized void finishFlushing(CallContext context) {
        this.is_flushing = false;
    }

    public void disableBuffering(CallContext context) {
        boolean initial_check = true;
        Queue<ActorChangeEvent> events_to_flush;
        boolean flushed = false;
        while ((events_to_flush = this.getEventsToFlush(context, initial_check)) != null) {
            flushed = true;
            ActorChangeEvent event;
            WeakHashMap<EventListener_ActorChangeEvent_,Long> local_listeners = this.startProcessingForQueue(context);
            while ((event = events_to_flush.poll()) != null) {
                if (event != null && event == null_event) {
                    event = null;
                }
                this.doNotify(context, event, local_listeners);
                initial_check = false;
            }
            this.endProcessing(context);
        }
        if (flushed) {
            this.finishFlushing(context);
        }
    }

    public String toString() {
        return super.toString() + "[" + this.id + "]";
    }
}
