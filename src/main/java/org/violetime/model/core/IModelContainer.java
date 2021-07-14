package org.violetime.model.core;

import com.alibaba.fastjson.JSONObject;

/**
 * 模型容器顶级接口
 */
public interface IModelContainer extends IModelDataContainer,IModelViewContainer,IModelArgsContainer,IModelResultContainer {
    public String getName();
    public String getCommand();
    public void setName(String name) ;
    public void setCommand(String path) ;

    /**
     * 获取模型结构，并存储结构，用于下次使用，比如训练好的网络结构
     * @return
     */
    public JSONObject getStructure();

    /**
     * 是否已加载了储存结构
     * @return
     */
    public boolean hasStructure();

    /**
     * 设置模型结构，并存储结构，用于下次使用，比如训练好的网络结构.默认返回null。需要重写该方法，实现结构存贮
     * @param structure
     */
    public void setStructure(JSONObject structure);

    /**
     * 获取语言
     * @return
     */
    public String getLang();

    /**
     * 设置语言
     * @param lang
     */
    public void setLang(String lang);

    /**
     * 是否支持存储结构
     * @return
     */
    public boolean isStructure() ;

    public void setStructure(boolean structure) ;
}
