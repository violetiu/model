package org.violetime.model.data;

public class ModelArgType {
    private String type="TextField";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ModelArgType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        return type.equals(obj.toString());
    }

    @Override
    public String toString() {
        return type;
    }
    public ModelArgType() {

    }



    public static ModelArgType Slider=new ModelArgType("Slider");
    public static ModelArgType TextField=new ModelArgType("TextField");
    public static ModelArgType Toogle=new ModelArgType("Toogle");
    public static ModelArgType Checkbox=new ModelArgType("Checkbox");
    public static ModelArgType ComboBox=new ModelArgType("ComboBox");
    public static ModelArgType FilePicker=new ModelArgType("FilePicker");
    //该参数 返回 选择数据的id，数据内容需要重写获取
    public static ModelArgType Data=new ModelArgType("Data");
}
