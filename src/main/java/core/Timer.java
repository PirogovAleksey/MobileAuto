package core;

import java.util.Date;

/**
 * Created by Alex on 3/30/2017.
 */
public class Timer {

    public long startStamp;

    public void start(){
        startStamp = getTimeStamp();
    }

    public static long getTimeStamp(){
        return new Date().getTime();
    }

    public boolean expired(int seconds){
        int difference = (int) ((getTimeStamp() - startStamp) / 1000);
        return difference > seconds;
    }





}
