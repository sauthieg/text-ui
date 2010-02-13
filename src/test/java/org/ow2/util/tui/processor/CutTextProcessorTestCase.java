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
public class CutTextProcessorTestCase {

    private CutTextProcessor processor;

    @BeforeTest
    private void setUp() {
        processor = new CutTextProcessor();
    }

    @Test
    public void testCutValue() {
        String value = processor.process("A long sentence", 5);
        Assert.assertEquals(value, "A lon");
    }

    @Test
    public void testUnCutValue() {
        String value = processor.process("Uncut", 10);
        Assert.assertEquals(value, "Uncut");
    }
    
    @Test
    public void testUnCutValueSizeEquals() {
        String value = processor.process("Uncut", 5);
        Assert.assertEquals(value, "Uncut");
    }
}
