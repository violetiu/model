package org.violetime.model.data;

import com.alibaba.fastjson.JSONArray;

/**
 * 模型传输数据集合
 */
public class DataAssemble implements  IDataAssemble {
    private  Object[][] data;

    private String[] dataTitle;

    public void setDataTitle(String[] dataTitle) {
        this.dataTitle = dataTitle;
    }


    @Override
    public String[] getDataTitle() {
        return dataTitle;
    }

    @Override
    public Object[][] getData() {
        return data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }
}
