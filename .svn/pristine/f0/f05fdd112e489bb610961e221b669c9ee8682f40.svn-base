package org.violetime.model.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.violetime.tool.JsonDataTool;

import org.violetime.model.annnotation.ModelContainerConfig;
import org.violetime.model.core.IModelContainer;
import org.violetime.model.core.ModelContainer;
import org.violetime.model.data.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 加载模型容器 注解中配置的文件，用于注册数据要求等
 */
public class ModelContainerConfigLoadder {

    private final static Logger LOGGER = LogManager.getLogger(ModelContainer.class);

    public static void loadContainerConfig(IModelContainer iModelContainer,String path) {
        Class containerClass = iModelContainer.getClass();

        Annotation annotation = containerClass.getAnnotation(ModelContainerConfig.class);
        if (annotation != null && annotation instanceof ModelContainerConfig) {
            ModelContainerConfig containerConfig = (ModelContainerConfig) annotation;
            String config = containerConfig.config();
            if (config != null) {

                String configPath =path + "/" + config;
                JSONObject configJson = JsonDataTool.readJsonObjectFile(configPath);
                if (configJson != null) {
                    loadContainerConfig(iModelContainer, configJson);
                }

            }
        }
    }


    public static void loadContainerConfig(IModelContainer iModelContainer, JSONObject configJson) {




        JSONArray dataDemandJson = configJson.getJSONArray("dataDemand");
        if (dataDemandJson != null) {
            IDataDemand iDataDemand = loadDataDemand(dataDemandJson);
            if (iDataDemand != null) {
                iModelContainer.dataDemand(iDataDemand);

            }

        }

        JSONArray argsDemandJson = configJson.getJSONArray("argsDemand");
        if (argsDemandJson != null) {
            IArgsDemand iArgsDemand = loadArgsDemand(argsDemandJson);
            if (iArgsDemand != null) {
                iModelContainer.argsDemand(iArgsDemand);

            }
        }


    }


    public static IDataDemand loadDataDemand(JSONArray dataDemandJson) {

        if (dataDemandJson == null || dataDemandJson.size() == 0) {
            return null;
        }
        List<IDataDemandColumn> dataDemandColumns = new ArrayList<>();
        for (int index = 0; index < dataDemandJson.size(); index++) {
            JSONObject dataDemandColumnJson = dataDemandJson.getJSONObject(index);
            if (dataDemandColumnJson == null || !dataDemandColumnJson.containsKey("type")) {
                continue;
            }
            IDataDemandColumn iDataDemandColumn = loadDataDemandColumn(dataDemandColumnJson);
            if (iDataDemandColumn != null)
                dataDemandColumns.add(iDataDemandColumn);
        }
        if (dataDemandColumns.size() == 0)
            return null;
        DataDemand dataDemand = new DataDemand();
        dataDemand.setColumns(listToArrayColumn(dataDemandColumns));
        return dataDemand;
    }
    private static IDataDemandColumn[] listToArrayColumn( List<IDataDemandColumn> iDataDemandColumns){
        IDataDemandColumn[] array=new DataDemandColumn[iDataDemandColumns.size()];
        for(int index=0;index<iDataDemandColumns.size();index++){
            array[index]=iDataDemandColumns.get(index);
        }
        return  array;

    }
    private static IModelArg[] listToArrayArgs( List<IModelArg> iModelArgs){
        IModelArg[] array=new IModelArg[iModelArgs.size()];
        for(int index=0;index<iModelArgs.size();index++){
            array[index]=iModelArgs.get(index);
        }
        return  array;

    }
    public static IArgsDemand loadArgsDemand(JSONArray argsdemandJson) {

        if (argsdemandJson == null || argsdemandJson.size() == 0) {
            return null;
        }
        List<IModelArg> modelArgs = new ArrayList<>();
        for (int index = 0; index < argsdemandJson.size(); index++) {
            JSONObject modelArgsJson = argsdemandJson.getJSONObject(index);
            if (modelArgsJson == null || !modelArgsJson.containsKey("type")) {
                continue;
            }
            IModelArg iModelArg = loadModelArgs(modelArgsJson);
            if (iModelArg != null)
                modelArgs.add(iModelArg);
        }
        if (modelArgs.size() == 0)
            return null;

        ArgsDemand argsDemand = new ArgsDemand();
        argsDemand.setiModelArgs(listToArrayArgs(modelArgs));
        LOGGER.debug("load args is "+argsDemand.getiModelArgs().length);
        return argsDemand;
    }

    private static IModelArg loadModelArgs(JSONObject modelArgJson) {
        if (modelArgJson.keySet() == null || modelArgJson.keySet().size() == 0)
            return null;
        ModelArg modelArg = new ModelArg();
        Class modelArgClass = modelArg.getClass();
        for (Object key : modelArgJson.keySet()) {
            try {
                Field field = modelArgClass.getDeclaredField(key.toString());
                field.setAccessible(true);
                if (field.getType().equals(String.class)) {
                    Object value = modelArgJson.get(key);
                    field.set(modelArg, value.toString());
                } else if (field.getType().equals(Integer.class)) {
                    Object value = modelArgJson.get(key);
                    field.set(modelArg, Integer.parseInt(value.toString()));
                } else if (field.getType().equals(Double.class)) {
                    Object value = modelArgJson.get(key);
                    field.set(modelArg, Double.parseDouble(value.toString()));
                } else if (field.getType().equals(ModelArgType.class)) {
                    String typeJson = modelArgJson.getString(key.toString());
                    ModelArgType modelArgType = new ModelArgType(typeJson);
                    field.set(modelArg, modelArgType);
                } else if (field.getType().equals(boolean.class)) {
                    Object value = modelArgJson.get(key);
                    field.set(modelArg, Boolean.parseBoolean(value.toString()));
                } else if (field.getType().equals(List.class)) {
                    JSONArray options = modelArgJson.getJSONArray(key.toString());

                    List<ModelArgsOption> modelArgsOptions = options.toJavaList(ModelArgsOption.class);

                    field.set(modelArg, modelArgsOptions);
                } else {
                    Object value = modelArgJson.get(key);
                    field.set(modelArg, value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        return modelArg;
    }

    private static IDataDemandColumn loadDataDemandColumn(JSONObject dataDemandColumnJson) {
        if (dataDemandColumnJson.keySet() == null || dataDemandColumnJson.keySet().size() == 0)
            return null;
        DataDemandColumn dataDemandColumn = new DataDemandColumn();
        Class dataDemandColumnClass = dataDemandColumn.getClass();
        for (Object key : dataDemandColumnJson.keySet()) {
            Object value = dataDemandColumnJson.get(key);
            try {
                Field field = dataDemandColumnClass.getDeclaredField(key.toString());
                field.setAccessible(true);
                if (field.getType().equals(String.class)) {
                    field.set(dataDemandColumn, value.toString());
                } else if (field.getType().equals(DataDemandColumnType.class)) {
                    String typeJson = dataDemandColumnJson.getString(key.toString());
                    DataDemandColumnType dataDemandColumnType =new DataDemandColumnType(typeJson);
                    field.set(dataDemandColumn, dataDemandColumnType);
                } else if (field.getType().equals(Integer.class)) {
                    field.set(dataDemandColumn, Integer.parseInt(value.toString()));
                } else if (field.getType().equals(Double.class)) {
                    field.set(dataDemandColumn, Double.parseDouble(value.toString()));
                } else {
                    field.set(dataDemandColumn, value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dataDemandColumn;
    }


}
