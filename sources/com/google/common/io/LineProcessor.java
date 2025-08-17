package com.google.common.io;

import java.io.IOException;

public interface LineProcessor<T> {
    boolean a(String str) throws IOException;

    T getResult();
}
