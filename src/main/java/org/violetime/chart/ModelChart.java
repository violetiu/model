package org.violetime.chart;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ModelChart {

    public static void main(String[] args) {
        LineCharts  lineCharts=new LineCharts();
        lineCharts.setTitle("title");
        lineCharts.setxAxis("x");
        lineCharts.setyAxis("y");
        lineCharts.setLegends(new String[]{"A"});
        lineCharts.setxData(new String[]{"0","1","2","3","4","5","6","7"});
        lineCharts.setyData(new Double[][]{{0.0,4.7,0.0,1.09,0.0,0.0,2.53,0.0}});
        line("/Users/taoyongwen/Downloads/demo.jpg",lineCharts);
    }
    public static void line(String path,LineCharts lineCharts) {
        int width=2000;
        int height=800;
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        final File file = new File(path);
        try {
            if(file.exists()) {
                file.delete();
                file.createNewFile();
            }
        }catch(IOException e) {
            e.printStackTrace();
        }

        Graphics2D g = (Graphics2D) bi.getGraphics();
        Font font = new Font(g.getFont().getName(), Font.BOLD, 18);
        g.setFont(font);
        g.setBackground(Color.WHITE);
        g.setColor(Color.WHITE);//设置笔刷白色
        g.fillRect(0,0,width,height);//填充整个屏幕

        lineCharts.setWidth(width);
        lineCharts.setHeight(height);
        lineCharts.render(g);
        g.dispose();
        boolean val = false;
        try {
            val = ImageIO.write(bi, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("绘图成功");

    }


}
