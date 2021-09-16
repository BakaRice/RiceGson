package com.ricemarch.gson;

import com.ricemarch.gson.internal.LinkedTreeMap;

/**
 * A class representing an object type in Json. An object consists of name-value pairs where names
 * are strings, and values are any other type of {@link JsonElement}. This allows for a creating a
 * tree of JsonElements. The member elements of this object are maintained in order they were added.
 *
 * @author Inderjeet Singh
 * @author Joel Leitch
 * @author tanwentao
 * @since 2021/9/16
 */
public final class JsonObject extends JsonElement {

    private final LinkedTreeMap<String,JsonElement> members = new LinkedTreeMap<>();
    @Override
    public JsonElement deepCopy() {
        JsonObject result = new JsonObject();

        return null;
    }
}
