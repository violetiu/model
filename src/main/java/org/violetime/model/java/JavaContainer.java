package org.violetime.model.java;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.violetime.tool.JsonDataTool;
import org.violetime.model.annnotation.ModelContainerConfig;
import org.violetime.model.annnotation.ModelContainerStructure;
import org.violetime.model.core.ModelContainer;
import org.violetime.model.data.IArgsAssemble;
import org.violetime.model.data.IDataAssemble;
import org.violetime.model.report.IModelReport;
import org.violetime.model.view.IModelMethodReturn;
import org.violetime.model.view.ModelMethodReturn;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

/**
 *  Java语言模型容器,
 *  继承该类，需要自动注入参数的类型，不应使用接口，
 */
public class JavaContainer extends ModelContainer implements IJavaContainer {
    public final  static Logger LOGGER= LogManager.getLogger(JavaContainer.class);

    protected  JSONObject structureSaveJson;

    @Override
    public IModelMethodReturn run() {
        IModelReport iModelReport=null;

        if(this.structure!=null&&this.isStructure()){
            structure_load();
            JSONArray jsonArray= this.structure.getJSONArray("dataTitle");
            if(jsonArray!=null&&jsonArray.size()>0){
                String[] dataTitle=new String[jsonArray.size()];
                for(int index=0;index<jsonArray.size();index++){
                    dataTitle[index]=jsonArray.getString(index);
                }
                iModelReport= runStructure(dataTitle);
            }else{
                iModelReport= runStructure(null);
            }

        }else{
            iModelReport=runModel(this.iDataAssemble.getData(),this.iDataAssemble.getDataTitle());
            if(this.isStructure())
                structure_get();

        }
        if(iModelReport==null){
            return  new ModelMethodReturn(false);
        }
        this.result=iModelReport;
        return super.run();
    }

    @Override
    public IModelMethodReturn argsCheck() {
        return super.argsCheck();
    }

    @Override
    public IModelMethodReturn dataCheck() {
        return super.dataCheck();
    }

    @Override
    public JSONObject getStructure() {
        if(this.structureSaveJson==null)
            return null;
        if( this.structureSaveJson.keySet()==null|| this.structureSaveJson.keySet().size()==0)
            return null;
        if(this.iDataAssemble!=null&&this.iDataAssemble.getDataTitle()!=null){
            this.structureSaveJson.put("dataTitle",this.iDataAssemble.getDataTitle());
        }
        return this.structureSaveJson;
    }


    @Override
    public IModelReport runModel(Object[][] data, String[] dataTitle) {
        return null;
    }

    @Override
    public IModelReport runStructure(String[] dataTitle) {
        return null;
    }
    protected void structure_load(){
        System.out.println("structure_load");

        Field[] fields= this.getClass().getDeclaredFields();
        if(fields!=null){
            for(Field field:fields){
                try{
                    Annotation annotation = field.getAnnotation(ModelContainerStructure.class);
                    if (annotation != null && annotation instanceof ModelContainerStructure) {
                        Object value= this.structure.get(field.getName());
                        if(value!=null){
                            field.setAccessible(true);

                            field.set(this, JsonDataTool.valueToObject(field.getType(),value));

                            System.out.println("ModelContainerStructure load  "+field.getName());

                        }
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    protected void structure_get(){
        Field[] fields= this.getClass().getDeclaredFields();
        if(fields!=null){
            for(Field field:fields){
                try{
                    Annotation annotation = field.getAnnotation(ModelContainerStructure.class);
                    if (annotation != null && annotation instanceof ModelContainerStructure) {
                        field.setAccessible(true);
                        Object value=field.get(this);
                        if(value!=null){
                            if(structureSaveJson==null)
                                structureSaveJson=new JSONObject();
                            structureSaveJson.put(field.getName(),value);
                        }
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }

        }
    }
}
