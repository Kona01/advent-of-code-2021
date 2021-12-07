import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day7_2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("./data/7.txt")));

        String input = s.next();
        String[] numbersArray = input.split(",");
        ArrayList<String> numbersStrings = new ArrayList<>(Arrays.asList(numbersArray));
        ArrayList<Integer> numbers = (ArrayList<Integer>) numbersStrings.stream().map(Integer::parseInt)
                .collect(Collectors.toList());

        s.close();
        System.out.println(solution(numbers));
    }

    public static int solution(ArrayList<Integer> input) {
        Integer min = null;
        int k = 0;
        for (int i = 1; i <= Collections.max(input); i++) {
            int sum = 0;
            for (Integer crab : input) {
                int dist = Math.abs(crab - i);
                int fuel = dist * (dist + 1) / 2;
                sum += fuel;
            }
            if (min == null || sum < min) {
                min = sum;
                k = i;
            }
        }
        return min;
    }

}
