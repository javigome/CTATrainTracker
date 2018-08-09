package com.example.fatty.ctatraintracker;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Route {
    private String prdt;//prediction
    private String arrt;//expected to arrive
    private String stpde; //service to
    private String destNm;//destination name

    public String getStpde() {
        return stpde;
    }

    public void setStpde(String stpde) {
        this.stpde = stpde;
    }


    public String getDestNm() {
        return destNm;
    }

    public void setDestNm(String destNm) {
        this.destNm = destNm;
    }

    public String getPrdt() {
        return prdt;
    }

    public String getArrt() {
        return arrt;
    }


    public void setPrdt(String prdt) {
        this.prdt = prdt;
    }

    public void setArrt(String ardt) {
        this.arrt = ardt;
    }

    public long getArrivals() {
        //ardt-prdt
        long num = 1;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
            Date parsedDate = dateFormat.parse(prdt);//old prdt
            Date parsedDate2 = dateFormat.parse(arrt);
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            Timestamp timestamp2 = new java.sql.Timestamp(parsedDate2.getTime());

            num = compareTwoTimeStamps(timestamp2, timestamp);
            System.out.println(num);
        } catch (Exception e) {
            //this generic but you can control another types of exception
        }
        return num;
    }

    public long compareTwoTimeStamps(java.sql.Timestamp currentTime, java.sql.Timestamp oldTime){
        long milliseconds1 = oldTime.getTime();
        long milliseconds2 = currentTime.getTime();

        long diff = milliseconds2 - milliseconds1;
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        long diffDays = diff / (24 * 60 * 60 * 1000);

        return diffMinutes;
    }

}

