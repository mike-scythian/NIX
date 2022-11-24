package nix.lessons;

import java.util.*;
import java.util.stream.Collectors;


public class WordUtils {


    public Set<String> getShortestWord(List<String> words) {

        Set<String> shortestWords = new HashSet<>();

        int minLength = words.get(0).length();

        for (String w : words)
            if (w.length() < minLength)
                minLength = w.length();

        for (String word : words)
            if (word.length() == minLength)
                shortestWords.add(word);

        return shortestWords;
    }

    public Map<String, Integer> wordCounter(List<String> words) {

        List<String> bufferList = words.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        return bufferList.stream()
                .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum, HashMap::new));

    }

}
