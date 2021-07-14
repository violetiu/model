package org.violetime.chart;

import java.awt.*;

public class LineCharts {

    private String[] legends;

    public String[] getLegends() {
        return legends;
    }

    public void setLegends(String[] legends) {
        this.legends = legends;
    }

    private int height;
    private int width;
    private String title;
    private String[] xData;
    private Double[][] yData;
    private String xAxis;
    private String yAxis;

    public  void render(Graphics2D  g){
        int margin=40;
        g.setStroke(new BasicStroke(2));
        g.setColor(new Color(40, 40, 40));
        //title
        g.drawString(title,margin,margin-20);
        //yAxis
        g.drawString(yAxis,margin-10,margin-20);
        g.drawLine(margin, margin, margin, height-margin);
        //xAxis
        g.drawString(xAxis,width-margin,height-margin+20);
        g.drawLine(margin, height-margin,width-margin, height-margin);
        //line
        Double max=null;
        Double min=null;
        for (Double[] list : yData) {
            for(Double val:list){
                if(max==null||max<val){
                    max=val;
                }
                if(min==null||min>val){
                    min=val;
                }
            }
        }
        double yHeight=max-min;
        int[] xPoints=new int[xData.length];
        for(int index=0;index<xData.length;index++){
            Double x=index*1.0/xData.length*(width-margin*2)+margin;
            xPoints[index]=x.intValue();
            g.drawString(xData[index],x.intValue(),height-margin+20);
        }

        for (int index=0;index<yData.length;index++) {
            Double[] list=yData[index];
            paintLine(list,g,margin,xPoints,max,min,yHeight,index);

        }
    }
    private  void paintLine(Double[] list,Graphics2D  g,int margin,  int[] xPoints,double max,double min,double yHeight,int legend){

        int[] yPoints=new int[list.length];
        for(int index=0;index<list.length;index++){
            double val=list[index];
            int x=xPoints[index];
            Double y=(height-margin*2)- (val-min)/yHeight*(height-margin*2)+margin;
            yPoints[index]=y.intValue();

            g.drawLine(x, height-margin, x, height-margin+10);;
            g.drawString(val+"",x,y.intValue());
        }
        float[] dash = { 2f+legend, 0f, 2f+legend };

        g.setStroke( new BasicStroke(1,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND,
                1.0f,
                dash,
                2f));
        g.drawPolyline(xPoints,yPoints,xPoints.length);
        int start=(width-title.length()*12)/3+legend*200;
        g.drawLine(start,margin-20,start+40,margin-20);;
        g.setStroke(new BasicStroke(2));
        g.drawString(legends[legend],start+40+10,margin-20);

    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getxData() {
        return xData;
    }

    public void setxData(String[] xData) {
        this.xData = xData;
    }

    public Double[][] getyData() {
        return yData;
    }

    public void setyData(Double[][] yData) {
        this.yData = yData;
    }

    public String getxAxis() {
        return xAxis;
    }

    public void setxAxis(String xAxis) {
        this.xAxis = xAxis;
    }

    public String getyAxis() {
        return yAxis;
    }

    public void setyAxis(String yAxis) {
        this.yAxis = yAxis;
    }
}
