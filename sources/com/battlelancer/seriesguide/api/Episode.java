package com.battlelancer.seriesguide.api;

import android.os.Bundle;

public class Episode {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f16074a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Integer f16075b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Integer f16076c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Integer f16077d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Integer f16078e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f16079f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f16080g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Integer f16081h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f16082i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f16083j;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Episode f16084a = new Episode();

        public Episode a() {
            return this.f16084a;
        }

        public Builder b(String str) {
            String unused = this.f16084a.f16079f = str;
            return this;
        }

        public Builder c(Integer num) {
            Integer unused = this.f16084a.f16075b = num;
            return this;
        }

        public Builder d(Integer num) {
            Integer unused = this.f16084a.f16076c = num;
            return this;
        }

        public Builder e(Integer num) {
            Integer unused = this.f16084a.f16077d = num;
            return this;
        }

        public Builder f(String str) {
            String unused = this.f16084a.f16083j = str;
            return this;
        }

        public Builder g(String str) {
            String unused = this.f16084a.f16082i = str;
            return this;
        }

        public Builder h(String str) {
            String unused = this.f16084a.f16080g = str;
            return this;
        }

        public Builder i(Integer num) {
            Integer unused = this.f16084a.f16081h = num;
            return this;
        }

        public Builder j(String str) {
            String unused = this.f16084a.f16074a = str;
            return this;
        }

        public Builder k(Integer num) {
            Integer unused = this.f16084a.f16078e = num;
            return this;
        }
    }

    public static Episode k(Bundle bundle) {
        return new Builder().j(bundle.getString("title")).c(Integer.valueOf(bundle.getInt("number"))).d(Integer.valueOf(bundle.getInt("numberAbsolute"))).e(Integer.valueOf(bundle.getInt("season"))).k(Integer.valueOf(bundle.getInt("tvdbid"))).b(bundle.getString("imdbid")).h(bundle.getString("showTitle")).i(Integer.valueOf(bundle.getInt("showTvdbId"))).g(bundle.getString("showImdbId")).f(bundle.getString("showFirstReleaseDate")).a();
    }

    public String l() {
        return this.f16079f;
    }

    public Integer m() {
        return this.f16075b;
    }

    public Integer n() {
        return this.f16077d;
    }

    public String o() {
        return this.f16083j;
    }

    public String p() {
        return this.f16082i;
    }

    public String q() {
        return this.f16080g;
    }

    public Integer r() {
        return this.f16081h;
    }

    public Bundle s() {
        Bundle bundle = new Bundle();
        bundle.putString("title", this.f16074a);
        bundle.putInt("number", this.f16075b.intValue());
        bundle.putInt("numberAbsolute", this.f16076c.intValue());
        bundle.putInt("season", this.f16077d.intValue());
        bundle.putInt("tvdbid", this.f16078e.intValue());
        bundle.putString("imdbid", this.f16079f);
        bundle.putString("showTitle", this.f16080g);
        bundle.putInt("showTvdbId", this.f16081h.intValue());
        bundle.putString("showImdbId", this.f16082i);
        bundle.putString("showFirstReleaseDate", this.f16083j);
        return bundle;
    }

    private Episode() {
    }
}
