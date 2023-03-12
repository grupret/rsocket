//package gur.explore.rsocket;
//
//import io.rsocket.RSocketFactory;
//import io.rsocket.transport.netty.server.WebsocketServerTransport;
//import reactor.core.publisher.Mono;
//
//public final class RawServer {
//    public static void main(String[] args) {
//        Void localhost = RSocketFactory.receive()
//            .acceptor((setup, sendingSocket) -> {
//                return Mono.just(new DefaultSimpleService());
//            })
//            .transport(WebsocketServerTransport.create("localhost", 8801)).start().block().onClose()
//            .block();
//    }
//
//    private static final class DefaultSimpleService extends AbstractRSocket {
//        private ObjectMapper jsonMapper = new ObjectMapper();
//
//        @Override
//        public Flux<Payload> requestStream(Payload payload) {
//            return Mono.just(payload.getDataUtf8())
//                .map(json -> {
//                    try {
//                        return jsonMapper.readValue(json, Message.class);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                        return null;
//                    }
//                })
//                .doOnNext(msg -> System.out.println("got message " + msg.message))
//                .flatMapMany(msg -> Flux.range(0, 5)
//                    .map(count -> msg.message + " #" + count))
//                .map(message -> DefaultPayload.create(message));
//        }
//    }
//}
