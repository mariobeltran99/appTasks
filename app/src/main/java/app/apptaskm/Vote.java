package app.apptaskm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class Vote extends AppCompatActivity {

    private EditText secuences;
    private Button btn1;
    private TextView rc1, rc2, rc3, rc4, rc5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);
        configView();
        validateComponents();
    }
    private void configView(){
        secuences = findViewById(R.id.etsecuence);
        btn1 = findViewById(R.id.btnvotes);
        rc1 = findViewById(R.id.tv_cand1);
        rc2 = findViewById(R.id.tv_cand2);
        rc3 = findViewById(R.id.tv_cand3);
        rc4 = findViewById(R.id.tv_cand4);
        rc5 = findViewById(R.id.tv_cand5);
    }
    private void validateComponents(){
        secuences.setOnFocusChangeListener((v, hasFocus) -> {
            if(secuences.getText().length() == 0){
                secuences.setError("Campo Vacío");
                btn1.setClickable(false);
            }else{
                btn1.setClickable(true);
            }
        });
    }
    public void showVotes(View v){
        try{
            String[] Vot = secuences.getText().toString().split(",");
            int N, v1 = 0, v2 = 0, v3 = 0, v4 = 0, v5 = 0;
            double p1, p2, p3, p4, p5;
            N = Vot.length;
            for (String s : Vot) {
                if(s.equals("1")){
                    v1++;
                }else if(s.equals("2")){
                    v2++;
                }else if(s.equals("3")){
                    v3++;
                }else if(s.equals("4")){
                    v4++;
                }else {
                    v5++;
                }
            }
            p1 = (v1 * 100) / N;
            p2 = (v2 * 100) / N;
            p3 = (v3 * 100) / N;
            p4 = (v4 * 100) / N;
            p5 = (v5 * 100) / N;
            rc1.setText("Candidato #1 -> Votos: " + v1 + " Porcentaje: " + p1 + "%");
            rc2.setText("Candidato #2 -> Votos: " + v2 + " Porcentaje: " + p2 + "%");
            rc3.setText("Candidato #3 -> Votos: " + v3 + " Porcentaje: " + p3 + "%");
            rc4.setText("Candidato #4 -> Votos: " + v4 + " Porcentaje: " + p4 + "%");
            rc5.setText("Votos Nulos -> Votos: " + v5 + " Porcentaje: " + p5 + "%");
        }catch(Exception e){
            Toast.makeText(this,"Debe separar los candidatos como se muestra en el ejemplo",Toast.LENGTH_LONG).show();
        }
    }
}