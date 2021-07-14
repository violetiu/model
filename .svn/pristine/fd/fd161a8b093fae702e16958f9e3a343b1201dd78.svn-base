package org.violetime.model.core;

import com.alibaba.fastjson.JSONObject;
import org.violetime.model.config.IModelConfig;
import org.violetime.model.report.IModelReport;
import org.violetime.model.view.IModelMethodReturn;

import java.lang.reflect.InvocationTargetException;

/**
 * 模型服务接口，用于实现异步
 */
public interface IModelServer {
    /**
     * 载入模型容器
     * @param iModelContainer
     */
    public void load(IModelContainer iModelContainer);
    public  IModelContainer init(IModelConfig iModelConfig) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException;

    public String getId();

    public boolean isComplete();
    public String getLog();
    public long getTime();
    public IModelReport getReport();
    /**
     * 获取模型结构，并存储结构，用于下次使用，比如训练好的网络结构
     * @return
     */
    public JSONObject getStructure();
    public IModelMethodReturn getReturn();
}
