/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Solution;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import model.Customer;
import model.Depot;
import model.Instance;
import model.Vehicle;

/**
 *
 * @author nappio
 */
public class TSP {

    /*private int id;
     private Vehicle vehicle;*/
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
        //lowestOrder = new LinkedList<Customer>();
        InitialSolution();
        Optimize();
        //test();

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
                    //currentcharge = customers.getCharge();
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
        /*s.setCharge(MinCharge);
        s.setCustomers(lowestOrder);*/
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
                //AllOrders.addAll(TourOrder);
           
            }
            }
        System.out.println();
        s.setCharge(MinCharge);
        s.setCustomers(optOrder);
        System.out.println(s.getCharge());
        System.out.println(optOrder);

    }

    public void test() {
        s = new Solution();
        Depot d = new Depot();
        d.setX(0);
        d.setY(0);
        d.setLB(0);
        d.setUB(1000);

        Customer c1 = new Customer();
        c1.setId(1);
        c1.setX(50);
        c1.setY(0);
        c1.setLB(0);
        c1.setUB(30);
        c1.setST(10);

        System.out.println();
        System.out.println(d);

        customers = new LinkedList<Customer>();
        customers.add(c1);

        //s.setCustomers(customers);
        s.setCharge(getCharge(customers));
        Charge ch1 = getCharge(customers);
        Charge ch2 = new Charge();
        ch2.setPenalty(20);
        ch2.setDuration(110);
        ch2.setDistance(101);
        System.out.println(ch1.less(ch2));

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
