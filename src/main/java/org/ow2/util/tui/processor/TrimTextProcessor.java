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

package org.ow2.util.tui.processor;

import org.ow2.util.tui.ITextProcessor;


/**
 * Created by IntelliJ IDEA.
 * User: Guillaume
 * Date: 7 mars 2009
 * Time: 18:30:56
 * To change this template use File | Settings | File Templates.
 */
public class TrimTextProcessor implements ITextProcessor {

    private static final String DEFAULT_REPLACEMENT_TEXT = "...";
    private String replacementText = DEFAULT_REPLACEMENT_TEXT;

    public String getReplacementText() {
        return replacementText;
    }

    public void setReplacementText(String replacementText) {
        this.replacementText = replacementText;
    }

    public String process(String text, int size) {

        int msgLength = text.length();
        if (msgLength <= size) {
            // Let the text unchanged
            return text;
        }

        int extraChars = msgLength - size - replacementText.length();
        if (extraChars < 0) {
            // authorized text size is not long enough to accept the middle part replacement
            // just cut the text to the size
            return text.substring(0, size);
        }

        int cutPoint = (size - replacementText.length()) / 2;
        String first = text.substring(0, cutPoint - 1);
        String second = text.substring(cutPoint + 2 + extraChars + replacementText.length());

        return first + replacementText + second;

    }
}
