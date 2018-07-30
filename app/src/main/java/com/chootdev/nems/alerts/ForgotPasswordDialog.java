package com.chootdev.nems.alerts;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.chootdev.nems.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotPasswordDialog {

    @BindView(R.id.input_username)
    EditText inputUsername;
    @BindView(R.id.btnSend)
    Button btnSubmit;

    private Context context;
    private Dialog dialog;

    private ForgotPasswordDialogCallback callback;

    public ForgotPasswordDialog(Context context, ForgotPasswordDialogCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    public void show() {
        dialog = new Dialog(context, R.style.CustomDialog);
        dialog.setContentView(R.layout.dialog_forgot_password);
        ButterKnife.bind(this, dialog);

        btnSubmit.setEnabled(false);
        btnSubmit.setAlpha(0.4f);

        inputUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length() == 0) {
                    btnSubmit.setEnabled(false);
                    btnSubmit.setAlpha(0.4f);
                } else {
                    if (inputUsername.getText() == null || inputUsername.getText().toString().trim().length() == 0) {
                        btnSubmit.setEnabled(false);
                        btnSubmit.setAlpha(0.4f);
                    } else if (isEmailValid(inputUsername.getText() != null ? inputUsername.getText().toString() : "")) {
                        btnSubmit.setEnabled(true);
                        btnSubmit.setAlpha(1.0f);
                    } else {
                        btnSubmit.setEnabled(false);
                        btnSubmit.setAlpha(0.4f);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setLayout(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    }

    @OnClick(R.id.btnSend)
    public void onViewClicked() {
        callback.onForgotpasswordSendPressed(inputUsername.getText().toString());

        if(dialog != null && dialog.isShowing())
            dialog.dismiss();
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public interface ForgotPasswordDialogCallback {
        void onForgotpasswordSendPressed(String email);
    }
}
