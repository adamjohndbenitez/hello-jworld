package ocp.annotations;

import java.time.LocalDate;

//@FunctionalInterface // Error: Multiple non-overriding abstract method found in interface ocp.annotation.Perishable
public interface Perishable {
    boolean parish(LocalDate expiryDate);
    int getDays(LocalDate expiryDate);
}

/* ANNOTATIONS THAT VALIDATE DESIGN (Functional Interface)
Annotation may be used to validate Class or interface design.
Enforce the definition of a functional interface:
- Only (1) abstract method should be present in a functional interface.
- The Functional Interface annotation prevents interface from compiling if this rule is broken.*/