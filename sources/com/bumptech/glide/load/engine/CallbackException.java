package com.bumptech.glide.load.engine;

final class CallbackException extends RuntimeException {
    CallbackException(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
