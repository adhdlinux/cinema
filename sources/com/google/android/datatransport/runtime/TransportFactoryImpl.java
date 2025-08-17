package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import java.util.Set;

final class TransportFactoryImpl implements TransportFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Encoding> f22517a;

    /* renamed from: b  reason: collision with root package name */
    private final TransportContext f22518b;

    /* renamed from: c  reason: collision with root package name */
    private final TransportInternal f22519c;

    TransportFactoryImpl(Set<Encoding> set, TransportContext transportContext, TransportInternal transportInternal) {
        this.f22517a = set;
        this.f22518b = transportContext;
        this.f22519c = transportInternal;
    }

    public <T> Transport<T> a(String str, Class<T> cls, Encoding encoding, Transformer<T, byte[]> transformer) {
        if (this.f22517a.contains(encoding)) {
            return new TransportImpl(this.f22518b, str, encoding, transformer, this.f22519c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[]{encoding, this.f22517a}));
    }
}
