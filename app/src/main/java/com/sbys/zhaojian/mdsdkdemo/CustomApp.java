package com.sbys.zhaojian.mdsdkdemo;

import android.app.Application;
import android.support.multidex.MultiDex;

import com.wadata.mobiledoctor.SDK.MDSdk;

/**
 * @author zhaojian
 * @time 2019/2/20 17:13
 * @describe
 */
public class CustomApp extends Application
{

    @Override
    public void onCreate()
    {
        super.onCreate();
        MultiDex.install(this);
        MDSdk.init(this,"https://dev.arounddoctor.com/hsb/","001001007011");
    }
}
