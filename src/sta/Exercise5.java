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
public class Exercise5 
{
    public static void main(String[] args)
    {
        Network network = new Network("Braess");
        
        
        Zone[] zones = network.getZones();
        Node[] nodes = network.getNodes();
        Link[] links = network.getLinks();
        
        for(int i = 0; i < zones.length; i++)
        {
            System.out.println(zones[i]+" "+(zones[i] == nodes[i])+" "+zones[i].getOutgoing());
        }
        
        for(int i = zones.length; i < nodes.length; i++)
        {
            System.out.println(nodes[i]+" "+nodes[i].getOutgoing());
        }
        
        for(Link l : links)
        {
            System.out.println(l+"\t"+l.getCapacity()+"\t"+l.getTravelTime());
        }
        
        
        for(int r = 0; r < zones.length; r++)
        {
            for(int s = 0; s < zones.length; s++)
            {
                System.out.println(zones[r]+" "+zones[s]+" "+zones[r].getDemand(zones[s]));
            }
        }
        
        autograde();
    }
    
    
    public static void autograde()
    {
        Autograde auto = new Autograde();
        
        Network network = new Network("Braess");
        
        auto.test(network.getNodes().length == 4);
        auto.test(network.getLinks().length == 5);
        auto.test(network.getZones().length == 4);
        
        auto.flush("reading metadata of \"net.txt\"");
        
        
        Zone[] zones = network.getZones();
        Node[] nodes = network.getNodes();
        Link[] links = network.getLinks();
        
        for(int i = 0; i < zones.length; i++)
        {
            auto.test(zones[i] == nodes[i] && zones[i] != null);
        }
        
        for(int i = zones.length; i< nodes.length; i++)
        {
            auto.test(nodes[i] != null);
        }
        
        auto.flush("construction of zones and nodes");
        
        for(int i = 0; i< nodes.length; i++)
        {
            auto.test(nodes[i].getId() == i+1);
        }
        
        auto.flush("correct ids for nodes");
        
        auto.test(links[0].getStart().getId() == 1);
        auto.test(links[1].getStart().getId() == 2);
        auto.test(links[2].getStart().getId() == 1);
        auto.test(links[3].getStart().getId() == 3);
        auto.test(links[4].getStart().getId() == 2);
        
        auto.test(links[0].getEnd().getId() == 2);
        auto.test(links[1].getEnd().getId() == 4);
        auto.test(links[2].getEnd().getId() == 3);
        auto.test(links[3].getEnd().getId() == 4);
        auto.test(links[4].getEnd().getId() == 3);
        
        auto.flush("start and end nodes from data file");
        
        auto.test(nodes[0].getOutgoing().contains(links[0]));
        auto.test(nodes[0].getOutgoing().contains(links[2]));
        auto.test(nodes[0].getOutgoing().size() == 2);
        
        auto.test(nodes[1].getOutgoing().contains(links[1]));
        auto.test(nodes[1].getOutgoing().contains(links[4]));
        auto.test(nodes[1].getOutgoing().size() == 2);
        
        auto.test(nodes[2].getOutgoing().contains(links[3]));
        auto.test(nodes[2].getOutgoing().size() == 1);
        
        auto.test(nodes[3].getOutgoing().size() == 0);
        

        auto.flush("outgoing links");
        
        auto.test(links[0].getTravelTime() == 1);
        auto.test(links[1].getTravelTime() == 50);
        auto.test(links[2].getTravelTime() == 45);
        auto.test(links[3].getTravelTime() == 1);
        auto.test(links[4].getTravelTime() == 5);
        
        auto.test(links[0].getCapacity() == 100);
        auto.test(links[1].getCapacity() == 1000000);
        auto.test(links[2].getCapacity() == 1000000);
        auto.test(links[3].getCapacity() == 200);
        auto.test(links[4].getCapacity() == 1000000);
        
        
        
        auto.flush("link capacities and free flow travel times");
        
        for(int r = 0; r < zones.length; r++)
        {
            for(int s = 0; s < zones.length; s++)
            {
                if(r == 0 && s == 3)
                {
                    auto.test(zones[r].getDemand(zones[s]) == 4000);
                    
                }
                else
                {
                    auto.test(zones[r].getDemand(zones[s]) == 0);
                }
            }
        }
        
        auto.flush("trips.txt file");
        
        
        
        network = new Network("SiouxFalls");
        
        
        zones = network.getZones();
        nodes = network.getNodes();
        links = network.getLinks();
        
        int[] outgoing = new int[]{2, 2, 3, 3, 3, 3, 2, 4, 3, 5, 4, 3, 2, 3, 4, 4, 3, 3, 3, 4, 3, 4, 3, 3};
        
        for(int i = 0; i < nodes.length; i++)
        {
            auto.test(nodes[i].getOutgoing().size() == outgoing[i]);
        }
        
        auto.flush("outgoing links of Sioux Falls");
        
        
        double[] productions = new double[]{8800.0, 4000.0, 2800.0, 11600.0, 6100.0, 7600.0, 12100.0, 16700.0, 16200.0, 45200.0, 
            22300.0, 13900.0, 14600.0, 14100.0, 21400.0, 26100.0, 23400.0, 4800.0, 12800.0, 18500.0, 11000.0, 24400.0, 14500.0, 7700.0};
        
        for(int i = 0; i < zones.length; i++)
        {
            auto.test(zones[i].getProductions() == productions[i]);
        }
        
        auto.flush("productions of Sioux Falls");
        
        
        for(int i = 0; i < nodes.length; i++)
        {
            if(i < zones.length)
            {
                auto.test(network.findNode(nodes[i].getId()) == zones[i]);
            }
            else
            {
                auto.test(network.findNode(nodes[i].getId()) == nodes[i]);
            }
        }
        
        auto.flush("Network.findNode()");
        
        for(int i = 0; i < links.length; i++)
        {
            auto.test(network.findLink(network.findNode(links[i].getStart().getId()), network.findNode(links[i].getEnd().getId())) == links[i]);
        }
        
        auto.flush("Network.findLink()");
        
        auto.end();
    }
}
