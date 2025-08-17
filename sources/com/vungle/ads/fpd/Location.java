package com.vungle.ads.fpd;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Serializable
public final class Location {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private String country;
    private Integer dma;
    private String regionState;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Location> serializer() {
            return Location$$serializer.INSTANCE;
        }
    }

    public Location() {
    }

    private static /* synthetic */ void getCountry$annotations() {
    }

    private static /* synthetic */ void getDma$annotations() {
    }

    private static /* synthetic */ void getRegionState$annotations() {
    }

    public static final void write$Self(Location location, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z2;
        boolean z3;
        Intrinsics.f(location, "self");
        Intrinsics.f(compositeEncoder, "output");
        Intrinsics.f(serialDescriptor, "serialDesc");
        boolean z4 = false;
        if (!compositeEncoder.z(serialDescriptor, 0) && location.country == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.i(serialDescriptor, 0, StringSerializer.f41077a, location.country);
        }
        if (!compositeEncoder.z(serialDescriptor, 1) && location.regionState == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            compositeEncoder.i(serialDescriptor, 1, StringSerializer.f41077a, location.regionState);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || location.dma != null) {
            z4 = true;
        }
        if (z4) {
            compositeEncoder.i(serialDescriptor, 2, IntSerializer.f41006a, location.dma);
        }
    }

    public final Location setCountry(String str) {
        Intrinsics.f(str, "country");
        this.country = str;
        return this;
    }

    public final Location setDma(int i2) {
        this.dma = Integer.valueOf(i2);
        return this;
    }

    public final Location setRegionState(String str) {
        Intrinsics.f(str, "regionState");
        this.regionState = str;
        return this;
    }

    public /* synthetic */ Location(int i2, String str, String str2, Integer num, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i2 & 0) != 0) {
            PluginExceptionsKt.a(i2, 0, Location$$serializer.INSTANCE.getDescriptor());
        }
        if ((i2 & 1) == 0) {
            this.country = null;
        } else {
            this.country = str;
        }
        if ((i2 & 2) == 0) {
            this.regionState = null;
        } else {
            this.regionState = str2;
        }
        if ((i2 & 4) == 0) {
            this.dma = null;
        } else {
            this.dma = num;
        }
    }
}
