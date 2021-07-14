package org.violetime.model.java;


import com.alibaba.fastjson.JSONObject;
import org.violetime.model.core.IModelContainer;
import org.violetime.model.data.IArgsAssemble;
import org.violetime.model.data.IDataAssemble;
import org.violetime.model.report.IModelReport;
import org.violetime.model.view.IModelMethodReturn;

/**
 * Java语言模型容器接口
 */
public interface IJavaContainer extends IModelContainer {


    /**
     * 正常运行模型，参数自动注入
     * @param data 获得数据
     * @param dataTitle 获得数据标题
     * @param
     * @return
     */
    public IModelReport runModel(Object[][] data,String[] dataTitle);


    /**
     * 使用模型已存储结构运行，参数自动注入

     * @param dataTitle  获得数据列标题
     * @return
     */
    public IModelReport runStructure(String[] dataTitle);
}
