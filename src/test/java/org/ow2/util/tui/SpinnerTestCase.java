/**
 * Copyright 2010 OW2 Util
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
        checkSpinChar("/");

        // second step
        checkSpinChar("-");

        // third step
        checkSpinChar("\\");

        // fourth step
        checkSpinChar("|");
    }

    @Test
    public void testSpinner2() {
        // first turn
        checkSpinChar("/");
        checkSpinChar("-");
        checkSpinChar("\\");
        checkSpinChar("|");

        // second turn
        checkSpinChar("/");
        checkSpinChar("-");
        checkSpinChar("\\");
        checkSpinChar("|");
    }

    private void checkSpinChar(String expected) {
        StringBuilder builder = new StringBuilder();
        spinner.paint(builder);
        Assert.assertEquals(builder.toString(), expected);
    }
}
