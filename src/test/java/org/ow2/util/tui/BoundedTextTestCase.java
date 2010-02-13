package org.ow2.util.tui;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Guillaume
 * Date: 13 févr. 2010
 * Time: 18:45:31
 * To change this template use File | Settings | File Templates.
 */
public class BoundedTextTestCase {

    private BoundedText text;

    @BeforeTest
    private void setUp() {
        text = new BoundedText();
        text.setSize(10);
    }

    @Test
    public void testLeftAlignment() {
        text.setAlignment(Alignment.LEFT);
        text.setValue("Hello!");

        StringBuilder sb = new StringBuilder();
        text.paint(sb);
        Assert.assertEquals(sb.toString(), "Hello!    ");
    }

    @Test
    public void testRightAlignment() {
        text.setAlignment(Alignment.RIGHT);
        text.setValue("Hello!");

        StringBuilder sb = new StringBuilder();
        text.paint(sb);
        Assert.assertEquals(sb.toString(), "    Hello!");
    }

    @Test
    public void testCenterAlignmentRemainingOddNumberOfSpaces() {
        text.setAlignment(Alignment.CENTER);
        text.setValue("Hello!");

        StringBuilder sb = new StringBuilder();
        text.paint(sb);
        // Exact center is possible
        Assert.assertEquals(sb.toString(), "  Hello!  ");
    }

    @Test
    public void testCenterAlignmentRemainingEvenNumberOfSpaces() {
        text.setAlignment(Alignment.CENTER);
        text.setValue("Hello");

        StringBuilder sb = new StringBuilder();
        text.paint(sb);
        // Prefer LEFT
        Assert.assertEquals(sb.toString(), "  Hello   ");
    }
}
