package org.anyrem.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String[] coursePrefixes;

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

        if (theCode != null) {

            for (String coursePrefix : coursePrefixes) {

                if (theCode.startsWith(coursePrefix)) {
                    return true;
                }

            }

        } else {
            return true;
        }
        return false;
    }

    @Override
    public void initialize(CourseCode courseCode) {

        coursePrefixes = courseCode.value();
    }
}
