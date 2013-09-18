/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nappio
 */
public class Customer {
    private int Id;
    private int X;
    private int Y;
    private int ST; //Servicetime=duration
    private int LB;
    private int UB;
    private int g; //#goods=Menge
    
    private int Arrival=0;
    private int Departure=0;
    private boolean depot=false;

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

    public int getST() {
        return ST;
    }

    public void setST(int ST) {
        this.ST = ST;
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

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getArrival() {
        return Arrival;
    }

    public void setArrival(int Arrival) {
        this.Arrival = Arrival;
    }

    public int getDeparture() {
        return Departure;
    }

    public void setDeparture(int Departure) {
        this.Departure = Departure;
    }

    public boolean isDepot() {
        return depot;
    }

    public void setDepot(boolean depot) {
        this.depot = depot;
    }

    @Override
    public String toString() {
        return "Customer{" + "Id=" + Id + ", X=" + X + ", Y=" + Y + ", ST=" + ST + ", LB=" + LB + ", UB=" + UB + ", g=" + g + ", depot=" + depot + '}';
    }
    
    
    
    
    
}
