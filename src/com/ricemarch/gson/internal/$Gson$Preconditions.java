package com.ricemarch.gson.internal;

/**
 * A simple utility class used to check method Preconditions.
 *
 * <pre>
 *     public log divideBy(long value){
 *         Preconditions.checkArgument(value != 0);
 *         return this.value / value;
 *     }
 * </pre>
 *
 * @author Inderjeet Singh
 * @author Joel Leitch
 * @author tanwentao
 * @since 2021/9/16
 */

public class $Gson$Preconditions {

    private $Gson$Preconditions() {
        throw new UnsupportedOperationException();
    }

    public static <T> T checkNotNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return obj;
    }

    public static void checkArgument(boolean condition) {
        if (!condition) {
            throw new IllegalArgumentException();
        }
    }
}
