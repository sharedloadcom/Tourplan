/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sharedload.com
 */
public class Instance {
    private int type;
    private Company company;
    private List<Customer> customers;
    private int VehiclesPerDepot;
    private int NumberOfCustomers;
    private int NumberOfDepots;

    public Instance() {
        customers=new ArrayList<Customer>();
        company =new Company();
    }
    
    

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public int getVehiclesPerDepot() {
        return VehiclesPerDepot;
    }

    public void setVehiclesPerDepot(int VehiclesPerDepot) {
        this.VehiclesPerDepot = VehiclesPerDepot;
    }

    public int getNumberOfCustomers() {
        return NumberOfCustomers;
    }

    public void setNumberOfCustomers(int NumberOfCustomers) {
        this.NumberOfCustomers = NumberOfCustomers;
    }

    public int getNumberOfDepots() {
        return NumberOfDepots;
    }

    public void setNumberOfDepots(int NumberOfDepots) {
        this.NumberOfDepots = NumberOfDepots;
    }

    
    
    
}
