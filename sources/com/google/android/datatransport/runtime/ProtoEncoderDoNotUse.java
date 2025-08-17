package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.firebase.encoders.proto.ProtobufEncoder;

public abstract class ProtoEncoderDoNotUse {

    /* renamed from: a  reason: collision with root package name */
    private static final ProtobufEncoder f22514a = ProtobufEncoder.a().d(AutoProtoEncoderDoNotUseEncoder.f22447a).c();

    private ProtoEncoderDoNotUse() {
    }

    public static byte[] a(Object obj) {
        return f22514a.c(obj);
    }

    public abstract ClientMetrics b();
}
