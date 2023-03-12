package gur.explore.rsocket;

import io.netty.channel.ChannelOption;
import io.rsocket.SocketAcceptor;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.ServerTransport;
import io.rsocket.transport.netty.server.CloseableChannel;
import io.rsocket.transport.netty.server.TcpServerTransport;
import reactor.core.publisher.Mono;
import reactor.netty.tcp.TcpServer;

public class Server {

    private String host="127.0.0.1";

    private int port=9000;

}
