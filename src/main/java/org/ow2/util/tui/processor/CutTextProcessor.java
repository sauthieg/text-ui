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
 * Time: 18:26:34
 * To change this template use File | Settings | File Templates.
 */
public class CutTextProcessor implements ITextProcessor {

    public String process(String text, int size) {
        if (text.length() <= size) {
            return text;
        }
        return text.substring(0, size);
    }
}
