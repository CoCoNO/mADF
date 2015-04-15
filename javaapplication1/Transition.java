package javaapplication1;

public class Transition {
	
	public char inChar;
	public State nextState;
	
	public Transition(char input, State next){
		this.inChar = input;
		this.nextState = next;
	}
	
	
	public boolean equals(Transition tran) {
		// TODO Auto-generated method stub
		return tran.inChar == this.inChar && this.nextState.equals(tran.nextState);
	}

}
