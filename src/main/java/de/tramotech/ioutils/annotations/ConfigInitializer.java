package de.tramotech.ioutils.annotations;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * The `ConfigInitializer` class provides a utility for initializing and populating
 * fields of classes annotated with `@TValue` and `@TConfiguration`.
 * It processes these annotations and reads configuration data from external files,
 * populating annotated fields with the corresponding values.
 *
 * <p>Users should call the `initialize` method with an instance of a class annotated
 * with `@TConfiguration` to execute the annotations and initialize the configuration.
 *
 * @author Ahmed Fikri
 */
public class ConfigInitializer {

    private static void processTconfiguration(Object target) {
        Class<?> targetClass = target.getClass();
        TConfiguration tConfigAnnotation = targetClass.getAnnotation(TConfiguration.class);
        if (tConfigAnnotation != null) {
            String filename = tConfigAnnotation.filename();
            Properties properties = new Properties();
            try (InputStream input = targetClass.getClassLoader().getResourceAsStream(filename)) {
                properties.load(input);
                for (Field field : targetClass.getDeclaredFields()) {
                    TValue valueAnnotation = field.getAnnotation(TValue.class);
                    if (valueAnnotation != null) {
                        String propertyName = valueAnnotation.name();
                        if(propertyName == null || propertyName.isBlank()) {
                            propertyName = field.getName();
                        }
                        String propertyValue = properties.getProperty(propertyName);
                        field.setAccessible(true);
                        if (propertyValue != null) {
                            try {
                                if (field.getType() == String.class) {
                                    field.set(target, propertyValue);
                                } else if (field.getType() == int.class || field.getType() == Integer.class) {
                                    field.set(target, Integer.parseInt(propertyValue));
                                }
                                // Add more data types as needed
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void initialize(Object target) {
        processTconfiguration(target);
    }
}

