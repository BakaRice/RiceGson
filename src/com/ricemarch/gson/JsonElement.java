package com.ricemarch.gson;


/**
 * A class representing an element of Json. It could either be a {@link JsonObject}, a
 * {@link JsonArray}, a {@link JsonPrimitive} or a {@link JsonNull}.
 *
 * @author tanwentao
 * @since 2021/9/16
 */

public abstract class JsonElement {

    public boolean isJsonArray() {
        return this instanceof JsonArray;
    }
}
