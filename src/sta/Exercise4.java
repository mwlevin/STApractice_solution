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
public class Exercise4 
{
    public static void main(String[] args)
    {
        
        Origin n1 = new Origin(1);
        Origin n2 = new Origin(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        
        
        System.out.println(n1.getId());
        System.out.println(n2.getId());
        
        n1.addDemand(n2, 15);
        n1.addDemand(n3, 20);
        n2.addDemand(n3, 19);
        n2.addDemand(n4, 23);
        
        System.out.println(n1.getDemand(n2));
        System.out.println(n1.getDemand(n3));
        System.out.println(n1.getDemand(n4));
        System.out.println(n2.getDemand(n1));
        System.out.println(n2.getDemand(n3));
        System.out.println(n2.getDemand(n4));
        
        
        autograde();
    }
    
    
    public static void autograde()
    {
        Autograde auto = new Autograde();
        
        
        Origin n1 = new Origin(1);
        Origin n2 = new Origin(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        
        auto.test(n1.getId() == 1, 1);
        auto.test(n2.getId() == 2, 1);
        
        auto.flush("Origin constructor");
        
        n1.addDemand(n2, 15);
        n1.addDemand(n3, 20);
        n2.addDemand(n3, 19);
        n2.addDemand(n4, 23);
        
        auto.test(n1.getDemand(n2) == 15, 1);
        auto.test(n1.getDemand(n3) == 20, 1);
        auto.test(n1.getDemand(n4) == 0, 1);
        auto.test(n2.getDemand(n1) == 0, 1);
        auto.test(n2.getDemand(n3) == 19, 1);
        auto.test(n2.getDemand(n4) == 23, 1);
        
        auto.flush("Origin.addDemand() and Origin.getDemand()");
        
        auto.end();
    }
}
