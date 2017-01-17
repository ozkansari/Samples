package com.ozkansari.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * Example to move a date to firstDayOfMonth, firstDayOfNextMonth, next Monday and etc.
 * 
 * In Java 8, you can use the predefined java.time.temporal.TemporalAdjusters to adjust a date or Temporal
 * 
 * https://www.mkyong.com/java8/java-8-temporaladjusters-examples/
 */
public class TemporalAdjustersSample {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
        System.out.println("current date : " + localDate);

        LocalDate with = localDate.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("firstDayOfMonth : " + with);

        LocalDate with1 = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("lastDayOfMonth : " + with1);

        LocalDate with2 = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("next monday : " + with2);

        LocalDate with3 = localDate.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("firstDayOfNextMonth : " + with3);
	}

}
