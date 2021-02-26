package app.apptaskm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class DetailsEmployee extends AppCompatActivity {

    private TextView bon;
    private TextView emp1name, emp1last, emp1hour,emp1car, emp1slb, emp1iss,emp1afp, emp1ren, emp1liq, emp1per,emp1abo, emp1net;
    private TextView emp2name, emp2last, emp2hour,emp2car, emp2slb, emp2iss,emp2afp, emp2ren, emp2liq, emp2per,emp2abo, emp2net;
    private TextView emp3name, emp3last, emp3hour,emp3car, emp3slb, emp3iss,emp3afp, emp3ren, emp3liq, emp3per,emp3abo, emp3net;
    private TextView salMa, salMe, salMyM, may1, may2, may3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_employee);
        configView();
        ArrayList<Person> pers;
        pers = (ArrayList<Person>) getIntent().getSerializableExtra("PersonsList");
        showDetails(pers);
    }
    private void showDetails(ArrayList<Person> p){
        DecimalFormat df = new DecimalFormat("0.00");
        Boolean dat = validateBo(p);
        String msg = "";
        if(dat){
            msg = "No hay bonos para los empleados";
        }
        //message Bonus
        bon.setText(msg);
        //empleado1
        emp1name.setText("Nombres: " + p.get(0).getName());
        emp1last.setText("Apellidos: " + p.get(0).getLast());
        emp1hour.setText("Horas Trabajadas: " + p.get(0).getHour().toString());
        emp1car.setText("Cargo: " + p.get(0).getCargo());
        emp1slb.setText("Sueldo Base: $" + df.format(p.get(0).salaryBase()));
        emp1iss.setText("ISSS(5.25%): $" + df.format(p.get(0).desISS()));
        emp1afp.setText("AFP(6.88%): $" + df.format(p.get(0).desAFP()));
        emp1ren.setText("RENTA(10%): $" + df.format(p.get(0).desREN()));
        emp1liq.setText("Salario Líquido: $" + df.format(p.get(0).salaryLiq()));
        emp1per.setText("Porcentaje del Bonus: " + p.get(0).percentBonus(dat).toString() + "%");
        emp1abo.setText("Monto del Bono: $" + df.format(p.get(0).amountBonus(dat)));
        emp1net.setText("Salario Neto: $" + df.format(p.get(0).salaryNet(dat)));
        //empleado2
        emp2name.setText("Nombres: " + p.get(1).getName());
        emp2last.setText("Apellidos: " + p.get(1).getLast());
        emp2hour.setText("Horas Trabajadas: " + p.get(1).getHour().toString());
        emp2car.setText("Cargo: " + p.get(1).getCargo());
        emp2slb.setText("Sueldo Base: $" + df.format(p.get(1).salaryBase()));
        emp2iss.setText("ISSS(5.25%): $" + df.format(p.get(1).desISS()));
        emp2afp.setText("AFP(6.88%): $" + df.format(p.get(1).desAFP()));
        emp2ren.setText("RENTA(10%): $" + df.format(p.get(1).desREN()));
        emp2liq.setText("Salario Líquido: $" + df.format(p.get(1).salaryLiq()));
        emp2per.setText("Porcentaje del Bonus: " + p.get(1).percentBonus(dat).toString() + "%");
        emp2abo.setText("Monto del Bono: $" + df.format(p.get(1).amountBonus(dat)));
        emp2net.setText("Salario Neto: $" + df.format(p.get(1).salaryNet(dat)));
        //empleado3
        emp3name.setText("Nombres: " + p.get(2).getName());
        emp3last.setText("Apellidos: " + p.get(2).getLast());
        emp3hour.setText("Horas Trabajadas: " + p.get(2).getHour().toString());
        emp3car.setText("Cargo: " + p.get(2).getCargo());
        emp3slb.setText("Sueldo Base: $" + df.format(p.get(2).salaryBase()));
        emp3iss.setText("ISSS(5.25%): $" + df.format(p.get(2).desISS()));
        emp3afp.setText("AFP(6.88%): $" + df.format(p.get(2).desAFP()));
        emp3ren.setText("RENTA(10%): $" + df.format(p.get(2).desREN()));
        emp3liq.setText("Salario Líquido: $" + df.format(p.get(2).salaryLiq()));
        emp3per.setText("Porcentaje del Bonus: " + p.get(2).percentBonus(dat).toString() + "%");
        emp3abo.setText("Monto del Bono: $" + df.format(p.get(2).amountBonus(dat)));
        emp3net.setText("Salario Neto: $" + df.format(p.get(2).salaryNet(dat)));
        mayor300(p, dat);
        mayymenor(p, dat);
    }
    private void configView(){
        //messageBonus
        bon = findViewById(R.id.tv_bono);
        //empleado 1
        emp1name = findViewById(R.id.tv_name1);
        emp1last = findViewById(R.id.tv_lastname1);
        emp1hour = findViewById(R.id.tv_hour1);
        emp1car = findViewById(R.id.tv_cargs1);
        emp1slb = findViewById(R.id.tv_salbase1);
        emp1iss = findViewById(R.id.tv_isss1);
        emp1afp = findViewById(R.id.tv_afp1);
        emp1ren = findViewById(R.id.tv_renta1);
        emp1liq = findViewById(R.id.tv_liqsal1);
        emp1per = findViewById(R.id.tv_porc1);
        emp1abo = findViewById(R.id.tv_amountb1);
        emp1net = findViewById(R.id.tv_salneto1);
        //empleado 2
        emp2name = findViewById(R.id.tv_name2);
        emp2last = findViewById(R.id.tv_lastname2);
        emp2hour = findViewById(R.id.tv_hour2);
        emp2car = findViewById(R.id.tv_cargs2);
        emp2slb = findViewById(R.id.tv_salbase2);
        emp2iss = findViewById(R.id.tv_isss2);
        emp2afp = findViewById(R.id.tv_afp2);
        emp2ren = findViewById(R.id.tv_renta2);
        emp2liq = findViewById(R.id.tv_liqsal2);
        emp2per = findViewById(R.id.tv_porc2);
        emp2abo = findViewById(R.id.tv_amountb2);
        emp2net = findViewById(R.id.tv_salneto2);
        //empleado 3
        emp3name = findViewById(R.id.tv_name3);
        emp3last = findViewById(R.id.tv_lastname3);
        emp3hour = findViewById(R.id.tv_hour3);
        emp3car = findViewById(R.id.tv_cargs3);
        emp3slb = findViewById(R.id.tv_salbase3);
        emp3iss = findViewById(R.id.tv_isss3);
        emp3afp = findViewById(R.id.tv_afp3);
        emp3ren = findViewById(R.id.tv_renta3);
        emp3liq = findViewById(R.id.tv_liqsal3);
        emp3per = findViewById(R.id.tv_porc3);
        emp3abo = findViewById(R.id.tv_amountb3);
        emp3net = findViewById(R.id.tv_salneto3);
        //mayores a 300
        may1 = findViewById(R.id.tv_may1);
        may2 = findViewById(R.id.tv_may2);
        may3 = findViewById(R.id.tv_may3);
        //mayor y menor
        salMa = findViewById(R.id.tv_salMay);
        salMe = findViewById(R.id.tv_salMen);
        salMyM = findViewById(R.id.tv_salMyM);
    }
    private Boolean validateBo(ArrayList<Person> list){
        return list.get(0).getCargo().contains("Gerente") && list.get(1).getCargo().contains("Asistente") && list.get(2).getCargo().contains("Secretaria");
    }
    private void mayor300(ArrayList<Person> pe, Boolean d ){
        ArrayList<String> names = new ArrayList<String>();
        DecimalFormat dl = new DecimalFormat("0.00");
        for(int i = 0; i < pe.size(); i++){
            if(pe.get(i).salaryNet(d) > 300.00){
                names.add("Empleado " + (i+1) + ": " + pe.get(i).getName() + " - $" + dl.format(pe.get(i).salaryNet(d)));
            }
        }
        if(names.size() == 0){
            names.add("No hay salarios mayores a $300.00");
            may1.setText(names.get(0));
        }else if(names.size() == 1){
            may1.setText(names.get(0));
        }else if(names.size() == 2){
            may1.setText(names.get(0));
            may2.setText(names.get(1));
        }else{
            may1.setText(names.get(0));
            may2.setText(names.get(1));
            may3.setText(names.get(2));
        }
    }
    private void mayymenor(ArrayList<Person> pe, Boolean d){
        Double plus = 0.00;
        Double minus = 0.00;
        Integer pos1 = 0, pos2 = 0;
        String msgm = "";
        DecimalFormat ds = new DecimalFormat("0.00");
        plus = pe.get(0).salaryNet(d);
        minus = pe.get(0).salaryNet(d);
        for(int j = 1; j < pe.size(); j++){
            if(pe.get(j).salaryNet(d) > plus){
                plus = pe.get(j).salaryNet(d);
                pos1 = j;
            }
            if(pe.get(j).salaryNet(d) < minus){
                minus = pe.get(j).salaryNet(d);
                pos2 = j;
            }
        }
        salMa.setText("Empleado " + (pos1+1) + ": " + pe.get(pos1).getName() + " - $" + ds.format(plus));
        salMe.setText("Empleado " + (pos2+1) + ": " + pe.get(pos2).getName() + " - $" + ds.format(minus));
        if(plus.equals(minus)){
            msgm = "Los tres salarios son iguales";
        }
        salMyM.setText(msgm);
    }
}