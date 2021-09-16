package com.ricemarch.gson;

/**
 * A class representing a Json {@code null} value.
 *
 * @author Inderjeet Singh
 * @author Joel Leitch
 * @author tanwentao
 * @since 2021/9/16
 */

public class JsonNull extends JsonElement {

    public static final JsonNull INSTANCE = new JsonNull();

    /**
     * creates a nee JsonNull object
     * Deprecated since Gson version 1.8. Use {@link #INSTANCE} instead.
     * so just remove the code
     */
    // @Deprecated
    // public JsonNull() {
    // Do nothing
    // }
    private JsonNull() {

    }

    /**
     * All instances of JsonNull have the same hash code since they are indistinguishable
     */
    @Override
    public int hashCode() {
        return JsonNull.class.hashCode();
    }

    /**
     * All instances of JsonNull are the same
     */
    @Override
    public boolean equals(Object other) {
        // return this == other || other instanceof JsonNull;
        return other instanceof JsonNull;
    }
}
