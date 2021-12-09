import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day8_1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("./data/8.txt")));

        ArrayList<String> input = new ArrayList<>();
        while (s.hasNextLine()) {
            input.add(s.nextLine());
        }
        ArrayList<String> outputValues = new ArrayList<>();
        for (String string : input) {
            String[] separate = string.split("\\|");
            ArrayList<String> separated = new ArrayList<>(Arrays.asList(separate));
            String outputs = separated.get(1);
            String[] individualOutputs = outputs.split(" ");
            outputValues.addAll(Arrays.asList(individualOutputs));
        }

        s.close();
        System.out.println(solution(outputValues));
    }

    public static int solution(ArrayList<String> input) {
        int count = 0;
        for (String s : input) {
            if (s.length() == 2 || s.length() == 3 || s.length() == 4 || s.length() == 7) {
                count++;
            }
        }
        return count;
    }

}
