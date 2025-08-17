package com.unity3d.services.core.configuration;

public interface IInitializationListener {
    void onSdkInitializationFailed(String str, ErrorState errorState, int i2);

    void onSdkInitialized();
}
