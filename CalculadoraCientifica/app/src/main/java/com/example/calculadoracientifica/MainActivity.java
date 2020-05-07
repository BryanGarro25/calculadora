package com.example.calculadoracientifica;

import androidx.appcompat.app.AppCompatActivity;

import android.media.audiofx.PresetReverb;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculadoracientifica.Logic.Evaluador;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    private String operacion ="";
    private List<Button> botones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.botones = new ArrayList<>();
        Button button0 = findViewById(R.id.cero_btn);
        this.botones.add(button0);
        Button button1 = findViewById(R.id.uno_btn);
        this.botones.add(button1);
        Button button2 = findViewById(R.id.dos_btn);
        this.botones.add(button2);
        Button button3 = findViewById(R.id.tres_btn);
        this.botones.add(button3);
        Button button4 = findViewById(R.id.cuatro_btn);
        this.botones.add(button4);
        Button button5 = findViewById(R.id.cinco_btn);
        this.botones.add(button5);
        Button button6 = findViewById(R.id.seis_btn);
        this.botones.add(button6);
        Button button7 = findViewById(R.id.siete_btn);
        this.botones.add(button7);
        Button button8 = findViewById(R.id.ocho_btn);
        this.botones.add(button8);
        Button button9 = findViewById(R.id.nueve_btn);
        this.botones.add(button9);
        Button button_tan = findViewById(R.id.tangente_btn);
        this.botones.add(button_tan);
        Button button_sen = findViewById(R.id.seno_btn);
        this.botones.add(button_sen);
        Button button_cos = findViewById(R.id.coseno_btn);
        this.botones.add(button_cos);
        Button button_pot = findViewById(R.id.e_btn);
        this.botones.add(button_pot);
        Button button_suma = findViewById(R.id.suma_btn);
        this.botones.add(button_suma);
        Button button_rest = findViewById(R.id.resta_btn);
        this.botones.add(button_rest);
        Button button_mult = findViewById(R.id.multiplicacion_btn);
        this.botones.add(button_mult);
        Button button_div = findViewById(R.id.division_btn);
        this.botones.add(button_div);
        Button button_open_parenthesis = findViewById(R.id.parentesis1_btn);
        this.botones.add(button_open_parenthesis);
        Button button_close_parenthesis = findViewById(R.id.parentesis2_btn);
        this.botones.add(button_close_parenthesis);
        Button button_square = findViewById(R.id.raiz_btn2);
        this.botones.add(button_square);
        Button button_ac= findViewById(R.id.AC_btn3);
        this.botones.add(button_ac);
        Button button_c = findViewById(R.id.C_btn);
        this.botones.add(button_c);
        Button button_porcentaje = findViewById(R.id.porcentaje_btn);
        this.botones.add(button_porcentaje);
        Button button_off= findViewById(R.id.salir_btn);
        this.botones.add(button_off);
        Button button_equal= findViewById(R.id.resultado_btn);
        this.botones.add(button_equal);
        TextView result_text = findViewById(R.id.textView);
        for (Button button : this.botones) {
            button.setOnClickListener(this);
        }

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cero_btn:
                expression("0");
                break;
            case R.id.uno_btn:
                expression("1");
                break;
            case R.id.dos_btn:
                expression("2");
                break;
            case R.id.tres_btn:
                expression("3");
                break;
            case R.id.cuatro_btn:
                expression("4");
                break;
            case R.id.cinco_btn:
                expression("5");
                break;
            case R.id.seis_btn:
                expression("6");
                break;
            case R.id.siete_btn:
                expression("7");
                break;
            case R.id.ocho_btn:
                expression("8");
                break;
            case R.id.nueve_btn:
                expression("9");
                break;
            case R.id.tangente_btn:
                expression("tan(");
                break;
            case R.id.seno_btn:
                expression("sen(");
                break;
            case R.id.coseno_btn:
                expression("cos(");
                break;
            case R.id.e_btn:
                expression("^");
                break;
            case R.id.suma_btn:
                expression("+");
                break;
            case R.id.resta_btn:
                expression("-");
                break;
            case R.id.multiplicacion_btn:
              expression("*");
                break;
            case R.id.division_btn:
                expression("/");
                break;
            case R.id.parentesis1_btn:
                expression("(");
                break;
            case R.id.parentesis2_btn:
                expression(")");
                break;
            case R.id.raiz_btn2:
                expression("sqrt(");
                break;
            case R.id.AC_btn3:
                delete_last();
                break;
            case R.id.C_btn:
                reset_operacion();
                break;
            case R.id.porcentaje_btn:
                expression("%");
                break;
            case R.id.salir_btn:
                closeApp();
                break;
            case R.id.resultado_btn:
                evaluate();
                break;


        }
    }
    private  void  closeApp(){
        finish();
        System.exit(0);
    }
    public void expression(String char_to_add){
        this.operacion += char_to_add;
        Toast.makeText(this, this.operacion, Toast.LENGTH_SHORT).show();
    }
    public void evaluate(){

        double result = Evaluador.eval(this.operacion);
        TextView result_text = findViewById(R.id.textView);
        result_text.setText(Double.toString(result));

    }
    public void reset_operacion(){
        this.operacion = "";
    }
    public void delete_last(){
        this.operacion = last(this.operacion);
    }
    private String last(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}
