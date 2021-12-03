import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Day3_2 {

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
        int oxygenRating;
        int co2Rating;

        ArrayList<String> oxygen = filter(new ArrayList<>(input), 0, true);
        int or = Integer.parseInt(oxygen.get(0), 2);

        ArrayList<String> co2 = filter(new ArrayList<>(input), 0, false);
        int cr = Integer.parseInt(co2.get(0), 2);

        return or * cr;
    }

    private static ArrayList<String> filter(ArrayList<String> input, Integer index, Boolean oxygen) {
        int count0 = 0;
        int count1 = 0;
        for (String num : input) {
            String digit = num.substring(index, index + 1);
            int value = Integer.parseInt(digit);
            if (value == 0) {
                count0++;
            } else {
                count1++;
            }
        }
        Boolean moreZeros = count0 > count1;
        Iterator<String> it = input.iterator();
        if (moreZeros) {
            if (oxygen) {
                while (it.hasNext()) {
                    String digit = it.next().substring(index, index + 1);
                    if (digit.equals("1")) {
                        it.remove();
                        if (input.size() == 1) {
                            return input;
                        }
                    }
                }
            } else {
                while (it.hasNext()) {
                    String digit = it.next().substring(index, index + 1);
                    if (digit.equals("0")) {
                        it.remove();
                        if (input.size() == 1) {
                            return input;
                        }
                    }
                }
            }
        } else {
            if (oxygen) {
                while (it.hasNext()) {
                    String digit = it.next().substring(index, index + 1);
                    if (digit.equals("0")) {
                        it.remove();
                        if (input.size() == 1) {
                            return input;
                        }
                    }
                }
            } else {
                while (it.hasNext()) {
                    String digit = it.next().substring(index, index + 1);
                    if (digit.equals("1")) {
                        it.remove();
                        if (input.size() == 1) {
                            return input;
                        }
                    }
                }
            }
        }
        if (input.size() <= 1) {
            return input;
        } else {
            return filter(input, index + 1, oxygen);
        }
    }

}
