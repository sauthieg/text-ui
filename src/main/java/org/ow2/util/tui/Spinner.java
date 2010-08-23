package org.ow2.util.tui;

/**
 * Created by IntelliJ IDEA.
 * User: guillaume
 * Date: 23 aožt 2010
 * Time: 19:02:23
 * To change this template use File | Settings | File Templates.
 */
public class Spinner implements ITextualComponent {

    private char[] spins = new char[] {'/', '-', '\\', '|'};

    private int state = 0;

    public void paint(StringBuilder builder) {
        builder.append(spins[state++]);
    }

    public int getSize() {
        return 1;
    }
}
