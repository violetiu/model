package org.violetime.tool;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateTool {

    public  static  String add(String date,int num) throws ParseException {
        if(date.length()==7){
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM");
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(simpleDateFormat.parse(date));
            calendar.add(Calendar.MONTH,num);
            return simpleDateFormat.format(calendar.getTime());
        }else if(date.length()==4){
           return  (Integer.parseInt(date)+num)+"";
        }else if(date.length()==10){
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-ddd");
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(simpleDateFormat.parse(date));
            calendar.add(Calendar.DAY_OF_MONTH,num);
            return simpleDateFormat.format(calendar.getTime());
        }else{
            return date;
        }

    }
    /**
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public  static String getNow(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  simpleDateFormat.format(new Date());
    }
    /**
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public  static String getToday(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return  simpleDateFormat.format(new Date());
    }

    /**
     *
     * @param start yyyy-MM-dd
     * @param end yyyy-MM-dd
     * @return
     */
    public  static boolean between(String start,String end){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date startDate=simpleDateFormat.parse(start);
            Date endDate=simpleDateFormat.parse(end);
            if(new Date().after(startDate)&&new Date().before(endDate)){
                return  true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  false;


    }

    /**
     *
     * @return HH,mm
     */
    public  static String getName(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH,mm");
        return  simpleDateFormat.format(new Date());
    }

    /**
     *
     * @param start yyyy-MM
     * @param end yyyy-MM
     * @return
     * @throws ParseException
     */
    public static List<String> getMonths(String start,String end) throws ParseException {
        List<String> result = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(sdf.parse(start));
        // 加了一个月
        tempStart.add(Calendar.MONTH, 1);
        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(sdf.parse(end));
        result.add(start);
        while (tempStart.before(tempEnd)) {
            result.add(sdf.format(tempStart.getTime()));
            tempStart.add(Calendar.MONTH, 1);
        }
        return  result;
    }

    /**
     *
     * @param start yyyy-MM-dd
     * @param end yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static List<String> getDays(String start,String end) throws ParseException {
        List<String> result = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(sdf.parse(start));
        // 加了一个月
        tempStart.add(Calendar.DAY_OF_MONTH, 1);
        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(sdf.parse(end));
        result.add(start);
        while (tempStart.before(tempEnd)) {
            result.add(sdf.format(tempStart.getTime()));
            tempStart.add(Calendar.DAY_OF_MONTH, 1);
        }
        return  result;
    }
    /**
     *
     * @param start yyyy-MM-dd
     * @param end yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static List<String> getDaysEnd(String start,String end) throws ParseException {
        List<String> result =getDays(start,end);
        result.add(end);
        return  result;
    }

    /**
     *
     * @param month  yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static int getDays(String month) throws ParseException {

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM");
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(simpleDateFormat.parse(month));
        return  calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
