package adp.multithreadingconcurrency.immutableobjects;

/**
 * The following rules define a simple strategy for creating immutable objects.
 * Not all classes documented as "immutable" follow these rules.
 * This does not necessarily mean the creators of these classes were sloppy — they may have good reason
 * for believing that instances of their classes never change after construction.
 * However, such strategies require sophisticated analysis and are not for beginners.
 *
 * 1. Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
 * 2. Make all fields final and private.
 * 3. Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final.
 *    A more sophisticated approach is to make the constructor private and construct instances in factory methods.
 * 4. If the instance fields include references to mutable objects, don't allow those objects to be changed:
 *        - Don't provide methods that modify the mutable objects.
 *        - Don't share references to the mutable objects.
 *          Never store references to external, mutable objects passed to the constructor;
 *          if necessary, create copies, and store references to the copies.
 *          Similarly, create copies of your internal mutable objects
 *          when necessary to avoid returning the originals in your methods.
 */
public class StrategyForDefiningImmutableObjects {
    /*
    Step 4:
    Only one field refers to an object, and that object (of class ImmutableRGB) is itself immutable.
    Therefore, no safeguards against changing the state of "contained" mutable objects are necessary.
     */

    /*
    Step 3:
    The class itself is declared final.
     */
    final public class ImmutableRGB {
        /*
        Step 2:
        All fields are already private; they are further qualified as final.
         */
        // Values must be between 0 and 255.
        final private int red;
        final private int green;
        final private int blue;
        final private String name;

        private void check(int red, int green, int blue) {
            if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
                throw new IllegalArgumentException();
            }
        }

        // Commented-out to try sophisticated approach (3.2) - an alternative way
//        public ImmutableRGB(int red, int green, int blue, String name) {
//            check(red, green, blue);
//            this.red = red;
//            this.green = green;
//            this.blue = blue;
//            this.name = name;
//        }
        /*
        Step 3.1:
        A more sophisticated approach is to make the constructor private and construct instances in factory methods.
         */
        private ImmutableRGB(int red, int green, int blue, String name) {
            check(red, green, blue);
            this.red = red;
            this.green = green;
            this.blue = blue;
            this.name = name;
        }
        public ImmutableRGB factoryMethodImmutableRGB(int red, int green, int blue, String name) {
            return new ImmutableRGB(red, green, blue, name);
        } // In this way, there is no explicitly creating instance but implicitly create through factory method().

        /*
        Step 1:
        There are two setter methods in this class.
        The first one, set, arbitrarily transforms the object,
        and has no place in an immutable version of the class.
         */
        // set() setter method should be REMOVE
//        public void set(int red, int green, int blue, String name) {
//            check(red, green, blue);
//            synchronized (this) {
//                this.red = red;
//                this.green = green;
//                this.blue = blue;
//                this.name = name;
//            }
//        }

        public int getRGB() {
            return ((red << 16) | (green << 8) | blue);
        }

        public String getName() {
            return name;
        }

        /*
        Step 1.1:
        The second one, invert, can be adapted by having it create a new object instead of modifying the existing one.
         */
        // invert() setter method should be REMOVE
//        public synchronized void invert() {
//            red = 255 - red;
//            green = 255 - green;
//            blue = 255 - blue;
//            name = "Inverse of " + name;
//        }
        // Setter replaced with an initialized new object
        public ImmutableRGB invert() {
            return new ImmutableRGB(255 - red, 255 - green, 255 - blue, "Inverse of " + name);
        }
    }

    // Applying this strategy to SynchronizedRGB class results in the ff steps in ImmutableRGB class.
    /*
    public static class SynchronizedRGB {
        // Values must be between 0 and 255.
        private int red;
        private int green;
        private int blue;
        private String name;

        private void check(int red, int green, int blue) {
            if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
                throw new IllegalArgumentException();
            }
        }

        public SynchronizedRGB(int red, int green, int blue, String name) {
            check(red, green, blue);
            this.red = red;
            this.green = green;
            this.blue = blue;
            this.name = name;
        }

        public void set(int red, int green, int blue, String name) {
            check(red, green, blue);
            synchronized (this) {
                this.red = red;
                this.green = green;
                this.blue = blue;
                this.name = name;
            }
        }

        public synchronized int getRGB() {
            return ((red << 16) | (green << 8) | blue);
        }

        public synchronized String getName() {
            return name;
        }

        public synchronized void invert() {
            red = 255 - red;
            green = 255 - green;
            blue = 255 - blue;
            name = "Inverse of " + name;
        }
    }
     */
}
