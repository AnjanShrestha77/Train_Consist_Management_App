/**
 * MAIN CLASS : UseCase9TrainConsistMgmnt
 *
 * Use Case 10: Count Total Seat in Train
 *
 * description:
 * this class aggregates the seating capacity using the java stream reduce()
 *
 * this application:
 * creates bogies list
 * map bogies to capacity
 * reduce the values into total
 * display the total numebr of seats
 *
 * @author Anjan
 * @version 10.0
 */

import java.util.ArrayList;
import java.util.List;

public class UseCase10TrainConsistMgmnt {
    public static void main(String[] args){
        List<Bogie> bogies=new ArrayList<>();
        bogies.add(new Bogie("Sleeper",72));
        bogies.add(new Bogie("AC Chair",56));
        bogies.add(new Bogie("First Class",24));
        bogies.add(new Bogie("Sleeper",70));
        System.out.println("Bogies in Train:");
        for (Bogie b: bogies){
            System.out.println(b.name+" --> "+b.capacity);
        }
        //aggregate using reduce
        int totalCapacityOfTrain=bogies.stream().map(Bogie::getCapacity).reduce(0,(sum,cap)->sum+cap);
        System.out.println("\nTotal Seating Capacity of Train: "+totalCapacityOfTrain);

        System.out.println("\nUC10 aggregation completed...");
    }
}
