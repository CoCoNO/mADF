package javaapplication1;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.LinkedList;


/**
 *
 * @author CoCoNO
 */
public class State {
    String name;
    LinkedList<Transition> transitions;
    boolean finale;
    boolean marked;
    
    public State(String _name, boolean _finale )
    {
        name=_name;
        finale=_finale;
        transitions= new LinkedList<Transition>();
    }
    

	public boolean equals(State st) {
		// TODO Auto-generated method stub
		return this.transitions.equals(st.transitions);
	}

	public void addTransition(char input,State goTo){
        transitions.add( new Transition( input, goTo) );
    }
}
