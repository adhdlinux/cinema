package com.vungle.ads.internal.network;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable
public enum HttpMethod {
    GET,
    POST;
    
    public static final Companion Companion = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<HttpMethod> serializer() {
            return HttpMethod$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }
}
