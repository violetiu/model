package org.violetime.model.data;

public class ModelPoint3<X,Y,Z> implements  IModelPoint3<X,Y,Z> {
    public ModelPoint3() {

    }
    private X x;
    private Y y;
    private Z z;

    @Override
    public Z getZ() {
        return z;
    }

    public ModelPoint3(X x, Y y, Z z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setZ(Z z) {
        this.z = z;
    }

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public Y getY() {
        return y;
    }

    public void setY(Y y) {
        this.y = y;
    }
}
