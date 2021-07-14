package org.violetime.model.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IModelList<X,Y,Z> {
    public ArrayList<ModelPoint3<X,Y,Z>> getPoints();
    public int size();
    public Z get(X x,Y y);
    public void put(X x,Y y,Z z);
    public boolean containsKey(X x, Y y);

}
