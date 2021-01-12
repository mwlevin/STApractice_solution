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
public class Exercise1 
{
    public static void main(String[] args)
    {
        Link link1 = new Link(null, null, 10, 2580, 0.15, 4);
        Link link2 = new Link(null, null, 12, 1900, 0.35, 2);
        
        link1.setFlow(1230.2);
        System.out.println(link1.getTravelTime());
        
        
        link2.setFlow(570);
        System.out.println(link2.getTravelTime());
        
        link1.setFlow(0);
        link2.setFlow(2512);

        System.out.println(link1.getTravelTime());
        System.out.println(link2.getTravelTime());
        
        
        
        autograde();
    }
    
    public static void autograde()
    {
        
        Link link1 = new Link(null, null, 10, 2580, 0.15, 4);
        Link link2 = new Link(null, null, 12, 1900, 0.35, 2);
        
        
        Autograde auto = new Autograde();
        
        
        link1.setFlow(1230.2);
        auto.test(Math.abs(link1.getTravelTime() - 10.077538130554997) < 0.01);
        
        link2.setFlow(570);
        
        auto.test(Math.abs(link2.getTravelTime() - 12.378) < 0.01);
        
        link1.setFlow(0);
        link2.setFlow(2512);
        

        auto.test(Math.abs(link1.getTravelTime() - 10.0) < 0.01);
        auto.test(Math.abs(link2.getTravelTime() - 19.341441772853184) < 0.01);
        
        auto.flush("Link.getTravelTime()");
        auto.end();
        
        
    }
}
