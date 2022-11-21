package nix.lessons;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> words = List.of("He", "world", "!!!", "w");
        List<String> words2 = List.of("hello", "world", "Apple", "hello", "apple", "apple", "nix");
        WordUtils wordUtils = new WordUtils();

        System.out.println(wordUtils.getShortestWord(words));

        System.out.println(words);

        System.out.println(wordUtils.wordCounter(words2));

    }
}
