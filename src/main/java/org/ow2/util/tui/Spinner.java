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

/**
 * A Spinner is a component that display a 1 unit length char that is spinning around it's axis (/-\|).
 * @author Guillaume Sauthier
 */
public class Spinner implements ITextualComponent {

    private char[] spins = new char[] {'/', '-', '\\', '|'};

    private int state = 0;

    public void paint(StringBuilder builder) {

        // Print the current char and increment the internal state
        builder.append(spins[state++]);

        // Reset state if required
        if (state == 4) {
            state = 0;
        }
    }

    /**
     * @return Always return 1.
     */
    public int getSize() {
        return 1;
    }
}
