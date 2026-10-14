package com.github.catvod.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * OkHttpClient 构造工具（内联替代缺失的外部依赖，与源码内 com.github.catvod.crawler 包的内联方式一致）
 */
public class OkHttp {

    public static OkHttpClient client() {
        return client(true, 15000);
    }

    public static OkHttpClient client(boolean redirect, int timeout) {
        return new OkHttpClient.Builder()
                .connectTimeout(timeout, TimeUnit.MILLISECONDS)
                .readTimeout(timeout, TimeUnit.MILLISECONDS)
                .writeTimeout(timeout, TimeUnit.MILLISECONDS)
                .followRedirects(redirect)
                .followSslRedirects(redirect)
                .build();
    }
}
