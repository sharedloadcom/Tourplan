/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Solution;

import java.util.LinkedList;
import model.Customer;

/**
 *
 * @author nappio
 */
public class Charge {

    private int penalty;
    private int duration;
    private int distance;

    public Charge getCharge(LinkedList<Customer> customers) {
        //calc Cahrge of this TSP
        //Charge c =new Charge();

        //int dist=0;
        //int duration=0;
        //int penalty=0;

        for (int i = 0; i < customers.size() - 1; i++) {
            distance += Calc.calcDistance(customers.get(i), customers.get(i + 1));
            duration += calcDuration(customers.get(i), customers.get(i + 1));
            penalty += calcPenalty(customers.get(i + 1));
        }

        //c.setDistance(dist);
        //c.setDuration(duration);
        //c.setPenalty(penalty);
        return this;


    }

    private int calcDuration(Customer c1, Customer c2) {
        if (c1.isDepot() && c2.isDepot()) {
            return 0;
        }
        int dist, dur;
        dist = Calc.calcDistance(c1, c2);
        c2.setArrival(Math.max(c2.getLB(), c1.getDeparture() + dist));
        int ar=Math.min(c2.getLB(), c1.getDeparture() + dist);
        int waitingTime = Math.max(0, (c2.getLB() - ar));

        c2.setDeparture(c2.getArrival() + c2.getST());
        dur = dist + c2.getST() + waitingTime;
        return dur;

    }

    private int calcPenalty(Customer c2) {
        return Math.max(0, (c2.getArrival() - c2.getUB()));
        //return 0;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean less(Charge c) {
        if (this.penalty < c.penalty) {
            return true;
        }
        if (this.penalty > c.penalty) {
            return false;
        }
        if (this.penalty == c.penalty) {
            if (this.duration < c.duration) {
                return true;
            }
            if (this.duration > c.duration) {
                return false;
            }
            if (this.duration == c.duration) {
                if (this.distance < c.distance) {
                    return true;
                }
                if (this.distance >= c.distance) {
                    return false;
                }
            }
        }
        return false;
    }

    public static Charge WorstCharge() {
        Charge c = new Charge();
        c.distance = Integer.MAX_VALUE;
        c.duration = Integer.MAX_VALUE;
        c.penalty = Integer.MAX_VALUE;
        return c;
    }

    public boolean more(Charge c) {
        return !less(c);
    }

    @Override
    public String toString() {
        return "Penalty: " + penalty + " Duration: " + duration + " Distanz " + distance;
    }
}
