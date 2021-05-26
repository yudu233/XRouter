package com.rain.arouterdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.rain.arouterdemo.arouter.XRouter;
import com.rain.arouterdemo.arouter.callback.ContactSelectInfoCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ARouter.getInstance().inject(this);

        Bundle bundle = new Bundle();
        findViewById(R.id.btn_01).setOnClickListener(v -> {
            XRouter.getRouter().create(AppNavigator.class)
                    .toSelectContactPage(bundle).startActivityForResult(new ContactSelectInfoCallback() {
                @Override
                public void onResponse(@NonNull SelectInfo data) {
                    Log.e("Rain",data.getName() +"-----------onResponse--------");
                }
            });
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        SelectInfo selectInfo = (SelectInfo) data.getSerializableExtra("selectInfo");
        Log.e("Rain",selectInfo.getName() + "--------onActivityResult----------");
        XRouter.getRouter().getActivityManager().onActivityResult(this, requestCode, resultCode, data);
    }
}