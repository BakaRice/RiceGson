package com.ricemarch.gson;

/**
 * @author tanwentao
 * @since 2021/9/16
 */

public class JsonIOException extends JsonParseException{
    public JsonIOException(String msg) {
        super(msg);
    }

    public JsonIOException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public JsonIOException(Throwable cause) {
        super(cause);
    }
}
