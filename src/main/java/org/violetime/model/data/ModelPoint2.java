package org.violetime.model.data;

public class ModelPoint2<X,Y> implements  IModelPoint2<X,Y> {
    public ModelPoint2() {

    }

    public ModelPoint2(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    private X x;
    private Y y;

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
