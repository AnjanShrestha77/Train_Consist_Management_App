import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TestCase10 {
    @Test
    void testReduce_TotalSeatCalculation(){
        List<Bogie> bogies=Arrays.asList(
                new Bogie("Sleeper",72),
                new Bogie ("AC Chair ",56)
                );
                int totalcapacity=bogies.stream().map(Bogie::getCapacity).reduce(0,(sum,cap)->sum+cap);
                assertEquals(128,totalcapacity);

    }

    @Test
    void testReduce_MultipleBogiesAggregation(){
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70)

        );
     int totalCapacity=bogies.stream().map(Bogie::getCapacity).reduce(0,(sum,cap)->sum+cap);
     assertEquals(222,totalCapacity);
    }
    @Test
    void testReduce_SingleBogieCapacity(){
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72));
        int totalCapacity=bogies.stream().map(Bogie::getCapacity).reduce(0,(sum,cap)->sum+cap);
        assertEquals(72,totalCapacity);
    }

    @Test
    void testReduce_EmptyBogieList(){
        List<Bogie> bogies = Arrays.asList();
        int totalCapacity=bogies.stream().map(Bogie::getCapacity).reduce(0,(sum,cap)->sum+cap);
        assertEquals(0,totalCapacity);
    }

    @Test
    void testReduce_CorrectCapacityExtraction(){

            Bogie sleeper = new Bogie("Sleeper", 72);
            Bogie ac = new Bogie("AC", 56);
            List<Bogie> bogies = Arrays.asList(sleeper, ac);

            // Act: Focus specifically on the mapping result
            List<Integer> extractedCapacities = bogies.stream()
                    .map(Bogie::getCapacity)
                    .toList();


            assertEquals(2, extractedCapacities.size());
            assertEquals(72, extractedCapacities.get(0));
            assertEquals(56, extractedCapacities.get(1));

    }

    @Test
    void testReduce_AllBogiesIncluded(){
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70)

        );
        int totalCapcaity=bogies.stream().map(Bogie::getCapacity).reduce(0,Integer::sum);
        assertEquals(222,totalCapcaity);
    }
    @Test
    void testReduce_OriginalListUnchanged(){
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70)

        );
        bogies.stream().map(Bogie::getCapacity).reduce(0,Integer::sum);
        assertEquals(4,bogies.size());
    }





}
