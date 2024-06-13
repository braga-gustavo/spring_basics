package com.github.braga_gustavo.lambaspring.service;

public interface  IDataConverter {

    <T> T getData(String json, Class<T> convertedClas);
}
