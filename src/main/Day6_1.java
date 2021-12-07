import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day6_1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("./data/6.txt")));

        String input = s.next();
        String[] numbersArray = input.split(",");
        ArrayList<String> numbersStrings = new ArrayList<>(Arrays.asList(numbersArray));
        ArrayList<Integer> numbers = (ArrayList<Integer>) numbersStrings.stream().map(Integer::parseInt)
                .collect(Collectors.toList());

        s.close();
        System.out.println(solution(numbers));
    }

    public static int solution(ArrayList<Integer> input) {
        for (int i = 0; i < 256; i++) {
            ListIterator<Integer> it = input.listIterator();
            while (it.hasNext()) {
                Integer fish = it.next();
                if (fish > 0) {
                    it.set(fish - 1);
                } else {
                    it.set(6);
                    it.add(8);
                }
            }
        }
        return input.size();
    }

}
