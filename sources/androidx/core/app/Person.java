package androidx.core.app;

import android.app.Person;
import android.graphics.drawable.Icon;
import androidx.core.graphics.drawable.IconCompat;

public class Person {

    /* renamed from: a  reason: collision with root package name */
    CharSequence f2444a;

    /* renamed from: b  reason: collision with root package name */
    IconCompat f2445b;

    /* renamed from: c  reason: collision with root package name */
    String f2446c;

    /* renamed from: d  reason: collision with root package name */
    String f2447d;

    /* renamed from: e  reason: collision with root package name */
    boolean f2448e;

    /* renamed from: f  reason: collision with root package name */
    boolean f2449f;

    static class Api28Impl {
        private Api28Impl() {
        }

        static Person a(android.app.Person person) {
            IconCompat iconCompat;
            Builder f2 = new Builder().f(person.getName());
            if (person.getIcon() != null) {
                iconCompat = IconCompat.b(person.getIcon());
            } else {
                iconCompat = null;
            }
            return f2.c(iconCompat).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        static android.app.Person b(Person person) {
            Icon icon;
            Person.Builder a2 = new Person.Builder().setName(person.c());
            if (person.a() != null) {
                icon = person.a().p();
            } else {
                icon = null;
            }
            return a2.setIcon(icon).setUri(person.d()).setKey(person.b()).setBot(person.e()).setImportant(person.f()).build();
        }
    }

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        CharSequence f2450a;

        /* renamed from: b  reason: collision with root package name */
        IconCompat f2451b;

        /* renamed from: c  reason: collision with root package name */
        String f2452c;

        /* renamed from: d  reason: collision with root package name */
        String f2453d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2454e;

        /* renamed from: f  reason: collision with root package name */
        boolean f2455f;

        public Person a() {
            return new Person(this);
        }

        public Builder b(boolean z2) {
            this.f2454e = z2;
            return this;
        }

        public Builder c(IconCompat iconCompat) {
            this.f2451b = iconCompat;
            return this;
        }

        public Builder d(boolean z2) {
            this.f2455f = z2;
            return this;
        }

        public Builder e(String str) {
            this.f2453d = str;
            return this;
        }

        public Builder f(CharSequence charSequence) {
            this.f2450a = charSequence;
            return this;
        }

        public Builder g(String str) {
            this.f2452c = str;
            return this;
        }
    }

    Person(Builder builder) {
        this.f2444a = builder.f2450a;
        this.f2445b = builder.f2451b;
        this.f2446c = builder.f2452c;
        this.f2447d = builder.f2453d;
        this.f2448e = builder.f2454e;
        this.f2449f = builder.f2455f;
    }

    public IconCompat a() {
        return this.f2445b;
    }

    public String b() {
        return this.f2447d;
    }

    public CharSequence c() {
        return this.f2444a;
    }

    public String d() {
        return this.f2446c;
    }

    public boolean e() {
        return this.f2448e;
    }

    public boolean f() {
        return this.f2449f;
    }

    public String g() {
        String str = this.f2446c;
        if (str != null) {
            return str;
        }
        if (this.f2444a == null) {
            return "";
        }
        return "name:" + this.f2444a;
    }

    public android.app.Person h() {
        return Api28Impl.b(this);
    }
}
