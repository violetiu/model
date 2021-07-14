package org.violetime.model.data;

public class DataDemandColumnType {

    public static DataDemandColumnType Number=new DataDemandColumnType("Number");
    public static DataDemandColumnType String=new DataDemandColumnType("String");
    public static DataDemandColumnType Other=new DataDemandColumnType("Other");

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public DataDemandColumnType() {

    }
    public DataDemandColumnType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        return this.type.equals(obj.toString());
    }

    @Override
    public String toString() {
        return this.type;
    }
}
