package businessdirt.libgdx.core.config.data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Property {

    PropertyType type();

    String name();
    String description() default "";

    String category();
    String subcategory() default "";

    // Range of numbers for Sliders
    int min() default 0;
    int max() default 0;

    // Options for Selectors
    String[] options() default {};

    // Hides the Property from the GUI
    boolean hidden() default false;
}
