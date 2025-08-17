package com.google.android.datatransport;

public interface TransportFactory {
    <T> Transport<T> a(String str, Class<T> cls, Encoding encoding, Transformer<T, byte[]> transformer);
}
