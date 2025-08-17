package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;

class ProtobufValueEncoderContext implements ValueEncoderContext {

    /* renamed from: a  reason: collision with root package name */
    private boolean f30820a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f30821b = false;

    /* renamed from: c  reason: collision with root package name */
    private FieldDescriptor f30822c;

    /* renamed from: d  reason: collision with root package name */
    private final ProtobufDataEncoderContext f30823d;

    ProtobufValueEncoderContext(ProtobufDataEncoderContext protobufDataEncoderContext) {
        this.f30823d = protobufDataEncoderContext;
    }

    private void a() {
        if (!this.f30820a) {
            this.f30820a = true;
            return;
        }
        throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
    }

    public ValueEncoderContext b(String str) throws IOException {
        a();
        this.f30823d.f(this.f30822c, str, this.f30821b);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void c(FieldDescriptor fieldDescriptor, boolean z2) {
        this.f30820a = false;
        this.f30822c = fieldDescriptor;
        this.f30821b = z2;
    }

    public ValueEncoderContext d(boolean z2) throws IOException {
        a();
        this.f30823d.k(this.f30822c, z2, this.f30821b);
        return this;
    }
}
