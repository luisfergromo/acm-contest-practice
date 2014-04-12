
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author roycr_000
 */
public class OneHundredThree {

    class Box {

        private boolean sorted = false;
        private int number;
        List<Integer> dimensions = new ArrayList<Integer>();
        private List<Box> fitable = new ArrayList<Box>();

        public Box(int number, int[] dimensions) {
            this.number = number;
            for (int i = 0; i != dimensions.length; i++) {
                this.dimensions.add(dimensions[i]);
            }
        }

        public boolean canFitBox(Box b) {
            if (!this.sorted) {
                this.sortDimensions();
            }
            if (!b.isSorted()) {
                b.sortDimensions();
            }
            for (int i = 0; i != this.dimensions.size(); i++) {
                if (b.dimensions.get(i) >= this.dimensions.get(i)) {
                    return false;
                }
            }
            //System.out.println(this + " can fit " + b);
            return true;
        }

        public boolean canFitInto(Box b) {
            return b.canFitBox(this);
        }

        public boolean isSorted() {
            return this.sorted;
        }

        public void sortDimensions() {
            Collections.sort(this.dimensions);
            this.sorted = true;
        }

        public String toString() {
            String fits = "";
            for (Box b : this.fitable) {
                fits += b.number + " ";
            }
            return "#" + this.number + "&dim=" + this.dimensions + "&fits=" + fits;
        }
    }

    Map<Box, Integer> nest;
    List<Box> boxes;

    public OneHundredThree() {

    }

    private void reset() {
        this.nest = new HashMap<>();
        this.boxes = new ArrayList<>();
    }

    public void run(Scanner in) {
        while (in.hasNextInt()) {
            this.reset();
            int numBoxes = in.nextInt();
            int numDim = in.nextInt();
            for (int boxNum = 0; boxNum != numBoxes; boxNum++) {
                int[] dim = new int[numDim];
                for (int i = 0; i != numDim; i++) {
                    dim[i] = in.nextInt();
                }
                boxes.add(new Box(boxNum, dim));
            }
            //        System.out.println(boxes);
            Box solution = this.solveOne();
            //    System.out.print("Solution: ");
            System.out.println(this.nest.get(solution));
            List<Box> path = recreateNest(solution);
            for (int i = 0; i != path.size(); i++) {
                System.out.print((path.get(i).number + 1) + " ");
            }
            if (in.hasNextInt()) {
                System.out.println();
            }
        }
    }

    private Box solveOne() {
        for (Box box : this.boxes) {
            this.calculateBoxNest(box);
//            System.out.println(box);
        }
        //System.out.println(this.boxes);
        //      System.out.println(this.nest);
        return this.findMax(this.nest);
    }

    private void calculateBoxNest(Box box) {
        if (this.nest.containsKey(box)) {
            return;
        }
        for (Box b : this.boxes) {
            if (b.canFitInto(box)) {
                box.fitable.add(b);
            }
        }
        if (box.fitable.isEmpty()) {
            this.nest.put(box, 1);
            return;
        }
        for (Box b : box.fitable) {
            //          System.out.println(b.number);
            if (!this.nest.containsKey(b)) {
                this.calculateBoxNest(b);
            }
        }
        Box b = findMaxNestNumber(box.fitable);
        this.nest.put(box, nest.get(b) + 1);
    }

    private Box findMaxNestNumber(List<Box> boxes) {
        int max = Integer.MIN_VALUE;
        Box solution = null;
        for (Box b : boxes) {
            if (this.nest.get(b) > max) {
                max = this.nest.get(b);
                solution = b;
            }
        }
        return solution;
    }

    private Box findMax(Map<Box, Integer> nests) {
        int max = Integer.MIN_VALUE;
        Box boxMax = null;
        for (Box b : nests.keySet()) {
            if (nests.get(b) > max) {
                max = nests.get(b);
                boxMax = b;
            }
        }
        return boxMax;
    }

    public List<Box> recreateNest(Box b) {
        List<Box> path = new ArrayList<>();
        path.add(b);
        Box curr = b;
        while (true) {
            if (curr.fitable.isEmpty()) {
                break;
            }
            curr = this.findMaxNestNumber(curr.fitable);
            path.add(curr);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) throws FileNotFoundException {
        OneHundredThree a = new OneHundredThree();
        a.run(new Scanner(new File("103.in")));
    }
}
