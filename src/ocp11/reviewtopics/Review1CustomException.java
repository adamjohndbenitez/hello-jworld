package ocp11.reviewtopics;

/*
    Create and use custom exceptions
 */
public class Review1CustomException {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        try {
            studentManager.find("001");
        } catch (StudentNotFoundException e) { // Use custom exception.
            e.printStackTrace();
        }
    }

    // Create custom exception.
    static class StudentNotFoundException extends Exception {
        public StudentNotFoundException(String message) {
            super(message);
        }
    }

    static class StudentManager {
        public Student find(String id) throws StudentNotFoundException {
            if (id.equals("12345")) {
                return new Student();
            } else {
                throw new StudentNotFoundException("Could not find student id " + id);
            }
        }
    }

    static class Student {
        String name;
        String id;
    }
}
