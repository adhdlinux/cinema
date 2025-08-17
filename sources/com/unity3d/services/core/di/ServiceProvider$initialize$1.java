package com.unity3d.services.core.di;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.unity3d.services.ads.measurements.MeasurementsService;
import com.unity3d.services.ads.token.AsyncTokenStorage;
import com.unity3d.services.ads.token.INativeTokenGenerator;
import com.unity3d.services.ads.token.InMemoryAsyncTokenStorage;
import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.ads.topics.TopicsService;
import com.unity3d.services.core.device.VolumeChange;
import com.unity3d.services.core.device.VolumeChangeMonitor;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.domain.task.InitializeSDK;
import com.unity3d.services.core.domain.task.InitializeStateComplete;
import com.unity3d.services.core.domain.task.InitializeStateConfig;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import com.unity3d.services.core.domain.task.InitializeStateCreate;
import com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote;
import com.unity3d.services.core.domain.task.InitializeStateError;
import com.unity3d.services.core.domain.task.InitializeStateLoadCache;
import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import com.unity3d.services.core.domain.task.InitializeStateReset;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.request.metrics.SDKMetrics;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;

final class ServiceProvider$initialize$1 extends Lambda implements Function1<ServicesRegistry, Unit> {
    public static final ServiceProvider$initialize$1 INSTANCE = new ServiceProvider$initialize$1();

