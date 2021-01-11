/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sta;

import static sta.Exercise1.autograde;

/**
 *
 * @author micha
 */
public class Exercise2 
{
    public static void main(String[] args)
    {
        Link[] array = new Link[]{
            
            
        };
        
        
        
        
        autograde();
    }
    
    public static void autograde()
    {
        
        Link link1 = new Link(null, null, 10, 2580, 0.15, 4);
        Link link2 = new Link(null, null, 12, 1900, 0.15, 4);
        
        
        double points = 0;
        double total = 0;
        
        System.out.println("\n\n********************");
        System.out.println("*    Autograde     *");
        System.out.println("********************");
        
        link1.setFlow(1230.2);
        points += (Math.abs(link1.getTravelTime() - 10.077538130554997) < 0.01)? 1 : 0;
        total ++;
        
        link2.setFlow(570);
        
        points += (Math.abs(link2.getTravelTime() - 12.014579999999999) < 0.01)? 1 : 0;
        total++;
        
        link1.setFlow(0);
        link2.setFlow(2512);
        
        
        
        
        points += (Math.abs(link1.getTravelTime() - 10.0) < 0.01)? 1 : 0;
        total++;
        
        points += (Math.abs(link2.getTravelTime() - 17.49967013308099) < 0.01)? 1 : 0;
        total++;
        
        System.out.println("\nTesting Link.getTravelTime(): " + Math.round(points/total*100.0)+"%");
        
        
    }
}
