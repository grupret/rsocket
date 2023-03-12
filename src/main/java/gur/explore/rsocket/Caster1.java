package gur.explore.rsocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Flux;

public class Caster1 {

    public static void main(String[] args) throws JsonProcessingException {
        RSocket clientSocket = RSocketFactory.connect()
            .transport(TcpClientTransport.create("24.199.74.9", 7000)).start().block();

        StreamMeta streamRequest = new StreamMeta();
        streamRequest.setStreamId("COMMAND");
        streamRequest.setComponent("COMMAND");
        streamRequest.setType("COMMAND"
            + "");
        ObjectMapper objectMapper = new ObjectMapper();
        String payload1 = objectMapper.writeValueAsString(streamRequest);
        System.out.println(">>>>>>>>>> Request:" +payload1);
        Payload payload = DefaultPayload.create(payload1,
            "STREAM_REQUEST");
        System.out.println(">>>>>>>>>> Request:" +payload);

        Flux<Payload> payloadFlux = clientSocket.requestStream(payload);
        System.out.println(">>>>>>>>>> Flux:" +payloadFlux);
        payloadFlux.doOnNext(data -> {
            System.out.println("=========================");
            System.out.println(data.getDataUtf8());
        }).blockLast();

    }

}
