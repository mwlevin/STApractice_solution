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
public class Exercise6 
{
    public static void main(String[] args)
    {
        Network network = new Network("SiouxFalls");
        
        
        Zone[] zones = network.getZones();
        Node[] nodes = network.getNodes();
        Link[] links = network.getLinks();
        
        
        for(int i = 0; i < links.length; i++)
        {
            links[i].setFlow(1021 + i*500);
        }
        
        Path path = new Path();
        path.add(links[0]);
        path.add(links[3]);
        path.add(links[14]);
        path.add(links[12]);
        
        System.out.println(path.isConnected());
        System.out.println(path.getTravelTime());        
        
        
        Path path2 = new Path();
        
        for(int i = 0; i < 4; i++)
        {
            path2.add(links[i]);
        }
        
        System.out.println(path2.isConnected());
        System.out.println(path2.getTravelTime());   
        
        
        
        autograde();
    }
    
    public static void autograde()
    {
        Autograde auto = new Autograde();
        
        
        
        Network network = new Network("SiouxFalls");
        
        
        Zone[] zones = network.getZones();
        Node[] nodes = network.getNodes();
        Link[] links = network.getLinks();
        
        
        for(int i = 0; i < links.length; i++)
        {
            links[i].setFlow(1021 + i*500);
        }
        
        Path path = new Path();
        path.add(links[0]);
        path.add(links[3]);
        path.add(links[14]);
        path.add(links[12]);
        
        auto.test(path.isConnected() == true);
                
        
        
        Path path2 = new Path();
        
        for(int i = 0; i < 4; i++)
        {
            path2.add(links[i]);
        }
        
        auto.test(path2.isConnected() == false);
        
        auto.flush("Link.isConnected()");
        
        
        
        auto.test(Math.abs(path.getTravelTime() - 24.37569064685568) < 0.01);
        auto.test(Math.abs(path2.getTravelTime() - 21.050172255908606) < 0.01);    
        
        
        auto.flush("Link.getTravelTime()");
        
        network.dijkstras(nodes[0]);
        
        auto.test(nodes[0].predecessor == null);
        
        for(int i = 1; i < nodes.length; i++)
        {
            if(i == 0)
            {
                auto.test(nodes[i].cost == 0);
            }
            else
            {
                auto.test(nodes[i].cost > 0);
            }
        }
        
        
        network.dijkstras(nodes[10]);
        
        auto.test(nodes[10].predecessor == null);
        
        for(int i = 1; i < nodes.length; i++)
        {
            if(i == 10)
            {
                auto.test(nodes[i].cost == 0);
            }
            else
            {
                auto.test(nodes[i].cost > 0);
            }
        }
        
        
        auto.flush("Dijkstra's initialization");
        
        
        
        auto.end();
    }
}
