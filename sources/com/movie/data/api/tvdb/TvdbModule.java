package com.movie.data.api.tvdb;

import com.uwetrottmann.thetvdb.TheTvdb;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class TvdbModule {

    class MyTvDB extends TheTvdb {
        public MyTvDB(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        public synchronized OkHttpClient okHttpClient() {
            OkHttpClient.Builder builder;
            builder = new OkHttpClient.Builder();
            setOkHttpClientDefaults(builder);
            return builder.build();
        }
    }

    /* access modifiers changed from: package-private */
    @Provides
    public TheTvdb a() {
        return new MyTvDB("6UMSCJSYNU96S28F");
    }
}
