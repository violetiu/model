package org.violetime.tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.violetime.model.data.DataDemandColumn;
import org.violetime.model.data.DataDemandColumnType;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * json数据操作
 */
public class JsonDataTool {

    public static double[] getColumnArray(Object[][] data,int column){
        double[] result=new double[data.length];
        for(int i=0;i<data.length;i++){

                result[i]= numberToDouble(data[i][column]);

        }

        return  result;
    }

    public static  Object valueToObject(Class type,Object value){
        if(value==null)
            return  value;

        if(type.equals(value.getClass())){
            return value;
        }
        if(type.equals(String.class)){
            return value.toString();
        }
        if(type.equals(Double.class)||type.equals(double.class)){
            return Double.parseDouble(value.toString());

        }
        if(type.equals(int.class)||type.equals(Integer.class)){
            return Integer.parseInt(value.toString());

        }
        if(type.equals(Boolean.class)||type.equals(boolean.class)){
            return Boolean.parseBoolean(value.toString());

        }
        if(value.getClass().equals(JSONObject.class)||value.getClass().equals(JSONArray.class)){
            return JSON.toJavaObject((JSON) value,type);
        }

        return  null;

    }

    public  static Double numberToDouble(Object cellVal){
        Double val=null;
        if(cellVal.getClass().equals(String.class)){
            if(cellVal.toString().trim().matches("-?\\d+\\.?\\d*")){
                val=Double.parseDouble(cellVal.toString());
            }else if(cellVal.toString().trim().matches("-?\\d+\\.?\\d*%")){
                val=Double.parseDouble(cellVal.toString().replace("%","E-2"));
            }else if(cellVal.toString().trim().matches(   "-?\\d+\\.?\\d*E\\+?-?\\d*")){
                val=Double.parseDouble(cellVal.toString());
            }
        }else if(cellVal.getClass().equals(Double.class)||cellVal.getClass().equals(double.class)){
            val= (Double) cellVal;

        }
        else if(cellVal.getClass().equals(Integer.class)||cellVal.getClass().equals(int.class)){
            val= (Integer) cellVal*1.0;

        }
        else if(cellVal.getClass().equals(BigDecimal.class)){
            val= ((BigDecimal) cellVal).doubleValue();

        }
        return val;
    }


    public  static Double numberCellToDouble(  DataDemandColumn demandColumn,Object cellVal){
        Double val=null;
        if(demandColumn.getType().equals(DataDemandColumnType.Number)){
            if(cellVal.toString().trim().matches("-?\\d+\\.?\\d*")){
                val=Double.parseDouble(cellVal.toString());
            }else if(cellVal.toString().trim().matches("-?\\d+\\.?\\d*%")){
                val=Double.parseDouble(cellVal.toString().replace("%","E-2"));
            }else if(cellVal.toString().trim().matches(   "-?\\d+\\.?\\d*E\\+?-?\\d*")){
                val=Double.parseDouble(cellVal.toString());
            }
        }
        return val;
    }

    /**
     *如果某个数据异常，默认为0
     * @param data
     * @return
     */
    public  static double[][] getObjectToDoubleArray(Object[][] data){

        double[][] result=new double[data.length][data[0].length];
        for(int index=0;index<data.length;index++){

            for(int j=0;j<data[index].length;j++){
                Object value=data[index][j];
                double val=0d;
                if(value!=null){
                    if(value.getClass().equals(String.class)){
                        if(value.toString().trim().matches("-?\\d+\\.?\\d*")){
                            val= Double.parseDouble(value.toString());
                        }else if(value.toString().trim().matches("-?\\d+\\.?\\d*%")){
                            val= Double.parseDouble(value.toString().replace("%","E-2"));
                        }else if(value.toString().trim().matches( "-?\\d+\\.?\\d*E\\+?-?\\d*")){
                            val= Double.parseDouble(value.toString());
                        }
                    }else{
                        try{
                            val= Double.parseDouble(value.toString());
                        }catch (Exception e) {

                        }
                    }
                }

                result[index][j]=val;
            }
        }

//        print(data);
//        System.out.println("=========");
//        print(result);

        return result;
    }
    /**
     *如果某个数据异常，默认为0
     * @param jsonArray
     * @return
     */
    public  static double[][] getJsonDoubleArray(JSONArray jsonArray){
        int columnCount=jsonArray.getJSONArray(0).size();
        double[][] result=new double[jsonArray.size()][columnCount];
        for(int index=0;index<jsonArray.size();index++){
            JSONArray array=jsonArray.getJSONArray(index);
            for(int j=0;j<array.size()&&j<columnCount;j++){
                Object value=array.get(j);
                double val=0d;
                try{
                   val= Double.parseDouble(value.toString());
                }catch (Exception e) {
                    e.printStackTrace();
                }
               result[index][j]=val;
            }
        }
        return result;
    }

