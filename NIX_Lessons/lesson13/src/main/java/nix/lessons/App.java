package nix.lessons;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> words = List.of("He", "world", "!!!", "w");
        List<String> words2 = List.of("hello", "world", "Apple", "hello", "apple", "apple", "nix");
        WordUtils wordUtils = new WordUtils();

        System.out.println("Shortest words");
        System.out.println(wordUtils.getShortestWord(words));
        System.out.println("List of words");
        System.out.println(words);
        System.out.println("Words counting");
        System.out.println(wordUtils.wordCounter(words2));

        List<Integer> intList = List.of(1, 2, 3, 4, 5, -5, -4, -3, -2, 1);
        NumberUtils numberUtils = new NumberUtils();

        System.out.println("Summa of elements");
        System.out.println(numberUtils.getSum(intList));
        System.out.println("List odd elements");
        System.out.println(numberUtils.multiplyOddNumbers(intList));
        System.out.println("Basic list of numbers");
        System.out.println(intList);

    }
}
