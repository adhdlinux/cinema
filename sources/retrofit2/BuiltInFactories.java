package retrofit2;

import android.annotation.TargetApi;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import retrofit2.CallAdapter;
import retrofit2.Converter;

class BuiltInFactories {

    @TargetApi(24)
    static final class Java8 extends BuiltInFactories {
        Java8() {
        }

        /* access modifiers changed from: package-private */
        public List<? extends CallAdapter.Factory> createDefaultCallAdapterFactories(Executor executor) {
            return Arrays.asList(new CallAdapter.Factory[]{new CompletableFutureCallAdapterFactory(), new DefaultCallAdapterFactory(executor)});
        }

        /* access modifiers changed from: package-private */
        public List<? extends Converter.Factory> createDefaultConverterFactories() {
            return Collections.singletonList(new OptionalConverterFactory());
        }
    }

    BuiltInFactories() {
    }

    /* access modifiers changed from: package-private */
    public List<? extends CallAdapter.Factory> createDefaultCallAdapterFactories(Executor executor) {
        return Collections.singletonList(new DefaultCallAdapterFactory(executor));
    }

    /* access modifiers changed from: package-private */
    public List<? extends Converter.Factory> createDefaultConverterFactories() {
        return Collections.emptyList();
    }
}
