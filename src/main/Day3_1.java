import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3_1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("./data/3.txt")));

        ArrayList<String> input = new ArrayList<>();
        while (s.hasNext()) {
            input.add(s.next());
        }

        s.close();
        System.out.println(solution(input));
    }

    public static int solution(ArrayList<String> input) {
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            int count0 = 0;
            int count1 = 0;
            for (String num : input) {
                String digit = num.substring(i, i+1);
                int value = Integer.parseInt(digit);
                if (value == 0) {
                    count0++;
                } else {
                    count1++;
                }
            }
            if (count0 > count1) {
                gamma.append("0");
                epsilon.append("1");
            } else {
                gamma.append("1");
                epsilon.append("0");
            }
        }
        int gr = Integer.parseInt(gamma.toString(), 2);
        int er = Integer.parseInt(epsilon.toString(), 2);

        return gr * er;
    }

}
