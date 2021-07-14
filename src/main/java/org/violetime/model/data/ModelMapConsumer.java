package org.violetime.model.data;
@FunctionalInterface
public interface ModelMapConsumer<X,Y,Z> {
    void accept(X x,Y y,Z z);
}
