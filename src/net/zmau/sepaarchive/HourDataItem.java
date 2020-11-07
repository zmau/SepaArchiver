package net.zmau.sepaarchive;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class HourDataItem extends DataItem {
    public void setTime(String Time){
        time = new GregorianCalendar();
        time.set(Calendar.DATE, Integer.parseInt(Time.substring(0, 1)));
        time.set(Calendar.MONTH, Integer.parseInt(Time.substring(3, 4)));
        time.set(Calendar.YEAR, Calendar.getInstance().getTime().getYear());
        time.set(Calendar.HOUR, Integer.parseInt(Time.substring(7, 8)));
    }
    public void setSO2(String text){
        SO2 = Float.parseFloat(text);
    };
    public void setPM10(String text){
        PM10 = Float.parseFloat(text);
    }
    public void setNO2(String text){
        NO2 = Float.parseFloat(text);
    }
    public void setCO(String text){
        CO = Float.parseFloat(text);
    }
    public void setPM2comma5(String text){
        PM2comma5 = Float.parseFloat(text);
    }
}
