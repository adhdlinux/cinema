package com.facebook.imagepipeline.core;

import android.content.Context;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;

public class ImagePipelineExperiments {
    private final boolean mAllowDelay;
    private final int mBitmapCloseableRefType;
    private boolean mBitmapPrepareToDrawForPrefetch;
    private final int mBitmapPrepareToDrawMaxSizeBytes;
    private final int mBitmapPrepareToDrawMinSizeBytes;
    private final boolean mDecodeCancellationEnabled;
    private boolean mDownsampleIfLargeBitmap;
    private final boolean mDownscaleFrameToDrawableDimensions;
    private boolean mEncodedCacheEnabled;
    private final boolean mEnsureTranscoderLibraryLoaded;
    private final boolean mExperimentalThreadHandoffQueueEnabled;
    private final boolean mGingerbreadDecoderEnabled;
    private final boolean mIsDiskCacheProbingEnabled;
    private final boolean mIsEncodedMemoryCacheProbingEnabled;
    private boolean mKeepCancelledFetchAsLowPriority;
    private final Supplier<Boolean> mLazyDataSource;
    private final int mMaxBitmapSize;
    private final long mMemoryType;
    private final boolean mNativeCodeDisabled;
    private final boolean mPartialImageCachingEnabled;
    private final ProducerFactoryMethod mProducerFactoryMethod;
    private final Supplier<Boolean> mSuppressBitmapPrefetchingSupplier;
    private final int mTrackedKeysSize;
    private final boolean mUseBitmapPrepareToDraw;
    private final boolean mUseCombinedNetworkAndCacheProducer;
    private final boolean mUseDownsamplingRatioForResizing;
    private final WebpBitmapFactory mWebpBitmapFactory;
    private final WebpBitmapFactory.WebpErrorLogger mWebpErrorLogger;
    private final boolean mWebpSupportEnabled;

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean mAllowDelay = false;
        public int mBitmapCloseableRefType;
        public boolean mBitmapPrepareToDrawForPrefetch = false;
        /* access modifiers changed from: private */
        public int mBitmapPrepareToDrawMaxSizeBytes = 0;
        /* access modifiers changed from: private */
        public int mBitmapPrepareToDrawMinSizeBytes = 0;
        private final ImagePipelineConfig.Builder mConfigBuilder;
        /* access modifiers changed from: private */
        public boolean mDecodeCancellationEnabled = false;
        public boolean mDownsampleIfLargeBitmap;
        public boolean mDownscaleFrameToDrawableDimensions;
        public boolean mEncodedCacheEnabled = true;
        public boolean mEnsureTranscoderLibraryLoaded = true;
        public boolean mExperimentalThreadHandoffQueueEnabled;
        public boolean mGingerbreadDecoderEnabled;
        /* access modifiers changed from: private */
        public boolean mIsDiskCacheProbingEnabled = false;
        /* access modifiers changed from: private */
        public boolean mIsEncodedMemoryCacheProbingEnabled = false;
        /* access modifiers changed from: private */
        public boolean mKeepCancelledFetchAsLowPriority;
        public Supplier<Boolean> mLazyDataSource;
        /* access modifiers changed from: private */
        public int mMaxBitmapSize = 2048;
        public long mMemoryType = 0;
        /* access modifiers changed from: private */
        public boolean mNativeCodeDisabled = false;
        /* access modifiers changed from: private */
        public boolean mPartialImageCachingEnabled = false;
        /* access modifiers changed from: private */
        public ProducerFactoryMethod mProducerFactoryMethod;
        public Supplier<Boolean> mSuppressBitmapPrefetchingSupplier = Suppliers.of(Boolean.FALSE);
        /* access modifiers changed from: private */
        public int mTrackedKeysSize = 20;
        /* access modifiers changed from: private */
        public boolean mUseBitmapPrepareToDraw = false;
        /* access modifiers changed from: private */
        public boolean mUseCombinedNetworkAndCacheProducer = false;
        /* access modifiers changed from: private */
        public boolean mUseDownsamplingRatioForResizing = false;
        /* access modifiers changed from: private */
        public WebpBitmapFactory mWebpBitmapFactory;
        /* access modifiers changed from: private */
        public WebpBitmapFactory.WebpErrorLogger mWebpErrorLogger;
        /* access modifiers changed from: private */
        public boolean mWebpSupportEnabled = false;

