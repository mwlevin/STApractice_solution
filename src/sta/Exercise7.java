/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sta;

/**
 *
 * @author micha
 */
public class Exercise7 
{
    public static void main(String[] args)
    {
        Network network = new Network("SiouxFalls");
                
        Link[] links = network.getLinks();
        
        
        for(int i = 0; i < links.length; i++)
        {
            links[i].setFlow(1021 + i*500);
        }
        
        
        System.out.println(network.getTSTT());
        System.out.println(network.getSPTT());
        System.out.println(network.getTotalTrips());
        System.out.println(network.getAEC());
        
        autograde();
    }
    
    public static void autograde()
    {
        Autograde auto = new Autograde();
        
        
        
        Network network = new Network("SiouxFalls");
        

        Link[] links = network.getLinks();
        
        
        for(int i = 0; i < links.length; i++)
        {
            links[i].setFlow(1021 + i*500);
        }
        
        
        auto.test(Math.abs(network.getTSTT() - 8.007500975406816E8) < 1);
        
        auto.flush("getTSTT()");
        
        auto.test(Math.abs(network.getSPTT() - 7.666724374221587E7) < 1);
        
        auto.flush("getSPTT()");
        
        auto.test(Math.abs(network.getTotalTrips() - 360600.0) < 1);
        
        auto.flush("getTotalTrips()");
        
        auto.test(Math.abs(network.getAEC() - 2007.9946028798274) < 0.1);
        
        auto.flush("getAEC()");
        
        auto.end();
        
    }
}
