package com.ricemarch.gson;

/**
 * @author tanwentao
 * @since 2021/9/16
 */

public class JsonParseException extends RuntimeException {

    public JsonParseException(String msg) {
        super(msg);
    }

    public JsonParseException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public JsonParseException(Throwable cause) {
        super(cause);
    }
}
