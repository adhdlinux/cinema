package com.unity3d.services.core.di;

public interface IServiceProvider {
    IServicesRegistry getRegistry();

    IServicesRegistry initialize();
}
