package com.bluebreezecf.tools.sparkjobserver.api;

import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Nicolò Marchi on IntelliJ IDEA.
 *
 * @author  nicolomarchi - <nicolo.marchi@contentwise.tv>
 * @since  01/12/17 - 10.41
 */
public class ProgressEntityWrapper extends HttpEntityWrapper {

    public interface ProgressListener {
        void progress(float percentage);
    }

    private ProgressListener listener;

    public ProgressEntityWrapper(HttpEntity entity,
                                 ProgressListener listener) {
        super(entity);
        this.listener = listener;
    }

    @Override
    public void writeTo(OutputStream outstream) throws IOException {
        super.writeTo(new CountingOutputStream(outstream,listener, getContentLength()));
    }
}
