
import java.io.*;
import java.util.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RoyZheng
 */
public class OneHundred {

    Map<Long, Long> cache = new HashMap<Long, Long>();

    OneHundred() {
        cache.put(new Long(1), new Long(1));
    }

    public void runStdIn() {
        Scanner in = new Scanner(System.in);
        
        // while there is some input to read
        while (in.hasNextInt()) {
            long num1 = in.nextInt();
            long num2 = in.nextInt();
            //System.out.println(values);
            System.out.print(num1 + " ");
            System.out.print(num2 + " ");;
            System.out.println(maxInRange(num1, num2));
        }
    }

    public long maxInRange(long num1, long num2) {
        long top = num1;
        long bot = num2;
        if (num2 > num1) {
            top = num2;
            bot = num1;
        }
        List<Long> values = new ArrayList<Long>();
        for (long i = bot; i <= top; i++) {
            values.add(runSingle(i));
        }
        return Collections.max(values);
    }

    public long runSingle(long a) {
        if (this.cache.containsKey(a)) {
            return this.cache.get(a);
        }
        rebuildCache(a);
        return this.cache.get(a);
    }

    private void rebuildCache(long a) {
        if (this.cache.containsKey(a)) {
            return;
        }
        if (a % 2 == 1) {
            rebuildCache(a * 3 + 1);
            this.cache.put(a, this.cache.get(a * 3 + 1) + 1);
        } else {
            rebuildCache(a / 2);
            this.cache.put(a, this.cache.get(a / 2) + 1);
        }
    }
}
