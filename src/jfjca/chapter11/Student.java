package jfjca.chapter11;

class Student {
    public static final String field1 = "field1";
    //default static final String field2 = "field2"; //Error - Modifier 'default' not allowed here
    protected static final String field3 = "field3";
    private static final String field4 = "field4";

    /* Setters */
    void setField1(String newValue) {
        //field1 = newValue; //Error - Cannot assign a value to final variable 'field1'
    }
    void setField2(String newValue) {
        //field2 = newValue; //Error - Cannot assign a value to final variable 'field1'
    }
    void setField3(String newValue) {
        //field3 = newValue; //Error - Cannot assign a value to final variable 'field1'
    }

    /* Getters */
    String getField1() {
        return field1;
    }
    String getField3() {
        return field3;
    }
    String getField4() {
        return field4;
    }

}