package ocp11.annotations;

import java.util.List;

public class Product {
    String id;
//    @Override // Error: Method does not override method from its superclass
    public boolean equals(Product product) {
        return this.id == product.id;
    }

    /* Suppress Compiler Warnings
        Indicate that compiler warnings should be suppressed for the annotated element
        - warning can be suppressed on a class or specificy method level
        - unchecked warnings are caused by assignment of raw-type object to generic-type variable.
        - deprecated warnings are caused by the use of out-of-date APIs
            - unchecked warning indiates potential heap pollution
            - non-parameterized (raw) object may allow values that contradict parameterized (generic) type.
            - compiler is unable to perform type safety check on the raw object.
            - suppressing compiler warnings could be dangerous. When compiling code, you may not notice that program is using out-of-date APIs, such as pre-generics or deprecated code. */
    @SuppressWarnings({"unchecked", "deprecation"})
    public void processProducts(ProductManager pm) {
        List<Product> products = pm.find(); // find() is passing raw type object, should also pass the exact/same generic parameterized type variable List<Product>
        pm.save();
    }
}

/* ANNOTATIONS THAT VALIDATE DESIGN (Override)
Annotation may be used to validate Class or interface design.
Verify that a mthod actually overrides a parent operation:
- Subclass must match the signature of the parent class method.
- The Override annotation prevents subclass from compiling if this rule is broken. */

