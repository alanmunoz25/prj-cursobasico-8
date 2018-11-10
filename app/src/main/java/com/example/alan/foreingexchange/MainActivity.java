package com.example.alan.foreingexchange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner mySpinner;
    private String[] currencies = {"DOP","USD","EUR"};

//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySpinner = findViewById(R.id.main_currency);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, currencies);
        mySpinner.setAdapter(adapter);

        final EditText editText = findViewById(R.id.input_valor);
        findViewById(R.id.btn_change).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                editText.onEditorAction(EditorInfo.IME_ACTION_DONE);
                String currency = mySpinner.getSelectedItem().toString();
                switch (currency) {
                    case "DOP":
                        convertDop();
                        break;
                    case "USD":
                        convertUsd();
                        break;
                    case "EUR":
                        convertEur();
                        break;
                }

            }
        });
    }


    public void convertDop() {
        
        EditText dop = findViewById(R.id.input_valor);
        dop.setInputType(InputType.TYPE_CLASS_NUMBER);

        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        formatter.applyPattern("#,###,###,###");
        
        double i = Integer.parseInt(dop.getText().toString());
        double res_usd = i / 50.60;
        double res_eur = i / 63.44;

        TextView tv_dop = findViewById(R.id.lbl_result_dop);
        tv_dop.setText(String.valueOf(formatter.format(i)));

        TextView usd = findViewById(R.id.lbl_result_usd);
        usd.setText(String.valueOf(formatter.format(res_usd)));

        TextView eur = findViewById(R.id.lbl_result_eur);
        eur.setText(String.valueOf(formatter.format(res_eur)));

    }
    public void convertUsd() {
        EditText usd = findViewById(R.id.input_valor);
        usd.setInputType(InputType.TYPE_CLASS_NUMBER);

        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        formatter.applyPattern("#,###,###,###");

        double i = Integer.parseInt(usd.getText().toString());
        double res_dop = i * 50.60;
        double res_eur = i * 0.88;

        TextView tv_usd = findViewById(R.id.lbl_result_usd);
        tv_usd.setText(String.valueOf(formatter.format(i)));

        TextView dop = findViewById(R.id.lbl_result_dop);
        dop.setText(String.valueOf(formatter.format(res_dop)));

        TextView eur = findViewById(R.id.lbl_result_eur);
        eur.setText(String.valueOf(formatter.format(res_eur)));

    }

    public void convertEur() {
        EditText eur = findViewById(R.id.input_valor);
        eur.setInputType(InputType.TYPE_CLASS_NUMBER);

        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        formatter.applyPattern("#,###,###,###");

        double i = Integer.parseInt(eur.getText().toString());
        double res_dop = i * 56.81;
        double res_usd = i * 1.13;

        TextView tv_eur = findViewById(R.id.lbl_result_eur);
        tv_eur.setText(String.valueOf(formatter.format(i)));

        TextView dop = findViewById(R.id.lbl_result_dop);
        dop.setText(String.valueOf(formatter.format(res_dop)));

        TextView usd = findViewById(R.id.lbl_result_usd);
        usd.setText(String.valueOf(formatter.format(res_usd)));
    }

    public void resetAll(View view) {
        TextView dop = findViewById(R.id.lbl_result_dop);
        TextView usd = findViewById(R.id.lbl_result_usd);
        TextView eur = findViewById(R.id.lbl_result_eur);
        EditText iValor = findViewById(R.id.input_valor);

        dop.setText("");
        usd.setText("");
        eur.setText("");
        iValor.setText("");
    }

}
