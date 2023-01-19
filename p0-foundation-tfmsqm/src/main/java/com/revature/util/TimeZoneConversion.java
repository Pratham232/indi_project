package com.revature.util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import com.revature.menu.UserAuthentication;

public class TimeZoneConversion {
	private static final Logger logger = Logger.getLogger(UserAuthentication.class);

	public static String formatDateToString(Date date, String format,
			String timeZone) {
		if (date == null) return null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if (timeZone == null || "".equalsIgnoreCase(timeZone.trim())) {
			timeZone = Calendar.getInstance().getTimeZone().getID();
		}
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		return sdf.format(date);
	}

	public static void main(String[] args) {
		Date date = new Date();
		logger.info("\nDefault Date:"+date.toString());
		logger.info("\nSystem Date: "+formatDateToString(date, "dd MMM yyyy hh:mm:ss a", null));
		logger.info("\nSystem Date in IST: "+formatDateToString(date, "dd MMM yyyy hh:mm:ss a", "IST"));
		logger.info("\nSystem Date in UTC: "+formatDateToString(date, "dd MMM yyyy hh:mm:ss a", "UTC"));
	}
	

}
