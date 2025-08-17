package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.proto.Protobuf;
import java.lang.annotation.Annotation;

public final class AtProtobuf {

    /* renamed from: a  reason: collision with root package name */
    private int f30794a;

    /* renamed from: b  reason: collision with root package name */
    private Protobuf.IntEncoding f30795b = Protobuf.IntEncoding.DEFAULT;

    private static final class ProtobufImpl implements Protobuf {

        /* renamed from: a  reason: collision with root package name */
        private final int f30796a;

        /* renamed from: b  reason: collision with root package name */
        private final Protobuf.IntEncoding f30797b;

        ProtobufImpl(int i2, Protobuf.IntEncoding intEncoding) {
            this.f30796a = i2;
            this.f30797b = intEncoding;
        }

        public Class<? extends Annotation> annotationType() {
            return Protobuf.class;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Protobuf)) {
                return false;
            }
            Protobuf protobuf = (Protobuf) obj;
            if (this.f30796a != protobuf.tag() || !this.f30797b.equals(protobuf.intEncoding())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (14552422 ^ this.f30796a) + (this.f30797b.hashCode() ^ 2041407134);
        }

        public Protobuf.IntEncoding intEncoding() {
            return this.f30797b;
        }

        public int tag() {
            return this.f30796a;
        }

        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf" + '(' + "tag=" + this.f30796a + "intEncoding=" + this.f30797b + ')';
        }
    }

    public static AtProtobuf b() {
        return new AtProtobuf();
    }

    public Protobuf a() {
        return new ProtobufImpl(this.f30794a, this.f30795b);
    }

    public AtProtobuf c(int i2) {
        this.f30794a = i2;
        return this;
    }
}
