
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
public class OneHundredOne {

    class Block {
        int value;
        int stack;

        public Block(int a) {
            this.value = this.stack = a;
        }
    }
    Map<Integer, Block> blocks;
    HashMap<Integer, LinkedList<Block>> stacks;

    public OneHundredOne() {
    }

    public void run(Scanner in) {
        int numBlocks = Integer.parseInt(in.nextLine());
        this.blocks = new HashMap<>();
        this.stacks = new HashMap<>();
        for (int i = 0; i != numBlocks; i++) {
            Block n = new Block(i);
            blocks.put(i, n);
            stacks.put(i, new LinkedList<Block>());
            stacks.get(i).add(n);
        }

        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.equals("quit")) {
                break;
            }
            String[] broken = line.split(" ");
            //System.out.println(line);return;
            String action = broken[0];
            Block target = this.blocks.get(Integer.parseInt(broken[1]));
            String actionType = broken[2];
            Block destination = this.blocks.get(Integer.parseInt(broken[3]));

            if (target == destination) {//this is an invalid move
                continue;
            }
            LinkedList<Block> checkStack = this.stacks.get(destination.stack);//retrieve the block on the top of the stack containing destination
            int flag = 0;
            for (Block temp : checkStack) {
                if (temp.value == target.value) {
                    flag++;
                }
                if (temp.value == destination.value) {
                    flag++;
                }
            }
            if (flag > 1) {
                continue;
            }
            if (action.equals("move")) {
                revertBlock(target);
                this.stacks.get(target.stack).removeLast();
                if (actionType.equals("over")) {//move over
                    target.stack = destination.stack;
                    this.stacks.get(destination.stack).add(target);
                } else {//move onto
                    revertBlock(destination);
                    target.stack = destination.stack;
                    this.stacks.get(destination.stack).add(target);
                }
            } else {
                List<Block> move = removeBlock(target);
                if (actionType.equals("over")) {//pile over

                } else {//pile onto
                    revertBlock(destination);
                }
                for (int ad = move.size() - 1; ad != -1; ad--) {
                    move.get(ad).stack = destination.stack;
                    this.stacks.get(destination.stack).add(move.get(ad));
                }
            }
            //System.out.println("------------");
            //this.printStacks();
        }//end whileHasLine()
        this.printStacks();
    }

    /**
     * Remove blocks the stack the block is in until block is found.
     */
    private void revertBlock(Block block) {
        LinkedList<Block> revertSource = this.stacks.get(block.stack);
        while (revertSource.peekLast() != block) {
            Block last = revertSource.removeLast();
            this.stacks.get(last.value).add(last);
            last.stack = last.value;
        }
        //revertSource.removeLast();
    }

    private List<Block> removeBlock(Block block) {
        List<Block> removed = new ArrayList<>();
        LinkedList<Block> removeSource = this.stacks.get(block.stack);
        while (removeSource.peekLast() != block) {
            Block last = removeSource.removeLast();
            removed.add(last);
        }
        removed.add(removeSource.removeLast());
        return removed;
    }

    public void printStacks() {
        for (int key = 0; key != this.stacks.size(); key++) {
            System.out.print(key + ":");
            for (Block b : this.stacks.get(key)) {
                System.out.print(" " + b.value);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("file2.txt"));
        OneHundredOne a = new OneHundredOne();
        a.run(sc);
    }
}
