/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tourplan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.Company;
import model.Customer;
import model.Depot;
import model.Instance;
import model.Vehicle;

/**
 *
 * @author nappio
 */
public class ReadInstance {

    public ReadInstance() {
    }

    public static Instance ReadStaticFile() {
        String file;
        String line;
        File inputFile;
        FileReader fr;
        BufferedReader br;

        String[] values;
        int maximumLoadOfAVehicle=0;
        Instance inst = new Instance();
        try {
           
            file = "/home/nappio/NetBeansProjects/Tourplan/src/Instances/C-mdvrptw/pr20";
            System.out.println("Inhalt von " + file);
            inputFile = new File(file);
            fr = new FileReader(inputFile);
            br = new BufferedReader(fr);
            line = br.readLine();
            values = line.split(" ");

            
            inst.setType(Integer.parseInt(values[0]));
            inst.setVehiclesPerDepot(Integer.parseInt(values[1]));
            inst.setNumberOfCustomers(Integer.parseInt(values[2]));
            inst.setNumberOfDepots(Integer.parseInt(values[3]));
            System.out.println("Anz. KFZ / Depot " + inst.getVehiclesPerDepot());
            System.out.println("Anz. Depot " + inst.getNumberOfDepots());
            System.out.println("Anz. Kunden " + inst.getNumberOfCustomers());
            for (int i = 0; i < inst.getNumberOfDepots(); i++) {
                //Vehicle v=new Vehicle();
                line = br.readLine();
                values = line.split(" ");
                
                maximumLoadOfAVehicle=(Integer.parseInt(values[1]));
                

            }
            System.out.println("Max. Zuladung eines LKW: "+maximumLoadOfAVehicle);


            for (int i = 0; i < inst.getNumberOfCustomers(); i++) {
                line = br.readLine();
                line = line.replace("  ", " ");
                line = line.replace("  ", " ");
                line = line.trim();
                values = line.split(" ");
                Customer c = new Customer();

                c.setId(Integer.parseInt(values[1 - 1])); //ID
                c.setX((Integer) (int) Math.round(Double.parseDouble(values[2 - 1]) + 100.0)); //x
                c.setY((Integer) (int) Math.round(Double.parseDouble(values[3 - 1]) + 100.0)); //y
                c.setLB(Integer.parseInt(values[values.length - 2])); //LB
                c.setUB(Integer.parseInt(values[values.length - 1])); //UB
                c.setG(Integer.parseInt(values[5 - 1])); //g
                c.setST(Integer.parseInt(values[4 - 1])); //ST
                inst.getCustomers().add(c);
            }
            for (int i = 0; i < inst.getNumberOfDepots(); i++) {
                Depot d = new Depot();
                line = br.readLine();
                line = line.replace("  ", " ");
                line = line.replace("  ", " ");
                line = line.trim();

                values = line.split(" ");
                for (int j=0; j<inst.getVehiclesPerDepot();j++){
                    Vehicle v=new Vehicle();
                    v.setId(j);
                    v.setCapacity(maximumLoadOfAVehicle);
                    d.getVehicles().add(v);
                }

                d.setId(Integer.parseInt(values[1 - 1]));//ID
                d.setX((Integer) (int) Math.round(Double.parseDouble(values[2 - 1]) + 100));//X
                d.setY((Integer) (int) Math.round(Double.parseDouble(values[3 - 1]) + 100));//Y
                d.setLB(Integer.parseInt(values[8 - 1]));//LB
                d.setUB(Integer.parseInt(values[9 - 1]));//UB
                d.setFilling(1000);
                inst.getCompany().getDepots().add(d);


            }

            if (inst.getType() == 20) {
                line = br.readLine();

                ArrayList<Integer> AllArtDist = new ArrayList();
                values = line.split(" ");
                Integer NoArtDist = Integer.parseInt(values[0]);
                for (int k = 0; k < NoArtDist; k++) {
                    line = br.readLine();
                    line = line.replace("  ", " ");
                    line = line.replace("  ", " ");
                    line = line.trim();
                    values = line.split(" ");
                    AllArtDist.add(Integer.parseInt(values[0]));
                    AllArtDist.add(Integer.parseInt(values[1]));
                    AllArtDist.add(Integer.parseInt(values[2]));
                }
            }


            //System.out.println(AlleDepots);
            br.close();
            
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Aufruf mit: java LeseDatei eingabedatei"+aioobe);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Fehler: " + fnfe);
        } catch (IOException ioe) {
            System.out.println("Fehler: " + ioe);
        }
        return inst;
    }
}
