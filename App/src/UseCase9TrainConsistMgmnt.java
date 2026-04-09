/**
 * ===================================================
 * MAIN CLASS: UseCase9TrainConsistMgmnt
 * ===================================================
 * use case 9: group bogies by type
 *
 * description :
 * this class groups the similar bogies using java stream Collectors.groupingBy()
 *
 * this application:
 * creates a list of bogies
 *  stream the list
 *  group the bogies by name
 *  stores grouped data in map
 *  displays grouped structure
 *
 * @author Anjan
 * @version 9.0
 */




import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UseCase9TrainConsistMgmnt {
    public static void main(String[] args){
        System.out.println("=========================================");
        System.out.println("UC9- Group Bogies by Type;");
        System.out.println("=========================================");

        List<Bogie> bogies=new ArrayList<>();
        bogies.add(new Bogie("Sleeper",72));
        bogies.add(new Bogie("AC Chair",56));
        bogies.add(new Bogie("First Class",24));
        bogies.add(new Bogie("Sleeper",70));
        bogies.add(new Bogie("AC Chair",60));

        //display input bogies
        System.out.println("ALl Bogies: ");
        for(Bogie b: bogies){
            System.out.println(b.name+" --> "+ b.capacity);
        }

        //group using collectors

        Map<String,List<Bogie>> groupedBogies= bogies.stream().collect(Collectors.groupingBy(b->b.name));

        System.out.println("\nGrouped Bogies");
        for (Map.Entry<String,List<Bogie>> entry : groupedBogies.entrySet()){
            System.out.println("Group: " + entry.getKey());

            for (Bogie bogie : entry.getValue()) {
                System.out.println("Capacity --> " + bogie.getCapacity());
            }
        }

        System.out.println("UC 9 completed..........");
    }

}
