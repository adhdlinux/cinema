package com.vungle.ads.fpd;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Serializable
public final class FirstPartyData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Map<String, String> _customData;
    private volatile Demographic _demographic;
    private volatile Location _location;
    private volatile Revenue _revenue;
    private volatile SessionContext _sessionContext;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<FirstPartyData> serializer() {
            return FirstPartyData$$serializer.INSTANCE;
        }
    }

    public FirstPartyData() {
    }

    private static /* synthetic */ void get_customData$annotations() {
    }

    private static /* synthetic */ void get_demographic$annotations() {
    }

    private static /* synthetic */ void get_location$annotations() {
    }

    private static /* synthetic */ void get_revenue$annotations() {
    }

    private static /* synthetic */ void get_sessionContext$annotations() {
    }

    public static final void write$Self(FirstPartyData firstPartyData, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Intrinsics.f(firstPartyData, "self");
        Intrinsics.f(compositeEncoder, "output");
        Intrinsics.f(serialDescriptor, "serialDesc");
        boolean z6 = false;
        if (!compositeEncoder.z(serialDescriptor, 0) && firstPartyData._sessionContext == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.i(serialDescriptor, 0, SessionContext$$serializer.INSTANCE, firstPartyData._sessionContext);
        }
        if (!compositeEncoder.z(serialDescriptor, 1) && firstPartyData._demographic == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            compositeEncoder.i(serialDescriptor, 1, Demographic$$serializer.INSTANCE, firstPartyData._demographic);
        }
        if (!compositeEncoder.z(serialDescriptor, 2) && firstPartyData._location == null) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            compositeEncoder.i(serialDescriptor, 2, Location$$serializer.INSTANCE, firstPartyData._location);
        }
        if (!compositeEncoder.z(serialDescriptor, 3) && firstPartyData._revenue == null) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z5) {
            compositeEncoder.i(serialDescriptor, 3, Revenue$$serializer.INSTANCE, firstPartyData._revenue);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || firstPartyData._customData != null) {
            z6 = true;
        }
        if (z6) {
            StringSerializer stringSerializer = StringSerializer.f41077a;
            compositeEncoder.i(serialDescriptor, 4, new LinkedHashMapSerializer(stringSerializer, stringSerializer), firstPartyData._customData);
        }
    }

    public final synchronized void clearAll() {
        this._sessionContext = null;
        this._demographic = null;
        this._location = null;
        this._revenue = null;
        Map<String, String> map = this._customData;
        if (map != null) {
            map.clear();
        }
        this._customData = null;
    }

    public final synchronized Map<String, String> getCustomData() {
        Map<String, String> map;
        map = this._customData;
        if (map == null) {
            map = new ConcurrentHashMap<>();
            this._customData = map;
        }
        return map;
    }

    public final synchronized Demographic getDemographic() {
        Demographic demographic;
        demographic = this._demographic;
        if (demographic == null) {
            demographic = new Demographic();
            this._demographic = demographic;
        }
        return demographic;
    }

    public final synchronized Location getLocation() {
        Location location;
        location = this._location;
        if (location == null) {
            location = new Location();
            this._location = location;
        }
        return location;
    }

    public final synchronized Revenue getRevenue() {
        Revenue revenue;
        revenue = this._revenue;
        if (revenue == null) {
            revenue = new Revenue();
            this._revenue = revenue;
        }
        return revenue;
    }

    public final synchronized SessionContext getSessionContext() {
        SessionContext sessionContext;
        sessionContext = this._sessionContext;
        if (sessionContext == null) {
            sessionContext = new SessionContext();
            this._sessionContext = sessionContext;
        }
        return sessionContext;
    }

    public /* synthetic */ FirstPartyData(int i2, SessionContext sessionContext, Demographic demographic, Location location, Revenue revenue, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i2 & 0) != 0) {
            PluginExceptionsKt.a(i2, 0, FirstPartyData$$serializer.INSTANCE.getDescriptor());
        }
        if ((i2 & 1) == 0) {
            this._sessionContext = null;
        } else {
            this._sessionContext = sessionContext;
        }
        if ((i2 & 2) == 0) {
            this._demographic = null;
        } else {
            this._demographic = demographic;
        }
        if ((i2 & 4) == 0) {
            this._location = null;
        } else {
            this._location = location;
        }
        if ((i2 & 8) == 0) {
            this._revenue = null;
        } else {
            this._revenue = revenue;
        }
        if ((i2 & 16) == 0) {
            this._customData = null;
        } else {
            this._customData = map;
        }
    }
}
