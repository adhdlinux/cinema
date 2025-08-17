package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ElfFileChannel implements ElfByteChannel {
    private FileChannel mFc;
    private File mFile;
    private FileInputStream mIs;

    public ElfFileChannel(File file) throws IOException {
        this.mFile = file;
        openChannel();
    }

    public void close() throws IOException {
        this.mIs.close();
    }

    public boolean isOpen() {
        return this.mFc.isOpen();
    }

    public void openChannel() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(this.mFile);
        this.mIs = fileInputStream;
        this.mFc = fileInputStream.getChannel();
    }

    public long position() throws IOException {
        return this.mFc.position();
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        return this.mFc.read(byteBuffer);
    }

    public long size() throws IOException {
        return this.mFc.size();
    }

    public ElfByteChannel truncate(long j2) throws IOException {
        this.mFc.truncate(j2);
        return this;
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        return this.mFc.write(byteBuffer);
    }

    public ElfByteChannel position(long j2) throws IOException {
        this.mFc.position(j2);
        return this;
    }

    public int read(ByteBuffer byteBuffer, long j2) throws IOException {
        return this.mFc.read(byteBuffer, j2);
    }
}
