import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2_1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("./data/2.txt")));

        ArrayList<String> direction = new ArrayList<>();
        ArrayList<Integer> amount = new ArrayList<>();
        int i = 0;
        while (s.hasNext()) {
            if (i % 2 == 0) {
                direction.add(s.next());
            } else {
                amount.add(s.nextInt());
            }
            i++;
        }

        s.close();
        System.out.println(solution(direction, amount));
    }

    public static int solution(ArrayList<String> direction, ArrayList<Integer> amount) {
        int depth = 0;
        int horizontal = 0;

        for (int i = 0; i < direction.size(); i++) {
            String dir = direction.get(i);
            int amt = amount.get(i);
            if (dir.equals("forward")) {
                horizontal += amt;
            } else if (dir.equals("down")) {
                depth += amt;
            } else if (dir.equals("up")) {
                depth -= amt;
            }
        }

        return depth * horizontal;
    }

}
