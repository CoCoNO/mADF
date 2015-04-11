import java.util.ArrayList;

public class AFDTable {
	protected ArrayList <ArrayList<AFDNode>> table;
	protected ArrayList <String> alphabet;
	protected ArrayList <String> states;
	protected String w;
	
	// Acquiring basic information to build the table.
	public AFDTable ( ArrayList <String> alphabet, ArrayList <String> states ) {
		if ( alphabet != null && ! alphabet.isEmpty() ) {
			this.alphabet = alphabet;
		}
		
		if ( states != null && ! states.isEmpty() ) {
			this.states = states;
		}
	}
	
	public void setAlphabet ( ArrayList <String>alphabet ) {
		if ( alphabet != null && ! alphabet.isEmpty() ) {
			this.alphabet = alphabet;
		}
	}
	
	public ArrayList<String> getAlphabet () {
		return this.alphabet;
	}
	
	public void setStates ( ArrayList <String> states ) {
		if ( states != null && ! states.isEmpty() ) {
			this.states = states;
		}
	}
	
	public ArrayList<String> getStates () {
		return this.states;
	}
	
	public void createTableHeader () {
		this.table = new ArrayList<ArrayList<AFDNode>>();
		
		if ( this.alphabet == null || this.alphabet.isEmpty() ) {
			System.out.println( "Error while creating the table header." );
		}
		else {
			int n = alphabet.size();
			for ( int i = 0; i < n; i++ ) {
				ArrayList <AFDNode> column = new ArrayList<AFDNode>();
				// System.out.println( "column aiming null?:  " + Utilities.aimingNullKA( column ) );
				this.table.add( column );
			}
			System.out.println( "Table created with " + table.size() + " letters." );
			System.out.println( table );
		}
	}
	
	public void addingCells () {
		ArrayList<AFDNode> col= new ArrayList<AFDNode> ();
		for ( int i = 0; i < this.table.size(); i++ ) {
			col = this.table.get( i );
			for ( int j = 0; j < states.size(); j++ ) {
				AFDNode node = new AFDNode();
				// node = col.get( j );
				node.setValue( this.states.get( j ) );
				node.setReads( this.alphabet.get(i) );
				col.add( node );
				// node.setDestination(); // I don't have that information yet :(
			}
		}
		System.out.println( "Out of loops." );
		System.out.println( table );
	}
	
	public ArrayList<ArrayList<AFDNode>> getTopOfTable() {
		return this.table;
	}
	
	public int size () {
		return this.table.size();
	}
	
	public ArrayList<AFDNode> get ( int i ) {
		return this.table.get( i );
	}
/*	
	public void setTransitions ( ArrayList linked ) {
		return;
	}
*/
	public void printWholeTable () {
		ArrayList<AFDNode> col = new ArrayList<AFDNode>();
		AFDNode current = new AFDNode();
		String string = "[ ";
		for ( int i = 0; i < this.table.size(); i++ ) {
			string += "[ ";
			col = this.table.get( i );
			for ( int j = 0; j < col.size(); j++ ) {
				current = col.get( j );
				string += current.getValue().toString() + "-" + current.getReads() + "-> "  + current.getDestination() + ", ";
			}
			string += "]\n ";
		}
		string += " ]";
		System.out.println( string );
	}
	public void setW ( String word ) {
		if ( word instanceof String && word != null && word.length() > 0) {
			this.w = word;
			System.out.println( "Word received correctly." );
		}
		else {
			System.out.println( "Wrong word..." );
		}
	}
	
	public String getW () {
		if ( this.w != null || this.w.length() > 0 ) {
			return this.w;
		}
		else {
			System.out.println( "W not ready yet!!" );
			return "";
		}
	}
	/*
	public char[] getWArray () {
		if ( this.w != null || this.w.length() > 0 ) {
			return this.w.toCharArray();
		}
		else {
			System.out.println( "W not ready yet!!" );
			return "".toCharArray();
		}
	}
	*/
}
