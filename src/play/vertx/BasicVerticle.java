//package play.vertx;
//
//import io.vertx.core.AbstractVerticle;
//import io.vertx.core.AsyncResult;
//import io.vertx.core.Handler;
//import io.vertx.core.Vertx;
//
///**
// * The Vertx instance by itself doesn't do much except all the thread management,
// * creating an event bus etc. which are all communication and infrastructure tasks.
// * In order to get the application to do something useful,
// * you need to deploy one or more verticles (component) inside the Vertx instance.
// *
// * Before you can deploy a verticle you need to create it.
// * You do so by creating a class that extends AbstractVerticle.
// *
// * @author Adam John Benitez
// */
//public class BasicVerticle extends AbstractVerticle {
//
//    /**
//     * Once you have created a verticle you need to deploy it to the Vertx instance.
//     * You deploy a verticle using one of the deployVerticle() methods on the Vertx instance
//     */
//    public void vertxDeployVerticle() {
//        Vertx vertx = Vertx.vertx();
//
//        // Vert.x will now deploy the verticle internally.
//        // Once Vert.x deploys the verticle, the verticle's start() method is called.
//        vertx.deployVerticle(new BasicVerticle());
//
//        //  If you need to know exactly when a verticle is fully deployed,
//        //  you can provide a Handler implementation to the the deployVerticle().
//        vertx.deployVerticle(new BasicVerticle(), new Handler<AsyncResult<String>>() {
//            @Override
//            public void handle(AsyncResult<String> stringAsyncResult) {
//                System.out.println("BasicVerticle deployment complete");
//            }
//        });
//        // OR using Java lambda expression:
//        vertx.deployVerticle(new BasicVerticle(), stringAsyncResult -> {
//            System.out.println("BasicVerticle deployment complete");
//        });
//    }
//
//    /**
//     * The AbstractVerticle class contains a start() method which you can override in your verticle class.
//     * The start() method is called by Vert.x when the verticle is deployed and ready to start.
//     *
//     * The start() method is where you initialize your verticle. Inside the start() method
//     * you will normally create e.g. HTTP or TCP server, register event handlers on the event bus,
//     * deploy other verticles, or whatever else your verticle needs to do its work.
//     *
//     * The AbstracVerticle class also contains another version of start() which takes a Future as parameter.
//     * This Future can be used to asynchronously tell Vert.x if the Verticle was deployed successfully.
//     *
//     * @throws Exception
//     */
//    @Override
//    public void start() throws Exception {
//        System.out.println("BasicVerticle started");
//        // Deploying a Verticle From Another Verticle
//        // It is possible to deploy one verticle from inside another verticle.
//        vertx.deployVerticle(new SecondVerticle());
//    }
//
//    /**
//     * The AbstractVerticle class also contains a stop() method you can override.
//     * The stop() method is called when Vert.x shuts down and your verticle needs to stop.
//     *
//     * @throws Exception
//     */
//    @Override
//    public void stop() throws Exception {
//        System.out.println("BasicVerticle stopped");
//    }
//}
