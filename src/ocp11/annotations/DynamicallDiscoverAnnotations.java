package ocp11.annotations;

import java.lang.annotation.Annotation;

public class DynamicallDiscoverAnnotations<policyAnnotations> {
    // All class level annotations and their types:
    Annotation[] shopAnnotations = Shop.class.getAnnotations();
    // Type of the first class level annotation:
    Class annotationType = Shop.class.getAnnotations()[0].annotationType();
    // Class level annotations of BusinessPolicy type:
    BusinessPolicy[] policyAnnotations = Shop.class.getAnnotationsByType(BusinessPolicy.class);
    // Retrieve values of annotation attributes:
//    for (BusinessPolicy policy : policyAnnotations) {//un expected token
//        System.out.println(policy.name());
//        System.out.println(policy.value());
//        for (String country : policy.countries()) {
//            System.out.println(country);
//        }
//    }
}

/* Java Reflections API allows dynamic discovery of class structures, including annotations.
Get array of annotations for the class, methods, or fields (eg. Shop.class.getAnnotations()
Discover annotation type (eg. eg. Shop.class.getAnnotations()[0].getAnnotationType()
Get annotaiton by type (eg. Shop.class.getAnnotationsByType(BusinessPolicy.class))
Invoke operrations upon annotation to retrieve its attributes
NOTE: Annotation applied to a class is not inherited by its subclasses, unless it is marked as @Inherited.

Document the Use of Annotaions
annotation can be marked with the @Documented annotation. */