package ocp.annotations;

@BusinessPolicies({
        @BusinessPolicy(name = "Returns Policy", countries = "GB", value = "4 weeks"),
        @BusinessPolicy(countries = {"GB", "FR"}, value = "Ship via Dover-Calais")
})
public class Shop {
}

/* Can use existing annotations OR construct your own annotations
Design Annotations:
	- annotations can have attributes (types: primitive, String, Class, Enum, Annotation, Array of any)
		- attributes can have default value, constant expression
		- attributes can be an array of values, repeatable annotations

Apply Annotations to the appropriate type of target
	- Attributes are set as list of name-value pairs (eg. @Annotation(name=value, arrayName={e1,e2})
	- When no attributes arer use, () can be omitted
	- If array has only one value, {} can be omitted	 */