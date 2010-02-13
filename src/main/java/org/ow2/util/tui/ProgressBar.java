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
 * Created by IntelliJ IDEA.
 * User: Guillaume
 * Date: 7 mars 2009
 * Time: 17:48:59
 * To change this template use File | Settings | File Templates.
 */
public class ProgressBar implements ITextualComponent {

    private static final char DEFAULT_OPENING_CHAR = '[';
    private static final char DEFAULT_ENDING_CHAR = ']';
    private static final int DEFAULT_BAR_SIZE = 40;
    private static final char DEFAULT_FILLING_CHAR = '*';
    private static final char WHITE_SPACE = ' ';

    private char openingChar = DEFAULT_OPENING_CHAR;
    private char endingChar = DEFAULT_ENDING_CHAR;
    private int size = DEFAULT_BAR_SIZE;
    private char fillingChar = DEFAULT_FILLING_CHAR;
    private int value = 0;
    private int progressBarSize;

    public char getOpeningChar() {
        return openingChar;
    }

    public void setOpeningChar(char openingChar) {
        this.openingChar = openingChar;
    }

    public char getEndingChar() {
        return endingChar;
    }

    public void setEndingChar(char endingChar) {
        this.endingChar = endingChar;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        this.progressBarSize = size - 2;
    }

    public char getFillingChar() {
        return fillingChar;
    }

    public void setFillingChar(char fillingChar) {
        this.fillingChar = fillingChar;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getProgressBarSize() {
        return progressBarSize;
    }

    /**
     * Paint the component's string representation into the given Builder.
     *
     * @param builder StringBuilder used to host this component's string representation.
     */
    public void paint(StringBuilder builder) {
        builder.append(openingChar);

        // Print the bar
        for (int i = 0; i < value ; i++) {
            builder.append(fillingChar);
        }
        // Print remaining chars as spaces
        for (int i = 0; i < (size - value - 2); i++) {
            builder.append(WHITE_SPACE);
        }
        builder.append(endingChar);
    }
}
