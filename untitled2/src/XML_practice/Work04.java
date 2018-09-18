package XML_practice;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Work04 {

    static ArrayList weatherarr=new ArrayList();

    public static void init() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        File file=new File("weather.xml");
        Document document = builder.parse(file);

        NodeList successlist=document.getElementsByTagName("success");
        NodeList weaidlist=document.getElementsByTagName("weaid");
        NodeList dayslist=document.getElementsByTagName("days");
        NodeList weeklist=document.getElementsByTagName("week");
        NodeList citynolist=document.getElementsByTagName("cityno");
        NodeList citynmlist=document.getElementsByTagName("citynm");
        NodeList cityidlist=document.getElementsByTagName("cityid");
        NodeList temperaturelist=document.getElementsByTagName("temperature");
        NodeList humiditylist=document.getElementsByTagName("humidity");
        NodeList weatherlist=document.getElementsByTagName("weather");
        NodeList weather_iconlist=document.getElementsByTagName("weather_icon");
        NodeList weather_icon1list=document.getElementsByTagName("weather_icon");
        NodeList windlist=document.getElementsByTagName("wind");
        NodeList winplist=document.getElementsByTagName("winp");
        NodeList temp_highlist=document.getElementsByTagName("temp_high");
        NodeList temp_lowlist=document.getElementsByTagName("temp_low");
        NodeList humi_highlist=document.getElementsByTagName("humi_high");
        NodeList humi_lowlist=document.getElementsByTagName("humi_low");
        NodeList weatidlist=document.getElementsByTagName("weatid");
        NodeList weatid1list=document.getElementsByTagName("weatid1");
        NodeList windidlist=document.getElementsByTagName("windid");
        NodeList winpidlist=document.getElementsByTagName("winpid");

        int length=weaidlist.getLength();
        int successint=Integer.parseInt(successlist.item(0).getFirstChild().getNodeValue());
        boolean success=(successint==1);
        System.out.println(success);

        for(int i=0;i<length;i++){
            String weaid=weaidlist.item(i).getFirstChild().getNodeValue();
            String daysstr=dayslist.item(i).getFirstChild().getNodeValue();
            String[] parts=daysstr.split("-");
            int year=Integer.parseInt(parts[0]);
            int month=Integer.parseInt(parts[1]);
            int day=Integer.parseInt(parts[2]);
            //System.out.println(Integer.parseInt(parts[0])+" "+Integer.parseInt(parts[1])+" "+Integer.parseInt(parts[2]));
            Date days=new Date(year-1,month-1,day);
            String week=weeklist.item(i).getFirstChild().getNodeValue();
            String cityno=citynolist.item(i).getFirstChild().getNodeValue();
            String citynm=citynmlist.item(i).getFirstChild().getNodeValue();
            String cityid=cityidlist.item(i).getFirstChild().getNodeValue();
            String temperature=temperaturelist.item(i).getFirstChild().getNodeValue();
            String humidity=humiditylist.item(i).getFirstChild().getNodeValue();
            String weather=weatherlist.item(i).getFirstChild().getNodeValue();
            String weather_icon=weather_iconlist.item(i).getFirstChild().getNodeValue();
            String weather_icon1=weather_icon1list.item(i).getFirstChild().getNodeValue();
            String wind=windlist.item(i).getFirstChild().getNodeValue();
            String winp=winplist.item(i).getFirstChild().getNodeValue();
            int temp_high=Integer.parseInt(temp_highlist.item(i).getFirstChild().getNodeValue());
            int temp_low=Integer.parseInt(temp_lowlist.item(i).getFirstChild().getNodeValue());
            int humi_high=Integer.parseInt(humi_highlist.item(i).getFirstChild().getNodeValue());
            int humi_low=Integer.parseInt(humi_lowlist.item(i).getFirstChild().getNodeValue());
            int weatid=Integer.parseInt(weatidlist.item(i).getFirstChild().getNodeValue());
            int weatid1=Integer.parseInt(weatid1list.item(i).getFirstChild().getNodeValue());
            int windid=Integer.parseInt(windidlist.item(i).getFirstChild().getNodeValue());
            int winpid=Integer.parseInt(winpidlist.item(i).getFirstChild().getNodeValue());

            weatherarr.add(new Weather(success,weaid,days,week,cityno,citynm,cityid,temperature,humidity,weather,weather_icon,weather_icon1,wind,winp,temp_high,temp_low,humi_high,humi_low,weatid,weatid1,windid,winpid));

        }






    }
    public static void main(String args[]){
        try {
            init();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        for(int i=0;i<weatherarr.size();i++){
            System.out.println(weatherarr.get(i));
        }
    }

}
