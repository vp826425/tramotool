package de.tramotech.ioutils.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotate classes with @TConfiguration to specify the configuration file for the class.
 * This annotation is used to indicate the name of the configuration file that should be
 * associated with the annotated class.
 *
 * @author Ahmed Fikri
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TConfiguration {
    String filename();
}
