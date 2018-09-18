package XML_practice;

import java.util.Date;

public class Weather {
    boolean success;
    String weaid;
    Date days;
    String week;
    String cityno;
    String citynm;
    String cityid;
    String temperature;
    String humidity;
    String weather;
    String weather_icon;
    String weather_icon1;
    String wind;
    String winp;
    int temp_high;
    int temp_low;
    int humi_high;
    int humi_low;
    int weatid;
    int weatid1;
    int windid;
    int winpid;

    public Weather(boolean success, String weaid, Date days, String week, String cityno, String citynm, String cityid, String temperature, String humidity, String weather, String weather_icon, String weather_icon1, String wind, String winp, int temp_high, int temp_low, int humi_high, int humi_low, int weatid, int weatid1, int windid, int winpid) {
        this.success = success;
        this.weaid = weaid;
        this.days = days;
        this.week = week;
        this.cityno = cityno;
        this.citynm = citynm;
        this.cityid = cityid;
        this.temperature = temperature;
        this.humidity = humidity;
        this.weather = weather;
        this.weather_icon = weather_icon;
        this.weather_icon1 = weather_icon1;
        this.wind = wind;
        this.winp = winp;
        this.temp_high = temp_high;
        this.temp_low = temp_low;
        this.humi_high = humi_high;
        this.humi_low = humi_low;
        this.weatid = weatid;
        this.weatid1 = weatid1;
        this.windid = windid;
        this.winpid = winpid;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "success=" + success +
                ", weaid='" + weaid + '\'' +
                ", days=" + days +
                ", week='" + week + '\'' +
                ", cityno='" + cityno + '\'' +
                ", citynm='" + citynm + '\'' +
                ", cityid='" + cityid + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", weather='" + weather + '\'' +
                ", weather_icon='" + weather_icon + '\'' +
                ", weather_icon1='" + weather_icon1 + '\'' +
                ", wind='" + wind + '\'' +
                ", winp='" + winp + '\'' +
                ", temp_high=" + temp_high +
                ", temp_low=" + temp_low +
                ", humi_high=" + humi_high +
                ", humi_low=" + humi_low +
                ", weatid=" + weatid +
                ", weatid1=" + weatid1 +
                ", windid=" + windid +
                ", winpid=" + winpid +
                '}';
    }
}
