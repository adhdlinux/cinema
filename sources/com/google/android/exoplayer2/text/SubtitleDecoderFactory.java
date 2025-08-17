package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.exoplayer2.text.dvb.DvbDecoder;
import com.google.android.exoplayer2.text.pgs.PgsDecoder;
import com.google.android.exoplayer2.text.ssa.SsaDecoder;
import com.google.android.exoplayer2.text.subrip.SubripDecoder;
import com.google.android.exoplayer2.text.ttml.TtmlDecoder;
import com.google.android.exoplayer2.text.tx3g.Tx3gDecoder;
import com.google.android.exoplayer2.text.webvtt.Mp4WebvttDecoder;
import com.google.android.exoplayer2.text.webvtt.WebvttDecoder;

public interface SubtitleDecoderFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final SubtitleDecoderFactory f27252a = new SubtitleDecoderFactory() {
        public SubtitleDecoder a(Format format) {
            String str = format.f23071m;
            if (str != null) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1351681404:
                        if (str.equals("application/dvbsubs")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1248334819:
                        if (str.equals("application/pgs")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1026075066:
                        if (str.equals("application/x-mp4-vtt")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1004728940:
                        if (str.equals("text/vtt")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 691401887:
                        if (str.equals("application/x-quicktime-tx3g")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 822864842:
                        if (str.equals("text/x-ssa")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 930165504:
                        if (str.equals("application/x-mp4-cea-608")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 1201784583:
                        if (str.equals("text/x-exoplayer-cues")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 1566015601:
                        if (str.equals("application/cea-608")) {
                            c2 = 8;
                            break;
                        }
                        break;
                    case 1566016562:
                        if (str.equals("application/cea-708")) {
                            c2 = 9;
                            break;
                        }
                        break;
                    case 1668750253:
                        if (str.equals("application/x-subrip")) {
                            c2 = 10;
                            break;
                        }
                        break;
                    case 1693976202:
                        if (str.equals("application/ttml+xml")) {
                            c2 = 11;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        return new DvbDecoder(format.f23073o);
                    case 1:
                        return new PgsDecoder();
                    case 2:
                        return new Mp4WebvttDecoder();
                    case 3:
                        return new WebvttDecoder();
                    case 4:
                        return new Tx3gDecoder(format.f23073o);
                    case 5:
                        return new SsaDecoder(format.f23073o);
                    case 6:
                    case 8:
                        return new Cea608Decoder(str, format.E, 16000);
                    case 7:
                        return new ExoplayerCuesDecoder();
                    case 9:
                        return new Cea708Decoder(format.E, format.f23073o);
                    case 10:
                        return new SubripDecoder();
                    case 11:
                        return new TtmlDecoder();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }

        public boolean c(Format format) {
            String str = format.f23071m;
            if ("text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str) || "text/x-exoplayer-cues".equals(str)) {
                return true;
            }
            return false;
        }
    };

    SubtitleDecoder a(Format format);

    boolean c(Format format);
}
