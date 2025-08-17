package com.unity3d.services.core.configuration;

public interface IInitializationNotificationCenter {
    void addListener(IInitializationListener iInitializationListener);

    void removeListener(IInitializationListener iInitializationListener);

    void triggerOnSdkInitializationFailed(String str, ErrorState errorState, int i2);

    void triggerOnSdkInitialized();
}
