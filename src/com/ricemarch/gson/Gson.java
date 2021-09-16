package com.ricemarch.gson;


import com.ricemarch.gson.internal.Primitives;
import com.ricemarch.gson.stream.JsonReader;

import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;

/**
 * @author tanwentao
 * @since 2021/9/15
 */

public class Gson {

    public Gson() {
    }


    public <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        Object object = this.fromJson(json, (Type) classOfT);
        return Primitives.wrap(classOfT).cast(object);
    }

    public <T> T fromJson(String json, Type typeOfT) throws JsonSyntaxException {
        if (json == null) {
            return null;
        }
        StringReader reader = new StringReader(json);
        T target = (T) fromJson(reader, typeOfT);
        return target;
    }

    public <T> T fromJson(Reader json, Class<T> classOfT) throws JsonSyntaxException, JsonIOException {
        return null;
    }

    public <T> T fromJson(Reader reader, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return null;
    }


    public <T> T fromJson(JsonReader reader, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return null;
    }

    // public <T> T fromJson(JsonEl)

}
