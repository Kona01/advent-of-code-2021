import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1_1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("./data/1.txt")));

        ArrayList<Integer> input = new ArrayList<>();
        while (s.hasNextInt()) {
            input.add(s.nextInt());
        }

        s.close();
        System.out.println(solution(input));
    }

    public static int solution(ArrayList<Integer> input) {
        int prev = input.get(0);
        input.remove(0);
        int count = 0;
        for (int i : input) {
            if (i > prev) {
                count++;
            }
            prev = i;
        }
        return count;
    }

}
