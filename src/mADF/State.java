package mADF;

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
    Hashtable< Character,State > transitions;
    Automaton parent;
    Boolean finale;
    public State(Automaton _parent,String _name,boolean _finale )
    {
        name=_name;
        finale=_finale;
        parent=_parent;
        transitions= new Hashtable< Character,State >();
        if (parent!=null) {
            parent.addState(this);
        }
    }
    
    public void addTransition(char input,State goTo)
    {
        if (!parent.containsState(goTo)) {
            return;
        }
        /**/
        transitions.put(input,goTo);
    }
    
    public void setFinale(boolean isFinal)
    {
        finale=isFinal;
    }
    public boolean isFinal()
    {
        return finale;
    }
    public boolean Proccess(String s)
    {
        System.out.println(name+":proccessing("+s+")");
        if (s=="") {
            return finale;
        }
        char c;
        String sc;
        if (s.length()>1) {
            c = s.charAt(s.length()-1);
            sc=s.substring(0, s.length() -1);
        }
        else{
            c=s.charAt(0);
            sc="";
        }
        
        
        State t=transitions.get((Character)c);
        return t.Proccess(sc);
    }
            
}
