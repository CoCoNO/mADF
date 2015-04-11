
public class AFDNode {

	protected String reads;
	protected String value;
	protected String destination;
	
	public AFDNode () {
	}
	
	public AFDNode ( String reads, String value, String destination ) {
		this.setReads( reads );
		this.setValue( value );
		this.setDestination( destination );
	}
	
	public void setReads ( String input ) {
		if ( input == null || input.isEmpty() ) {
			return;
		}
		else {
			this.reads = input.toString();
		}
	}
	
	public String getReads () {
		return this.reads;
	}
	
	public void setValue ( String input ) {
		if ( input == null || input.isEmpty() ) {
			return;
		}
		else {
			this.value = input.toString();
		}
	}
	
	public String getValue () {
		return this.value;
		
	}
	
	public void setDestination ( String input ) {
		if ( input == null || input.isEmpty() ) {
			return;
		}
		else {
			this.destination = input.toString(); 
		}
	}
	
	public String getDestination () {
		return this.destination;
	}
}
