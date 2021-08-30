package com.homains.utils;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanUtils;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    public boolean isValid(final Class<?> value, final ConstraintValidatorContext context) {
        boolean valid = true;
        try
        {
            final Object firstObj = BeanUtils.getPropertyDescriptor(value, firstFieldName);
            final Object secondObj = BeanUtils.getPropertyDescriptor(value, secondFieldName);

            valid =  firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        }
        catch (final Exception ignore)
        {
            // ignore
        }

        if (!valid){
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(firstFieldName)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return valid;
    }

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}
}
