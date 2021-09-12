package adp.multithreadingconcurrency.highlevelconcurrencyobjects.executors;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Fork/Join:
 * a framework is an implementation of the ExecutorService interface that
 * helps you take advantage of multiple processors. It is designed for work that can be broken
 * into smaller pieces recursively. The goal is to use all the available processing power
 * to enhance the performance of your application.
 *
 * As with any ExecutorService implementation, the fork/join framework distributes tasks
 * to worker threads in a thread pool. The fork/join framework is distinct
 * because it uses a "work-stealing algorithm". Worker threads that run out of things
 * to do can steal tasks from other threads that are still busy.
 *
 * The center of the fork/join framework is the ForkJoinPool class,
 * an extension of the AbstractExecutorService class. ForkJoinPool implements
 * the core work-stealing algorithm and can execute ForkJoinTask processes.
 *
 * Standard Implementations
 * Besides using the fork/join framework to implement custom algorithms for tasks
 * to be performed concurrently on a multiprocessor system
 * (such as the ForkBlur.java example in the previous section),
 * there are some generally useful features in Java SE which are already implemented
 * using the fork/join framework. One such implementation, introduced in Java SE 8,
 * is used by the java.util.Arrays class for its parallelSort() methods.
 * These methods are similar to sort(), but leverage concurrency via the fork/join framework.
 * Parallel sorting of large arrays is faster than sequential sorting
 * when run on multiprocessor systems. However, how exactly the fork/join framework
 * is leveraged by these methods is outside the scope of the Java Tutorials.
 * For this information, see the Java API documentation.
 *
 * Another implementation of the fork/join framework is used by methods in the
 * java.util.streams package, which is part of Project Lambda scheduled for the Java SE 8 release.
 */
public class ForkJoin {
    /*
    Blurring for Clarity:
    To help you understand how the fork/join framework works,
    consider the following example.
    Suppose that you want to blur an image.
    The original source image is represented by an array of integers,
    where each integer contains the color values for a single pixel.
    The blurred destination image is also represented
    by an integer array with the same size as the source.

    Performing the blur is accomplished by working
    through the source array one pixel at a time.
    Each pixel is averaged with its surrounding pixels
    (the red, green, and blue components are averaged),
    and the result is placed in the destination array.
    Since an image is a large array, this process can take a long time.
    You can take advantage of concurrent processing on multiprocessor systems
    by implementing the algorithm using the fork/join framework.
    Here is one possible implementation: ForkBlur class
     */

    /**
     * ForkBlur implements a simple horizontal image blur. It averages pixels in the
     * source array and writes them to a destination array. The sThreshold value
     * determines whether the blurring will be performed directly or split into two
     * tasks.
     *
     * This is not the recommended way to blur images; it is only intended to
     * illustrate the use of the Fork/Join framework.
     */
    public static class ForkBlur extends RecursiveAction {

        private int[] mSource;
        private int mStart;
        private int mLength;
        private int[] mDestination;
        private int mBlurWidth = 15; // Processing window size, should be odd.

        public ForkBlur(int[] src, int start, int length, int[] dst) {
            mSource = src;
            mStart = start;
            mLength = length;
            mDestination = dst;
        }

        // Average pixels from source, write results into destination.
        protected void computeDirectly() {
            int sidePixels = (mBlurWidth - 1) / 2;
            for (int index = mStart; index < mStart + mLength; index++) {
                // Calculate average.
                float rt = 0, gt = 0, bt = 0;
                for (int mi = -sidePixels; mi <= sidePixels; mi++) {
                    int mindex = Math.min(Math.max(mi + index, 0), mSource.length - 1);
                    int pixel = mSource[mindex];
                    rt += (float) ((pixel & 0x00ff0000) >> 16) / mBlurWidth;
                    gt += (float) ((pixel & 0x0000ff00) >> 8) / mBlurWidth;
                    bt += (float) ((pixel & 0x000000ff) >> 0) / mBlurWidth;
                }

                // Re-assemble destination pixel.
                int dpixel = (0xff000000)
                        | (((int) rt) << 16)
                        | (((int) gt) << 8)
                        | (((int) bt) << 0);
                mDestination[index] = dpixel;
            }
        }
        protected static int sThreshold = 10000;

