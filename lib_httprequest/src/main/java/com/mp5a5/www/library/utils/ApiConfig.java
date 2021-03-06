package com.mp5a5.www.library.utils;

import android.content.Context;
import android.util.ArrayMap;
import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * @author ：mp5a5 on 2018/12/27 20：51
 * @describe 网络请求配置文件
 * @email：wwb199055@126.com
 */
public class ApiConfig implements Serializable {

    private static int mInvalidToken;
    private static int mQuitCode;
    private static String mBaseUrl;
    private static int mDefaultTimeout = 2000;
    private static int mSucceedCode;
    private static String mTokenInvalidBroadcastFilter;
    private static String mQuitBroadcastFilter;
    private static ArrayMap<String, String> mHeads;
    private static String mToken = "";
    private static boolean mOpenHttps;
    private static SslSocketConfigure mSslSocketConfigure;

    private ApiConfig(Builder builder) {
        mInvalidToken = builder.invalidateToken;
        mQuitCode = builder.quitCode;
        mBaseUrl = builder.baseUrl;
        mDefaultTimeout = builder.defaultTimeout;
        mSucceedCode = builder.succeedCode;
        mTokenInvalidBroadcastFilter = builder.tokenInvalidBroadcastFilter;
        mQuitBroadcastFilter = builder.quitBroadcastFilter;
        mHeads = builder.heads;
        mOpenHttps = builder.openHttps;
        mSslSocketConfigure = builder.sslSocketConfigure;
    }

    public void init(Context appContext) {
        AppContextUtils.init(appContext);
    }

    public static int getInvalidToken() {
        return mInvalidToken;
    }

    public static String getBaseUrl() {
        return mBaseUrl;
    }

    public static int getDefaultTimeout() {
        return mDefaultTimeout;
    }

    public static int getSucceedCode() {
        return mSucceedCode;
    }

    public static String getTokenInvalidBroadcastFilter() {
        return mTokenInvalidBroadcastFilter;
    }
    public static String getQuitBroadcastFilter() {
        return mQuitBroadcastFilter;
    }

    public static ArrayMap<String, String> getHeads() {
        return mHeads;
    }

    public static void setHeads(ArrayMap<String, String> mHeads) {
        ApiConfig.mHeads = mHeads;
    }

    public static String getToken() {
        return mToken;
    }

    public static void setToken(String mToken) {
        ApiConfig.mToken = mToken;
    }

    public static boolean getOpenHttps() {
        return mOpenHttps;
    }

    public static int getQuitCode() {
        return mQuitCode;
    }

    public static SslSocketConfigure getSslSocketConfigure() {
        return mSslSocketConfigure;
    }

    public static final class Builder  {

        private int invalidateToken;

        private int quitCode;

        private String baseUrl;

        private int defaultTimeout;

        private int succeedCode;

        private String quitBroadcastFilter;

        private String tokenInvalidBroadcastFilter;

        private ArrayMap<String, String> heads;

        private boolean openHttps = false;

        private SslSocketConfigure sslSocketConfigure;

        public Builder setHeads(ArrayMap<String, String> heads) {
            this.heads = heads;
            return this;
        }

        public Builder setTokenInvalidFilter(@NonNull String filter) {
            this.tokenInvalidBroadcastFilter = filter;
            return this;
        }

        public Builder setQuitFilter(@NonNull String filter) {
            this.quitBroadcastFilter = filter;
            return this;
        }


        public Builder setSucceedCode(int succeedCode) {
            this.succeedCode = succeedCode;
            return this;
        }

        public Builder setBaseUrl(String mBaseUrl) {
            this.baseUrl = mBaseUrl;
            return this;
        }

        public Builder setInvalidToken(int invalidateToken) {
            this.invalidateToken = invalidateToken;
            return this;
        }

        public Builder setQuitCode(int quitCode) {
            this.quitCode = quitCode;
            return this;
        }

        public Builder setDefaultTimeout(int defaultTimeout) {
            this.defaultTimeout = defaultTimeout;
            return this;
        }

        public Builder setOpenHttps(boolean open) {
            this.openHttps = open;
            return this;
        }

        public Builder setSslSocketConfigure(SslSocketConfigure sslSocketConfigure) {
            this.sslSocketConfigure = sslSocketConfigure;
            return this;
        }

        public ApiConfig build() {
            return new ApiConfig(this);
        }
    }
}
