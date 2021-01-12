/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sta;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import static sta.Exercise2.findCongestedLinks;

/**
 *
 * @author micha
 */
public class Exercise8 
{
    public static void main(String[] args)
    {
        Network network = new Network("SiouxFalls");
                
        Link[] links = network.getLinks();
        
        
        for(int i = 0; i < links.length; i++)
        {
            links[i].setFlow(1021 + i*500);
        }
        
        for(int i = 0; i < links.length; i++)
        {
            links[i].addXstar(100 + i*30);
        }
        
        for(int i = 0; i < links.length; i++)
        {
            links[i].addXstar(300 + i*55);
        }
        
        double lambda = network.calculateStepsize(3);
        
        for(int i = 0; i < links.length; i++)
        {
            links[i].calculateNewX(lambda);
        }
        
        for(int i = 0; i < links.length; i++)
        {
            System.out.println(links[i]+"\t"+links[i].getFlow());
        }
        
        
        network = new Network("Braess");
        
        links = network.getLinks();
        
        network.calculateAON();
        
        network.calculateNewX(1);
        
        
        for(int i = 0; i < links.length; i++)
        {
            System.out.println(links[i]+"\t"+links[i].getFlow());
        }
        
        
        network = new Network("Braess");
        
        links = network.getLinks();
        
        network.msa(10);
        
        for(int i = 0; i < links.length; i++)
        {
            System.out.println(links[i]+"\t"+links[i].getFlow());
        }
        
        
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
        
        for(int i = 0; i < links.length; i++)
        {
            links[i].addXstar(100 + i*30);
        }
        
        for(int i = 0; i < links.length; i++)
        {
            links[i].addXstar(300 + i*55);
        }
        
        double lambda = network.calculateStepsize(3);
        
        for(int i = 0; i < links.length; i++)
        {
            links[i].calculateNewX(lambda);
        }
        
        
        double[] newflows = new double[]{814.0, 1175.6666666666667, 1537.3333333333335, 1899.0, 2260.666666666667, 2622.3333333333335, 
            2984.0000000000005, 3345.666666666667, 3707.3333333333335, 4069.0000000000005, 4430.666666666667, 4792.333333333334, 
            5154.0, 5515.666666666668, 5877.333333333334, 6239.0, 6600.666666666668, 6962.333333333334, 7324.0, 7685.666666666668, 
            8047.333333333334, 8409.000000000002, 8770.666666666668, 9132.333333333334, 9494.000000000002, 9855.666666666668, 
            10217.333333333334, 10579.000000000002, 10940.666666666668, 11302.333333333334, 11664.000000000002, 12025.666666666668, 
            12387.333333333334, 12749.000000000002, 13110.666666666668, 13472.333333333334, 13834.000000000002, 14195.666666666668, 
            14557.333333333334, 14919.000000000002, 15280.666666666668, 15642.333333333336, 16004.000000000002, 16365.666666666668, 
            16727.333333333336, 17089.0, 17450.666666666668, 17812.333333333336, 18174.0, 18535.66666666667, 18897.333333333336, 19259.0, 
            19620.66666666667, 19982.333333333336, 20344.0, 20705.66666666667, 21067.333333333336, 21429.0, 21790.66666666667, 22152.333333333336, 
            22514.0, 22875.66666666667, 23237.333333333336, 23599.0, 23960.66666666667, 24322.333333333336, 24684.0, 25045.66666666667, 25407.333333333336, 
            25769.0, 26130.66666666667, 26492.333333333336, 26854.0, 27215.66666666667, 27577.333333333336, 27939.0};
        
        for(int i = 0; i < 76; i++)
        {
            if(i < links.length)
            {
                auto.test(Math.abs(links[i].getFlow() - newflows[i]) < 0.1);
            }
            else
            {
                auto.test(false);
            }
        }
        
        auto.flush("Link.calculateNewX()");
        
        for(int i = 0; i < links.length; i++)
        {
            links[i].setFlow(1021 + i*500);
        }
        
        for(int i = 0; i < links.length; i++)
        {
            links[i].addXstar(100 + i*30);
        }
        
        for(int i = 0; i < links.length; i++)
        {
            links[i].addXstar(300 + i*55);
        }
        
        lambda = network.calculateStepsize(5);
        
        network.calculateNewX(lambda);
        
        newflows = new double[]{896.8000000000001, 1313.8, 1730.8000000000002, 2147.8, 2564.8, 2981.8, 3398.8, 3815.8, 4232.8, 
            4649.8, 5066.8, 5483.8, 5900.8, 6317.8, 6734.8, 7151.8, 7568.8, 7985.8, 8402.8, 8819.800000000001, 9236.800000000001, 
            9653.800000000001, 10070.800000000001, 10487.800000000001, 10904.800000000001, 11321.800000000001, 11738.800000000001, 
            12155.800000000001, 12572.800000000001, 12989.800000000001, 13406.800000000001, 13823.800000000001, 14240.800000000001, 
            14657.800000000001, 15074.800000000001, 15491.800000000001, 15908.800000000001, 16325.800000000001, 16742.800000000003, 
            17159.8, 17576.8, 17993.8, 18410.8, 18827.8, 19244.8, 19661.8, 20078.8, 20495.8, 20912.800000000003, 21329.800000000003, 
            21746.800000000003, 22163.800000000003, 22580.800000000003, 22997.800000000003, 23414.800000000003, 23831.800000000003, 
            24248.800000000003, 24665.800000000003, 25082.800000000003, 25499.800000000003, 25916.800000000003, 26333.800000000003, 
            26750.800000000003, 27167.800000000003, 27584.800000000003, 28001.800000000003, 28418.800000000003, 28835.800000000003, 
            29252.800000000003, 29669.800000000003, 30086.800000000003, 30503.800000000003, 30920.800000000003, 31337.800000000003, 
            31754.800000000003, 32171.800000000003};
        
        for(int i = 0; i < 76; i++)
        {
            if(i < links.length)
            {
                auto.test(Math.abs(links[i].getFlow() - newflows[i]) < 0.1);
            }
            else
            {
                auto.test(false);
            }
        }
        
        auto.flush("Network.calculateNewX()");
        
        
        
        
        
        network = new Network("Braess");
        
        links = network.getLinks();
        
        network.calculateAON();
        
        network.calculateNewX(1);
        
        
        newflows = new double[]{4000.0, 0.0, 0.0, 4000.0, 4000.0};
        
        for(int i = 0; i < links.length; i++)
        {
            auto.test(Math.abs(links[i].getFlow() - newflows[i]) < 0.1);
        }
        
        auto.flush("Network.calculateAON()");
        
        
        
        network = new Network("Braess");
        
        links = network.getLinks();
        
        double[] AECs = new double[]{1.02, 9.54, 4.126666666666664, 2.2575, 1.404, 0.9466666666666642, 0.6746938775510279, 0.5006250000000073, 0.3829629629629635, 0.3};
        
        newflows = new double[]{3600.0, 0.0, 400.00000000000006, 4000.0, 3600.0};
        
        try
        {
            PrintStream normalOut = System.out;
            
            File tempFile = new File("temporary_testing.txt");
            PrintStream fileout = new PrintStream(new FileOutputStream(tempFile), true);
            System.setOut(fileout);
            
            network.msa(10);
            fileout.close();
            
            
            
            System.setOut(normalOut);
            
            
            Scanner filein = new Scanner(tempFile);
            
            if(filein.hasNext())
            {
                auto.test(filein.next().equalsIgnoreCase("Iteration"));
            }
            else
            {
                auto.test(false);
            }
            
            if(filein.hasNext())
            {
                auto.test(filein.next().equalsIgnoreCase("AEC"));
            }
            else
            {
                auto.test(false);
            }
            
            for(int i = 0; i < AECs.length; i++)
            {
                if(filein.hasNextInt())
                {
                    auto.test(filein.nextInt() == i+1);
                }
                else
                {
                    auto.test(false);
                    if(filein.hasNext())
                    {
                        filein.next();
                    }
                }
                
                if(filein.hasNextDouble())
                {
                    auto.test(Math.abs(filein.nextDouble() - AECs[i]) < 0.01);
                }
                else
                {
                    auto.test(false);
                    if(filein.hasNext())
                    {
                        filein.next();
                    }
                }
            }

            filein.close();
            
            tempFile.delete();
        }
        catch(IOException ex)
        {
            ex.printStackTrace(System.err);
        }
        
        auto.flush("method of successive averages");
        
        
        for(int i = 0; i < 5; i++)
        {
            if(i < links.length)
            {
                auto.test(Math.abs(links[i].getFlow() - newflows[i]) < 0.01);
            }
            else
            {
                auto.test(false);
            }
        }
        
        auto.flush("link flows after 10 iterations of MSA");
        
        auto.end();
        
    }
}
