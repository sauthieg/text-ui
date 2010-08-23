package org.ow2.util.tui;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Guillaume
 * Date: 13 févr. 2010
 * Time: 11:25:04
 * To change this template use File | Settings | File Templates.
 */
public class SpinnerTestCase {

    private Spinner spinner;

    @BeforeTest
    private void setUp() {
        spinner = new Spinner();
    }

    @Test
    public void testSpinner() {
        // first step
        StringBuilder sb1 = new StringBuilder();
        spinner.paint(sb1);
        Assert.assertEquals(sb1.toString(), "/");

        // second step
        StringBuilder sb2 = new StringBuilder();
        spinner.paint(sb2);
        Assert.assertEquals(sb2.toString(), "-");

        // third step
        StringBuilder sb3 = new StringBuilder();
        spinner.paint(sb3);
        Assert.assertEquals(sb3.toString(), "\\");

        // fourth step
        StringBuilder sb4 = new StringBuilder();
        spinner.paint(sb4);
        Assert.assertEquals(sb4.toString(), "|");
    }
}
