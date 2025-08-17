package androidx.loader.app;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class LoaderManager {

    public interface LoaderCallbacks<D> {
        Loader<D> onCreateLoader(int i2, Bundle bundle);

        void onLoadFinished(Loader<D> loader, D d2);

        void onLoaderReset(Loader<D> loader);
    }

    public static <T extends LifecycleOwner & ViewModelStoreOwner> LoaderManager c(T t2) {
        return new LoaderManagerImpl(t2, ((ViewModelStoreOwner) t2).getViewModelStore());
    }

    public abstract void a(int i2);

    @Deprecated
    public abstract void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract <D> Loader<D> d(int i2, Bundle bundle, LoaderCallbacks<D> loaderCallbacks);

    public abstract void e();

    public abstract <D> Loader<D> f(int i2, Bundle bundle, LoaderCallbacks<D> loaderCallbacks);
}
