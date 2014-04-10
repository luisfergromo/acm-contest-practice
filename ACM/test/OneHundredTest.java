/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roycr_000
 */
public class OneHundredTest {

    public OneHundredTest() {
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
     * Test of maxInRange method, of class OneHundred.
     */
    @Test
    public void testMaxInRange() {
        System.out.println("maxInRange");
        OneHundred instance = new OneHundred();

        assertEquals(20, instance.maxInRange(1, 10));
        assertEquals(20, instance.maxInRange(10, 1));
        assertEquals(125, instance.maxInRange(100, 200));
        assertEquals(89, instance.maxInRange(201, 210));
        assertEquals(174, instance.maxInRange(900, 1000));

    }

    /**
     * Test of runSingle method, of class OneHundred.
     */
    @Test
    public void testRunSingle() {
        System.out.println("runSingle");
        OneHundred instance = new OneHundred();

        assertEquals(1, instance.runSingle(1));
        assertEquals(112, instance.runSingle(1000));
        assertEquals(26, instance.runSingle(100));
        assertEquals(30, instance.runSingle(10000));
        assertEquals(27, instance.runSingle(1313));
        instance = new OneHundred();
        assertEquals(30, instance.runSingle(10000));
//        System.out.println(instance.runSingle(1313));
    }
}
