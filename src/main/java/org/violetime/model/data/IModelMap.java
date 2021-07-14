package org.violetime.model.data;

import java.util.Map;

/**
 * 三维MAP
 * @param <X>
 * @param <Y>
 * @param <Z>
 */
public interface IModelMap<X,Y,Z> {


    public void put(X x,Y y,Z z);
    public Z get(X x,Y y);
    public Map<Y,Z> getX(X x);
    public Map<X,Z> getY(Y y);
    public Map<X,Y> getZ(Z z);
    public int size();
    public boolean containsKey(X x,Y y,Z z);
    public void clear();
    public void forEach(ModelMapConsumer<X,Y,Z> action);


}
