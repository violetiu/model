package org.violetime.tool;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.violetime.model.data.DataDemandColumn;
import org.violetime.model.data.DataDemandColumnType;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 数据 的json格式存贮对象
 */
public class JsonData implements IJsonData {

    private   String columnString = "ABCDEFGHIJKLMNOPQRSTVUWXYZ";
    private DataDemandColumnType getCellType(Object cell){
        Class type =cell.getClass();
        if (type.equals(String.class)) {

            if(cell.toString().trim().matches("-?\\d+\\.?\\d*")){
                return DataDemandColumnType.Number;
            }else if(cell.toString().trim().matches("-?\\d+\\.?\\d*%")){
                return DataDemandColumnType.Number;
            }else if(cell.toString().trim().matches("-?\\d+\\.?\\d*E\\+?-?\\d*")){
                return DataDemandColumnType.Number;
            }else{
                return  DataDemandColumnType.String;
            }
        } else if (type.equals(Double.class) || type.equals(double.class)
                || type.equals(Integer.class) || type.equals(int.class)
                || type.equals(BigDecimal.class)) {

            return DataDemandColumnType.Number;
        } else {

            return  DataDemandColumnType.Other;
        }

    }

    public boolean loadData(Object[][] data) {
        if (data == null || data.length == 0)
            return false;

        int hasTitle = 0;
        //判断是否有标题
        boolean hasNoString=false;//检查是否存在非文本值，如果不存在，需要处理全是文本情况下的标题数据。
        for (int row = 0; row < data.length; row++) {
            boolean isFalg = true;

            for (int column = 0; column < data[row].length; column++) {
                Object cellTop = data[row][column];
                if(cellTop==null)
                    continue;
                if(!cellTop.getClass().equals(String.class)){
                    hasNoString=true;
                }
                if (row + 1 < data.length) {
                    Object cellBottom = data[row + 1][column];
                    if(cellBottom==null)
                        continue;
                    if (cellTop.getClass().equals(cellBottom.getClass())) {
                    } else {
                        isFalg = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!isFalg) {
                hasTitle = row + 1;
            }
        }
        //如果不存在，需要处理全是文本情况下的标题数据。
        //如果第一行的长度异常于其他行，则认为第一行为标题列。
        if(!hasNoString){
            for(int column=0;column<data[0].length;column++){
                Integer maxLen=null;
                Integer minLen=null;
                int sumLen=0;
                Integer firstLen=null;
                for(int row=0;row<data.length;row++){
                    Object value=data[row][column];
                    if(value==null)
                        continue;;
                    int len=value.toString().length();

                    if(row==0){
                        firstLen=len;
                    }else{
                        if(maxLen==null||maxLen<len){
                            maxLen=len;
                        }
                        if(minLen==null||minLen>len){
                            minLen=len;
                        }
                    }
                    sumLen+=len;
                }
                if(firstLen<minLen||firstLen>maxLen){
                    hasTitle=1;
                    break;
                }
            }
        }

        //获取 列类型
        DataDemandColumnType[] columnsTypes = new DataDemandColumnType[data[0].length];
        for (int column = 0; column < data[0].length; column++) {
            DataDemandColumnType columnType = null;
            for (int row = hasTitle; row < data.length; row++) {
                Object cell = data[row][column];
                if(cell==null)
                    continue;
                DataDemandColumnType cellType = getCellType(cell);
                if (columnType == null) {
                    columnType = cellType;
                } else if (!cellType.equals(cellType)) {
                    columnType = DataDemandColumnType.String;
                    break;
                }
            }
            if (columnType == null)
                columnType = DataDemandColumnType.Other;
            columnsTypes[column] = columnType;
        }
        this.titleRow=hasTitle;
        //获取  列名
        String[] columnTitles = new String[data[0].length];
        if (hasTitle > 0) {
            for (int index = 0; index < columnTitles.length; index++) {
                columnTitles[index] = data[0][index].toString();
            }
        } else {
            for (int index = 0; index < columnTitles.length; index++) {
                columnTitles[index] = columnString.charAt(index) + "";
            }
        }
        this.titles=columnTitles;
        //组装列名 和 类型
        DataDemandColumn[] iDataDemandColumns = new DataDemandColumn[columnTitles.length];
        for (int index = 0; index < columnTitles.length; index++) {
            DataDemandColumn dataDemandColumn = new DataDemandColumn();
            dataDemandColumn.setIndex(index);
            String title = columnTitles[index];
            dataDemandColumn.setLabel(title);
            dataDemandColumn.setType(columnsTypes[index]);
            iDataDemandColumns[index] = dataDemandColumn;
        }
        this.columns=iDataDemandColumns;

        int newRowCount=data.length-hasTitle;
        this.data=new Object[newRowCount][columnTitles.length];
        for(int index=hasTitle;index<data.length;index++){
            this.data[index-hasTitle]=data[index];
        }


        return  true;
    }
    private Object[][] data;
    private int titleRow;
    private DataDemandColumn[] columns;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String[] titles;

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public Object[][] getData() {
        return data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    public int getTitleRow() {
        return titleRow;
    }

    public void setTitleRow(int titleRow) {
        this.titleRow = titleRow;
    }

    public DataDemandColumn[] getColumns() {
        return columns;
    }

    @Override
    public IJsonData loadDemand(JSONArray demandJsons) {
        JsonData newJsonData=new JsonData();

        int demandCount=0;
        List<Integer> checkedColumns=new ArrayList<>();
        for(int demandIndex=0;demandIndex<demandJsons.size();demandIndex++) {
            JSONObject demandJson = demandJsons.getJSONObject(demandIndex);
            if (demandJson.containsKey("checked")) {
                Boolean checked = demandJson.getBoolean("checked");
                if (checked) {
                    demandCount++;
                    checkedColumns.add(demandIndex);
                }
            }
        }

        String[] newTitles=new String[demandCount];
        DataDemandColumn[] newDemandColumns=new DataDemandColumn[demandCount];
        int count=0;
        for(int demandIndex=0;demandIndex<demandJsons.size();demandIndex++) {
            JSONObject demandJson = demandJsons.getJSONObject(demandIndex);
            if (demandJson.containsKey("checked")) {
                Boolean checked = demandJson.getBoolean("checked");
                if (checked) {
                    newTitles[count]=this.titles[demandIndex];
                    newDemandColumns[count]=this.columns[demandIndex];
                    count++;
                }
            }
        }
        newJsonData.setTitles(newTitles);
        newJsonData.setColumns(newDemandColumns);
        Object[][] newData=new Object[this.data.length][demandCount];
        for(int row=0;row<this.data.length;row++){
            for(int column=0;column<this.titles.length;column++ ){
                   int index=checkedColumns.indexOf(column);
                    if(index>=0){
                        newData[row][index]=this.data[row][column];
                    }

            }
        }
        newJsonData.setData(newData);
        return  newJsonData;
    }

    public void setColumns(DataDemandColumn[] columns) {
        this.columns = columns;
    }

    public void loadData(List<?> list, Class cls, Map<String, String> titles) {
        Object[][] datas=new Object[list.size()+1][titles.size()];
        int col=0;
       for(Object key :titles.keySet()){
           datas[0][col]=titles.get(key);
           col++;
       }
       for(int row=0;row<list.size();row++){
           int colTmp=0;
           for(Object key :titles.keySet()){
               try {
                   Method method= cls.getMethod("get"+key.toString().substring(0,1).toUpperCase()+key.toString().substring(1));
                   Object value=method.invoke(list.get(row));
                   datas[row+1][colTmp]=value;
               }catch (Exception ex){
                   ex.printStackTrace();
               }
               colTmp++;
           }
       }
       loadData(datas);
    }

    public enum MessageCode {
        Success,Error,error_no_select,error_model_data,error_no_file,error_request,error_param,error_token,error_no_auth
    }
}
