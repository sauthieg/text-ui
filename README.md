Description
-----------

Textual UI Library.
This library has to be used to create formatted ASCII line.

Components
--------

# ProgressBar
    Sample output: [****   ]
* Delimiter chars + progress chare are modifiable

# BoundedText
    Sample output: >bounded values<
* Define a text zone, supports alignment (left/right/center)
* Too long strings will be cropped
* Too small strings will be completed with spaces 

Building
--------

### Requirements

* Maven 2+
* Java 5+

Check out and build:

    git clone git://github.com/sauthieg/text-ui.git
    cd text-ui
    mvn install
