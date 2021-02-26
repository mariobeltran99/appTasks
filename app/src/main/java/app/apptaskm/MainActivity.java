package app.apptaskm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void appGeneral(View v){
        Intent i = new Intent(this, General.class);
        startActivity(i);
    }
    public void appCountVote(View v){
        Intent i = new Intent(this, Vote.class);
        startActivity(i);
    }
    public void appSalary(View v){
        Intent i = new Intent(this, Employee.class);
        startActivity(i);
    }
}