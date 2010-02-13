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

package org.ow2.util.tui.util;

/**
 * Created by IntelliJ IDEA.
 * User: Guillaume
 * Date: 7 mars 2009
 * Time: 17:45:04
 * To change this template use File | Settings | File Templates.
 */
public class Strings {

    public static void fill(StringBuilder sb, char c, int n) {

        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
    }

    public static String trimMessage(String message, int maxLength) {

        String middle = "...";
        int msgLength = message.length();
        if (msgLength <= maxLength) {
            // Let the message unchanged
            return message;
        }

        int extraChars = msgLength - maxLength - middle.length();
        if (extraChars < 0) {
            // authorized message size is not long enough to accept the middle part replacement
            // just cut the message to the maxLength
            return message.substring(0, maxLength);
        }

        int cutPoint = (maxLength - middle.length()) / 2;
        String first = message.substring(0, cutPoint - 1);
        String second = message.substring(cutPoint + 2 + extraChars + middle.length());

        return first + middle + second;
    }
}
