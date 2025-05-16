/*
 * Author: Troyano85.
 * Date: 14/05/2025
 * Description: Custom smoke Annotation
 * Version: 1.0
 * */
package annotations;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Tag("smoke")
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Smoke {
}
