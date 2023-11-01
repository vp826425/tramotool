package de.tramotech;

import de.tramotech.ioutils.MyConfigClass;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        MyConfigClass config = new MyConfigClass();
        System.out.println(String.format("Prop1: %s, Prop2: %s", config.getProperty1(),config.getProperty2()));
    }
}
