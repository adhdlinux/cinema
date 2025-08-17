package com.vungle.ads.internal.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

@Serializable
public final class AppNode {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String appId;
    private final String bundle;
    private final String ver;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<AppNode> serializer() {
            return AppNode$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AppNode(int i2, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i2 & 7)) {
            PluginExceptionsKt.a(i2, 7, AppNode$$serializer.INSTANCE.getDescriptor());
        }
        this.bundle = str;
        this.ver = str2;
        this.appId = str3;
    }

    public static /* synthetic */ AppNode copy$default(AppNode appNode, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = appNode.bundle;
        }
        if ((i2 & 2) != 0) {
            str2 = appNode.ver;
        }
        if ((i2 & 4) != 0) {
            str3 = appNode.appId;
        }
        return appNode.copy(str, str2, str3);
    }

    public static /* synthetic */ void getAppId$annotations() {
    }

    public static final void write$Self(AppNode appNode, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.f(appNode, "self");
        Intrinsics.f(compositeEncoder, "output");
        Intrinsics.f(serialDescriptor, "serialDesc");
        compositeEncoder.y(serialDescriptor, 0, appNode.bundle);
        compositeEncoder.y(serialDescriptor, 1, appNode.ver);
        compositeEncoder.y(serialDescriptor, 2, appNode.appId);
    }

    public final String component1() {
        return this.bundle;
    }

    public final String component2() {
        return this.ver;
    }

    public final String component3() {
        return this.appId;
    }

    public final AppNode copy(String str, String str2, String str3) {
        Intrinsics.f(str, "bundle");
        Intrinsics.f(str2, "ver");
        Intrinsics.f(str3, "appId");
        return new AppNode(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppNode)) {
            return false;
        }
        AppNode appNode = (AppNode) obj;
        return Intrinsics.a(this.bundle, appNode.bundle) && Intrinsics.a(this.ver, appNode.ver) && Intrinsics.a(this.appId, appNode.appId);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getBundle() {
        return this.bundle;
    }

    public final String getVer() {
        return this.ver;
    }

    public int hashCode() {
        return (((this.bundle.hashCode() * 31) + this.ver.hashCode()) * 31) + this.appId.hashCode();
    }

    public String toString() {
        return "AppNode(bundle=" + this.bundle + ", ver=" + this.ver + ", appId=" + this.appId + ')';
    }

    public AppNode(String str, String str2, String str3) {
        Intrinsics.f(str, "bundle");
        Intrinsics.f(str2, "ver");
        Intrinsics.f(str3, "appId");
        this.bundle = str;
        this.ver = str2;
        this.appId = str3;
    }
}