        /**
         * Now you implement the abstract compute() method, which either performs the blur
         * directly or splits it into two smaller tasks.
         * A simple array length threshold helps determine whether the work is performed or split.
         */
        @Override
        protected void compute() {
            /*
            Basic Use:
            The first step for using the fork/join framework is to write code that performs
            a segment of the work. Your code should look similar to the following pseudocode:

            if (my portion of the work is small enough)
              do the work directly
            else
              split my work into two pieces
              invoke the two pieces and wait for the results

             */
            if (mLength < sThreshold) { // A simple array length threshold helps determine whether the work is performed or split.
                computeDirectly();
                return;
            }

            int split = mLength / 2;

            /*
            Wrap this code in a ForkJoinTask subclass, typically using one of its more specialized types,
            either RecursiveTask (which can return a result) or RecursiveAction.
            Code Tracing:
                class ForkBlur extends RecursiveAction {...}
                abstract class RecursiveAction extends ForkJoinTask<Void> {...}
                abstract class ForkJoinTask<V> implements Future<V>, Serializable {...}
             */
            invokeAll(new ForkBlur(mSource, mStart, split, mDestination),
                    new ForkBlur(mSource, mStart + split, mLength - split,
                            mDestination));
        }

        // Plumbing follows.
        public static void main(String[] args) throws Exception {
            String srcName = "red-tulips.jpg";
            File srcFile = new File("/Users/abenitez/aj/hello-jworld/src/adp/multithreadingconcurrency/highlevelconcurrencyobjects/executors/red-tulips.jpg");
            BufferedImage image = ImageIO.read(srcFile);

            System.out.println("Source image: " + srcName);

            BufferedImage blurredImage = blur(image);

            String dstName = "blurred-tulips.jpg";
            File dstFile = new File(dstName);
            ImageIO.write(blurredImage, "jpg", dstFile);

            System.out.println("Output image: " + dstName);

        }

        /**
         * If the previous methods are in a subclass of the RecursiveAction class, then setting up the task to run in a ForkJoinPool is straightforward, and involves the following steps:
         *
         * 1. Create a task that represents all of the work to be done.
         *        ForkBlur fb = new ForkBlur(src, 0, src.length, dst);
         * 2. Create the ForkJoinPool that will run the task.
         *        ForkJoinPool pool = new ForkJoinPool();
         * 3. Run the task.
         *        pool.invoke(fb);
         *
         * @param srcImage
         * @return
         */
        public static BufferedImage blur(BufferedImage srcImage) {
            int w = srcImage.getWidth();
            int h = srcImage.getHeight();

            int[] src = srcImage.getRGB(0, 0, w, h, null, 0, w);
            int[] dst = new int[src.length];

            System.out.println("Array size is " + src.length);
            System.out.println("Threshold is " + sThreshold);

            int processors = Runtime.getRuntime().availableProcessors();
            System.out.println(Integer.toString(processors) + " processor"
                    + (processors != 1 ? "s are " : " is ")
                    + "available");
            // 1. Create a task that represents all of the work to be done.
            // source image pixels are in src
            // destination image pixels are in dst
            ForkBlur fb = new ForkBlur(src, 0, src.length, dst);

            // 2. Create the ForkJoinPool that will run the task.
            ForkJoinPool pool = new ForkJoinPool();

            long startTime = System.currentTimeMillis();
            /*
            After your ForkJoinTask subclass is ready, create the object that represents all the work
            to be done and pass it to the invoke() method of a ForkJoinPool instance.
             */
            // 3. Run the tasks.
            pool.invoke(fb);
            long endTime = System.currentTimeMillis();

            System.out.println("Image blur took " + (endTime - startTime) +
                    " milliseconds.");

            BufferedImage dstImage =
                    new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            dstImage.setRGB(0, 0, w, h, dst, 0, w);

            return dstImage;
        }
    }
}

/*
CONSOLE OUTPUT:
Source image: red-tulips.jpg
Array size is 6016000
Threshold is 10000
4 processors are available
Image blur took 431 milliseconds.
Output image: blurred-tulips.jpg

Output File can be found:
/Users/abenitez/aj/hello-jworld/blurred-tulips.jpg
 */



