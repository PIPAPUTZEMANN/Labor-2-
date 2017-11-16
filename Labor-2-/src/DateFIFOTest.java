import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;


public class DateFIFOTest {

	private DateFIFO testee;
	private Class testeeClass = DateFIFO.class;
	private Date[] elements;
	private Date date1,date2,date3;
	
	@Before
	public void setUp() {
		this.testee = new DateFIFO(2);
		try {
			Field elements=testeeClass.getDeclaredField("elements");
			elements.setAccessible(true);
			this.elements=(Date[])elements.get(testee);
			
		}
		catch(NoSuchFieldException exc) {
			exc.printStackTrace();
		}
		catch(IllegalAccessException exc) {
			exc.printStackTrace();
		}
		this.date1 = new Date(1,1,2013);
		this.date2 = new Date(1,2,2013);
		this.date3 = new Date(1,3,2013);
	}
	
	@Test
	public void testPushOk() {
		testee.push(date1);
		assertTrue(this.elements[0]==date1);
	}

	@Test
	public void testPushArrayLengthReached() {
		testee.push(date1);
		testee.push(date2);
		testee.push(date3);
		refreshArrayReference();
		assertTrue(this.elements.length==12&&this.elements[2]==date3);
	}
	
	private void refreshArrayReference() {
		try {
			Field elements=testeeClass.getDeclaredField("elements");
			elements.setAccessible(true);
			this.elements=(Date[])elements.get(testee);
			
		}
		catch(NoSuchFieldException exc) {
			exc.printStackTrace();
		}
		catch(IllegalAccessException exc) {
			exc.printStackTrace();
		}
	}

	@Test
	public void testPopOk() {
		testee.push(date1);
		Date ret=testee.pop();
		assertTrue(this.elements[0]==null&&ret==date1);
	}
	
	@Test
	public void testPopShiftOK() {
		testee.push(date1);
		testee.push(date2);
		testee.push(date3);
		refreshArrayReference();
		Date ret = testee.pop();
		assertTrue(this.elements[2]==null&&this.elements[1]==date3&&this.elements[0]==date2&&date1==ret);
	}
	
	@Test
	public void testPeekOk() {
		testee.push(date1);
		Date ret = testee.peek();
		assertTrue(this.elements[0]==date1&&ret==date1);
	}
	
	@Test
	public void testIsEmtpyTrue() {
		assertTrue(testee.isEmpty());
	}
	
	@Test
	public void testIsEmptyFalse() {
		testee.push(date1);
		assertFalse(testee.isEmpty());
	}
	
	@Test
	public void testFindOK() {
		testee.push(date1);
		testee.push(date2);
		testee.push(date3);
		assertTrue(testee.find(new Date(date2))==1);
	}
	
	@Test
	public void testFindNotOK() {
		testee.push(date1);
		testee.push(date2);
		testee.push(date2);
		assertTrue(testee.find(date3)==-1);
	}
	
	@Test
	public void testDeepCopyOK() {
		testee.push(date1);
		testee.push(date2);
		testee.push(date3);
		DateFIFO ret=testee.deepCopy();
		Date d1=ret.pop();
		Date d2=ret.pop();
		Date d3=ret.pop();
		assertTrue(d1!=date1&&d2!=date2&&d3!=date3);
		assertTrue(testee.find(d1)==0 && testee.find(d2)==1 && testee.find(d3)==2);
	}
}
