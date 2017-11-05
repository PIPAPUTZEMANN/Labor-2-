/**
 * UnitTest for Date class
 * Copyright (c) 2007 Klaus Dorer
 * Modified 2016 Tobias Lauer
 * Hochschule Offenburg
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;


public class DateTest
{
	Date testee;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		testee = new Date(4, 6, 1988);
	}

	@Test
	public void testDateDefault()
	{
		Date localDate = new Date();
		assertTrue(localDate.toString(), "01.01.1970".equals(localDate.toString()));
	}

	@Test
	public void testDateInvalid() throws Exception
	{
		Date localDate = new Date(0, 1, 1970);
		assertTrue(localDate.toString(), "01.01.1970".equals(localDate.toString()));
	}

	@Test
	public void testSetDateMonth1() throws Exception
	{
		assertEquals(true, testee.setDate(1, 1, 1970));
	}

	@Test
	public void testSetDateMonth12() throws Exception
	{
		assertEquals(true, testee.setDate(1, 12, 1970));
	}

	@Test
	public void testSetDateMonth0() throws Exception
	{
		assertEquals(false, testee.setDate(1, 0, 1970));
	}

	@Test
	public void testSetDateMonth13() throws Exception
	{
		assertEquals(false, testee.setDate(1, 13, 1970));
	}

	@Test
	public void testSetDateDay311() throws Exception
	{
		assertEquals(true, testee.setDate(31, 1, 1970));
	}

	@Test
	public void testSetDateDay282() throws Exception
	{
		assertEquals(true, testee.setDate(28, 2, 1970));
	}

	@Test
	public void testSetDateDay304() throws Exception
	{
		assertEquals(true, testee.setDate(30, 4, 1970));
	}

	@Test
	public void testSetDateDay0() throws Exception
	{
		assertEquals(false, testee.setDate(0, 1, 1970));
	}

	@Test
	public void testSetDateDay321() throws Exception
	{
		assertEquals(false, testee.setDate(32, 1, 1970));
	}

	@Test
	public void testSetDateDay314() throws Exception
	{
		assertEquals(false, testee.setDate(31, 4, 1970));
	}

	@Test
	public void testSetDateLeap30() throws Exception
	{
		assertEquals(false, testee.setDate(30, 2, 1970));
	}

	@Test
	public void testSetDateNoLeap29() throws Exception
	{
		assertEquals(false, testee.setDate(29, 2, 1997));
	}

	@Test
	public void testSetDateLeap4() throws Exception
	{
		assertEquals(true, testee.setDate(29, 2, 1996));
	}

	@Test
	public void testSetDateLeap400() throws Exception
	{
		assertEquals(true, testee.setDate(29, 2, 2000));
	}

	@Test
	public void testSetDateNoLeap100() throws Exception
	{
		assertEquals(false, testee.setDate(29, 2, 1900));
	}

	@Test
	public void testIsBeforeDayYes() throws Exception
	{
		// check day check
		assertEquals(true, testee.isBefore(new Date(5, 6, 1988)));
	}

	@Test
	public void testIsBeforeDayEqual() throws Exception
	{
		assertEquals(false, testee.isBefore(new Date(4, 6, 1988)));
	}

	@Test
	public void testIsBeforeDayNo() throws Exception
	{
		assertEquals(false, testee.isBefore(new Date(3, 6, 1988)));
	}

	// check month check
	@Test
	public void testIsBeforeMonthYes() throws Exception
	{
		assertEquals(true, testee.isBefore(new Date(3, 7, 1988)));
	}

	@Test
	public void testIsBeforeMonthNoYearEqual() throws Exception
	{
		assertEquals(false, testee.isBefore(new Date(5, 5, 1988)));
	}

	@Test
	public void testIsBeforeMonthNo() throws Exception
	{
		assertEquals(false, testee.isBefore(new Date(5, 5, 1987)));
	}

	// check year check
	@Test
	public void testIsBeforeYearYes() throws Exception
	{
		assertEquals(true, testee.isBefore(new Date(3, 4, 1989)));
	}

	@Test
	public void testIsBeforeYearNo() throws Exception
	{
		assertEquals(false, testee.isBefore(new Date(5, 7, 1987)));
	}

	@Test
	public void testDateCopyConstructor() throws Exception
	{
		Date testDate = new Date(20, 11, 2008);
		assertEquals("20.11.2008", new Date(testDate).toString());
	}

	@Test
	public void testAddDayNormal() throws Exception
	{
		Date testDate = new Date(20, 11, 2008);
		assertEquals("21.11.2008", testDate.nextDay().toString());
		assertEquals("Original Date should not be changed", "20.11.2008", testDate.toString());
	}

	@Test
	public void testAddDayEndOfJanuary() throws Exception
	{
		Date localDate = new Date(31, 1, 2008);
		Date testDate = localDate.nextDay();
		assertTrue(testDate.toString(), "01.02.2008".equals(testDate.toString()));
	}

	@Test
	public void testAddDayEndOfFebruaryNoLeapYear() throws Exception
	{
		Date localDate = new Date(28, 2, 2007);
		Date testDate = localDate.nextDay();
		assertTrue(testDate.toString(), "01.03.2007".equals(testDate.toString()));
	}

	@Test
	public void testAddDayEndOfFebruaryLeapYear28() throws Exception
	{
		Date localDate = new Date(28, 2, 2000);
		Date testDate = localDate.nextDay();
		assertTrue(testDate.toString(), "29.02.2000".equals(testDate.toString()));
	}

	@Test
	public void testAddDayEndOfFebruaryLeapYear29() throws Exception
	{
		Date localDate = new Date(29, 2, 2000);
		Date testDate = localDate.nextDay();
		assertTrue(testDate.toString(), "01.03.2000".equals(testDate.toString()));
	}

	@Test
	public void testAddDayEndOfDecember() throws Exception
	{
		Date localDate = new Date(31, 12, 1999);
		Date testDate = localDate.nextDay();
		assertTrue(testDate.toString(), "01.01.2000".equals(testDate.toString()));
	}
	
	/**
	@Test
	public void testDayOfWeek1471789() throws Exception
	{
		Date testDate = new Date(14, 7, 1789);
		assertTrue("TUESDAY".equalsIgnoreCase(Date.getDayOfWeek(testDate).toString()));
	}

	@Test
	public void testDayOfWeek9111989() throws Exception
	{
		Date testDate = new Date(9, 11, 1989);
		System.out.println(Date.getDayOfWeek(testDate).toString());
		assertTrue("THURSDAY".equalsIgnoreCase(Date.getDayOfWeek(testDate).toString()));
	} */
	
	/**
	 * Test method for {@link javaoo.exercise2.Date#getNumberOfDateObjects()}.
	 *
	@Test
	public void testGetNumberOfDateObjects() throws Exception
	{
		int objectsBefore = Date.getNumberOfDateObjects();
		Date unused1 = new Date();
		Date unused2 = new Date(2, 2, 1970);
		Date unused3 = new Date(unused2);
		Date unused4 = unused3.nextDay();
		// just to avoid warnings
		unused1 = unused3;
		unused3 = unused1;
		unused1 = unused4;
		// test
		assertEquals(objectsBefore + 4, Date.getNumberOfDateObjects());
	} */

	@Test
	public void testPrivateAttributeDay()
	{
		try {
			Field day = testee.getClass().getDeclaredField("day");
			if ((day.getModifiers() & Modifier.PRIVATE) == 0) {
				fail("attribute day is not private, can set any day");
			}
		} catch (SecurityException e) {
			fail("Security exception");
		} catch (NoSuchFieldException e) {
			fail("Field day not existing in class Date");
		}
	}
}
