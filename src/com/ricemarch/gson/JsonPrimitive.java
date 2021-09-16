package com.ricemarch.gson;

import com.ricemarch.gson.internal.$Gson$Preconditions;

/**
 * A Class representing a Json primitive value. A primitive value
 * is either a String, a Java primitive, or a Java primitive
 *
 * @author Inderjeet Singh
 * @author Joel Leitch
 * @author tanwentao
 * @since 2021/9/16
 */

public class JsonPrimitive extends JsonElement {

    private final Object value;

    @Override
    public JsonElement deepCopy() {
        return this;
    }

    /**
     * create a primitive containing a boolean value.
     *
     * @param bool the value to create the primitive with.
     */
    public JsonPrimitive(Boolean bool) {
        value = $Gson$Preconditions.checkNotNull(bool);
    }

    /**
     * create a primitive containing a string value.
     *
     * @param number the value to create the primitive with.
     */
    public JsonPrimitive(Number number) {
        value = $Gson$Preconditions.checkNotNull(number);
    }

    /**
     * Create a primitive containing a character. The character is turned into a one character string
     * since Json only supports String.
     *
     * @param string the value to create the primitive with.
     */
    public JsonPrimitive(String string) {
        value = $Gson$Preconditions.checkNotNull(string);
    }

    /**
     * create a primitive containing a character. The charater is turned into a one character String
     * since Json only supports String.
     *
     * @param character the value to create the primitive with.
     */
    public JsonPrimitive(Character character) {
        value = $Gson$Preconditions.checkNotNull(character).toString();
    }


}
