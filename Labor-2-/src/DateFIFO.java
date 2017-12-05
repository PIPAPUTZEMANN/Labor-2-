
public class DateFIFO {
	
	
	
	/**
	* Adds a new element at the end of the queue
	*
	* @param aDate the element to be added
	*/
	

	private int size;
	private Date[] elements;
	private int aktuelleAnzahl;
	
	public DateFIFO(int groesse){
		
		this.size=groesse;
		this.elements = new Date[size];
		this.aktuelleAnzahl=0;
	}

	public void push(Date date){
		
if(aktuelleAnzahl<size){
			
			elements[aktuelleAnzahl]=date;
			aktuelleAnzahl++;
		}
		else {
			
			Date[]nextArray;  
			nextArray=new Date[(this.size+10)];
			
			System.arraycopy(elements, 0, nextArray, 0, (this.size));
			
			elements = nextArray;
			elements[aktuelleAnzahl]=date;
		}
		
	}
	/**
	* Removes and returns the first element in the queue
	*
	* @return the element that was the first in the list,
	* or null if there was no such element
	*/
	public Date pop(){
		
			
			Date zwischentag=new Date();
			zwischentag=elements[0];
			int a;
			for(int i=1;i<=aktuelleAnzahl;i++){
				a=i;
				elements[--a]=elements[i];
			}
			aktuelleAnzahl--;
			return zwischentag;
			
			
		}
	/**
	* Searches the queue for a date that is equal to the given date and
	* returns the index (i.e. the position) of the first occurrence of the
	* date, or -1 if the given date is not contained in the queue.
	* Two dates are equal if all of their attribute values are equal.
	*
	* @return the index within the queue for the given date, or -1 if the
	* given date is not included within the queue
	*/
	public int find(Date date){
	
		int a = -1;
		for(int i=0;i<aktuelleAnzahl;i++){
			if((date.getDay()==elements[i].getDay())&&(date.getMonth()==elements[i].getMonth())&&(date.getYear()==elements[i].getYear())){
				a = i;
			}
		}	
		return a;
	}
	/**
	* Returns but does not remove the first element in the queue
	*
	* @return the first element, or null, if there is no such element
	*/
	public Date peek(){
		

		if(elements[0]!=null){
			
			return elements[0];
		}
		else{
			
			return null;
		}
		
	}
	
	/**
	* Returns whether or not this queue is empty
	*
	* @return true if this queue contains no elements; false otherwise
	*/
	public boolean isEmpty(){
		boolean empty = false;
	
			if (elements[0] == null){
				empty = true;
			
		}
		return empty;
	}
	/**
	* Creates a deep copy of the current DateFIFO Object. Deep copy means that
	* the copy contains copies of the original elements (not the original
	* elements themselves)
	*
	* @return a deep copy of this DateFIFO Object.
	*/
	public DateFIFO deepCopy(){
		
		DateFIFO copy = new DateFIFO(size);
		
		
	
		
		copy.size=this.size;
		copy.aktuelleAnzahl=this.aktuelleAnzahl;
		copy.elements=this.elements;
		
		
	return copy;
	}
}

