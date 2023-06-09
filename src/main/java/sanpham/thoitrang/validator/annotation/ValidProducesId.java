package sanpham.thoitrang.validator.annotation;
import sanpham.thoitrang.validator.ValidProducesIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
@Target({TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidProducesIdValidator.class)
@Documented
public @interface ValidProducesId {
    String message() default "Invalid Produces ID";
    Class<?>[] groups() default {};
    Class <? extends Payload>[] payload() default {};
}
