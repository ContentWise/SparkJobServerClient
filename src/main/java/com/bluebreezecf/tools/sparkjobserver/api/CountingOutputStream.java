package com.bluebreezecf.tools.sparkjobserver.api;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Nicolò Marchi on IntelliJ IDEA.
 * @author  nicolomarchi - <nicolo.marchi@contentwise.tv>
 * @since 01/12/17 - 10.42
 */
public class CountingOutputStream extends FilterOutputStream {
    private ProgressEntityWrapper.ProgressListener listener;
    private long transferred;
    private long totalBytes;

    public CountingOutputStream(OutputStream out, ProgressEntityWrapper.ProgressListener listener, long totalBytes) {
        super(out);
        this.listener = listener;
        transferred = 0;
        this.totalBytes = totalBytes;
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        out.write(b, off, len);
        transferred += len;
        listener.progress(getCurrentProgress());
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
        transferred++;
        listener.progress(getCurrentProgress());
    }

    private float getCurrentProgress() {
        return ((float) transferred / totalBytes) * 100;
    }
}
