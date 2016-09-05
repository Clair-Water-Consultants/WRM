package com.wrm.api;

import java.text.SimpleDateFormat;

public class Constants {
	public static int SESSION_MAX_AGE = 24 * 60 * 60;
	public static int MINUS_ONE = -1;
	public static String DEFAULT_HOURS_TIMEPERIOD = "30";//30 hours
	public static String DEFAULT_DAYS_TIMEPERIOD = "30";//30 days
	public static String DEFAULT_WEEKS_TIMEPERIOD = "210"; //30 * 7 days
	public static String DEFAULT_MONTHLY_TIMEPERIOD = "900"; //30 * 30 days
	public static String DEFAULT_YEARLY_TIMEPERIOD = "1829"; //(5 * 365) + 4 
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
}
