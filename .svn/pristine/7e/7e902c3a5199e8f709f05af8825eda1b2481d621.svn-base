package org.violetime.model.core;


import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.violetime.tool.DateTool;
import org.violetime.tool.JsonDataTool;
import org.violetime.model.data.*;
import org.violetime.model.report.IModelReport;
import org.violetime.model.report.ModelReport;
import org.violetime.model.view.IModelMethodReturn;
import org.violetime.model.view.ModelMethodReturn;
import org.violetime.tool.JsonData;

import java.lang.reflect.Field;

/**
 * 模型容器顶级基类
 */

public class ModelContainer implements IModelContainer {
    private final static Logger LOGGER = LogManager.getLogger(ModelContainer.class);
    protected IDataAssemble iDataAssemble;
    protected IArgsAssemble iArgsAssemble;
    protected IArgsDemand iArgsDemand;
    protected IDataDemand iDataDemand;
    protected String name, command;
    protected IModelReport result;
    protected String lang;
    protected JSONObject structure;
    private boolean isStructure;

    public boolean isStructure() {
        return isStructure;
    }

    public void setStructure(boolean structure) {
        isStructure = structure;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public JSONObject getStructure() {
        return null;
    }

    @Override
    public boolean hasStructure() {
        if(this.structure!=null)
            return  true;
        return false;
    }

    @Override
    public void setStructure(JSONObject structure) {
        this.structure=structure;
    }

    @Override
    public String getLang() {
        return this.lang;
    }

    @Override
    public void setLang(String lang) {
        this.lang=lang;
    }

    @Override
    public IArgsDemand argsDemand() {
        return this.iArgsDemand;
    }

    @Override
    public void argsDemand(IArgsDemand iArgsDemand) {
        this.iArgsDemand=iArgsDemand;
    }

    @Override
    public IModelMethodReturn argsLoad(IArgsAssemble iArgsAssemble) {
        this.iArgsAssemble = iArgsAssemble;

        if(iArgsAssemble!=null&&iArgsAssemble.getArgs()!=null){
            for(Object key : iArgsAssemble.getArgs().keySet()){
                Object value=iArgsAssemble.getArgs().get(key);
                if(value==null)
                    continue;
                try{
                    Field field= this.getClass().getDeclaredField(key.toString());
                    field.setAccessible(true);
                    field.set(this,JsonDataTool.valueToObject(field.getType(),value));
                }catch (Exception ex){
                    ex.printStackTrace();
                    LOGGER.debug("参数注入失败 : "+key);
                }

            }
        }

        return new ModelMethodReturn(true);
    }

    @Override
    public IModelMethodReturn argsCheck() {
        return new ModelMethodReturn(true);
    }

    @Override
    public IDataDemand dataDemand() {
        return this.iDataDemand;
    }

    @Override
    public void dataDemand(IDataDemand iDataDemand) {
        this.iDataDemand=iDataDemand;
    }

    @Override
    public IModelMethodReturn dataLoad(IDataAssemble iDataAssemble) {
        LOGGER.debug("dataLoad " + iDataAssemble);
        this.iDataAssemble = iDataAssemble;
        return new ModelMethodReturn(true);
    }

    @Override
    public IModelMethodReturn dataCheck() {
        return new ModelMethodReturn(true);
    }

    @Override
    public IModelMethodReturn start() {
        LOGGER.debug("ModelC Start");
        LOGGER.debug("ModelC Start dataCheck " + this.iDataAssemble);
        IModelMethodReturn check = dataCheck();

        if (!check.isSuccess()) {
            return new ModelMethodReturn(false, JsonData.MessageCode.error_model_data);
        }
        LOGGER.debug("ModelC Start argsCheck");
        check = argsCheck();
        if (!check.isSuccess()) {

            return new ModelMethodReturn(false, JsonData.MessageCode.error_param);
        }
        LOGGER.debug("ModelC Start Run");
        check = run();
        if (!check.isSuccess()) {
            return new ModelMethodReturn(false, JsonData.MessageCode.Error);
        }
        return new ModelMethodReturn(true, JsonData.MessageCode.Success);

    }

    @Override
    public IModelMethodReturn run() {
        return new ModelMethodReturn(true,  JsonData.MessageCode.Success);
    }

    @Override
    public IModelMethodReturn stop() {
        return new ModelMethodReturn(true);
    }

    @Override
    public IModelMethodReturn log() {
        return new ModelMethodReturn(true);
    }

    @Override
    public IModelReport result()
    {
        if(this.result!=null){
            ModelReport modelReport= (ModelReport) this.result;
            modelReport.setModel(getName());
            if(lang.equals("zh-CN")){
                modelReport.setTitle("模型报告-"+ DateTool.getName());
            }else{
                modelReport.setTitle("Model Report-"+ DateTool.getName());
            }

            return  modelReport;
        }
        return this.result;
    }
}
