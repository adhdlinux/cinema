package com.unity3d.services.core.di;

public interface IServiceComponent {

    public static final class DefaultImpls {
        public static IServiceProvider getServiceProvider(IServiceComponent iServiceComponent) {
            return ServiceProvider.INSTANCE;
        }
    }

    IServiceProvider getServiceProvider();
}
