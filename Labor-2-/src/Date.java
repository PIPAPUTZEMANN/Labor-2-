
public class Date {

	private int day;
	private	int month;
	private int year;
	static int anzahlObjekte;

	public Date() {

		setDate(1, 1, 1970);
		anzahlObjekte++;
	}

	public Date(int day, int month, int year) {

		this();
		setDate(day, month, year);
		

	}

	public Date(Date other) {

		this();

		if (other != null) {

			setDate(other.day, other.month, other.year);
			
		}

	}

	public boolean setDate(int day, int month, int year) {

		if (isValidDate(day, month, year)) {

			this.day = day;
			this.month = month;
			this.year = year;
			return true;
		} else {

			return false;

		}
	}

	public boolean isValidDate(int day, int month, int year) {

		boolean valid = true;

		int maxDay;

		if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))&& month==2) {

			maxDay = 29;

		} else {
			switch (month) {
			case 1:
				maxDay = 31;
				break;
			case 2:
				maxDay = 28;
				break;
			case 3:
				maxDay = 31;
				break;
			case 4:
				maxDay = 30;
				break;
			case 5:
				maxDay = 31;
				break;
			case 6:
				maxDay = 30;
				break;
			case 7:
				maxDay = 31;
				break;
			case 8:
				maxDay = 31;
				break;
			case 9:
				maxDay = 30;
				break;
			case 10:
				maxDay = 31;
				break;
			case 11:
				maxDay = 30;
				break;
			case 12:
				maxDay = 31;
				break;
			default:
				valid = false;
				maxDay = 0;
			}
		}
		if (day > maxDay || day <= 0) {
			valid = false;
		}
		if (year < 1583) {
			valid = false;
		}
		return valid;
	}

	public String toString() {
		return String.format("%02d.%02d.%04d", day, month, year);
	}

	public boolean isBefore(Date otherDate) {
		boolean iB = false;

		if (year == otherDate.year) {
			if (month == otherDate.month) {
				if (day < otherDate.day) {
					iB = true;
				}
			}
		}
		if (year == otherDate.year) {
			if (month < otherDate.month) {
				iB = true;
			}
		}
		if (year < otherDate.year) {
			iB = true;
		}

		return iB;
	}

	public Date nextDay() {
		if (isValidDate(day + 1, month, year)) {
			return new Date(day + 1, month, year);
		} else if (isValidDate(1, month + 1, year)) {
			return new Date(1, month + 1, year);
		} else {
			return new Date(1, 1, year + 1);
		}
	}
	
	public Day getWeekday() {

		Day dayEnum = null;
		int w;

		if (month < 3) {

			month = month + 12;
			year = year - 1;
		}

		w = (day + 2 * month + (3 * month + 3) / 5 + year + year / 4 - year / 100 + year / 400 + 1) % 7;

		switch (w) {

		case 0:
			dayEnum = Day.SUNDAY;
			break;

		case 1:
			dayEnum = Day.MONDAY;
			break;

		case 2:
			dayEnum = Day.TUESDAY;
			break;

		case 3:
			dayEnum = Day.WEDNESDAY;
			break;

		case 4:
			dayEnum = Day.THURSDAY;
			break;

		case 5:
			dayEnum = Day.FRIDAY;
			break;

		case 6:
			dayEnum = Day.SATURDAY;
			break;

		}
		return dayEnum;

	}

	public static int getNumberOfDateObjects() {
		return anzahlObjekte;

	}

	public void finalize() {

		anzahlObjekte--;

	}

	public boolean equals(Object other) {
		if(other instanceof Date){
		Date rek= new Date();
		rek=(Date) other;
		
		if(this.day==rek.day && this.month==rek.month && this.year==rek.year){
			
			return true;
		}
		
		
		



		}
		return false;
}
	public int getDay(){
		return day;
	}
	public int getMonth(){
		return month;
	}
	public int getYear(){
		return year;
	}
	
}