import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import static java.util.Collections.shuffle;

public class RandomGenerator {

    private static final int minVal = 1;
    private static final int maxVal = 75;
    private static final Random random = new Random();
    List<Integer> numbers;
    ListIterator<Integer> iterator;

    /**
     * Generate a list of numbers, then shuffle it for the moves list
     */
    public RandomGenerator() {
        numbers = new ArrayList<>();

        for (int i = minVal; i <= maxVal; i++) {
            numbers.add(i);
        }

        shuffle(numbers, random);
        iterator = numbers.listIterator();
    }

    /**
     * Get the next number from the moves list
     * @return int
     * @throws Exception if there are no more values
     */
    public int getNext() throws Exception {
        if (iterator.hasNext()) {
            return iterator.next();
        } else {
            throw new Exception("No more values");
        }
    }

}
