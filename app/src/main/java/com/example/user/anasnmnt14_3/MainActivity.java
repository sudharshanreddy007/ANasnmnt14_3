package com.example.user.anasnmnt14_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    //creating objects
    EditText editText;
    TextView textView;
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //INITIALIZING
        editText= (EditText) findViewById(R.id.edittext);
        textView= (TextView) findViewById(R.id.textview);
        textView.setVisibility(View.GONE);
    }
    //Method to write messege in file
    public void writeMessage(View view){
        String message= editText.getText().toString();
        String file_Name="Student file.";
        try {

            FileOutputStream fileOutputStream = openFileOutput(file_Name,MODE_PRIVATE);
            fileOutputStream.write(message.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(),"message saved sucessfully",Toast.LENGTH_LONG).show();
            editText.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Read file in Internal Storage we use this method
    public void readMessage(View view){
        try {
            String Message ;
            FileInputStream fileInputStream=openFileInput("Student file");
            InputStreamReader inputStreamReader= new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer= new StringBuffer();

            try {
                while ((Message = bufferedReader.readLine())!=null) {
                    stringBuffer.append(Message + "\n");
                }
                textView.setText(stringBuffer.toString());
                textView.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}