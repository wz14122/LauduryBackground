package com.example.demo.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date getToday() {
		return new Date();
	}

	/**
	 * @param nums 后一天就是1，前一天就是-1
	 * @return
	 */
	public static Date getDayByNums(int nums) {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, nums);
		return calendar.getTime();
	}
}
