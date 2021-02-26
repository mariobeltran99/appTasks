package app.apptaskm;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String lastname;
    private Integer hour;
    private String cargo;

    public Person(String na, String last, Integer ho, String carg){
        name = na;
        lastname = last;
        hour = ho;
        cargo = carg;
    }
    public String getName(){
        return name;
    }
    public String getLast(){
        return lastname;
    }
    public Integer getHour(){
        return hour;
    }
    public String getCargo(){
        return cargo;
    }
    public Double salaryBase(){
        if(hour <= 160){
            return hour * 9.75;
        }else{
            return ( 160 * 9.75 ) + ( ( hour - 160 ) *11.50);
        }
    }
    public Double  desISS(){
        return salaryBase() * (5.25/100);
    }
    public Double  desAFP(){
        return salaryBase() * (6.88/100);
    }
    public Double  desREN(){
        return salaryBase() * 0.10;
    }
    public Double  salaryLiq(){
        return salaryBase() - desISS() - desAFP() - desREN();
    }
    public Double  percentBonus(Boolean sim){
        if(sim){
            return 0.00;
        }else{
            switch (cargo){
                case "Gerente": return 10.00;
                case "Asistente": return 5.00;
                case "Secretaria": return 3.00;
                case "Otro": return 2.00;
                default: return 0.00;
            }
        }
    }
    public Double amountBonus(Boolean simil){
        if(simil){
            return 0.00;
        }else{
            return salaryLiq() * (percentBonus(simil)/100);
        }
    }
    public Double salaryNet(Boolean fd){
        return salaryLiq() + amountBonus(fd);
    }
}
