/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acmcontest;

import com.wontonst.util.acmcontest.DataSetPrinter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RoyZheng
 */
public class DataSetPrinterTest {

    public DataSetPrinterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of nextSet method, of class DataSetPrinter.
     */
    @Test
    public void testNextSet() {
        System.out.println("\n--------nextSet");
        DataSetPrinter instance = new DataSetPrinter();
        instance.printString("test string");
        for (int i = 0; i != 10; i++) {
            instance.nextSet();
            instance.printString("test string");;
        }
    }

    /**
     * Test of printString method, of class DataSetPrinter.
     */
    @Test
    public void testPrintString() {
        System.out.println("\n------------printString");
        DataSetPrinter instance = new DataSetPrinter();
        for (int i = 0; i != 10; i++) {
            instance.printString("test string number " + i);
        }
    }

    /**
     * Test of printKeyValue method, of class DataSetPrinter.
     */
    @Test
    public void testPrintKeyValue() {
        System.out.println("\n------------printKeyValue");
        Map<Long, Double> map = new HashMap<Long, Double>();
        map.put(Long.MIN_VALUE, Double.MAX_VALUE);
        map.put(Long.MAX_VALUE, Double.MIN_NORMAL);
        for (int i = 1; i != 9; i++) {
            map.put(Long.MAX_VALUE - i, Double.MAX_VALUE - i);
        }
        DataSetPrinter instance = new DataSetPrinter();
        instance.printKeyValue(map);
    }

    /**
     * Test of printKeyList method, of class DataSetPrinter.
     */
    @Test
    public void testPrintKeyList() {
        System.out.println("\n------------printKeyList");
        int test_n = 10;
        Map<Float, List<Integer>> map = new HashMap<Float, List<Integer>>();

        for (int ii = 0; ii != test_n; ii++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i != 10; i++) {
                list.add(Integer.MAX_VALUE - i - 20 * ii);
            }
            map.put((float)(ii * Math.PI), list);
        }
        Assert.assertEquals("Test should've created a correct size map", test_n, map.size());
        DataSetPrinter instance = new DataSetPrinter();
        instance.printKeyValue(map);
    }

    /**
     * Test of printList method, of class DataSetPrinter.
     */
    @Test
    public void testPrintList() {
        System.out.println("\n------------printList");
        DataSetPrinter instance = new DataSetPrinter();
        for (int ii = 0; ii != 10; ii++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i != 10; i++) {
                list.add(Integer.MAX_VALUE - i - 20 * ii);
            }
            instance.printList(list);
        }
    }
}