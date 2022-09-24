package jfjca.chapter14;/* Invoke the sum method created above from main. Wrap the call in an appropriate try/catch statement. Print two different messages on sonsole depending upon whether the call results in a checked exception or an unchecked exception. Propagate all exceptions up the call chain. */

class Chap14Exer8 {
  public static void main(String[] args) throws Exception {
    //unchecked exception
    try {
      int total = sum(0, 0);
      if (total == 0) throw new Exception();
    } catch(Exception e) {
      e.printStackTrace();
      System.out.println("run-time/unchecked exception");
      System.out.printf("JVM exception message => %s \n", e.getMessage());
    }

    //checked exception
    try {
//      int total = sum("a", 0); //Error - Error:(17, 23) java: incompatible types: java.lang.String cannot be converted to int
      int total = sum(0, 0);
    } catch(Exception e) {
      e.printStackTrace();
      System.out.println("compile-time/checked exception");
      System.out.printf("compiler exception message => %s \n", e.getMessage());
    } // comment this block to trigger unchecked exception

  }
  //putting throws Exception will propagate up to the caller/invoker of the method.
  static int sum(int n1, int n2) throws Exception {
    return n1 + n2;
  }
}

/* i think that there is no way we can print both checked and unchecked exception in 1 run, since the checked exceptions are thrown during compile time, unchecked exceptions are thrown during run time,
so compiling will throw an error */