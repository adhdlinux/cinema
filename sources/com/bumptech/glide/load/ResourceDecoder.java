package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

public interface ResourceDecoder<T, Z> {
    boolean a(T t2, Options options) throws IOException;

    Resource<Z> b(T t2, int i2, int i3, Options options) throws IOException;
}
