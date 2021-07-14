package org.violetime.model.report;

public class ModelReportType {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ModelReportType() {

    }

    public ModelReportType(String type) {
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
    //报告：包括子项报告
    public static ModelReportType Report=new ModelReportType("Report");
    //文件
    public static ModelReportType File=new ModelReportType("File");
    //图片
    public static ModelReportType Image=new ModelReportType("Image");
    //数字
    public static ModelReportType Number=new ModelReportType("Number");
    //文本
    public static ModelReportType Text=new ModelReportType("Text");
    //矩阵：返回一个二维数据
    public static ModelReportType Matrix=new ModelReportType("Matrix");
    //空
    public static ModelReportType Null=new ModelReportType("Null");
    //表格
    public static ModelReportType Table=new ModelReportType("Table");
    public static ModelReportType LineChart=new ModelReportType("LineChart");
    public static ModelReportType ScatterChart=new ModelReportType("ScatterChart");


}
