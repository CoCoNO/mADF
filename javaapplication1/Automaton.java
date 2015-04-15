/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package javaapplication1;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author CoCoNO
 */
public class Automaton {
    State first;
    ArrayList<State> states;
    ArrayList<Character> alphabet;
    boolean lastResult;
    public Automaton()
    {
        first=null;
        lastResult=false;
        
        states= new ArrayList<State>() ;
        alphabet= new ArrayList<Character>() ;
    }
    
    public void setStates(ArrayList<State> _states)
    {
        states=_states;
    }
    
    public void addState(State state)
    {
        states.add(state);
    }
    public void setInitialState(State state)
    {
        if (states.contains(state)) {
            first=state;
        }
    }
    public boolean Run()
    {
        //DoStuff;
        return false;
    }
    
    public void mergeStates(State s1, State s2 ){
    	String nState = s1.name + s2.name; //Concatenación de los nombres de ambos estados a combinar
    	
    	for(State s: this.states) //Ciclo for each para cada uno de los estados
    		for(Transition t: s.transitions) //Ciclo for each para revisar cada transición
    			if(t.nextState.equals(s1) || t.nextState.equals(s2)) //Se revisa si la transición contiene alguno de los estados a reemplazar.
    				t.nextState.name = nState; 

    	s1.name = nState;
    	states.remove(s2);
 
    }
    
    public void  depthSearch(){ //Busqueda a profundidad para eliminar los nodos no accesibles
    	State ini = this.first;
    	State actualState = ini;
    	Stack<State> toVisit = new Stack<State>();
        ArrayList<State> visited = new ArrayList<State>();

    	do{
    		for (Transition trans : actualState.transitions) {
    			toVisit.add(trans.nextState);
			}
    		
    		visited.add(actualState);
    			
    		for (State state : visited) {
				if(state.equals(toVisit.peek())) toVisit.pop();
				else actualState = toVisit.pop();
			}
    	}while( !toVisit.empty());
    	
    	this.states.clear(); //Se borra y se vuelve a llenar con los nodos visitados
    	this.states.addAll(visited);
    }
    
    
}
