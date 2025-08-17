package com.google.android.gms.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

public interface SettingsClient extends HasApiKey<Api.ApiOptions.NoOptions> {
    Task<LocationSettingsResponse> checkLocationSettings(LocationSettingsRequest locationSettingsRequest);
}
