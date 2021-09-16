package com.ricemarch.gson;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * A class representing an array type in Json. An array is a list of {@link JsonElement}s each of
 * which can be of a different type. This is an ordered list, meaning that the order in which
 * elements are added is preserved.
 *
 * @author Inderjeet Singh
 * @author Joel Leitch
 * @author tanwentao
 * @since 2021/9/16
 */

public class JsonArray extends JsonElement implements Iterable<JsonElement> {
    private final List<JsonElement> elements;

    /**
     * creates an empty JsonArray.
     */
    public JsonArray() {
        this.elements = new ArrayList<>();
    }

    public JsonArray(int capacity) {
        this.elements = new ArrayList<>(capacity);
    }

    /**
     * Add the specified boolean to self
     *
     * @param bool the boolean that needs to be added to the array.
     */
    public void add(Boolean bool) {
        elements.add(bool == null ? JsonNull.INSTANCE : new JsonPrimitive(bool));
    }

    @Override
    public Iterator<JsonElement> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super JsonElement> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<JsonElement> spliterator() {
        return Iterable.super.spliterator();
    }
}
