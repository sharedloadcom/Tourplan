/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author nappio
 */
public class Depot {
    private int Id;
    private List<Vehicle> vehicles;
    private int X;
    private int Y;
    private int LB;
    private int UB;
    private int Filling; //Füllgrad des Depots
    private int Load; //bereits abgeholte Kapazität;

    public Depot() {
        vehicles=new ArrayList<Vehicle>();
    }
    
    
    
    public int remainingFilling(){
        return Filling-Load;
    }
    
    public boolean addLoad(int l){
        if (Load+l<=remainingFilling()){
            Load=Load+l;
            return true;
        } else {
            return false;
        }
        
    }
    
    public boolean isEmpty(){
        return this.remainingFilling()<=0;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public int getFilling() {
        return Filling;
    }

    public void setFilling(int Filling) {
        this.Filling = Filling;
    }

    public int getLB() {
        return LB;
    }

    public void setLB(int LB) {
        this.LB = LB;
    }

    public int getUB() {
        return UB;
    }

    public void setUB(int UB) {
        this.UB = UB;
    }
    
    public int getG(){
        return 1000;
    }
    
    public int getST(){
        return 0;
    }
    
    public Customer DepotToCustomer(){
        //this=new Depot();
        Customer c = new Customer();
        c.setLB(this.getLB());
        c.setUB(this.getUB());
        c.setX(this.getX());
        c.setY(this.getY());
        c.setDepot(true);
        return c;
    }

    @Override
    public String toString() {
        return "Depot{" + "Id=" + Id + ", X=" + X + ", Y=" + Y + ", LB=" + LB + ", UB=" + UB + '}';
    }
    
    
}
