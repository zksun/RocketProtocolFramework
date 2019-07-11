package com.rocket.framework.utils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by zksun on 5/17/16.
 */
public abstract class IOUtils {

    public static void write(byte[] data, OutputStream outputStream) throws IOException {
        if (null != data) {
            try {
                outputStream.write(data);
            } finally {
                outputStream.close();
            }
        }
    }

}
