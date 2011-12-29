package org.svenehrke.java.misc.datetime;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateTimeTest {

	final private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss-z");

	@Test
	public void testCalendar() {
//		Timestamp.UTC();
		final Calendar cal = Calendar.getInstance();
		cal.set(1900 + 111, Calendar.DECEMBER, 22, 10, 0, 0);
		System.out.println("cal = " + cal);
		System.out.println(sdf.format(new Date(cal.getTimeInMillis())));
	}
	@Test
	public void testTimeZone() {
		TimeZone tz = TimeZone.getTimeZone("CEST"); // CEST is not valid
		assertEquals("GMT", tz.getID());

		tz = TimeZone.getTimeZone("GMT+02");
		assertEquals("GMT+02:00", tz.getID());


		final Calendar cal = Calendar.getInstance();
		cal.set(1900 + 111, Calendar.DECEMBER, 22, 10, 0, 0);
		final Timestamp ts = new Timestamp(System.currentTimeMillis());
		System.out.println("ts = " + ts);

		final Calendar gmt = Calendar.getInstance();
		sdf.setTimeZone(TimeZone.getTimeZone("GMT-1"));
		System.out.println(sdf.format(gmt.getTime()));
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+1"));
		System.out.println(sdf.format(gmt.getTime()));
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+2"));

		System.out.println(sdf.format(gmt.getTime()));

		gmt.set(Calendar.MONTH, Calendar.JANUARY);
		System.out.println(sdf.format(gmt.getTime()));
		gmt.set(Calendar.MONTH, Calendar.JULY);
		System.out.println(sdf.format(gmt.getTime()));

		System.out.println(new Date(gmt.getTimeInMillis()));
		gmt.set(Calendar.MONTH, Calendar.JANUARY);
		System.out.println(new Date(gmt.getTimeInMillis()));

		final TimeZone germanTZ = TimeZone.getTimeZone("Europe/Berlin");
		System.out.println("germanTZ.getID() = " + germanTZ.getID());
		System.out.println("germanTZ.getDSTSavings() = " + germanTZ.getDSTSavings());

		Date gc = new GregorianCalendar(2011, Calendar.JANUARY, 2, 9, 2).getTime();
		assertFalse(germanTZ.inDaylightTime(gc));

		gc = new GregorianCalendar(2011, Calendar.OCTOBER, 2, 9, 2).getTime();
		assertTrue(germanTZ.inDaylightTime(gc));

		gc = new GregorianCalendar(1992, Calendar.OCTOBER, 2, 9, 2).getTime();
		assertFalse(germanTZ.inDaylightTime(gc));

		gc = new GregorianCalendar(1992, Calendar.JULY, 2, 9, 2).getTime();
		assertTrue(germanTZ.inDaylightTime(gc));

		gc = new GregorianCalendar(1979, Calendar.JULY, 2, 9, 2).getTime();
		assertFalse(germanTZ.inDaylightTime(gc));

		gc = new GregorianCalendar(1980, Calendar.JULY, 2, 9, 2).getTime();
		assertTrue(germanTZ.inDaylightTime(gc));

		// Switzerland
		final TimeZone swissTZ = TimeZone.getTimeZone("Europe/Zurich");
		gc = new GregorianCalendar(1980, Calendar.JULY, 2, 9, 2).getTime();
		assertFalse(swissTZ.inDaylightTime(gc));

		gc = new GregorianCalendar(1981, Calendar.JULY, 2, 9, 2).getTime();
		assertTrue(swissTZ.inDaylightTime(gc));

	}

	@Test
	public void test() {
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+1"));
		System.out.println(sdf.format(newDate("2011-03-03 16:40:44")));

	}

	@Test
	public void test1() {
		SimpleDateFormat sdfGMT = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss z");
		sdfGMT.setTimeZone(TimeZone.getTimeZone("GMT"));

		SimpleDateFormat sdfMadrid = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss z");
		sdfMadrid.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));

		Date inptdate = newDate("2011-23-03 16:40:44");
		System.out.println("GMT:\t\t" + sdfGMT.format(inptdate));
		System.out.println("Europe/Madrid:\t" + sdfMadrid.format(inptdate));

	}

/*
	@Test
	public void testTimestamp() {
		Timestamp ts = Timestamp.valueOf()
	}
*/


	private Date newDate(final String aDateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(aDateString);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}


}
