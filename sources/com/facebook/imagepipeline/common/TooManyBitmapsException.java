package com.facebook.imagepipeline.common;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class TooManyBitmapsException extends RuntimeException {
    public TooManyBitmapsException() {
    }

    public TooManyBitmapsException(String str) {
        super(str);
    }
}
