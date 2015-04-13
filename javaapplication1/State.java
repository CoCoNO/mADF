package javaapplication1;

import java.lang.String;
import java.util.Hashtable;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author CoCoNO
 */
public class State {
    String name;
    Hashtable< State,Character > transitions;
    Boolean finale;
    public State(String _name,boolean _finale )
    {
        name=_name;
        finale=_finale;
        transitions= new Hashtable< State,Character >();
    }
    
    public void addTransition(char input,State goTo)
    {
        transitions.put(goTo,input);
    }
}
