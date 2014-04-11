
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

        boolean sorted = false;
        int number;
        List<Integer> dimensions;
        List<Box> fitable = new ArrayList<Box>();

        public Box(int number, int[] dimensions) {
            this.number = number;
            for (int i = 0; i != dimensions.length; i++) {
                this.dimensions.add(dimensions[i]);
            }
        }

        public boolean canFit(Box b) {

        }

        public void sortDimensions() {
            Collections.sort(this.dimensions);
            this.sorted = true;
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
            Box solution = this.solveOne();
            System.out.println(this.nest.get(solution));
        }
    }

    private Box solveOne() {
        this.sortBoxes();
        for (Box box : this.boxes) {
            this.calculateBoxNest(box);
        }
        return this.findMax(this.nest);
    }

    private void sortBoxes() {

    }

    private void calculateBoxNest(Box b) {

    }

    private Box findMax(Map<Box, Integer> nests) {
        return null;
    }
}
