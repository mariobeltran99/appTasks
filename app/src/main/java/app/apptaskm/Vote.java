package app.apptaskm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Vote extends AppCompatActivity {

    private EditText secuences;
    private Button btn1;
    private TextView rc1, rc2, rc3, rc4;
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
        
    }
}