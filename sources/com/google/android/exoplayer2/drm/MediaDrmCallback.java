package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.ExoMediaDrm;
import java.util.UUID;

public interface MediaDrmCallback {
    byte[] a(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws MediaDrmCallbackException;

    byte[] b(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws MediaDrmCallbackException;
}
