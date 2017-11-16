
public class DateApplication {
	
public static void main(String[] args) {
		
		
		System.out.println("Überprüfung des übergebenen Datums!\n");
		
		Date test1 = new Date(31,07,1991);
		System.out.println("Vorgegeben 31.07.1991 :: " + test1 + " :: Fall 1: Gültiges Datum");

		Date test2= new Date(31,07,1111);
		System.out.println("Vorgegeben 31.07.1111 :: " + test2 + " :: Fall 2: Jahr zu klein");
		
		Date test3 = new Date(32,07,1991);
		System.out.println("Vorgegeben 32.07.1991 :: " + test3 + " :: Fall 3: Tag ungültig");
		
		Date test4 = new Date(31,13,1991);
		System.out.println("Vorgegeben 31.13.1991 :: " + test4 + " :: Fall 2: Monat ungültig");
		
		Date test5 = new Date(31,07,5000);
		System.out.println("Vorgegeben 31.07.5000 :: " + test5 + " :: Fall 2: Zukunftsjahr\n\n\n\n");
		
		
		System.out.println("Überprüfung der Methode nextDate!\n");
		
		test1=test1.nextDay();
		System.out.println("Alter Tag: 31.07.1991 - Neuer Tag:"+test1);
		
		test2=test2.nextDay();
		System.out.println("Alter Tag: 31.07.1111 - Neuer Tag:"+test2);
		
		test3 = test3.nextDay();
		System.out.println("Alter Tag: 32.07.1991 - Neuer Tag:"+test3);
		
		test4 = test4.nextDay();
		System.out.println("Alter Tag: 31.13.1991 - Neuer Tag:"+test4);
		
		test5 = test5.nextDay();
		System.out.println("Alter Tag: 31.07.5000 - Neuer Tag:"+test5+"\n\n\n\n");
		
		
		System.out.println("Überprüfung der Date other Methode!\n");
		
	Date test6 = new Date(test1);
//		test6.setYear(4454);
		System.out.println(test6+ "\n\n\n\n");
		
		
		System.out.println("Überprüfen der Methode setDate!\n");
		
		boolean test7=test1.setDate(20, 2, 1991);
		System.out.println(test7);
		System.out.println(test1+"\n");
	
		boolean test8=test2.setDate(20, 13, 1991);
		System.out.println(test8);
		System.out.println(test2+"\n\n\n\n");
		
		
		System.out.println("Überprüfen der Methode isBefore!\n");
		
		Date test11 = new Date(1,1,2001);
		Date test12 = new Date(1,1,2000);
		System.out.println("Muss false anzeigen == "+ test11.isBefore(test12));
		
		Date test13 = new Date(1,1,2000);
		Date test14 = new Date(1,2,2000);
		System.out.println("Muss true anzeigen == "+test13.isBefore(test14));
		
		
	
		    
		Date localDate = new Date(31, 1, 2008);
		System.out.println(localDate.toString());
		Date testDate = localDate.nextDay();
		System.out.println(testDate.toString());
		System.out.println(testDate.isValidDate(31, 1, 2008));
		
		
		
		System.out.println(test14.toString());
		System.out.println(test14.getWeekday().getGermanName());
		System.out.println("");
		
		
		
		
		System.out.println(test1.getNumberOfDateObjects());
		
		System.out.println(test1.toString().equals(test5.toString()));
		
		
	}


}
