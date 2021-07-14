package org.violetime.tool;

/**
 * 模型 数学 基本方法
 */
public class ModelMath {
    /**
     * 求和
     * @param array
     * @return
     */
    public static double sum(double[] array) {
        if(array==null||array.length==0){
            return 0d;
        }
        double sum=0d;
        for(double value :array){
            sum+=value;
        }
        return sum;

    }

    /**
     * 求均值
     * @param array
     * @return
     */
    public static double mean(double[] array) {
        if(array==null||array.length==0){
            return 0d;
        }
        return sum(array)/array.length;
    }
    /**
     * 求均值
     * @param array
     * @return
     */
    public static double mean(double[] array,double sum) {
        if(array==null||array.length==0){
            return 0d;
        }
        return sum/array.length;
    }

    /**
     * 求最大值
     * @param array
     * @return
     */
    public static double max(double[] array){
        if(array==null||array.length==0){
            return 0d;
        }
        Double max=null;
        for(double value :array){
            if(max==null||max<value){
                max=value;
            }
        }
        return max;
    }

    /**
     * 求最小值
     * @param array
     * @return
     */
    public static double min(double[] array){
        if(array==null||array.length==0){
            return 0d;
        }
        Double min=null;
        for(double value :array){
            if(min==null||min>value){
                min=value;
            }
        }
        return min;
    }

    /**
     * 标准差
     * @param array
     * @return
     */
    public static double std(double[] array){
        if(array==null||array.length==0){
            return 0d;
        }
        double mean=mean(array);
        double tmp=0d;
        for(double value :array){
            tmp+=Math.pow(value-mean,2);
        }
        return Math.pow(tmp/array.length,0.5);
    }

    /**
     * 标准差
     * @param array
     * @return
     */
    public static double std(double[] array,double mean){
        if(array==null||array.length==0){
            return 0d;
        }
        double tmp=0d;
        for(double value :array){
            tmp+=Math.pow(value-mean,2);
        }
        return Math.pow(tmp/array.length,0.5);
    }

    /**
     * 控制精度 四舍五入
     * @param value
     * @param len
     * @return
     */
    public static double floor(double value,int len){
        return Math.floor(value*Math.pow(10,len))/Math.pow(10,len);
    }

    /**
     * 转置
     * @param matix
     * @return
     */
    public static Object[][] transpose(Object[][] matix){
        Object[][] result=new Object[matix[0].length][matix.length];
        for(int i=0;i<matix.length;i++){
            for(int j=0;j<matix[0].length;j++){
                result[j][i]=matix[i][j];
            }
        }
        return result;
    }
    /**
     * 转置
     * @param matix
     * @return
     */
    public static double[][] transpose(double[][] matix){
        double[][] result=new double[matix[0].length][matix.length];
        for(int i=0;i<matix.length;i++){
            for(int j=0;j<matix[0].length;j++){
                result[j][i]=matix[i][j];
            }
        }
        return result;
    }
}
