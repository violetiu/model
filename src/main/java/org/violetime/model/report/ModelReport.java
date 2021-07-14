package org.violetime.model.report;

import java.util.Date;

/**
 * 模型计算结果，以报告形式返回
 */
public class ModelReport implements IModelReport{

    private  ModelReportType type;
    private  String filePath;
    private String imageSrc;
    private  IModelReport[] reports;
    private Double num;
    private String text;
    private Double[][] matrix;
    private Object[][] table;
    private String title;
    private String model;
    private Date time;
    private Object data;
    private String[] axis;

    public String[] getAxis() {
        return axis;
    }

    public void setAxis(String[] axis) {
        this.axis = axis;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public ModelReportType getType() {
        return type;
    }

    public void setType(ModelReportType type) {
        this.type = type;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    @Override
    public IModelReport[] getReports() {
        return reports;
    }

    public void setReports(IModelReport[] reports) {
        this.reports = reports;
    }

    @Override
    public Double getNumber() {
        return num;
    }

    public void setNumber(Double number) {
        this.num = number;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Double[][] matrix) {
        this.matrix = matrix;
    }

    public void setTable(Object[][] table) {
        this.table = table;
    }

    @Override
    public Object[][] getTable() {
        return this.table;
    }


    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
