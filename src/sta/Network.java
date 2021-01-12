/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sta;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author micha
 */
public class Network 
{
    private Node[] nodes;
    private Link[] links;
    private Zone[] zones;
    
    public Network(String name)
    {
        try
        {
            readNetwork(name);
        }
        catch(IOException ex)
        {
            ex.printStackTrace(System.err);
        }
    }
    
    
    public Network(Node[] nodes, Link[] links)
    {
        this.nodes = nodes;
        this.links = links;
        this.zones = zones;
    }
    
    
    public Link[] getLinks()
    {
        return links;
    }
    
    public Node[] getNodes()
    {
        return nodes;
    }
    
    public Zone[] getZones()
    {
        return zones;
    }
    
    
    
    
    public void readNetwork(String name) throws IOException
    {
        File netFile = new File("data/"+name+"/net.txt");
        File tripsFile = new File("data/"+name+"/trips.txt");
        
        
        
        int firstThruNode = 1;
        
        
        Scanner filein = new Scanner(netFile);
        
        String line;
        
        do
        {
            line = filein.nextLine();
            
            if(line.indexOf("<NUMBER OF ZONES>") >= 0)
            {
                zones = new Zone[Integer.parseInt(line.substring(line.indexOf('>')+1).trim())];
            }
            else if(line.indexOf("<NUMBER OF NODES>") >= 0)
            {
                nodes = new Node[Integer.parseInt(line.substring(line.indexOf('>')+1).trim())];
            }
            else if(line.indexOf("<NUMBER OF LINKS>") >= 0)
            {
                links = new Link[Integer.parseInt(line.substring(line.indexOf('>')+1).trim())];
            }
            else if(line.indexOf("<FIRST THRU NODE>") >= 0)
            {
                firstThruNode = Integer.parseInt(line.substring(line.indexOf('>')+1).trim());
            }
        }
        while(!line.trim().equals("<END OF METADATA>"));
        
        
        for(int i = 0; i < zones.length; i++)
        {
            zones[i] = new Zone(i+1);
        }
        
        for(int i = 0; i < nodes.length; i++)
        {
            if(i < zones.length)
            {
                nodes[i] = zones[i];
            }
            else
            {
                nodes[i] = new Node(i+1);
            }
        }
        
        
        while(!filein.hasNextInt())
        {
            filein.nextLine();
        }
        
        
        for(int i = 0; i < links.length; i++)
        {
            Node start = nodes[filein.nextInt()-1];
            Node end = nodes[filein.nextInt()-1];
            double C = filein.nextDouble();
            filein.nextDouble();
            double t_ff = filein.nextDouble();
            double alpha = filein.nextDouble();
            double beta = filein.nextDouble();
            
            filein.nextLine();
            
            links[i] = new Link(start, end, t_ff, C, alpha, beta);
            
        }
        
        
        filein.close();
        
        
        
        
        filein = new Scanner(tripsFile);
        
        do
        {
            line = filein.nextLine();
        }
        while(!line.trim().equals("<END OF METADATA>"));
        
        Zone r = null;
        
        while(filein.hasNext())
        {
            if(filein.hasNextInt())
            {
                Zone s = zones[filein.nextInt()-1];
                filein.next();
                String next = filein.next();
                double d = Double.parseDouble(next.substring(0, next.length()-1));
                
                r.addDemand(s, d);
            }
            else if(filein.next().equals("Origin"))
            {
                r = zones[filein.nextInt()-1];
            }
            
            
        }
        
        filein.close();
        
    }
}
