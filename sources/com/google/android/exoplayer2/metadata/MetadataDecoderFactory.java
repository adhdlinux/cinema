package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTableDecoder;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.metadata.icy.IcyDecoder;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.scte35.SpliceInfoDecoder;

public interface MetadataDecoderFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final MetadataDecoderFactory f25353a = new MetadataDecoderFactory() {
        public MetadataDecoder a(Format format) {
            String str = format.f23071m;
            if (str != null) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1354451219:
                        if (str.equals("application/vnd.dvb.ait")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1348231605:
                        if (str.equals("application/x-icy")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1248341703:
                        if (str.equals("application/id3")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1154383568:
                        if (str.equals("application/x-emsg")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1652648887:
                        if (str.equals("application/x-scte35")) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        return new AppInfoTableDecoder();
                    case 1:
                        return new IcyDecoder();
                    case 2:
                        return new Id3Decoder();
                    case 3:
                        return new EventMessageDecoder();
                    case 4:
                        return new SpliceInfoDecoder();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }

        public boolean c(Format format) {
            String str = format.f23071m;
            if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str)) {
                return true;
            }
            return false;
        }
    };

    MetadataDecoder a(Format format);

    boolean c(Format format);
}
