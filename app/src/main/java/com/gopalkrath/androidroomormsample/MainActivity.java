package com.gopalkrath.androidroomormsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final int ACTIVITY_RESULT_CODE = 11;

    RecyclerView rcvMain;
    RcvAdapter rcvAdapter;
    ArrayList<TaskModel> lstTaskModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addNewEmpActivity = new Intent(getApplicationContext(),AddNewTaskActivity.class);
                startActivityForResult(addNewEmpActivity, ACTIVITY_RESULT_CODE);
            }
        });

        lstTaskModel = new ArrayList<>();

        rcvMain = (RecyclerView) findViewById(R.id.rcvMain);
        rcvMain.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rcvAdapter = new RcvAdapter(lstTaskModel);
        rcvMain.setAdapter(rcvAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ACTIVITY_RESULT_CODE) {
            if (resultCode == RESULT_OK){
                if (data != null) {
                    String sub = data.getStringExtra("sub");
                    String desc = data.getStringExtra("desc");
                    String status = data.getStringExtra("status");

                    lstTaskModel.add(new TaskModel(sub,desc,status));
                    rcvAdapter.notifyDataSetChanged();
                }
            }

            if (resultCode == RESULT_CANCELED){
                //cancel
            }

        }
    }
}
