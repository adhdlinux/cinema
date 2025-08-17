package com.movie.data.model.trakt;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

public final class Person {
    @SerializedName("ids")
    private final Ids ids;
    @SerializedName("name")
    private final String name;

    public Person(Ids ids2, String str) {
        Intrinsics.f(ids2, "ids");
        Intrinsics.f(str, "name");
        this.ids = ids2;
        this.name = str;
    }

    public static /* synthetic */ Person copy$default(Person person, Ids ids2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            ids2 = person.ids;
        }
        if ((i2 & 2) != 0) {
            str = person.name;
        }
        return person.copy(ids2, str);
    }

    public final Ids component1() {
        return this.ids;
    }

    public final String component2() {
        return this.name;
    }

    public final Person copy(Ids ids2, String str) {
        Intrinsics.f(ids2, "ids");
        Intrinsics.f(str, "name");
        return new Person(ids2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;
        return Intrinsics.a(this.ids, person.ids) && Intrinsics.a(this.name, person.name);
    }

    public final Ids getIds() {
        return this.ids;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.ids.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "Person(ids=" + this.ids + ", name=" + this.name + ')';
    }
}
