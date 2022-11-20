import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import static java.util.Collections.shuffle;

public class RandomGenerator {

    private static final int MIN_VAL = 1;
    private static final int MAX_VAL = 75;
    private static final int COLUMNS = 5;

    // Using separate lists and iterators for board generation vs selecting values
    List<Integer> numbers;
    ListIterator<Integer> iterator;
    List<RandomValue> gameValues;
    ListIterator<RandomValue> valuesIterator;

    /**
     * Generate a list of numbers, then shuffle it for the moves list
     */
    public RandomGenerator() {
        numbers = new ArrayList<>();
        gameValues = new ArrayList<>();

        for (int i = MIN_VAL; i <= MAX_VAL; i++) {
            numbers.add(i);
        }

        shuffle(numbers, new Random());
        iterator = numbers.listIterator();

        // Create list with all values for b-i-n-g-o columns
        for (int col = 0; col < COLUMNS; col++) {
            for (int num : numbers) {
                gameValues.add(new RandomValue(col, num));
            }
        }

        shuffle(gameValues, new Random());
        valuesIterator = gameValues.listIterator();
    }

    /**
     * Get the next number from the list of board options
     * @return int
     * @throws Exception if there are no more values
     */
    public int getNextNumber() throws Exception {
        if (iterator.hasNext()) {
            return iterator.next();
        } else {
            throw new Exception("No more numbers");
        }
    }

    /**
     * Get the next number from the moves list
     * @return int
     * @throws Exception if there are no more values
     */
    public RandomValue getNextValue() throws Exception {
        if (valuesIterator.hasNext()) {
            return valuesIterator.next();
        } else {
            throw new Exception("No more values");
        }
    }

}
