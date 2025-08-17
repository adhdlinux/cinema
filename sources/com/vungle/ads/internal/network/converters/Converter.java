package com.vungle.ads.internal.network.converters;

import java.io.IOException;

public interface Converter<In, Out> {
    Out convert(In in) throws IOException;
}
