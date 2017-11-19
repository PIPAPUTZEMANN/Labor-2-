
public enum Day { SUNDAY, MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY;
	
	/**
	 * Determined german weekday.
	 * We get the English weekday from date  and can find the German here.
	 * 
	 * @return returns german weekday.
	 */
	public String getGermanName(){
		
		String day = null;
		
		
		if(this==SUNDAY){
			
			day="Sonntag";
		}
		
		if(this==MONDAY){
			
			day="Montag";
		}
		
		if(this==TUESDAY){
			
			day="Dienstag";
		}
		
		if(this==WEDNESDAY){
			
			day="Mittwoch";
		}
		
		if(this==THURSDAY){
			
			day="Donnerstag";
		}
		
		if(this==FRIDAY){
			
			day="Freitag";
		}
		
		if(this==SATURDAY){
			
			day="Samstag";
		}
		
		return day;
		
	}

}
