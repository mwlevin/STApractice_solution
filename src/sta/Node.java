/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sta;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author micha
 */
public class Node 
{
    
    
    /* **********
    Exercise 3(b)
    ********** */
    
    private int id;
    
    
    public Node(int id)
    {
        this.id = id;
        outgoing = new ArrayList<>();
    }
    
    public int getId()
    {
        return id;
    }
    
    
    
    
    
    
    
    public int hashCode()
    {
        return getId();
    }
    
    /* **********
    Exercise 3(c)
    ********** */
    public String toString()
    {
        return ""+getId();
    }
    
    
    
    
    /* **********
    Exercise 3(d)
    ********** */
    
    private ArrayList<Link> outgoing;
    
    public ArrayList<Link> getOutgoing()
    {
        return outgoing;
    }
    
    public void addOutgoingLink(Link l)
    {
        outgoing.add(l);
    }
}
