package nix.lessons;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

class WordUtilsTest {

    private static String testString =  "Snow on the ground " +
                                        "Snow on the tree " +
                                        "Snow on the house " +
                                        "Snow on me";
    private static List<String> testList;
    private static WordUtils wordUtils;

    @BeforeAll
    static void init() {
        testList = List.of(testString.split(" "));
        wordUtils = new WordUtils();
    }

    @Test
    void shouldFindShortesWord() {

        assertEquals(Set.of("me", "on"), wordUtils.getShortestWord(testList), "Should be [me,on]");
    }

    @Test
    void testCalculateWords() {

        Map<String, Integer> exceptedMap = Map.of(
                "snow", 4,
                "on", 4,
                "the", 3,
                "ground", 1,
                "tree", 1,
                "house", 1,
                "me", 1);

        assertEquals(exceptedMap, wordUtils.wordCounter(testList));
    }
}
