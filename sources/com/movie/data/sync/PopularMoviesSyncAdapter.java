package com.movie.data.sync;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import timber.log.Timber;

public class PopularMoviesSyncAdapter extends AbstractThreadedSyncAdapter {
    public PopularMoviesSyncAdapter(Context context, boolean z2) {
        super(context, z2);
    }

    public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        Timber.b("onPerformSync Called.", new Object[0]);
    }
}
