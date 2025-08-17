package com.utils.subtitle.services.openSubtitle.models;

import kotlin.jvm.internal.Intrinsics;

public final class Data {
    private final Attributes attributes;
    private final String id;
    private final String type;

    public Data(Attributes attributes2, String str, String str2) {
        Intrinsics.f(attributes2, "attributes");
        Intrinsics.f(str, "id");
        Intrinsics.f(str2, "type");
        this.attributes = attributes2;
        this.id = str;
        this.type = str2;
    }

    public static /* synthetic */ Data copy$default(Data data, Attributes attributes2, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            attributes2 = data.attributes;
        }
        if ((i2 & 2) != 0) {
            str = data.id;
        }
        if ((i2 & 4) != 0) {
            str2 = data.type;
        }
        return data.copy(attributes2, str, str2);
    }

    public final Attributes component1() {
        return this.attributes;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.type;
    }

    public final Data copy(Attributes attributes2, String str, String str2) {
        Intrinsics.f(attributes2, "attributes");
        Intrinsics.f(str, "id");
        Intrinsics.f(str2, "type");
        return new Data(attributes2, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Data)) {
            return false;
        }
        Data data = (Data) obj;
        return Intrinsics.a(this.attributes, data.attributes) && Intrinsics.a(this.id, data.id) && Intrinsics.a(this.type, data.type);
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.attributes.hashCode() * 31) + this.id.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "Data(attributes=" + this.attributes + ", id=" + this.id + ", type=" + this.type + ')';
    }
}
