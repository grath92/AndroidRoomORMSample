package com.gopalkrath.androidroomormsample;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AddNewTaskActivity extends AppCompatActivity {

    TextInputEditText txtInEdtSubject, txtInEdtDescription;
    RadioGroup rdgStatus;
    RadioButton rdbTodo, rdbDone;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);

        initializeView();
    }

    private void initializeView() {
        txtInEdtSubject = (TextInputEditText) findViewById(R.id.txtInEdtSubject);
        txtInEdtDescription = (TextInputEditText) findViewById(R.id.txtInEdtDescription);
        rdgStatus = (RadioGroup) findViewById(R.id.rdgStatus);
        rdbTodo = (RadioButton) findViewById(R.id.rdbTodo);
        rdbDone = (RadioButton) findViewById(R.id.rdbDone);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sub = txtInEdtSubject.getText().toString();
                String desc = txtInEdtDescription.getText().toString();
                String status = "";
                if (rdgStatus.getCheckedRadioButtonId() == R.id.rdbTodo)
                    status = "todo";
                else if (rdgStatus.getCheckedRadioButtonId() == R.id.rdbDone)
                    status = "done";

                if (!sub.equals(""))
                    if (!desc.equals(""))
                        if (!status.equals(""))
                            sendBackResultOk(sub, desc, status);
                        else
                            Snackbar.make(view,"Please Choose a Status", Snackbar.LENGTH_SHORT).show();
                    else
                        Snackbar.make(view,"Please Fill Description", Snackbar.LENGTH_SHORT).show();
                else
                    Snackbar.make(view,"Please Fill Subject", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void sendBackResultOk(String sub, String desc, String status) {
        Intent sendBackIntent = new Intent();
        sendBackIntent.putExtra("sub", sub);
        sendBackIntent.putExtra("desc", desc);
        sendBackIntent.putExtra("status", status);
        setResult(RESULT_OK, sendBackIntent);
        finish();
    }

    private void sendBackResultCancel() {
        Intent sendBackIntent = new Intent();
        setResult(RESULT_CANCELED, sendBackIntent);
        finish();
    }
}
