package org.violetime.model.data;

import java.util.*;

public class ModelHashMap<X,Y,Z> implements  IModelMap<X,Y,Z>{

    private Map<String,X> xMap;
    private Map<String,Y> yMap;
    private Map<String,Z> zMap;

    private Map<String,IModelMapEntry> entrySet;

    @Override
    public void put(X x, Y y, Z z) {
        if(entrySet==null)
            entrySet=new HashMap<>();
        String key=x.toString()+"--"+y.toString();
        IModelMapEntry<X,Y,Z> iModelMapEntry=entrySet.get(key);
        if(iModelMapEntry==null){
            iModelMapEntry=new ModelMapEntry<X,Y,Z>();
            entrySet.put(key,iModelMapEntry);
        }
        iModelMapEntry.setX(x);
        iModelMapEntry.setY(y);
        iModelMapEntry.setZ(z);

    }

    @Override
    public Z get(X x, Y y) {

        if(entrySet==null)
         return null;
        String key=x.toString()+"--"+y.toString();
        IModelMapEntry<X,Y,Z> iModelMapEntry=entrySet.get(key);
        if(iModelMapEntry==null)
            return null;
        return  iModelMapEntry.getZ();

    }

    @Override
    public Map<Y, Z> getX(X x) {
        return null;
    }

    @Override
    public Map<X, Z> getY(Y y) {
        return null;
    }

    @Override
    public Map<X, Y> getZ(Z z) {
        return null;
    }

    @Override
    public int size() {
        return entrySet.size();
    }

    @Override
    public boolean containsKey(X x, Y y, Z z) {

        if(entrySet==null)
            return false;
        String key=x.toString()+"--"+y.toString();
        IModelMapEntry<X,Y,Z> iModelMapEntry=entrySet.get(key);
        if(iModelMapEntry==null)
            return false;
        if(iModelMapEntry.getZ()==z)
            return true;
        return false;
    }

    @Override
    public void clear() {
        entrySet.clear();
    }

    @Override
    public void forEach(ModelMapConsumer<X, Y, Z> action) {

        Objects.requireNonNull(action);
        for(Object key :entrySet.keySet()){
            IModelMapEntry<X,Y,Z> iModelMapEntry=entrySet.get(key);
            if(iModelMapEntry!=null){
                action.accept(iModelMapEntry.getX(), iModelMapEntry.getY(),iModelMapEntry.getZ());
            }


        }


    }
}
