package com.ricemarch.gson;

import com.ricemarch.gson.internal.$Gson$Preconditions;
import com.ricemarch.gson.internal.LazilyParsedNumber;

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


    /**
     * Check whether this primitive contains a boolean value.
     *
     * @return true if this primitive contains a boolean value, false otherwise.
     */
    public boolean isBoolean() {
        return value instanceof Boolean;
    }

    /**
     * convenience method to get this element as a boolean value.
     *
     * @return get this element as a primitive boolean value.
     */
    @Override
    public boolean getAsBoolean() {
        if (isBoolean()) {
            return ((Boolean) value).booleanValue();
        }
        // Check to see if the value as a String is "true" in any case.
        return Boolean.parseBoolean(getAsString());
    }

    /**
     * Check whether this primitive contains a Number.
     *
     * @return true if this primitive contains a Number, false otherwise.
     */
    public boolean isNumber() {
        return value instanceof Number;
    }

    @Override
    public Number getAsNumber() {
        return value instanceof String ? new LazilyParsedNumber((String) value) : (Number) value;
    }

    public boolean isString() {
        return value instanceof String;
    }

    @Override
    public String getAsString() {
        if (isNumber()) {
            return getAsNumber().toString();
        } else if (isBoolean()) {
            return ((Boolean) value).toString();
        } else {
            return (String) value;
        }
    }

}
