package org.violetime.model.data;

import java.util.*;

public class ModelArrayList<X,Y,Z>  implements  IModelList<X,Y,Z> {

    private ArrayList<ModelPoint3<X,Y,Z> > points;

    @Override
    public ArrayList<ModelPoint3<X, Y, Z>> getPoints() {
        return points;
    }

    @Override
    public int size() {
        if(points==null)
            return  0;
        return points.size();
    }
    @Override
    public boolean containsKey(X x, Y y) {
        if(points==null)
            return false;
        for(int index=0;index<points.size();index++){
            IModelPoint3<X,Y,Z> point=points.get(index);
            if(point.getX().equals(x)&&point.getY().equals(y)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Z get(X x, Y y) {
        if(points==null)
            return null;
        for(int index=0;index<points.size();index++){
            IModelPoint3<X,Y,Z> point=points.get(index);
            if(point.getX().equals(x)&&point.getY().equals(y)){
                return point.getZ();
            }
        }
        return null;
    }

    @Override
    public void put(X x, Y y, Z z) {
        if(points==null)
            points=new ArrayList<>();
        boolean has=false;
        for(int index=0;index<points.size();index++){
            IModelPoint3 point=points.get(index);
            if(point.getX().equals(x)&&point.getY().equals(y)){
                point.setZ(z);
                has=true;
                break;
            }
        }
        if(!has){
            points.add(new ModelPoint3<X,Y,Z>(x,y,z));
        }
    }


    public void setPoints(ArrayList<ModelPoint3<X, Y, Z>> points) {
        this.points = points;
    }
}
