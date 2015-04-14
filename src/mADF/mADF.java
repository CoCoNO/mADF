/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author CoCoNO
 */
public class mADF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Hello, World"+example());

    }
	
	public static bool example()
	{
		Automaton t= new Automaton();
        State a,b,c,d;
        a=new State(t, "A", false);
        b=new State(t, "B", false);
        c=new State(t, "C", false);
        d=new State(t, "D", true);
        
        
        a.addTransition('a', a);
        a.addTransition('b', d);
        d.addTransition('a', d);
        d.addTransition('b', d);
        t.setInitialState(a);
        
        
        return t.Run("ab");
	}
    public static Automaton minimizeAutomaton(Automaton t)
	{
		
		//DeepSearch unreachable removal
		
		//Make all pairs
		State [][]pairs;
		//separate indistinguishable states
		
		Return t;
		
	}
}
