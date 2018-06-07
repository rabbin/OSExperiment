package disk_managemnet;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args){

        Random rd = new Random(System.currentTimeMillis());

        final int start = 100;
        final int len = 8;
        LinkedList<Integer> requestQueue = new LinkedList<>();
        for(int i = 0; i< len; i++ ){
            requestQueue.add(rd.nextInt(200)+15);
        }

        System.out.println("SSTF: ");
        DiskManageService sstf = new DiskManageService(DiskManageService.Type.SSTF, requestQueue);
        sstf.start(start);

        System.out.println("SCAN: ");

        DiskManageService scan = new DiskManageService(DiskManageService.Type.SCAN, requestQueue);
        scan.start(start);


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // 创建窗口对象
                MyFrame frame = new MyFrame(sstf.visitQueue, scan.visitQueue);
                // 显示窗口
                frame.setVisible(true);
            }
        });




    }


    public static class MyFrame extends JFrame {

        public static final String TITLE = "OS experiment";

        public static final int WIDTH = 700;
        public static final int HEIGHT = 300;

        LinkedList<Integer> sstf;
        LinkedList<Integer> scan;

        public MyFrame(LinkedList<Integer> sstf, LinkedList<Integer> scan) {
            super();
            this.sstf = sstf;
            this.scan = scan;
            initFrame();
        }

        private void initFrame() {
            // 设置 窗口标题 和 窗口大小
            setTitle(TITLE);
            setSize(WIDTH, HEIGHT);

            // 设置窗口关闭按钮的默认操作(点击关闭时退出进程)
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            // 把窗口位置设置到屏幕的中心
            setLocationRelativeTo(null);

            // 设置窗口的内容面板
            MyPanel panel = new MyPanel(this);
            setContentPane(panel);
        }

    }


    public static class MyPanel extends JPanel {

        private MyFrame frame;

        public MyPanel(MyFrame frame) {
            super();
            this.frame = frame;
        }

        /**
         * 绘制面板的内容: 创建 JPanel 后会调用一次该方法绘制内容,
         * 之后如果数据改变需要重新绘制, 可调用 updateUI() 方法触发
         * 系统再次调用该方法绘制更新 JPanel 的内容。
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            frame.setTitle("os-disk");

            Graphics2D g2d = (Graphics2D) g.create();

            // 抗锯齿
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // 设置画笔颜色

            int nPoints = frame.scan.size()-1;
            int[] xPoints = new int[nPoints];
            for (int i = 0;i<nPoints;i++){
                xPoints[i]= (i+1)*50;
            }
            int[] scanYPoints = new int[nPoints];
            for (int i = 0; i< nPoints;i++){
                scanYPoints[i]= frame.scan.get(i);
            }



            int[] sstfYPoint = new int[nPoints];
            for (int i = 0; i< nPoints;i++){
                sstfYPoint[i]= frame.sstf.get(i);
            }

            g2d.setColor(Color.BLUE);
            g2d.drawPolyline(xPoints, sstfYPoint, nPoints);

            g2d.setColor(Color.RED);
            g2d.drawPolyline(xPoints, scanYPoints, nPoints);


            drawString(g2d, frame.sstf, frame.scan);


        }

        private void drawString(Graphics2D g2d, LinkedList<Integer> sstf, LinkedList<Integer> scan) {


            // 设置字体样式, null 表示使用默认字体, Font.PLAIN 为普通样式, 大小为 25px
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font(null, Font.PLAIN, 10));

            int size = sstf.size();
            for(int i= 0;i < size-1;i++){
                if(sstf.get(i).equals(scan.get(i))){
                    g2d.drawString(String.valueOf(sstf.get(i)), (i+1)*50, sstf.get(i)-5);

                }
                else{
                    g2d.drawString(String.valueOf(sstf.get(i)), (i+1)*50, sstf.get(i)+10);

                    g2d.drawString(String.valueOf(scan.get(i)), (i+1)*50, scan.get(i)-5);

                }
            }


            g2d.setFont(new Font(null, Font.PLAIN, 15));

            g2d.setColor(Color.BLUE);

            g2d.drawString("总移臂量(sstf)： "+sstf.get(size-1), 460, 100);

            g2d.setColor(Color.RED);

            g2d.drawString("总移臂量(scan)： "+scan.get(size-1), 460, 200);




            g2d.dispose();
        }

    }
}


