package org.violetime.model.core;


import org.violetime.model.data.IDataAssemble;
import org.violetime.model.data.IDataDemand;
import org.violetime.model.view.IModelMethodReturn;

/**
 *  模型容器数据接口
 */
public interface IModelDataContainer {

    /**
     * 数据传入要求
     * @return
     */
    public IDataDemand dataDemand();

    /**
     * 数据要求
     * @return
     */
    public void dataDemand(IDataDemand iDataDemand);

    /**
     * 加载数据
     */
    public IModelMethodReturn dataLoad(IDataAssemble iDataAssemble);

    /**
     * 数据检查
     * @return
     */
    public IModelMethodReturn dataCheck();

}
