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
public class Exercise3 
{
    public static void main(String[] args)
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        
        Link[] array = new Link[]{
            new Link(n1, n2, 10, 2580, 0.15, 4),
            new Link(n1, n3, 11, 1130, 0.15, 4),
            new Link(n2, n4, 6, 1280, 0.15, 4),
            new Link(n3, n4, 12, 1900, 0.35, 2),
            new Link(n2, n3, 13, 1460, 0.15, 4)
        };
        
        System.out.println(n1.getId()+" "+n1.getOutgoing());
        System.out.println(n2.getId()+" "+n2.getOutgoing());
        System.out.println(n3.getId()+" "+n3.getOutgoing());
        System.out.println(n4.getId()+" "+n4.getOutgoing());
        
        for(Link l : array)
        {
            System.out.println(l+" "+l.getStart()+" "+l.getEnd());
        }
        
        
        System.out.println(n1.getOutgoing());
        System.out.println(n2.getOutgoing());
        System.out.println(n3.getOutgoing());
        System.out.println(n4.getOutgoing());
        
        
        
        
        
        
        
        autograde();
    }
    
    
    public static void autograde()
    {
        
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        
        double[] flows = new double[]{1200, 1300, 1400, 1500, 1600};
        
        Link[] array = new Link[]{
            new Link(n1, n2, 10, 2580, 0.15, 4),
            new Link(n1, n3, 11, 1130, 0.15, 4),
            new Link(n2, n4, 6, 1280, 0.15, 4),
            new Link(n3, n4, 12, 1900, 0.35, 2),
            new Link(n2, n3, 13, 1460, 0.15, 4)
        };
        
        Node[] starts = new Node[]{n1, n1, n2, n3, n2};
        Node[] ends = new Node[]{n2, n3, n4, n4, n3};
        
        for(int i = 0; i < array.length; i++)
        {
            array[i].setFlow(flows[i]);
        }
        
        
        
        
        Autograde auto = new Autograde();
        
        for(int i = 0; i < array.length; i++)
        {
            auto.test(array[i].getStart() == starts[i]);
        }
        
        auto.flush("Node.getStart()");
        
        for(int i = 0; i < array.length; i++)
        {
            auto.test(array[i].getEnd() == ends[i]);
        }
        
        auto.flush("Node.getEnd()");
        
        
        auto.test(n1.getId()==1);
        auto.test(n2.getId()==2);
        auto.test(n3.getId()==3);
        auto.test(n4.getId()==4);
        
        auto.flush("Node.getId()");
        
        auto.test(n1.toString().equals("1"));
        auto.test(n2.toString().equals("2"));
        auto.test(n3.toString().equals("3"));
        auto.test(n4.toString().equals("4"));
        
        auto.flush("Node.toString()");
        
        auto.test(array[0].toString().equals("(1, 2)"));
        auto.test(array[1].toString().equals("(1, 3)"));
        auto.test(array[2].toString().equals("(2, 4)"));
        auto.test(array[3].toString().equals("(3, 4)"));
        auto.test(array[4].toString().equals("(2, 3)"));
        
        auto.flush("Link.toString()");
        
        auto.test((""+n1.getOutgoing()).equals("[(1, 2), (1, 3)]") || (""+n1.getOutgoing()).toString().equals("[(1, 3), (1, 2)]"));
        auto.test((""+n2.getOutgoing()).toString().equals("[(2, 3), (2, 4)]") || (""+n2.getOutgoing()).toString().equals("[(2, 4), (2, 3)]"));
        auto.test((""+n3.getOutgoing()).toString().equals("[(3, 4)]"));
        auto.test((""+n4.getOutgoing()).toString().equals("[]"));
        
        auto.flush("Node.getOutgoing()");
        
        auto.end();
    }
}
