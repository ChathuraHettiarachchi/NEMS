package com.chootdev.nems.alerts;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.chootdev.nems.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddApplianceDialog {


    @BindView(R.id.inputName)
    EditText inputName;
    @BindView(R.id.radioLight)
    RadioButton radioLight;
    @BindView(R.id.radioFan)
    RadioButton radioFan;
    @BindView(R.id.radioHeater)
    RadioButton radioHeater;
    @BindView(R.id.radioTelevision)
    RadioButton radioTelevision;
    @BindView(R.id.radioSet)
    RadioGroup radioSet;
    @BindView(R.id.btnAdd)
    Button btnAdd;

    private Context context;
    private Dialog dialog;

    private AddApplianceDialogCallback callback;

    public AddApplianceDialog(Context context, AddApplianceDialogCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    public void show() {
        dialog = new Dialog(context, R.style.CustomDialog);
        dialog.setContentView(R.layout.dialog_add_electrical_appliance);
        ButterKnife.bind(this, dialog);

        btnAdd.setEnabled(false);

        inputName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()>0 && !TextUtils.isEmpty(charSequence.toString()))
                    btnAdd.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    }

    @OnClick(R.id.btnAdd)
    public void onViewClicked() {

        int selectedId = radioSet.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) dialog.findViewById(selectedId);

        callback.onAddApplianceCalled(inputName.getText().toString(), radioButton.getText().toString());

        if (dialog != null && dialog.isShowing())
            dialog.dismiss();
    }

    public interface AddApplianceDialogCallback {
        void onAddApplianceCalled(String name, String type);
    }
}
