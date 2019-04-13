package com.linxu.pillow.service;

/**
 * @author linxu
 * @date 2019/4/13
 */
public interface EmbeddedService<T> {

    boolean resolve(T data);

}
