package org.violetime.tool;

import com.alibaba.fastjson.JSONArray;
import org.violetime.model.data.DataDemandColumn;

import java.util.List;
import java.util.Map;

/**
 * 数据 的json格式存贮对象
 */
public interface IJsonData {
    /**
     * 加载数据，过程中会提取出标题和列类型，并且返回的data中将不包括标题
     * @param data
     * @return
     */
    public boolean loadData(Object[][] data);

    public Object[][] getData() ;

    public int getTitleRow() ;


    public String[] getTitles();
    public DataDemandColumn[] getColumns() ;

    /**
     * 根据数据要求 复制一份
     * @param demandJsons
     * @return
     */
    IJsonData loadDemand(JSONArray demandJsons);
    public void loadData(List<?> list, Class cls, Map<String, String> titles);
    public String getType() ;
}
