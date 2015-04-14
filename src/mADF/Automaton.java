/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package mADF;

import java.util.ArrayList;

/**
 *
 * @author CoCoNO
 */
public class Automaton {
    State first;
    ArrayList<State> states;
    ArrayList<State> alphabet;
    boolean lastResult;
    public Automaton()
    {
        first=null;
        lastResult=false;
        
        states= new ArrayList<State>() ;
        alphabet= new ArrayList<State>() ;
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
        if (state==null) {
            return;
        }
        if (states.contains(state)) {
            first=state;
        }
    }
    public State getInitialState()
    {
        return first;
    }
    public boolean Run(String n)
    {
        if (first==null) {
            return false;
        }
        //DoStuff;
        System.out.println("Processin:");
        return first.Proccess(n) ;
    }
    public boolean containsState(State _state)
    {
        return states.contains(_state);
    }
    
    
}
