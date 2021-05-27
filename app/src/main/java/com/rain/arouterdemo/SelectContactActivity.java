package com.rain.arouterdemo;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 *  @AuthorName :       Rain
 *  @Org        :       https://www.yudu233.com
 *  @CreateDate :       5/26/21 4:37 PM
 *  @VersonCode :       1.0
 *  @Descroption :      选择联系人页面
 */
@Route(path = AppNavigator._selectPage)
public class SelectContactActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_01).setOnClickListener(v->{
            Intent intent = new Intent();
            SelectInfo selectInfo = new SelectInfo();
            selectInfo.setName("Rain");
            intent.putExtra("selectInfo",selectInfo);
            setResult(RESULT_OK,intent);
            finish();
        });

    }
}
