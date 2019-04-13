package com.linxu.pillow.handlers;

import com.linxu.pillow.service.EmbeddedService;
import com.linxu.pillow.utils.DateUtil;
import com.linxu.pillow.utils.EmptyUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
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
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println(s);
           boolean ret=embeddedService.resolve(s);
           if (ret){
               //修改为response
               channelHandlerContext.channel().flush();
           }else {
               log.error("数据格式出错，解析失败，数据是：{}",s);
               //关闭链接
               channelHandlerContext.close();
           }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
    }
    private void response(){

    }


}
