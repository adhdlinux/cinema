package com.battlelancer.seriesguide.api;

import android.os.Bundle;
import com.facebook.common.time.Clock;
import java.util.Date;

public class Movie {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f16085a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Integer f16086b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f16087c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Date f16088d;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Movie f16089a = new Movie();

        public Movie a() {
            return this.f16089a;
        }

        public Builder b(String str) {
            String unused = this.f16089a.f16087c = str;
            return this;
        }

        public Builder c(Date date) {
            Date unused = this.f16089a.f16088d = date;
            return this;
        }

        public Builder d(String str) {
            String unused = this.f16089a.f16085a = str;
            return this;
        }

        public Builder e(Integer num) {
            Integer unused = this.f16089a.f16086b = num;
            return this;
        }
    }

    public static Movie e(Bundle bundle) {
        Date date;
        long j2 = bundle.getLong("releaseDate", Clock.MAX_TIME);
        Builder b2 = new Builder().d(bundle.getString("title")).e(Integer.valueOf(bundle.getInt("tmdbid"))).b(bundle.getString("imdbid"));
        if (j2 == Clock.MAX_TIME) {
            date = null;
        } else {
            date = new Date(j2);
        }
        return b2.c(date).a();
    }

    public String f() {
        return this.f16087c;
    }

    public Date g() {
        return this.f16088d;
    }

    public String h() {
        return this.f16085a;
    }

    public Integer i() {
        return this.f16086b;
    }

    private Movie() {
    }
}
