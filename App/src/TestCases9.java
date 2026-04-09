import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TestCases9 {
@Test
    void testGrouping_BoogiesGroupedByType() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );
        Map<String, List<Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(Bogie::getName));
        assertEquals(2, grouped.get("Sleeper").size());
    }
@Test
    void testGrouping_MultipleBogiesInSameGroup(){
    List<Bogie> bogies = Arrays.asList(
            new Bogie("Sleeper", 72),
            new Bogie("Sleeper", 70)
    );

    Map<String, List<Bogie>> grouped =
            bogies.stream().collect(Collectors.groupingBy(Bogie::getName));

    assertEquals(2, grouped.get("Sleeper").size());
}
    @Test
    void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        Map<String, List<Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(3, grouped.size());
    }
    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        Map<String, List<Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(grouped.isEmpty());
    }
    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 80)
        );
        Map<String, List<Bogie>> grouped = bogies.stream().collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(1, grouped.size());
    }
@Test
    void testGrouping_MapContainsCorrectKeys() {
    List<Bogie> bogies = Arrays.asList(
            new Bogie("Sleeper", 72),
            new Bogie("AC Chair", 56),
            new Bogie("First Class", 24),
            new Bogie("Sleeper", 70),
            new Bogie("AC Chair", 60)
    );

    Map<String,List<Bogie>> grouped=bogies.stream().collect(Collectors.groupingBy(Bogie::getName));
    assertTrue(grouped.containsKey("Sleeper"));
    assertTrue(grouped.containsKey("AC Chair"));
    assertTrue(grouped.containsKey("First Class"));
}
    @Test
    void testGrouping_GroupSizeValidation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );
        int originalSize = bogies.size();

        Map<String, List<Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(originalSize, bogies.size());
    }


}
