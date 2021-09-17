package com.ricemarch.gson;

import com.ricemarch.gson.internal.LinkedTreeMap;

import java.util.Map;
import java.util.Set;

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

    private final LinkedTreeMap<String, JsonElement> members = new LinkedTreeMap<>();

    @Override
    public JsonElement deepCopy() {
        JsonObject result = new JsonObject();
        for (Map.Entry<String, JsonElement> entry : members.entrySet()) {
            result.add(entry.getKey(), entry.getValue().deepCopy());
        }
        return result;
    }

    /**
     * Adds a member, which is a name-value pair, to self. The name must be a String, but the value
     * can be an arbitrary JsonElement, thereby allowing you to build a full tree of JsonElements
     * rooted at this node.
     *
     * @param property name of the member.
     * @param value    the member object.
     */
    public void add(String property, JsonElement value) {
        members.put(property, value == null ? JsonNull.INSTANCE : value);
    }

    public JsonElement remove(String property) {
        return members.remove(property);
    }

    /**
     * 快捷添加primitive成员的方法，特别为了能够转换为String类型的JsonPrimitive
     */
    public void addProperty(String property, String value) {
        add(property, value == null ? JsonNull.INSTANCE : new JsonPrimitive(value));
    }

    public void addProperty(String property, Number value) {
        add(property, value == null ? JsonNull.INSTANCE : new JsonPrimitive(value));
    }

    public void addProperty(String property, Boolean value) {
        add(property, value == null ? JsonNull.INSTANCE : new JsonPrimitive(value));
    }

    public void addProperty(String property, Character value) {
        add(property, value == null ? JsonNull.INSTANCE : new JsonPrimitive(value));
    }

    /**
     * 返回set集合的成员对象，这个集合是有序的，且按照添加顺序进行排序
     *
     * @return a set of members of this object.
     */
    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return members.entrySet();
    }

    /**
     * returns a set of members key values
     *
     * @return a set of member keys as Strings
     */
    public Set<String> keySet() {
        return members.keySet();
    }

    /**
     * Returns the number of key/value pairs in the object.
     *
     * @return the number of key/value pairs in the object.
     */
    public int size() {
        return members.size();
    }

    /**
     * Convenience method to check if a member with the specified name is present in this object.
     *
     * @param memberName name of the member that is being checked for presence.
     * @return true if there is a member with the specified name, false otherwise.
     */
    public boolean has(String memberName) {
        return members.containsKey(memberName);
    }

    /**
     * Returns the member with the specified name.
     *
     * @param memberName name of the member that is being requested.
     * @return the member matching the name. Null if no such member exists.
     */
    public JsonElement get(String memberName) {
        return members.get(memberName);
    }

    /**
     * Convenience method to get the specified member as a JsonPrimitive element.
     *
     * @param memberName name of the member being requested.
     * @return the JsonPrimitive corresponding to the specified member.
     */
    public JsonPrimitive getAsJsonPrimitive(String memberName) {
        return (JsonPrimitive) members.get(memberName);
    }

    /**
     * Convenience method to get the specified member as a JsonArray.
     *
     * @param memberName name of the member being requested.
     * @return the JsonArray corresponding to the specified member.
     */
    public JsonArray getAsJsonArray(String memberName) {
        return (JsonArray) members.get(memberName);
    }

    /**
     * Convenience method to get the specified member as a JsonObject.
     *
     * @param memberName name of the member being requested.
     * @return the JsonObject corresponding to the specified member.
     */
    public JsonObject getAsJsonObject(String memberName) {
        return (JsonObject) members.get(memberName);
    }

    @Override
    public int hashCode() {
        return members.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj == this) || (obj instanceof JsonObject && (((JsonObject) obj).members.equals(members)));
    }
}
