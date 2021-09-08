//package ojexplorer;
//
//import io.helidon.webserver.Handler;
//import io.helidon.webserver.ServerRequest;
//import io.helidon.webserver.ServerResponse;
//
///**
// * To handle the new web request.
// */
//public class ItemList implements Handler {
//    private Clothing[] items;
//
//    public ItemList(Clothing[] items) {
//        this.items = items;
//    }
//
//    @Override
//    public void accept(ServerRequest serverRequest, ServerResponse serverResponse) {
//        serverResponse.status();
//        serverResponse.headers().put("Content-Type", "text/plain; charset=UTF-8");
//        StringBuilder result = new StringBuilder();
//        for (Clothing cloth : items) {
//            result.append("\n");
//        }
//        serverResponse.send(result);
//    }
//}
