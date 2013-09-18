/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Solution;

import java.awt.Point;
import java.util.LinkedList;
import model.Customer;

/**
 *
 * @author nappio
 */
public class Calc {

    public Calc() {
    }

    private static int distance(int x1, int y1, int x2, int y2) {
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        return (int) Math.round(p1.distance(p2));

    }

    public static int calcDistance(Customer c1, Customer c2) {
        if (c1.isDepot() && c2.isDepot()) {
            return 0;
        }
        return Calc.distance(c1.getX(), c1.getY(), c2.getX(), c2.getY());

    }
}