    /**
     * 根据数据要求获取数据
     * @param jsonArrayTmp
     * @param demandJsonArray
     * @return
     */
    public static JSONArray dealJsonDataByDemand( JSONArray jsonArrayTmp,JSONArray demandJsonArray){
        JSONArray jsonArray=new JSONArray();
        for(int index=0;index<jsonArrayTmp.size();index++){
            JSONArray rowTmp=jsonArrayTmp.getJSONArray(index);
            JSONArray row=new JSONArray();
            for(int demandIndex=0;demandIndex<demandJsonArray.size();demandIndex++){
                JSONObject demandJson=demandJsonArray.getJSONObject(demandIndex);
                if(demandJson.containsKey("checked")){
                    Boolean checked= demandJson.getBoolean("checked");
                    if(checked){
                       Object cell= rowTmp.get(demandIndex);
                       String columnType=demandJson.getJSONObject("type").getString("type");

                       if(columnType.equals(DataDemandColumnType.Number.toString())){
                           if(cell.toString().trim().matches("-?\\d+\\.?\\d*")){
                               row.set(row.size(),Double.parseDouble(cell.toString()));
                           }else if(cell.toString().trim().matches("-?\\d+\\.?\\d*%")){
                               row.set(row.size(),Double.parseDouble(cell.toString().replace("%","E-2")));
                           }else if(cell.toString().trim().matches(   "-?\\d+\\.?\\d*E\\+?-?\\d*")){
                               row.set(row.size(),Double.parseDouble(cell.toString()));
                           }else{
                               row.set(row.size(),cell);
                           }

                       }else if(columnType.equals(DataDemandColumnType.String.toString())){
                           row.set(row.size(),cell.toString());
                        }else{
                           row.set(row.size(),cell);
                        }

                    }
                }
            }

            jsonArray.set(jsonArray.size(),row);
        }
        return  jsonArray;
    }


    /**
     * 获取数据要求
     * @param demandJsons
     * @return
     */
    public static List<Integer> getDemandIndexs( JSONArray demandJsons){
        List<Integer> demandIndexs=new ArrayList<>();
        for(int index=0;index<demandJsons.size();index++){
            JSONObject demandObjo=demandJsons.getJSONObject(index);
            if(demandObjo.containsKey("checked")){
                Boolean checked= demandObjo.getBoolean("checked");
                if(checked){
                    demandIndexs.add(index);
                }
            }

        }
        return  demandIndexs;
    }

    public  static int hasTitleData(Object[][] data){
        int hasTitle=0;
        //获取 列类型
        //判断是否有标题
        for(int row=0;row<data.length;row++){
            boolean isFalg=true;
            for(int column=0;column<data[row].length;column++){
                Object cellTop=data[row][column];

                if(row+1<data.length){
                    Object cellBottom=data[row+1][column];
                    if(cellTop.getClass().equals(cellBottom.getClass())){

                    }else{

                        isFalg=false;
                        break;
                    }
                }else{
                    break;
                }
            }
            if(!isFalg)
            {
                hasTitle=row+1;
            }
        }
        return  hasTitle;
    }
    /**
     * 读取 jsonObject文件
     * @param jsonPath
     * @return
     */
    public  static IJsonData readJsonData(String  jsonPath){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File(jsonPath)));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
            return  JSON.toJavaObject(JSON.parseObject(result.toString()), JsonData.class);
        }catch(Exception e){
            e.printStackTrace();
        }
        return  null;
    }
    /**
     * 保存对象值json文件中，返回路径
     * @param data
     * @return
     */
    public  static  String  saveToJsonData(IJsonData data, String appPath){
        String jsonPath= appPath+ "tmp/data-"+ UUID.randomUUID()+".json";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(jsonPath);
            fileWriter.write(JSON.toJSONString(data));
            fileWriter.flush();
            fileWriter.close();
            return jsonPath;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 保存对象值json文件中，返回路径
     * @param data
     * @return
     */
    public  static  String  saveToJson(Object  data,String appPath){
        String jsonPath=appPath+ "tmp/data-"+ UUID.randomUUID()+".json";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(jsonPath);
            fileWriter.write(JSON.toJSONString(data));
            fileWriter.flush();
            fileWriter.close();
            return jsonPath;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 读取 jsonArray文件
     * @param jsonPath
     * @return
     */
    public  static  Object[][] readJsonArrayFileToObjects(String  jsonPath){
        JSONArray jsonArray=readJsonArrayFile(jsonPath);
        if(jsonArray==null)
            return null;
        Object[][] data=JSON.toJavaObject(jsonArray,Object[][].class);
        return  data;
    }
    /**
     * 读取 jsonArray文件
     * @param jsonPath
     * @return
     */
    public  static JSONArray readJsonArrayFile(String  jsonPath){
       File file=new File(jsonPath);
       if(!file.exists()){
           return  null;
       }

        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
            return  JSON.parseArray(result.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
        return  null;
    }
    /**
     * 读取 jsonObject文件
     * @param jsonPath
     * @return
     */
    public  static JSONObject readJsonObjectFile(String  jsonPath){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File(jsonPath)));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
            return  JSON.parseObject(result.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
        return  null;
    }
    public static void print(Object[][] data){
        System.out.println("----print-Object[][]-----");
        for(Object[] obj :data){
            print(obj);
        }

    }
    public static void print(double[][] points){
        System.out.println("----------");
        for(double[] point :points){
            print(point);
        }

    }
    public static void print(Object[] list){
        for(Object val :list){
            System.out.print(val+"\t");
        }
        System.out.println();
    }
    public static void print(double[] point){
        for(double val :point){
            System.out.print(val+"\t");
        }
        System.out.println();
    }

}
