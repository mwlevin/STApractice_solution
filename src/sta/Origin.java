/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sta;

import java.util.HashMap;

/**
 *
 * @author micha
 */
public class Origin extends Node
{
    private HashMap<Node, Double> demand;
    
    /* **********
    Exercise 4(a)
    ********** */
    public Origin(int id)
    {
        // remove this
        super(id);
        demand = new HashMap<>();
        
    }
    
    
    
    /* **********
    Exercise 4(b)
    ********** */
    public void addDemand(Node s, double d)
    {
        if(demand.containsKey(s))
        {
            demand.put(s, demand.get(s) + d);
        }
        else
        {
            demand.put(s, d);
        }
    }
    
    public double getDemand(Node s)
    {
        if(demand.containsKey(s))
        {
            return demand.get(s);
        }
        else
        {
            return 0;
        }
    }
}
