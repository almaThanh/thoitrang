package sanpham.thoitrang.validator;
import sanpham.thoitrang.enity.Produces;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import sanpham.thoitrang.validator.annotation.ValidProducesId;

public class ValidProducesIdValidator implements ConstraintValidator<ValidProducesId, Produces> {
    @Override
    public boolean isValid(Produces produces, ConstraintValidatorContext context) {
        return produces != null && produces.getId() != null;
    }
}
