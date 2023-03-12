package gur.explore.rsocket;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsocket.client.RSocketClient;
import com.rsocket.client.RSocketConnection;
import com.rsocket.client.RSocketConnection.Type;
import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;

public class ControllerApp {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        StreamMeta streamRequest = new StreamMeta();
        streamRequest.setStreamId("COMMAND");
        streamRequest.setComponent("COMMAND");
        streamRequest.setType("DATA");
        byte[] metadata = mapper.writeValueAsBytes(streamRequest);

		RSocketConnection connection = new RSocketConnection("24.199.74.9", 7000, 1000l,
			Type.TCP);

        RSocket clientSocket = RSocketFactory.connect()
            .transport(TcpClientTransport.create("24.199.74.9", 7000)).start().block();



        int i=1;
		while(i<10) {
            String s1 = "{\"DeviceId\":\"123\",\"message\":\"This is a test message:\"";
            String s2 = "\"}";
            String data =   s1  + i + s2;
			Payload payload = DefaultPayload.create(data.getBytes(), metadata);
			System.out.println("Request :" + payload);
//			clientSocket.fireAndForget(payload).block();

            RSocketClient client =
                new RSocketClient(connection, data.getBytes(), metadata);
            client.fireAndForget();
			i++;
		}


    }

}
