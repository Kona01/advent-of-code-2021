import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day9_1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("./data/9.txt")));

        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        while (s.hasNext()) {
            String wholeRow = s.next();
            String [] rowAsArray = wholeRow.split("(?!^)");
            ArrayList<String> rowAsStrings = new ArrayList<>(Arrays.asList(rowAsArray));
            ArrayList<Integer> row = (ArrayList<Integer>) rowAsStrings.stream().map(Integer::parseInt)
                    .collect(Collectors.toList());
            input.add(row);
        }

        s.close();
        System.out.println(solution(input));
    }

    public static int solution(ArrayList<ArrayList<Integer>> input) {
        ArrayList<Integer> lowPoints = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            ArrayList<Integer> row = input.get(i);
            for (int n = 0; n < row.size(); n++) {
                int pos = row.get(n);
                boolean low = true;
                if (n != 0 && pos >= row.get(n-1)) {
                    low = false;
                }
                if (n != row.size() - 1 && pos >= row.get(n+1)) {
                    low = false;
                }
                if (i != 0 && pos >= input.get(i-1).get(n)) {
                    low = false;
                }
                if (i != input.size() - 1 && pos >= input.get(i+1).get(n)) {
                    low = false;
                }
                if (low) {
                    lowPoints.add(pos);
                }
            }
        }

        int sum = 0;

        for (int point : lowPoints) {
            sum += point + 1;
        }

        return sum;

    }

}
