package com.example.grade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mGradeEditText1,mGradeEditText2,mGradeEditText3;
    TextView mShow_grade_TextView1,mShow_grade_TextView2,mShow_grade_TextView3;
    Button mReset_button,mOk_button,mNext_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGradeEditText1 = (EditText) findViewById(R.id.grade_editText1) ;
        mGradeEditText2= (EditText) findViewById(R.id.grade_editText2) ;
        mGradeEditText3= (EditText) findViewById(R.id.grade_editText3) ;
        mShow_grade_TextView1 = (TextView) findViewById(R.id.show_grade_TextView1) ;
        mShow_grade_TextView2= (TextView) findViewById(R.id.show_grade_TextView2) ;
        mShow_grade_TextView3= (TextView) findViewById(R.id.show_grade_TextView3) ;
        mReset_button = (Button)findViewById(R.id.reset_button);
        mOk_button = (Button) findViewById(R.id.ok_button);
        mNext_button = (Button) findViewById(R.id.next_button);
        Toast t =Toast.makeText(
                MainActivity.this,
                "Hello",
                Toast.LENGTH_SHORT

        );
        t.show();
        mOk_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int gradeInput1 = Integer.parseInt(mGradeEditText1.getText().toString());
                int gradeInput2 = Integer.parseInt(mGradeEditText2.getText().toString());
                int gradeInput3 = Integer.parseInt(mGradeEditText3.getText().toString());
                mShow_grade_TextView1.setText(getGradeText(gradeInput1));
                mShow_grade_TextView2.setText(getGradeText(gradeInput2));
                mShow_grade_TextView3.setText(getGradeText(gradeInput3));

            }
        });
        mReset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();

            }
        });
        mNext_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentP2 = new Intent(MainActivity.this,showGrade.class);//(context.คลาสปลายทางที่จะรัน)
                intentP2.putExtra("gradeText1",mShow_grade_TextView1.getText().toString()); //ส่งค่าไป (key,value)
                intentP2.putExtra("gradeText2",mShow_grade_TextView2.getText().toString());
                intentP2.putExtra("gradeText3",mShow_grade_TextView3.getText().toString());
                reset();
                startActivity(intentP2);
            }
        });
    }
    public String getGradeText(int g){
        String gS="";
        if(g==1) gS="D";
        else if(g==2) gS="C";
        else if(g==3) gS="B";
        else gS="A";
        return gS;

    }
    public void reset(){
        mGradeEditText1.requestFocus();//ให้เคอเซอกลับไปช่องแรก
        mGradeEditText1.setText("");
        mGradeEditText2.setText("");
        mGradeEditText3.setText("");
        mShow_grade_TextView1.setText("");
        mShow_grade_TextView2.setText("");
        mShow_grade_TextView3.setText("");

    }
}
