package com.linxu.pillow.handlers;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author linxu
 * @date 2019/4/13
 */
@Component
@Qualifier("initHandler")
public class InitHandler extends ChannelInitializer<SocketChannel> {
    @Autowired
    private StringDecoder decoder;

    @Autowired
    private StringEncoder encoder;

    @Autowired
    private TcpHandler tcpHandler;

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline()
                .addLast("idleStateHandler", new IdleStateHandler(10, 20, 30, TimeUnit.SECONDS))
                .addLast(decoder)
                .addLast(encoder)
                .addLast(tcpHandler)
        ;
    }
}