        public Builder(ImagePipelineConfig.Builder builder) {
            this.mConfigBuilder = builder;
        }

        public ImagePipelineExperiments build() {
            return new ImagePipelineExperiments(this);
        }

        public boolean isPartialImageCachingEnabled() {
            return this.mPartialImageCachingEnabled;
        }

        public ImagePipelineConfig.Builder setAllowDelay(boolean z2) {
            this.mAllowDelay = z2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setBitmapCloseableRefType(int i2) {
            this.mBitmapCloseableRefType = i2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setBitmapPrepareToDraw(boolean z2, int i2, int i3, boolean z3) {
            this.mUseBitmapPrepareToDraw = z2;
            this.mBitmapPrepareToDrawMinSizeBytes = i2;
            this.mBitmapPrepareToDrawMaxSizeBytes = i3;
            this.mBitmapPrepareToDrawForPrefetch = z3;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setDecodeCancellationEnabled(boolean z2) {
            this.mDecodeCancellationEnabled = z2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setDownsampleIfLargeBitmap(boolean z2) {
            this.mDownsampleIfLargeBitmap = z2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setEncodedCacheEnabled(boolean z2) {
            this.mEncodedCacheEnabled = z2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setEnsureTranscoderLibraryLoaded(boolean z2) {
            this.mEnsureTranscoderLibraryLoaded = z2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setExperimentalMemoryType(long j2) {
            this.mMemoryType = j2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setExperimentalThreadHandoffQueueEnabled(boolean z2) {
            this.mExperimentalThreadHandoffQueueEnabled = z2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setGingerbreadDecoderEnabled(boolean z2) {
            this.mGingerbreadDecoderEnabled = z2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setIsDiskCacheProbingEnabled(boolean z2) {
            this.mIsDiskCacheProbingEnabled = z2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setIsEncodedMemoryCacheProbingEnabled(boolean z2) {
            this.mIsEncodedMemoryCacheProbingEnabled = z2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setKeepCancelledFetchAsLowPriority(boolean z2) {
            this.mKeepCancelledFetchAsLowPriority = z2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setLazyDataSource(Supplier<Boolean> supplier) {
            this.mLazyDataSource = supplier;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setMaxBitmapSize(int i2) {
            this.mMaxBitmapSize = i2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setNativeCodeDisabled(boolean z2) {
            this.mNativeCodeDisabled = z2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setPartialImageCachingEnabled(boolean z2) {
            this.mPartialImageCachingEnabled = z2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setProducerFactoryMethod(ProducerFactoryMethod producerFactoryMethod) {
            this.mProducerFactoryMethod = producerFactoryMethod;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setShouldDownscaleFrameToDrawableDimensions(boolean z2) {
            this.mDownscaleFrameToDrawableDimensions = z2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setSuppressBitmapPrefetchingSupplier(Supplier<Boolean> supplier) {
            this.mSuppressBitmapPrefetchingSupplier = supplier;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setTrackedKeysSize(int i2) {
            this.mTrackedKeysSize = i2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setUseCombinedNetworkAndCacheProducer(boolean z2) {
            this.mUseCombinedNetworkAndCacheProducer = z2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setUseDownsampligRatioForResizing(boolean z2) {
            this.mUseDownsamplingRatioForResizing = z2;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setWebpBitmapFactory(WebpBitmapFactory webpBitmapFactory) {
            this.mWebpBitmapFactory = webpBitmapFactory;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setWebpErrorLogger(WebpBitmapFactory.WebpErrorLogger webpErrorLogger) {
            this.mWebpErrorLogger = webpErrorLogger;
            return this.mConfigBuilder;
        }

        public ImagePipelineConfig.Builder setWebpSupportEnabled(boolean z2) {
            this.mWebpSupportEnabled = z2;
            return this.mConfigBuilder;
        }
    }

    public static class DefaultProducerFactoryMethod implements ProducerFactoryMethod {
        public ProducerFactory createProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z2, boolean z3, boolean z4, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int i2, int i3, boolean z5, int i4, CloseableReferenceFactory closeableReferenceFactory, boolean z6, int i5) {
            return new ProducerFactory(context, byteArrayPool, imageDecoder, progressiveJpegConfig, z2, z3, z4, executorSupplier, pooledByteBufferFactory, memoryCache, memoryCache2, bufferedDiskCache, bufferedDiskCache2, cacheKeyFactory, platformBitmapFactory, i2, i3, z5, i4, closeableReferenceFactory, z6, i5);
        }
    }

    public interface ProducerFactoryMethod {
        ProducerFactory createProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z2, boolean z3, boolean z4, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int i2, int i3, boolean z5, int i4, CloseableReferenceFactory closeableReferenceFactory, boolean z6, int i5);
    }

    public static Builder newBuilder(ImagePipelineConfig.Builder builder) {
        return new Builder(builder);
    }

    public boolean allowDelay() {
        return this.mAllowDelay;
    }

    public int getBitmapCloseableRefType() {
        return this.mBitmapCloseableRefType;
    }

    public boolean getBitmapPrepareToDrawForPrefetch() {
        return this.mBitmapPrepareToDrawForPrefetch;
    }

    public int getBitmapPrepareToDrawMaxSizeBytes() {
        return this.mBitmapPrepareToDrawMaxSizeBytes;
    }

    public int getBitmapPrepareToDrawMinSizeBytes() {
        return this.mBitmapPrepareToDrawMinSizeBytes;
    }

    public int getMaxBitmapSize() {
        return this.mMaxBitmapSize;
    }

    public long getMemoryType() {
        return this.mMemoryType;
    }

    public ProducerFactoryMethod getProducerFactoryMethod() {
        return this.mProducerFactoryMethod;
    }

    public Supplier<Boolean> getSuppressBitmapPrefetchingSupplier() {
        return this.mSuppressBitmapPrefetchingSupplier;
    }

    public int getTrackedKeysSize() {
        return this.mTrackedKeysSize;
    }

    public boolean getUseBitmapPrepareToDraw() {
        return this.mUseBitmapPrepareToDraw;
    }

    public boolean getUseDownsamplingRatioForResizing() {
        return this.mUseDownsamplingRatioForResizing;
    }

    public WebpBitmapFactory getWebpBitmapFactory() {
        return this.mWebpBitmapFactory;
    }

    public WebpBitmapFactory.WebpErrorLogger getWebpErrorLogger() {
        return this.mWebpErrorLogger;
    }

    public boolean isDecodeCancellationEnabled() {
        return this.mDecodeCancellationEnabled;
    }

    public boolean isDiskCacheProbingEnabled() {
        return this.mIsDiskCacheProbingEnabled;
    }

    public boolean isEncodedCacheEnabled() {
        return this.mEncodedCacheEnabled;
    }

    public boolean isEncodedMemoryCacheProbingEnabled() {
        return this.mIsEncodedMemoryCacheProbingEnabled;
    }

    public boolean isEnsureTranscoderLibraryLoaded() {
        return this.mEnsureTranscoderLibraryLoaded;
    }

    public boolean isExperimentalThreadHandoffQueueEnabled() {
        return this.mExperimentalThreadHandoffQueueEnabled;
    }

    public boolean isGingerbreadDecoderEnabled() {
        return this.mGingerbreadDecoderEnabled;
    }

    public Supplier<Boolean> isLazyDataSource() {
        return this.mLazyDataSource;
    }

    public boolean isNativeCodeDisabled() {
        return this.mNativeCodeDisabled;
    }

    public boolean isPartialImageCachingEnabled() {
        return this.mPartialImageCachingEnabled;
    }

    public boolean isWebpSupportEnabled() {
        return this.mWebpSupportEnabled;
    }

    public boolean shouldDownsampleIfLargeBitmap() {
        return this.mDownsampleIfLargeBitmap;
    }

    public boolean shouldDownscaleFrameToDrawableDimensions() {
        return this.mDownscaleFrameToDrawableDimensions;
    }

    public boolean shouldKeepCancelledFetchAsLowPriority() {
        return this.mKeepCancelledFetchAsLowPriority;
    }

    public boolean shouldUseCombinedNetworkAndCacheProducer() {
        return this.mUseCombinedNetworkAndCacheProducer;
    }

    private ImagePipelineExperiments(Builder builder) {
        this.mWebpSupportEnabled = builder.mWebpSupportEnabled;
        this.mWebpErrorLogger = builder.mWebpErrorLogger;
        this.mDecodeCancellationEnabled = builder.mDecodeCancellationEnabled;
        this.mWebpBitmapFactory = builder.mWebpBitmapFactory;
        this.mUseDownsamplingRatioForResizing = builder.mUseDownsamplingRatioForResizing;
        this.mUseBitmapPrepareToDraw = builder.mUseBitmapPrepareToDraw;
        this.mBitmapPrepareToDrawMinSizeBytes = builder.mBitmapPrepareToDrawMinSizeBytes;
        this.mBitmapPrepareToDrawMaxSizeBytes = builder.mBitmapPrepareToDrawMaxSizeBytes;
        this.mBitmapPrepareToDrawForPrefetch = builder.mBitmapPrepareToDrawForPrefetch;
        this.mMaxBitmapSize = builder.mMaxBitmapSize;
        this.mNativeCodeDisabled = builder.mNativeCodeDisabled;
        this.mPartialImageCachingEnabled = builder.mPartialImageCachingEnabled;
        if (builder.mProducerFactoryMethod == null) {
            this.mProducerFactoryMethod = new DefaultProducerFactoryMethod();
        } else {
            this.mProducerFactoryMethod = builder.mProducerFactoryMethod;
        }
        this.mLazyDataSource = builder.mLazyDataSource;
        this.mGingerbreadDecoderEnabled = builder.mGingerbreadDecoderEnabled;
        this.mDownscaleFrameToDrawableDimensions = builder.mDownscaleFrameToDrawableDimensions;
        this.mBitmapCloseableRefType = builder.mBitmapCloseableRefType;
        this.mSuppressBitmapPrefetchingSupplier = builder.mSuppressBitmapPrefetchingSupplier;
        this.mExperimentalThreadHandoffQueueEnabled = builder.mExperimentalThreadHandoffQueueEnabled;
        this.mMemoryType = builder.mMemoryType;
        this.mKeepCancelledFetchAsLowPriority = builder.mKeepCancelledFetchAsLowPriority;
        this.mDownsampleIfLargeBitmap = builder.mDownsampleIfLargeBitmap;
        this.mEncodedCacheEnabled = builder.mEncodedCacheEnabled;
        this.mEnsureTranscoderLibraryLoaded = builder.mEnsureTranscoderLibraryLoaded;
        this.mIsEncodedMemoryCacheProbingEnabled = builder.mIsEncodedMemoryCacheProbingEnabled;
        this.mIsDiskCacheProbingEnabled = builder.mIsDiskCacheProbingEnabled;
        this.mTrackedKeysSize = builder.mTrackedKeysSize;
        this.mUseCombinedNetworkAndCacheProducer = builder.mUseCombinedNetworkAndCacheProducer;
        this.mAllowDelay = builder.mAllowDelay;
    }
}
