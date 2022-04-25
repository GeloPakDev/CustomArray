package creator;

import entity.CustomArray;
import exception.CustomArrayException;

import java.util.Random;

public class CustomArrayCreator {

    public CustomArray createCustomArray(int[] array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array should contain Elements");
        }
        return new CustomArray(array);
    }

    public CustomArray generateRandomCustomArray(int quantity, int from, int to) throws CustomArrayException {
        if (quantity < 0) {
            throw new CustomArrayException("There negative number of elements");
        }
        Random random = new Random();
        int length = from + to;
        int[] array = new int[length];
        for (int i = 0; i < quantity; i++) {
            array[i] = random.nextInt(to) + from;
        }
        return new CustomArray(array);
    }
}
