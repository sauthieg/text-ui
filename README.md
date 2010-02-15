Description
-----------

Textual UI Library.
This library has to be used to create formatted ASCII line.

Components
--------

## ProgressBar
    Sample output: [****   ]
* Delimiter chars + progress chars are modifiable

## BoundedText
    Sample output: >bounded values<
* Define a text zone, supports alignment (left/right/center)
* Too long strings will be cropped
* Too small strings will be completed with spaces 

Toughts (for the future)
--------

* Ansi support (Support coloring)
* Multiline support
* Provide a component for Ascii Art display
* Table support
* Use a PrintStream instead of a StringBuilder as paint() parameter
* List support

Building
--------

### Requirements

* Maven 2+
* Java 5+

Check out and build:

    git clone git://github.com/sauthieg/text-ui.git
    cd text-ui
    mvn install
