package com.domain.api.provider;

import android.content.ContentValues;
import android.net.Uri;

public interface ProviderClient {
    Uri a();

    Uri b(ContentValues contentValues);
}
