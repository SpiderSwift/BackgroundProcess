package by.citech.testbroadcast;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = new Intent(getApplicationContext(), MyService.class);
        getApplicationContext().startService(i);
        setContentView(R.layout.activity_main);


    }



    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}
