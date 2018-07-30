package com.chootdev.nems.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chootdev.nems.R;
import com.chootdev.nems.alerts.ForgotPasswordDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ForgotPasswordDialog.ForgotPasswordDialogCallback {

    @BindView(R.id.input_username)
    EditText inputUsername;
    @BindView(R.id.input_password)
    EditText inputPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogin)
    public void onBtnLoginClicked() {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.txtForgotPassword)
    public void onTxtForgotPasswordClicked() {
        new ForgotPasswordDialog(LoginActivity.this, this).show();
    }

    @Override
    public void onForgotpasswordSendPressed(String email) {
        Toast.makeText(this, email,Toast.LENGTH_LONG).show();
    }
}
