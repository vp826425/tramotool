package de.tramotech.ioutils.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * `Annotate fields with @TValue to inject configuration properties.
 * If the 'name' attribute is not provided, it defaults to the field name itself.`
 *
 * @author Ahmed Fikri
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TValue {
    String name() default "";
}
