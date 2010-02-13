package org.ow2.util.tui.processor;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Guillaume
 * Date: 13 févr. 2010
 * Time: 18:55:30
 * To change this template use File | Settings | File Templates.
 */
public class TrimTextProcessorTestCase {

    private TrimTextProcessor processor;

    @BeforeTest
    private void setUp() {
        processor = new TrimTextProcessor();
    }

    @Test
    public void testNotTrimmedValue() {
        String value = processor.process("Not trimmed", 15);
        Assert.assertEquals(value, "Not trimmed");
    }

    @Test
    public void testTrimmedValue() {
        String value = processor.process("Long message", 10);
        Assert.assertEquals(value, "Long...age");
        Assert.assertEquals(value.length(), 10);
    }

    @Test
    public void testTrimmedValue2() {
        String value = processor.process("Long message2", 10);
        Assert.assertEquals(value, "Long...ge2");
        Assert.assertEquals(value.length(), 10);
    }

    @Test
    public void testTrimmedValueSmall() {
        String value = processor.process("Small", 2);
        Assert.assertEquals(value, "Sm");
    }

    @Test
    public void testNotTrimmedValueSizeEquals() {
        String value = processor.process("Not trimmed", 11);
        Assert.assertEquals(value, "Not trimmed");
        Assert.assertEquals(value.length(), 11);
    }
}