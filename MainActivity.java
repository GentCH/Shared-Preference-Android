package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et;
    SharedPreferences sharedPreferences;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText)findViewById(R.id.editText);
        tv = (TextView)findViewById(R.id.textView);
        sharedPreferences = getSharedPreferences("detail", MODE_PRIVATE);
    }

    public void setSharedPreferences(View v){
        if(et.getText().toString().equals("")){
            et.setError("text required");
        }
        else{
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("text", et.getText().toString());
            editor.commit();
            et.setText("");
            tv.setText(sharedPreferences.getString("text", ""));
        }
    }

    public void clearSharedPreferences(View v){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        if(sharedPreferences.contains("text")){
            tv.setText(sharedPreferences.getString("text", ""));
        }
        else{
            tv.setText("-");
        }
    }
}
