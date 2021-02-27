package app.apptaskm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class General extends AppCompatActivity {

    private EditText a, b, c;
    private TextView tx1, tx2;
    private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        configView();
        validateComponents();
    }
    private void configView(){
        a = findViewById(R.id.eta);
        b = findViewById(R.id.etb);
        c = findViewById(R.id.etc);
        tx1 = findViewById(R.id.tv_x1);
        tx2 = findViewById(R.id.tv_x2);
        bt1 = findViewById(R.id.btncal);
        a.setFocusable(true);
    }
    private void validateComponents(){
        a.setOnFocusChangeListener((v, hasFocus) -> {
            if(a.getText().length() == 0){
                a.setError("Campo Vacío");
                bt1.setClickable(false);
            }else{
                bt1.setClickable(true);
            }
        });
        b.setOnFocusChangeListener((v, hasFocus) -> {
            if(b.getText().length() == 0){
                b.setError("Campo Vacío");
                bt1.setClickable(false);
            }else{
                bt1.setClickable(true);
            }
        });
        c.setOnFocusChangeListener((v, hasFocus) -> {
            if(c.getText().length() == 0){
                c.setError("Campo Vacío");
                bt1.setClickable(false);
            }else{
                bt1.setClickable(true);
            }
        });
    }
    public void formulate(View v){
        try{
            double dis = 0.0, x1 = 0.0, x2 = 0.0, deno = 0.0;
            DecimalFormat df = new DecimalFormat("0.00");
            double va = Double.parseDouble(a.getText().toString());
            double vb = Double.parseDouble(b.getText().toString());
            double vc = Double.parseDouble(c.getText().toString());
            dis = Math.pow(vb,2)-4*va*vc;
            deno = 2 * va;
            if(dis >= 0 && deno != 0){
                x1 = (- vb + Math.sqrt(dis) ) / (2 * va);
                x2 = (- vb - Math.sqrt(dis) ) / (2 * va);
                tx1.setText("X1: " + String.valueOf(df.format(x1)));
                tx2.setText("X2: " + String.valueOf(df.format(x2)));
            }else{
                Toast.makeText(this, "No se puede resolver, porque el discriminante da imaginario o se indetermina", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Toast.makeText(this, "No cumplió con lo solicitado", Toast.LENGTH_LONG).show();
        }
    }
}