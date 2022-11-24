package nix.lessons;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NumberUtils {

    public Integer getSum(List<Integer> numbers) {

        if (!Optional.ofNullable(numbers).isPresent())
            return 0;

        return numbers.stream()
                .reduce(Integer::sum)
                .orElse(0);
    }

    public List<Integer> multiplyOddNumbers(List<Integer> numbers) {

        if (!Optional.ofNullable(numbers).isPresent())
            return Collections.emptyList();

        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> num % 2 == 0)
                .map(num -> num * 2)
                .boxed()
                .collect(Collectors.toList());

    }
}
