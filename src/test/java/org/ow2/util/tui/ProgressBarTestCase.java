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
public class ProgressBarTestCase {

    private ProgressBar bar;

    @BeforeTest
    private void setUp() {
        bar = new ProgressBar();
        // Default size
        bar.setSize(10);
    }

    @Test
    public void testEmptyBar() {

        // Empty bar
        bar.setValue(0);

        StringBuilder sb = new StringBuilder();
        bar.paint(sb);
        Assert.assertEquals(sb.toString(), "[        ]");
    }

    @Test
    public void testFullBar() {

        bar.setValue(bar.getProgressBarSize());

        StringBuilder sb = new StringBuilder();
        bar.paint(sb);
        Assert.assertEquals(sb.toString(), "[********]");
    }

    @Test
    public void testMiddlefilledBar() {

        bar.setValue(4);

        StringBuilder sb = new StringBuilder();
        bar.paint(sb);
        Assert.assertEquals(sb.toString(), "[****    ]");
    }

    @Test
    public void testOverflowBar() {

        bar.setValue(100);

        StringBuilder sb = new StringBuilder();
        bar.paint(sb);
        // Should only filled the space, not too much
        Assert.assertEquals(sb.toString(), "[********]");
    }

    @Test
    public void testNegativeBar() {

        bar.setValue(-10);

        StringBuilder sb = new StringBuilder();
        bar.paint(sb);
        // Should be an empty bar
        Assert.assertEquals(sb.toString(), "[        ]");
    }
}
