package com.example.grade;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class showGrade extends AppCompatActivity {
TextView mShow_g_textView1,mShow_g_textView2,mShow_g_textView3;
    Button mBack_button,mNext_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_grade);
        mShow_g_textView1 = (TextView) findViewById(R.id.show_g_textView1);
        mShow_g_textView2 = (TextView) findViewById(R.id.show_g_textView2);
        mShow_g_textView3 = (TextView) findViewById(R.id.show_g_textView3);
        mBack_button = (Button) findViewById(R.id.back_button);
        mNext_button = (Button) findViewById(R.id.next_button2);
        Intent intent = getIntent();
        String gradeText1 = intent.getStringExtra("gradeText1");
        String gradeText2 = intent.getStringExtra("gradeText2");
        String gradeText3 = intent.getStringExtra("gradeText3");
        mShow_g_textView1.setText(gradeText1);
        mShow_g_textView2.setText(gradeText2);
        mShow_g_textView3.setText(gradeText3);
        mBack_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mNext_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast t =Toast.makeText(
                        showGrade.this,
                        "showToast",
                        Toast.LENGTH_SHORT

                );
                t.show();

                AlertDialog.Builder dialog = new AlertDialog.Builder(showGrade.this);
                dialog.setTitle("Grade");
                dialog.setMessage("show Grade");
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//โค้ดที่ต้องการให้ทำงาน เมือปุ่ม OK ใน dialog ถูกคลิค}
                        finish();
                    }

                });
                dialog.show();
            }
        });
    }
}
