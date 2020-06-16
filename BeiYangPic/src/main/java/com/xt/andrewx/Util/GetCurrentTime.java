package com.xt.andrewx.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetCurrentTime {
    public static String currentTimeOnDay(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date(System.currentTimeMillis());

        String todayForString = sdf.format(today);

        return todayForString;
    }

    public static String currentTimeOnSec(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date today = new Date(System.currentTimeMillis());

        String todayForString = sdf.format(today);

        return todayForString;
    }
}
