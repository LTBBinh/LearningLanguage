package com.nmp.phuc.applearnlanguage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Phuc on 1/13/2018.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;
    private TextView tvRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvRegister = (TextView) findViewById(R.id.tvRegister);

        tvRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnLogin:
                intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tvRegister:
                intent = new Intent(this,RegisterActivity.class);
                startActivityForResult(intent, ManagerKey.REQUEST_REGISTER);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ManagerKey.REQUEST_REGISTER){
            if (resultCode == RESULT_OK){
                finish();
            }else{
                //RESULT_CANCEL
            }
        }
    }
}