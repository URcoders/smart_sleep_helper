package com.linxu.pillow.service;

/**
 * @author linxu
 * @date 2019/4/13
 * once I think it doesn't need transaction.
 * but consider that the data can be read by another request,
 * so add transaction.
 */
public interface EmbeddedService<T> {

    boolean resolve(T data);

}
