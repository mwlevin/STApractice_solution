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
public class Autograde 
{
    private double points, total;
    private double overall_points, overall_total;
    
    public Autograde()
    {
        printAutogradeHeader();
        
        points = 0;
        total = 0;
        overall_points = 0;
        overall_total = 0;
    }
    
    public void test(boolean pass, int value)
    {
        total += value;
        
        if(pass)
        {
            points += value;
        }
    }
    
    public void flush(String label)
    {
        System.out.println("Testing "+label+": " + Math.round(points/total*100.0)+"%");
        
        overall_points += points;
        overall_total += total;
        
        total = 0;
        points = 0;
    }
    
    public void end()
    {
        System.out.println("\nTotal: "+Math.round(overall_points / overall_total * 100.0)+"%");
        
        printAutogradeFooter();
    }
    
    
    public void printAutogradeHeader()
    {
        System.out.println("\n\n********************");
        System.out.println("*    Autograde     *");
        System.out.println("********************\n");
    }
    
    public void printAutogradeFooter()
    {
        System.out.println("\n********************");
        System.out.println("*  End Autograde   *");
        System.out.println("********************");
    }
}
