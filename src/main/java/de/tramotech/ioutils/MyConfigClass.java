package de.tramotech.ioutils;

import de.tramotech.ioutils.annotations.ConfigInitializer;
import de.tramotech.ioutils.annotations.TConfiguration;
import de.tramotech.ioutils.annotations.TValue;

@TConfiguration(filename = "myconfig.properties")
public class MyConfigClass {
    @TValue(name = "prop1")
    private String property1;

    @TValue()
    private String prop2;

    public MyConfigClass() {
        ConfigInitializer.initialize(this); // Initialize the class during construction
    }

    public String getProperty1() {
        return this.property1;
    }

    public String getProperty2() {
        return this.prop2;
    }
}
