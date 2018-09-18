package MyThread;

import java.applet.Applet;
import java.awt.*;
import java.util.Date;

public class MyClock extends Applet implements Runnable {
    Thread hhread=null;
    Thread mThread=null;
    Thread sThread=null;

    int hourX,hourY,minuteX,minuteY,secondX,secondY;
    int currentHour=0;
    int currentMinute=0;
    int currentSecond=0;
    Graphics sGraphics=null;
    Graphics mGraphics=null;
    Graphics hGraphics=null;
    Graphics2D mg2D=null;
    Graphics2D hg2D=null;
    Graphics2D sg2D=null;
    double drawX[]=new double[61];
    double drawY[]=new double[61];
    double dial_x[]=new double[61];
    double dial_y[]=new double[61];
    int isRestart=0;
    public void init(){
        hGraphics=this.getGraphics();
        hGraphics.setColor(Color.white);
        hg2D=(Graphics2D) hGraphics;
        hGraphics.translate(200,200);
        mGraphics=this.getGraphics();
        mg2D=(Graphics2D) mGraphics;
        mGraphics.setColor(Color.green);
        mGraphics.translate(200,200);
        sGraphics=this.getGraphics();
        sg2D=(Graphics2D) sGraphics;
        sGraphics.setColor(Color.blue);
        sGraphics.translate(200,200);
        drawX[0]=0;
        drawY[0]=-120;
        dial_x[0]=0;
        dial_y[0]=-140;
        double jiaodu=6*Math.PI/180;//问题
        for(int i=0;i<60;i++){
            drawX[i+1]=drawX[i]*Math.cos(jiaodu)-Math.sin(jiaodu)*drawY[i];
            drawY[i+1]=drawY[i]*Math.cos(jiaodu)+drawX[i]*Math.sin(jiaodu);

        }
        drawX[60]=0;
        drawY[60]=-120;
        for (int i=0;i<60;i++){
            dial_x[i+1]=dial_x[i]*Math.cos(jiaodu)-Math.sin(jiaodu)*dial_y[i];
            dial_y[i+1]=dial_y[i]*Math.cos(jiaodu)+Math.sin(jiaodu)*dial_x[i];
        }
        dial_x[60]=0;
        dial_y[60]=-140;

    }
    public void start(){
        if(isRestart>=1){
            sThread.interrupt();;
            mThread.interrupt();;
            hhread.interrupt();
        }
        hhread=new Thread(this);
        mThread=new Thread(this);
        sThread=new Thread(this);
        sThread.start();
        mThread.start();
        hhread.start();
        isRestart++;
        if(isRestart>=2){
            isRestart=1;
        }
    }
    public void stop(){
        sThread.interrupt();
        mThread.interrupt();
        hhread.interrupt();
    }
    public void paint(Graphics graphics){
        this.setBackground(Color.black);
        this.start();
        graphics.drawOval(50,50,300,300);
        graphics.translate(200,200);
        for (int i=0;i<60;i++){
            if(i%5==0){
                graphics.setColor(Color.red);
                graphics.fillOval((int) dial_x[i],(int) dial_y[i],10,10);
            }else {
                graphics.fillOval((int) dial_x[i],(int) dial_y[i],5,5);
            }
        }

    }

    @Override
    public void run() {
        Date date=new Date();
        String string=date.toString();
        currentHour=Integer.parseInt(string.substring(11,13));
        currentMinute=Integer.parseInt(string.substring(14,16));
        currentSecond=Integer.parseInt(string.substring(17,19));
        if(Thread.currentThread()==sThread){
            secondX=(int) drawX[currentSecond];
            secondY=(int) drawY[currentSecond];
            sGraphics.drawLine(0,0,secondX,secondY);
            sg2D.setStroke(new BasicStroke(2.0f));
            int i=currentSecond;
            while (true){
                try {
                    sThread.sleep(1000);
                    Color c=getBackground();
                    sGraphics.setColor(c);
                    sGraphics.drawLine(0,0,secondX,secondY);
                    sg2D.setStroke(new BasicStroke(2.0F));
                    if ((secondX==minuteX)&&(secondY==minuteY)){
                        mGraphics.drawLine(0,0,minuteX,minuteY);
                    }
                    if ((secondX==hourX)&&(secondY==hourY)){
                        hGraphics.drawLine(0,0,hourX,hourY);
                        hg2D.setStroke(new BasicStroke(4.0f));
                    }


                }catch (InterruptedException e){
                    Color c=getBackground();
                    sGraphics.setColor(c);
                    sGraphics.drawLine(0,0,secondX,secondY);
                    sg2D.setStroke(new BasicStroke(2.0F));
                    return;
                }
                secondX=(int) drawX[(i+1)%60];
                secondY=(int) drawY[(i+1)%60];
                sGraphics.setColor(Color.blue);
                sGraphics.drawLine(0,0,secondX,secondY);
                sg2D.setStroke(new BasicStroke(2.0F));
                i++;
            }
        }
        if(Thread.currentThread()==mThread){
            minuteX=(int) drawX[currentMinute];
            minuteY=(int) drawY[currentMinute];
            mGraphics.drawLine(0,0,minuteX,minuteY);
            mg2D.setStroke(new BasicStroke(3.0F));
            int i=currentMinute;
            while (true){
                try {
                    mThread.sleep(1000*60-currentSecond*1000);
                    currentSecond=0;
                    Color c=getBackground();
                    mGraphics.setColor(c);
                    mg2D.setStroke(new BasicStroke(3.0F));
                    mGraphics.drawLine(0,0,minuteX,minuteY);
                    if((hourX==minuteX)&&(hourY==minuteY)){
                        hGraphics.drawLine(0,0,minuteX,minuteY);
                        hg2D.setStroke(new BasicStroke(4.0F));
                    }

                }catch (InterruptedException e){
                    return;
                }
                minuteX=(int) drawX[(i+1)%60];
                minuteY=(int) drawY[(i+1)%60];
                mGraphics.setColor(Color.blue);
                mg2D.setStroke(new BasicStroke(3.0F));
                mGraphics.drawLine(0,0,minuteX,minuteY);
                i++;
                currentSecond=0;


            }
        }
        if(Thread.currentThread()==hhread){
            int h=currentHour%12;
            hourX=(int) drawX[h*5+currentMinute/12];
            hourY=(int) drawY[h*5+currentMinute/12];
            int i=h*5+currentMinute/12;
            hGraphics.drawLine(0,0,hourX,hourY);
            hg2D.setStroke(new BasicStroke(4.0F));
            while (true){
                try{
                    hhread.sleep(1000*60*12-1000*60*(currentMinute%12)-currentSecond*1000);
                    currentMinute=0;
                    Color c=getBackground();
                    hGraphics.setColor(c);
                    hGraphics.drawLine(0,0,hourX,hourY);
                    hg2D.setStroke(new BasicStroke(4.0F));
                }catch (InterruptedException e){
                    return;
                }
                hourX=(int) drawX[(i+1)%60];
                hourY=(int) drawY[(i+1)%60];
                hGraphics.setColor(Color.black);
                hGraphics.drawLine(0,0,hourX,hourY);
                hg2D.setStroke(new BasicStroke(4.0F));
                i++;
                currentMinute=0;
            }
        }
    }
}
