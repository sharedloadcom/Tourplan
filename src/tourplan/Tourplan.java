/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tourplan;

import Solution.Solution;
import Solution.TSP;
import model.Instance;

/**
 *
 * @author sharedload.com
 */
public class Tourplan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Instance i=ReadInstance.ReadStaticFile();
        System.out.println("Anzahl Kunden" +i.getCustomers().size());
        TSP tsp=new TSP(i);
        Solution s=tsp.getSolution();
        System.out.println("Beste Tour "+s.getCustomers());
        System.out.println("Beste Lösung "+s.getCharge());
        
        
        
    }
}
