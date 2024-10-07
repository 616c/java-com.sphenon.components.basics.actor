// instantiated with jti.pl from OSet_LinkedListTreeImpl
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

import java.util.Hashtable;

public class OSet_LinkedListTreeImpl_SessionData_Type_
  implements OSet_SessionData_Type_ {
    protected java.util.Hashtable map;
    protected Set_LinkedListTreeImpl_SessionData_ toplevel_set;
    protected Type itemtype;


    public OSet_LinkedListTreeImpl_SessionData_Type_ (CallContext context) {
        this.map = new java.util.Hashtable ();
        this.toplevel_set = new Set_LinkedListTreeImpl_SessionData_ (context);
        this.itemtype = TypeManager.get(context, SessionData.class);
        map.put(this.itemtype, this.toplevel_set);
    }

    public OSet_LinkedListTreeImpl_SessionData_Type_ (CallContext context, java.util.Hashtable map) {
        this.map = map;
        this.toplevel_set = new Set_LinkedListTreeImpl_SessionData_ (context);
        this.itemtype = TypeManager.get(context, SessionData.class);
        map.put(this.itemtype, this.toplevel_set);
    }


    public Set_SessionData_ get     (CallContext context, Type index) throws DoesNotExist {
        // if (! index.isA(context, itemtype)) DoesNotExist.createAndThrow(context);
        Object item = map.get(index);
        if (item == null) DoesNotExist.createAndThrow(context);
        return (Set_SessionData_) item;
    }

    public Set_SessionData_ getMany    (CallContext context, Type index) throws DoesNotExist {
        return this.get(context, index);
    }

    public SessionData      getSole    (CallContext context, Type index) throws DoesNotExist, MoreThanOne {
        Set_SessionData_ set = this.get(context, index);
        if (set.getSize(context) != 1) MoreThanOne.createAndThrow(context);
        return set.getNavigator(context).tryGetCurrent(context);
    }

    public Set_SessionData_ tryGet  (CallContext context, Type index) {
        // if (! index.isA(context, itemtype)) return null;
        return (Set_SessionData_) map.get(index);
    }

    public Set_SessionData_ tryGetMany (CallContext context, Type index) {
        return this.tryGet(context, index);
    }

    public SessionData      tryGetSole (CallContext context, Type index) {
        Set_SessionData_ set = this.tryGet(context, index);
        if (set == null || set.getSize(context) != 1) return null;
        return set.getNavigator(context).tryGetCurrent(context);
    }

    public boolean  canGet  (CallContext context, Type index) {
        if (! index.isA(context, itemtype)) return false;
        return map.containsKey(index);
    }

    public boolean       canGetMany (CallContext context, Type index) {
        return this.canGet(context, index);
   
    }

    public boolean       canGetSole (CallContext context, Type index) {
        Set_SessionData_ set = this.tryGet(context, index);
        if (set == null || set.getSize(context) != 1) return false;
        return true;
    }

    private Set_LinkedListTreeImpl_SessionData_ getEntry(CallContext context, Type index) {
        Set_LinkedListTreeImpl_SessionData_ set = (Set_LinkedListTreeImpl_SessionData_) map.get(index);
        if (set == null) {
            set = new Set_LinkedListTreeImpl_SessionData_ (context);
            map.put(index, set);
            this._setSuper(context, index, set);
        }
        return set;
    }

    private void    _setSuper  (CallContext context, Type index, Set_LinkedListTreeImpl_SessionData_ sllti) {
        if (index.equals(itemtype)) return;
        // Iterator_Type_ supertypes = index.getSuperTypes(context).getNavigator(context);
        Iterator_Type_ supertypes = index.getAllShortestPathSuperInterfaces(context).getNavigator(context);
        Type supertype;
        while ((supertype = supertypes.tryGetCurrent(context)) != null) {
            if (supertype.isA(context, itemtype)) {
                this.getEntry(context, supertype).set(context, sllti);
                // this._setSuper(context, item, supertype);
            }
            supertypes.next(context);
        }
    }

    private void    _unsetSuper  (CallContext context, SessionData item, Type index, Set_LinkedListTreeImpl_SessionData_ sllti) {
        if (index.equals(itemtype)) return;
        // Iterator_Type_ supertypes = index.getSuperTypes(context).getNavigator(context);
        Iterator_Type_ supertypes = index.getAllShortestPathSuperInterfaces(context).getNavigator(context);
        Type supertype;
        while ((supertype = supertypes.tryGetCurrent(context)) != null) {
            if (supertype.isA(context, itemtype)) {
                this.getEntry(context, supertype).unset(context, sllti);
                // this._unsetSuper(context, item, supertype);
            }
            supertypes.next(context);
        }
    }

    public void     set     (CallContext context, SessionData item) {
        Type index = TypeManager.get(context, item.getClass());
        Set_LinkedListTreeImpl_SessionData_ entry = this.getEntry(context, index);
        entry.set(context, item);
    }

    public void     add     (CallContext context, SessionData item) throws AlreadyExists {
        Type index = TypeManager.get(context, item.getClass());
        Set_LinkedListTreeImpl_SessionData_ entry = this.getEntry(context, index);
        entry.add(context, item);
    }

    public void     replace (CallContext context, SessionData item) throws DoesNotExist {
        Type index = TypeManager.get(context, item.getClass());
        Set_LinkedListTreeImpl_SessionData_ entry = this.getEntry(context, index);
        entry.replace(context, item);
    }

    public void     unset   (CallContext context, SessionData item) {
        Type index = TypeManager.get(context, item.getClass());
        Set_LinkedListTreeImpl_SessionData_ entry = this.getEntry(context, index);
        entry.unset(context, item);
        // this._unsetSuper(context, item, index, entry);
    }

    public void     remove  (CallContext context, SessionData item) throws DoesNotExist {
        Type index = TypeManager.get(context, item.getClass());
        Set_LinkedListTreeImpl_SessionData_ entry = this.getEntry(context, index);
        entry.remove(context, item);
        // this._unsetSuper(context, item, index, entry);
    }

    public Iterator_SessionData_ getNavigator (CallContext context) {
        return this.toplevel_set.getNavigator(context);
    }

    public long     getSize (CallContext context) {
        return this.toplevel_set.getSize(context);
    }
}
