package com.example.isr.ppstest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    private EditText editText;
    private Uri uri;
    private String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        final String action = intent.getAction();
        uri = intent.getData();
        data = intent.getData().toString();
        editText = (EditText) findViewById(R.id.edit_Text);
        editText.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        editText.setSingleLine(false);
        editText.setHorizontallyScrolling(false);
        editText.setText(data);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent("android.intent.action.VIEW");
                data = editText.getText().toString();
                Uri myUri = Uri.parse(data);
                intent1.setData(myUri);
//                intent1.setData(uri);
                startActivities(new Intent[]{intent1});
            }
        });


//        AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(this);
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.setTitle("Deeplink content from PPS");
//        alertDialog.setMessage(data);
//        alertDialog.show();
    }
}
