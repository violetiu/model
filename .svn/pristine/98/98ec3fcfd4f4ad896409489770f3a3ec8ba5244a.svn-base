package org.violetime.model.core;


import com.alibaba.fastjson.JSONObject;
import org.violetime.model.report.IModelReport;
import org.violetime.model.view.IModelMethodReturn;

public interface IModelServerResult {
    public boolean isComplete();
    public String getLog();
    public long getTime();
    public IModelReport getReport();
    /**
     * 获取结果口令
     * @return
     */
    public String getToken();

    /**
     * 使用口令初始化结果
     * @param token
     */
    public void init(String token);
    /**
     * 获取模型结构，并存储结构，用于下次使用，比如训练好的网络结构
     * @return
     */
    public JSONObject getStructure();
    public IModelMethodReturn getReturn();
}
