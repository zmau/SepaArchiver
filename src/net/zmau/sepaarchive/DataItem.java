package net.zmau.sepaarchive;

public abstract class DataItem {
    protected java.util.Calendar time;
    protected float SO2;
    protected float PM10;
    protected float CO;
    protected float NO2;
    protected float PM2comma5;

    public java.util.Calendar getTime(){
        return time;
    }
    public float getSO2(){
        return SO2;
    }
    public float getPM10(){
        return PM10;
    }
    public float getNO2(){
        return NO2;
    }
    public float getCO(){
        return CO;
    }
    public float getPM2comma5(){
        return PM2comma5;
    }
}
