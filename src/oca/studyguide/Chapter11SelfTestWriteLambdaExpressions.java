package oca.studyguide;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chapter11SelfTestWriteLambdaExpressions {

    public static void main(String[] args) {

        System.out.println("Q#1:");
        question1_CorrectSyntaxToRefactorLambdaExpression();
        System.out.println("Q#2:");
        question2_ValidCode();
        // Question #3: Runnable and Callable are specific-purpose functional interfaces - they don't have target types.
        System.out.println("Q#4:");
        question4_PrintI2L126I2L126R1bI2L126();
        // Question #5: Check oca.studyguide.Sequenceable Functional Interface for answer.
        // Question #6: java.util.function.Predicate<T> FI, it doesn't have xor(Predicate<? super T> other),
        //              Only: xor(Predicate<? super T> other) and xor(Predicate<? super T> other), negate(),
        System.out.println("Q#7:");
        question7_MissingCodeSegment();
        System.out.println("Q#8:");
        question8_ValidBlockStatementOfLambdaExpression();
    }

    private static void question8_ValidBlockStatementOfLambdaExpression() {
        List<String> words = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");
        words.forEach(p -> {});
        words.forEach(p -> {{;}
            System.out.print("{{;}}");});
        System.out.println();
        words.forEach(p -> {;});
        words.forEach(p -> {;;
            System.out.print(";;");});
        System.out.println();
    }

    private static void question7_MissingCodeSegment() {
        String [] birdArray = {"bluebird", "scarlet macaw", "bluejay"};
        List <String> birdlist = Arrays.asList (birdArray);
        birdlist.forEach( (String p) -> // MISSING-CODE: parameter with explicit target type and parentheses
                System.out.println(p.toString(). contains("blue")));
    }

    private static void question4_PrintI2L126I2L126R1bI2L126() {
        List<String> yHaplogroupList = new ArrayList <> ();
        yHaplogroupList.add("I2");
        yHaplogroupList.add("L126");
        yHaplogroupList.add("R1b");
        yHaplogroupList.stream().filter(s -> !s.startsWith("R"))
                .forEach(s -> System.out.print(s + " "));
        yHaplogroupList.forEach(s -> System.out.print(s + " "));
        yHaplogroupList.removeIf(s -> s.startsWith("R"));
        yHaplogroupList.forEach(s -> System.out.print(s + " "));
    }

    private static void question2_ValidCode() {
        PathMatcher matcher1 = (Path p) -> { return (p.toString().contains("DNA")); };
        PathMatcher matcher2 = p -> { return
                (p.toString().equals("DNA")); };
        PathMatcher matcher3 = (Path p) -> p.toString().startsWith("DNA");
        PathMatcher matcher4 = p -> p.toString().endsWith("DNA");
        Path path = FileSystems.getDefault().getPath("\\dna_data\\DNA_results.txt");
        System.out.print(matcher1.matches (path));
        System.out.print(" " + matcher2.matches (path));
        System.out.print(" " + matcher3.matches (path));
        System.out.println(" " + matcher4.matches (path));
    }

    private static void question1_CorrectSyntaxToRefactorLambdaExpression() {
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