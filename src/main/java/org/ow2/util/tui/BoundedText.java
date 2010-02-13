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

import org.ow2.util.tui.processor.CutTextProcessor;
import org.ow2.util.tui.util.Strings;


/**
 * Created by IntelliJ IDEA.
 * User: Guillaume
 * Date: 7 mars 2009
 * Time: 17:53:30
 * To change this template use File | Settings | File Templates.
 */
public class BoundedText implements ITextualComponent {

    /**
     * Maximum chars to be displayed.
     */
    private int size = 30;

    /**
     * Initial text to be displayed.
     */
    private String value = "";

    /**
     * String text processor (for too long char).
     */
    private ITextProcessor processor = new CutTextProcessor();

    /**
     * Text alignment.
     */
    private Alignment alignment = Alignment.LEFT;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ITextProcessor getProcessor() {
        return processor;
    }

    public void setProcessor(ITextProcessor processor) {
        this.processor = processor;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Paint the component's string representation into the given Builder.
     *
     * @param builder StringBuilder used to host this component's string representation.
     */
    public void paint(StringBuilder builder) {
        // If the text is not long enough, fill it with white spaces
        if (value.length() <= size) {
            int missing = size - value.length();

            switch (alignment) {
                case LEFT:
                    builder.append(value);
                    Strings.fill(builder, ' ', missing);
                    break;
                case CENTER:
                    int divided = missing / 2;
                    int modulo = missing % 2;
                    Strings.fill(builder, ' ', divided);
                    builder.append(value);
                    Strings.fill(builder, ' ', divided + modulo);
                    break;
                case RIGHT:
                    Strings.fill(builder, ' ', missing);
                    builder.append(value);
                    break;
            }

        } else {

            // If the text length is superior to size, process the text
            String processed = processor.process(value, size);
            builder.append(processed);

        }

    }
}
