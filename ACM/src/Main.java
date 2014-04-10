
import java.util.*;

public class Main {

    public class OneHundredTwo {

        int[][] input;

        public OneHundredTwo(Scanner in) {

            while (in.hasNextInt()) {
                input = new int[3][3];
                int min = Integer.MAX_VALUE;
                List<Integer> solutions = new ArrayList<Integer>();
                for (int i = 0; i != 3; i++) {
                    for (int ii = 0; ii != 3; ii++) {
                        input[i][ii] = in.nextInt();
                        //System.out.println(stores[i][ii]);
                    }
                }
                final int numB = input[0][0] + input[1][0] + input[2][0];
                final int numG = input[0][1] + input[1][1] + input[2][1];
                final int numC = input[0][2] + input[1][2] + input[2][2];

                //System.out.println(numG + " " + numB + " " + numC);
                for (int i = 0; i != 3; i++) {
                    int aAmt = numB - input[i][0];
                    for (int ii = 0; ii != 3; ii++) {
                        if (i == ii) {
                            continue;
                        }
                        int bAmt = numG - input[ii][1];
                        //System.out.println("numB=" + numB + " stores[1][" + ii + "]=" + stores[1][ii]);
                        for (int iii = 0; iii != 3; iii++) {
                            if (iii == ii || iii == i) {
                                continue;
                            }
                            //System.out.println(i + " " + ii + " " + iii);
                            int cAmt = numC - input[iii][2];
                            int sum = aAmt + bAmt + cAmt;
                            //System.out.println(aAmt + "+" + bAmt + "+" + cAmt + "=" + sum);
                            //System.out.println(sum);
                            solutions.add(sum);
                            if (sum < min) {
                                min = sum;
                            }
                        }
                    }
                }
                int temp = solutions.get(4);
                solutions.set(4, solutions.get(3));
                solutions.set(3, temp);
                System.out.println(greedyAlphabetical(solutions, min) + " " + min);
                /*                for (int i = 0; i != 3; i++) {
                 System.out.print(toLetter(i, binB, binG, binC));
                 }
                 System.out.println(" " + min);
                 System.out.println(solutions);*/
            }
        }

        private String greedyAlphabetical(List<Integer> solutions, int min) {
            int[] sorted = {1, 0, 4, 5, 2, 3};
            //System.out.println(solutions);
            for (int i = 0; i != sorted.length; i++) {
                if (solutions.get(sorted[i]) == min) {
                    //System.out.println("sorted" + i + "=" + sorted[i]);
                    return toLetters(sorted[i]);
                }
            }
            return "INVALID" + min;
        }

        private String toLetters(int i) {
            switch (i) {
                case 0:
                    return "BGC";
                case 1:
                    return "BCG";
                case 2:
                    return "GBC";
                case 3:
                    return "GCB";
                case 4:
                    return "CBG";
                case 5:
                    return "CGB";
            }
            return "INVALID " + i;
        }

        private String toLetter(int index, int binB, int binG, int binC) {
            if (binG == index) {
                return "G";
            } else if (binB == index) {
                return "B";
            } else {
                return "C";
            }

        }

        private String toLetter(int a) {
            switch (a) {
                case 0:
                    return "B";
                case 1:
                    return "G";
                case 2:
                    return "C";
            }
            return "INVALID";
        }
    }

    public Main() {
        OneHundredTwo a = new OneHundredTwo(new Scanner(System.in));
//    OneHundredOne a = new OneHundredOne();
        //   a.run(new Scanner(System.in));
//        OneHundred a = new OneHundred();
        //       a.runStdIn();
    }

    public static void main(String[] args) {
        Main m = new Main();
    }
}
