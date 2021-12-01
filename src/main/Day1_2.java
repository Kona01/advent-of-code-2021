import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1_2 {

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
        int numSums = input.size() - 2;
        ArrayList<Integer> sums = new ArrayList<>();
        for (int n = 0; n < numSums; n++) {
            int one = input.get(n);
            int two = input.get(n+1);
            int three = input.get(n+2);
            int sum = one + two + three;
            sums.add(sum);
        }

        int prev = sums.get(0);
        sums.remove(0);
        int count = 0;
        for (int i : sums) {
            if (i > prev) {
                count++;
            }
            prev = i;
        }
        return count;
    }

}
