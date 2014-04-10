/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acmcontest;

import com.wontonst.util.acmcontest.DataParser;
import java.net.URL;
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
public class DataParserTest {

    public DataParserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // URL location = Test.class.getProtectionDomain().getCodeSource().getLocation();
        //System.out.println(location.getFile());
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of readFile method, of class DataParser.
     */
    @Test
    public void testReadFile() throws Exception {
        System.out.println("readFile");
        DataParser instance = new DataParserImpl("C:\\test.in");
        instance.readFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dataSetLines method, of class DataParser.
     */
    @Test
    public void testDataSetLines() {
        System.out.println("dataSetLines");
        String s = "";
        DataParser instance = null;
        int expResult = 0;
        int result = instance.dataSetLines(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class DataParserImpl extends DataParser {

        public DataParserImpl(String s) {
            super(s);
        }

        @Override
        public int dataSetLines(String s) {
            return s.charAt(0);
        }
    }
}