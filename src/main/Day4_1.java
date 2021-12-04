import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day4_1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("./data/4.txt")));

        String numbersRaw = s.next();
        String[] numbersArray = numbersRaw.split(",");
        ArrayList<String> numbersStrings = new ArrayList<>(Arrays.asList(numbersArray));
        ArrayList<Integer> numbers = (ArrayList<Integer>) numbersStrings.stream().map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayList<Board> boards = new ArrayList<>();
        while (s.hasNext()) {
            Board board = new Board();
            for (int i = 0; i < 25; i++) {
                board.add(s.nextInt());
            }
            boards.add(board);
        }

        s.close();
        System.out.println(solution(numbers, boards));
    }

    public static int solution(ArrayList<Integer> numbers, ArrayList<Board> boards) {
        for (Integer number : numbers) {
            for (Board board : boards) {
                board.mark(number);
                if (board.wins) {
                    return board.score(number);
                }
            }
        }
        return 0;
    }

    private static class Board {
        ArrayList<Integer> numbers;
        ArrayList<Integer> markedPositions;
        Boolean wins;

        public Board() {
            numbers = new ArrayList<>();
            markedPositions = new ArrayList<>();
            wins = false;
        }

        public void add(Integer i) {
            numbers.add(i);
        }

        public void mark(Integer i) {
            if (numbers.contains(i)) {
                markedPositions.add(numbers.indexOf(i));
                checkWin();
            }
        }

        private void checkWin() {
            for (WinCombo winCombo : WinCombo.values()) {
                if (markedPositions.containsAll(winCombo.getPositions())) {
                    wins = true;
                }
            }
        }

        public Integer score(Integer calledLast) {
            for (int i : markedPositions) {
                numbers.set(i, 0);
            }
            Integer sum = 0;
            for (Integer i : numbers) {
                sum += i;
            }
            return sum * calledLast;
        }
    }

    private enum WinCombo {
        ROW_ONE (0, 1, 2, 3, 4), ROW_TWO (5, 6, 7, 8, 9), ROW_THREE (10, 11, 12, 13, 14), ROW_FOUR (15, 16, 17, 18, 19),
        ROW_FIVE (20, 21, 22, 23, 24), COLUMN_ONE (0, 5, 10, 15, 20), COLUMN_TWO (1, 6, 11, 16, 21),
        COLUMN_THREE (2, 7, 12, 17, 22), COLUMN_FOUR (3, 8, 13, 18, 23), COLUMN_FIVE (4, 9, 14, 19, 24);

        private List<Integer> positions;

        WinCombo(int i1, int i2, int i3, int i4, int i5) {
            positions = new ArrayList<>();
            positions.add(i1);
            positions.add(i2);
            positions.add(i3);
            positions.add(i4);
            positions.add(i5);
        }

        public List<Integer> getPositions() {
            return positions;
        }
    }

}
