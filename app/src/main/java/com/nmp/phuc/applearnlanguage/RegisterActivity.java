package com.nmp.phuc.applearnlanguage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Phuc on 1/13/2018.
 */

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {

    }

    private void register(){
        //register thanh cong
        Intent intent = new Intent();
        setResult(RESULT_OK,intent);
        finish();
    }
}
