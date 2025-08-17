package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.bumptech.glide.load.data.DataRewinder;
import java.io.IOException;

public final class ParcelFileDescriptorRewinder implements DataRewinder<ParcelFileDescriptor> {

    /* renamed from: a  reason: collision with root package name */
    private final InternalRewinder f16342a;

    public static final class Factory implements DataRewinder.Factory<ParcelFileDescriptor> {
        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }

        /* renamed from: c */
        public DataRewinder<ParcelFileDescriptor> b(ParcelFileDescriptor parcelFileDescriptor) {
            return new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }
    }

    private static final class InternalRewinder {

        /* renamed from: a  reason: collision with root package name */
        private final ParcelFileDescriptor f16343a;

        InternalRewinder(ParcelFileDescriptor parcelFileDescriptor) {
            this.f16343a = parcelFileDescriptor;
        }

        /* access modifiers changed from: package-private */
        public ParcelFileDescriptor a() throws IOException {
            try {
                Os.lseek(this.f16343a.getFileDescriptor(), 0, OsConstants.SEEK_SET);
                return this.f16343a;
            } catch (ErrnoException e2) {
                throw new IOException(e2);
            }
        }
    }

    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        this.f16342a = new InternalRewinder(parcelFileDescriptor);
    }

    public static boolean c() {
        return true;
    }

    public void b() {
    }

    /* renamed from: d */
    public ParcelFileDescriptor a() throws IOException {
        return this.f16342a.a();
    }
}
