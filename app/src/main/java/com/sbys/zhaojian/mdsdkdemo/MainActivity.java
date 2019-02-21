package com.sbys.zhaojian.mdsdkdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.wadata.mobiledoctor.SDK.MDSdk;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.jump_list).setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.login:
                MDSdk.login("320282198501182612", "zj", "15088888888")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<String>()
                        {
                            @Override
                            public void onSubscribe(Disposable d)
                            {

                            }

                            @Override
                            public void onNext(String s)
                            {
                                Log.d(TAG, "------------------->onNext: " + s);
                            }

                            @Override
                            public void onError(Throwable e)
                            {
                                Log.d(TAG, "----------------------->onError: 登录失败");
                            }

                            @Override
                            public void onComplete()
                            {

                            }
                        });
                break;
            case R.id.jump_list:
                MDSdk.jumpToServiceList(this,1000);
                break;
            default:
                break;
        }
    }
}
