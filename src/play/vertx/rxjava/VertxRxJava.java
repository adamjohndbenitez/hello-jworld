package practice.vertx.rxjava;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.AsyncFile;
import io.vertx.core.file.FileSystem;
import io.vertx.core.file.OpenOptions;
import io.vertx.rx.java.RxHelper;
import rx.Observable;

public class VertxRxJava {

    private final String filename = "C:\\Users\\adamj\\IdeaProjects\\hello-world\\src\\practice\\vertx\\rxjava\\data.txt";
    private final Vertx vertx = Vertx.vertx();
    /**
     * Read stream support
     * RxJava Observable is a perfect match for Vert.x ReadStream class : both provide a flow of items.
     * The RxHelper.toObservable static methods convert a Vert.x read stream to an rx.Observable:
     */
    public void readStreamSupport1() {
        FileSystem fileSystem = vertx.fileSystem();
        fileSystem.open(filename, new OpenOptions(), asyncFileAsyncResult -> {
            AsyncFile file = asyncFileAsyncResult.result();
            Observable<Buffer> observable = RxHelper.toObservable(file);
            observable.forEach(data -> System.out.println("Read data: " + data.toString("UTF-8")));
        });
    }

    /**
     * The Rxified Vert.x API provides a toObservable method on ReadStream:
     */
    public void readStreamSupport2() {
        FileSystem fs = vertx.fileSystem();
        fs.open(filename, new OpenOptions(), asyncFileAsyncResult -> {
            AsyncFile asyncFile = asyncFileAsyncResult.result();
//            Observable<Buffer> observable = asyncFile.toObservable(); // TODO cannot resolve '.toObservable()'
//            observable.forEach(data -> System.out.println("Read data: " + data.toString("UTF-8")));
        });
    }
    /**
     * When you need to delay the subscription, you need to pause the ReadStream and then resume it,
     * which is what you would do with a ReadStream.
     */
// TODO    public void delayTheSubcription() {
//        server.requestHandler
//    }
}