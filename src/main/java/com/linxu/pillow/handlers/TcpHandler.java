package com.linxu.pillow.handlers;

import com.linxu.pillow.service.EmbeddedService;
import com.linxu.pillow.utils.DateUtil;
import com.linxu.pillow.utils.EmptyUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.ReadTimeoutException;
import io.netty.handler.timeout.WriteTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author linxu
 * @date 2019/4/13
 */
@Component
@ChannelHandler.Sharable
@Slf4j
public class TcpHandler extends SimpleChannelInboundHandler<String> {
    @Autowired
    private EmbeddedService embeddedService;
    private static final String PONG_MSG = "2";

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        if (embeddedService.resolve(s)) {
            //修改为response
            channelHandlerContext.channel().writeAndFlush(PONG_MSG);
        } else {
            log.error("数据格式出错，解析失败，数据是：{}", s);
            //关闭链接
            channelHandlerContext.close();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Throwable t = cause.getCause();
        if (t instanceof ReadTimeoutException) {
            log.info("read time out");
        } else if (t instanceof WriteTimeoutException) {
            log.info("write time out");
        }
        ctx.channel().close();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        //心跳新增对不活动链接的处理
        if (evt instanceof IdleStateEvent) {
            log.warn("close the channel not active , remote address :{}", ctx.channel().remoteAddress());
            ctx.channel().close();
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
    }

}
