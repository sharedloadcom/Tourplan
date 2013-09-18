/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Solution;

import java.util.Collections;
import java.util.LinkedList;
import model.Customer;
import model.Depot;
import model.Instance;

/**
 *
 * @author sharedload.com
 */
public class TSP {

  
    private Depot depot;
    private LinkedList<Customer> customers;
    private LinkedList<Customer> lowestOrder;
    private LinkedList<Customer> OrigList;
    private Solution s;

    public TSP(Instance i) {

        OrigList = new LinkedList<Customer>();
        OrigList.addAll(i.getCustomers());
        depot = i.getCompany().getDepots().get(0);
        customers = new LinkedList<Customer>();
        InitialSolution();
        Optimize();

    }

    //Nearest Neighbor
    private void InitialSolution() {
        lowestOrder= new LinkedList<Customer>();
        System.out.println(customers.size());
        System.out.println(OrigList.size());
        Customer c = OrigList.pop();
        customers.add(c);
        System.out.println(customers);
        Charge currentcharge = null;
        Charge MinCharge = null;
        s = new Solution();
        while (!OrigList.isEmpty()) {
            c = OrigList.pop();

            MinCharge = Charge.WorstCharge();

            customers.add(0, c);
            
            currentcharge = getCharge(customers);
            if (currentcharge.less(MinCharge)) {
                lowestOrder.clear();
                lowestOrder.addAll(customers);
                MinCharge = currentcharge;
            }
            

            for (int i = 1; i <= customers.size(); i++) {

                if (i < customers.size()) {
                   
                    Collections.swap(customers,i - 1, i);
                    currentcharge = getCharge(customers);
                    if (currentcharge.less(MinCharge)) {
                        lowestOrder.clear();
                        lowestOrder.addAll(customers);
                        MinCharge = currentcharge;
                        

                    } 

                }

            }
            
        }
        s.setCharge(MinCharge);
        s.setCustomers(lowestOrder);
        System.out.println(s.getCharge());
        System.out.println(lowestOrder);
    }

    //2-OPT
    private void Optimize() {
        LinkedList<Customer> optOrder= new LinkedList<Customer>();
        
        Charge MinCharge = s.getCharge();
        Charge currentcharge;
        optOrder.addAll(s.getCustomers());
        System.out.println("In opt "+lowestOrder);
        for (int i = 1; i < lowestOrder.size() - 2; i++) {
            for (int j = i + 1; j < lowestOrder.size() - 1; j++) {
                Collections.swap(lowestOrder,i , j);
                currentcharge = getCharge(lowestOrder);
                if (currentcharge.less(MinCharge)){
                    MinCharge=currentcharge;
                    optOrder.clear();
                    optOrder.addAll(lowestOrder);
                }
               
           
            }
            }
        System.out.println();
        s.setCharge(MinCharge);
        s.setCustomers(optOrder);
        System.out.println(s.getCharge());
        System.out.println(optOrder);

    }

    

    public Solution getSolution() {

        return s;

    }
    
    public Charge getCharge(LinkedList<Customer> clist){
        clist.offerFirst(depot.DepotToCustomer());
        clist.offerLast(depot.DepotToCustomer());
        Charge c=new Charge().getCharge(clist);
        clist.removeFirst();
        clist.removeLast();
        return c;
        
    }
}
