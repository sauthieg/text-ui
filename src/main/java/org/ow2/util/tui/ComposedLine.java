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

import java.util.List;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Guillaume
 * Date: 8 mars 2009
 * Time: 09:59:54
 * To change this template use File | Settings | File Templates.
 */
public class ComposedLine implements ITextualComponent {

    private List<ITextualComponent> components;

    public ComposedLine() {
        this.components = new ArrayList<ITextualComponent>();
    }

    public void addComponent(ITextualComponent component) {
        this.components.add(component);
    }

    public void removeComponent(ITextualComponent component) {
        this.components.remove(component);
    }

    /**
     * Compute the size required to display the component.
     *
     * @return component's size
     */
    public int getSize() {
        int sum = 0;
        for (ITextualComponent component : components) {
            sum += component.getSize();
        }
        return sum;
    }

    /**
     * Paint the component's string representation into the given Builder.
     *
     * @param builder StringBuilder used to host this component's string representation.
     */
    public void paint(StringBuilder builder) {
        for (ITextualComponent component : components) {
            component.paint(builder);
        }
    }
}
