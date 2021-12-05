import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day5_2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("./data/5.txt")));

        ArrayList<String> input = new ArrayList<>();
        while (s.hasNext()) {
            input.add(s.next());
        }

        ArrayList<Line> lines = new ArrayList<>();

        for (int i = 0; i < input.size() / 3; i++) {
            int p1 = i * 3;
            int p3 = p1 + 2;
            Line line = new Line(new Position(input.get(p1)), new Position(input.get(p3)));
            lines.add(line);
        }

        s.close();
        System.out.println(solution(lines));
    }

    public static int solution(ArrayList<Line> input) {

        ArrayList<Position> map = new ArrayList<>();
        for (Line l : input) {
            map.addAll(l.positions);
        }

        Map<Position, Long> counts = map.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        int count = 0;
        for (Long l : counts.values()) {
            if (l > 1) {
                count++;
            }
        }

        return count;

    }

    private static class Position {
        private int x;
        private int y;
        private int occurrences;

        public Position(String pos) {
            String[] posArray = pos.split(",");
            ArrayList<String> posSplit = new ArrayList<>(Arrays.asList(posArray));
            x = Integer.parseInt(posSplit.get(0));
            y = Integer.parseInt(posSplit.get(1));
            occurrences = 1;
        }

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
            occurrences = 1;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void addOccurrence() {
            occurrences++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (x != position.x) return false;
            return y == position.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    private static class Line {
        private ArrayList<Position> positions;

        public Line(Position p1, Position p2) {
            int x1 = p1.getX();
            int x2 = p2.getX();
            int y1 = p1.getY();
            int y2 = p2.getY();

            positions = new ArrayList<>();
            if (y1 == y2) {
                for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
                    positions.add(new Position(i, y1));
                }
            } else if (x1 == x2) {
                for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
                    positions.add(new Position(x1, i));
                }
            } else if (x1 < x2) {
                if (y1 < y2) {
                    for (int i = 0; i <= (x2 - x1); i++) {
                        positions.add(new Position(x1 + i, y1 + i));
                    }
                } else {
                    for (int i = 0; i <= (x2 - x1); i++) {
                        positions.add(new Position(x1 + i, y1 - i));
                    }
                }
            } else {
                if (y1 < y2) {
                    for (int i = 0; i <= (x1 - x2); i++) {
                        positions.add(new Position(x1 - i, y1 + i));
                    }
                } else {
                    for (int i = 0; i <= (x1 - x2); i++) {
                        positions.add(new Position(x1 - i, y1 - i));
                    }
                }
            }
        }
    }
}