    ServiceProvider$initialize$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ServicesRegistry) obj);
        return Unit.f40298a;
    }

    public final void invoke(final ServicesRegistry servicesRegistry) {
        Intrinsics.f(servicesRegistry, "$this$registry");
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(SDKMetricsSender.class)), LazyKt__LazyJVMKt.b(AnonymousClass1.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(ISDKDispatchers.class)), LazyKt__LazyJVMKt.b(AnonymousClass2.INSTANCE));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.NAMED_SDK, Reflection.b(CoroutineExceptionHandler.class)), LazyKt__LazyJVMKt.b(new Function0<CoroutineExceptionHandler>() {
            public final CoroutineExceptionHandler invoke() {
                return ServiceProvider.INSTANCE.provideSDKErrorHandler((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ISDKDispatchers.class))), (SDKMetricsSender) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(SDKMetricsSender.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey(ServiceProvider.NAMED_SDK, Reflection.b(CoroutineScope.class)), LazyKt__LazyJVMKt.b(new Function0<CoroutineScope>() {
            public final CoroutineScope invoke() {
                return ServiceProvider.INSTANCE.provideSDKScope((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ISDKDispatchers.class))), (CoroutineExceptionHandler) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.NAMED_SDK, Reflection.b(CoroutineExceptionHandler.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(HttpClient.class)), LazyKt__LazyJVMKt.b(new Function0<HttpClient>() {
            public final HttpClient invoke() {
                return ServiceProvider.INSTANCE.provideHttpClient((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ISDKDispatchers.class))), (ConfigFileFromLocalStorage) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ConfigFileFromLocalStorage.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(InitializeStateNetworkError.class)), ServiceFactoryKt.factoryOf(new Function0<InitializeStateNetworkError>() {
            public final InitializeStateNetworkError invoke() {
                return new InitializeStateNetworkError((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(ConfigFileFromLocalStorage.class)), LazyKt__LazyJVMKt.b(new Function0<ConfigFileFromLocalStorage>() {
            public final ConfigFileFromLocalStorage invoke() {
                return new ConfigFileFromLocalStorage((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(InitializeStateReset.class)), LazyKt__LazyJVMKt.b(new Function0<InitializeStateReset>() {
            public final InitializeStateReset invoke() {
                return new InitializeStateReset((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(InitializeStateError.class)), LazyKt__LazyJVMKt.b(new Function0<InitializeStateError>() {
            public final InitializeStateError invoke() {
                return new InitializeStateError((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(InitializeStateConfigWithLoader.class)), LazyKt__LazyJVMKt.b(new Function0<InitializeStateConfigWithLoader>() {
            public final InitializeStateConfigWithLoader invoke() {
                return new InitializeStateConfigWithLoader((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ISDKDispatchers.class))), (InitializeStateNetworkError) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(InitializeStateNetworkError.class))), (TokenStorage) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(TokenStorage.class))), (SDKMetricsSender) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(SDKMetricsSender.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(InitializeStateConfig.class)), LazyKt__LazyJVMKt.b(new Function0<InitializeStateConfig>() {
            public final InitializeStateConfig invoke() {
                return new InitializeStateConfig((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ISDKDispatchers.class))), (InitializeStateConfigWithLoader) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(InitializeStateConfigWithLoader.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(InitializeStateCreate.class)), LazyKt__LazyJVMKt.b(new Function0<InitializeStateCreate>() {
            public final InitializeStateCreate invoke() {
                return new InitializeStateCreate((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(InitializeStateLoadCache.class)), LazyKt__LazyJVMKt.b(new Function0<InitializeStateLoadCache>() {
            public final InitializeStateLoadCache invoke() {
                return new InitializeStateLoadCache((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(InitializeStateCreateWithRemote.class)), LazyKt__LazyJVMKt.b(new Function0<InitializeStateCreateWithRemote>() {
            public final InitializeStateCreateWithRemote invoke() {
                return new InitializeStateCreateWithRemote((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(InitializeStateLoadWeb.class)), LazyKt__LazyJVMKt.b(new Function0<InitializeStateLoadWeb>() {
            public final InitializeStateLoadWeb invoke() {
                return new InitializeStateLoadWeb((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ISDKDispatchers.class))), (InitializeStateNetworkError) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(InitializeStateNetworkError.class))), (HttpClient) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(HttpClient.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(InitializeStateComplete.class)), LazyKt__LazyJVMKt.b(new Function0<InitializeStateComplete>() {
            public final InitializeStateComplete invoke() {
                return new InitializeStateComplete((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ISDKDispatchers.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(InitializeSDK.class)), LazyKt__LazyJVMKt.b(new Function0<InitializeSDK>() {
            public final InitializeSDK invoke() {
                return new InitializeSDK((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ISDKDispatchers.class))), (ConfigFileFromLocalStorage) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ConfigFileFromLocalStorage.class))), (InitializeStateReset) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(InitializeStateReset.class))), (InitializeStateError) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(InitializeStateError.class))), (InitializeStateConfig) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(InitializeStateConfig.class))), (InitializeStateCreate) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(InitializeStateCreate.class))), (InitializeStateLoadCache) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(InitializeStateLoadCache.class))), (InitializeStateCreateWithRemote) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(InitializeStateCreateWithRemote.class))), (InitializeStateLoadWeb) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(InitializeStateLoadWeb.class))), (InitializeStateComplete) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(InitializeStateComplete.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(TokenStorage.class)), LazyKt__LazyJVMKt.b(AnonymousClass18.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(AsyncTokenStorage.class)), LazyKt__LazyJVMKt.b(new Function0<AsyncTokenStorage>() {
            public final AsyncTokenStorage invoke() {
                return new InMemoryAsyncTokenStorage((INativeTokenGenerator) null, new Handler(Looper.getMainLooper()), SDKMetrics.getInstance(), (TokenStorage) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(TokenStorage.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(VolumeChange.class)), LazyKt__LazyJVMKt.b(AnonymousClass20.INSTANCE));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(VolumeChangeMonitor.class)), LazyKt__LazyJVMKt.b(new Function0<VolumeChangeMonitor>() {
            public final VolumeChangeMonitor invoke() {
                return new VolumeChangeMonitor(SharedInstances.INSTANCE.getWebViewEventSender(), (VolumeChange) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(VolumeChange.class))));
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(MeasurementsService.class)), LazyKt__LazyJVMKt.b(new Function0<MeasurementsService>() {
            public final MeasurementsService invoke() {
                Context applicationContext = ClientProperties.getApplicationContext();
                Intrinsics.e(applicationContext, "getApplicationContext()");
                return new MeasurementsService(applicationContext, (ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ISDKDispatchers.class))), SharedInstances.INSTANCE.getWebViewEventSender());
            }
        }));
        servicesRegistry.updateService(new ServiceKey("", Reflection.b(TopicsService.class)), LazyKt__LazyJVMKt.b(new Function0<TopicsService>() {
            public final TopicsService invoke() {
                Context applicationContext = ClientProperties.getApplicationContext();
                Intrinsics.e(applicationContext, "getApplicationContext()");
                return new TopicsService(applicationContext, (ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", Reflection.b(ISDKDispatchers.class))), SharedInstances.INSTANCE.getWebViewEventSender());
            }
        }));
    }
}
