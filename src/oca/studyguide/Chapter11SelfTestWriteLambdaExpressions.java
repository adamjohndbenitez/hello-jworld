package oca.studyguide;

public class Chapter11SelfTestWriteLambdaExpressions {

    public static void main(String[] args) {

        Thread thread0 = new Thread( new Runnable() {
            @Override
            public void run() {
                processDNA(0);
            }
        });
        thread0.start();

        // Refactor:
        Thread thread1 = new Thread( () -> // Parentheses for a zero argument target type, followed by the arrow operator and method name, is the acceptable format for lambda expressions.
                processDNA(1)
        );
        thread1.start();
    }

    private static void processDNA(int num) {
        System.out.println("processing # " + num + " DNA");
    }
}
