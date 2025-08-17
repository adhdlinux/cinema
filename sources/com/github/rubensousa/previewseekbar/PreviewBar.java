package com.github.rubensousa.previewseekbar;

public interface PreviewBar {

    public interface OnPreviewVisibilityListener {
        void a(PreviewBar previewBar, boolean z2);
    }

    public interface OnScrubListener {
        void a(PreviewBar previewBar);

        void b(PreviewBar previewBar);

        void c(PreviewBar previewBar, int i2, boolean z2);
    }

    int getMax();

    int getProgress();

    int getScrubberColor();

    int getThumbOffset();
}
