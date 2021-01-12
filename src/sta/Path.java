/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sta;

import java.util.ArrayList;

/**
 *
 * @author micha
 */
public class Path extends ArrayList<Link>
{
    public double getTravelTime()
    {
        double output = 0;
        
        for(Link l : this)
        {
            output += l.getTravelTime();
        }
        
        return output;
    }
    
    public boolean isConnected()
    {
        for(int i = 0; i < size()-1; i++)
        {
            if(get(i).getEnd() != get(i+1).getStart())
            {
                return false;
            }
        }
        
        return true;
    }
    
    public void addFlow(double h)
    {
        
    }
}
