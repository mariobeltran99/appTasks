package app.apptaskm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Employee extends AppCompatActivity {

    private EditText named, lastnamed, hourd;
    private RadioButton rdb1, rdb2, rdb3, rdb4;
    private Button bt1;
    private TextView count;
    private Integer n = 0;
    private ArrayList<Person> persons = new ArrayList<Person>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        configView();
        validateComponents();
    }
    private void configView(){
        named = findViewById(R.id.etname);
        lastnamed = findViewById(R.id.etlastname);
        hourd = findViewById(R.id.ethours);
        rdb1 = findViewById(R.id.rd1);
        rdb2 = findViewById(R.id.rd2);
        rdb3 = findViewById(R.id.rd3);
        rdb4 = findViewById(R.id.rd4);
        bt1 = findViewById(R.id.btnemploy);
        count = findViewById(R.id.tvemp);
        count.setText("Empleado " + String.valueOf((n+1)));
    }
    private void validateComponents(){
        hourd.setOnFocusChangeListener((v, hasFocus) -> {
            if(hourd.getText().length() == 0){
                hourd.setError("Campo Vacío");
                bt1.setClickable(false);
            }else{
                bt1.setClickable(true);
            }
        });
        named.setOnFocusChangeListener((v, hasFocus) -> {
            if(named.getText().toString().trim().isEmpty()){
                named.setError("Campo Vacío");
                bt1.setClickable(false);
            }else{
                bt1.setClickable(true);
            }
        });
        lastnamed.setOnFocusChangeListener((v, hasFocus) -> {
            if(lastnamed.getText().toString().trim().isEmpty()){
                lastnamed.setError("Campo Vacío");
                bt1.setClickable(false);
            }else{
                bt1.setClickable(true);
            }
        });
    }
    private void clearComponents(){
        count.setText("Empleado " + String.valueOf((n+1)));
        named.getText().clear();
        lastnamed.getText().clear();
        hourd.getText().clear();
        rdb1.setChecked(true);
    }
    public void addEmployee(View v){
        try{
            String name = named.getText().toString();
            String last = lastnamed.getText().toString();
            Integer hours = Integer.parseInt(hourd.getText().toString());
            String cargo = "";
            if(hours <= 0){
                Toast.makeText(this,"No se pueden números negativos o cero",Toast.LENGTH_LONG).show();
            }else{
                if(rdb1.isChecked()){
                    cargo = "Gerente";
                }else if(rdb2.isChecked()){
                    cargo = "Asistente";
                }else if(rdb3.isChecked()){
                    cargo = "Secretaria";
                }else if(rdb4.isChecked()){
                    cargo = "Otro";
                }
                Person per = new Person(name, last, hours, cargo);
                persons.add(n,per);
                n++;
                if(n > 2){
                    Intent j = new Intent(this,DetailsEmployee.class);
                    j.putExtra("PersonsList", persons);
                    startActivity(j);
                }else{
                    clearComponents();
                }
            }
        }catch (Exception e){
            Toast.makeText(this, "No cumplió con lo solicitado", Toast.LENGTH_LONG).show();
        }

    }
}