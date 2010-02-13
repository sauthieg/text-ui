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

        if (size <= replacementText.length()) {
            // The replacement text is longer than the requested
            // size, so truncate the text value
            return text.substring(0, size);
        }
        // Text is longer than the requested size

        int remainingTextSize = (size - replacementText.length());

        int cutPoint = remainingTextSize / 2;
        int modulo = remainingTextSize % 2; // To know if this is odd or even size
        String first = text.substring(0, cutPoint + modulo);
        String second = text.substring(text.length() - cutPoint);

        return first + replacementText + second;

    }
}
