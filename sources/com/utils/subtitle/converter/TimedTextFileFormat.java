package com.utils.subtitle.converter;

import java.io.IOException;
import java.io.InputStream;

public interface TimedTextFileFormat {
    TimedTextObject a(String str, InputStream inputStream, String str2) throws IOException, FatalParsingException;

    Object b(TimedTextObject timedTextObject);
}
