package com.google.ar.core;

public interface Future {
    boolean cancel();

    FutureState getState();
}
