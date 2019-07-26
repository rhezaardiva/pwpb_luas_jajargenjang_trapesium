package org.sandec.aplikasirumusbangundatar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Trapesium extends AppCompatActivity implements View.OnClickListener{
    private EditText eAtas;
    private EditText eBawah;
    private EditText eTinggi;
    private Button bHitung;
    private TextView tHasilE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapesium);

        eAtas = findViewById(R.id.idatas);
        eBawah = findViewById(R.id.idbawah);
        eTinggi = findViewById(R.id.idtinggiT);
        bHitung = findViewById(R.id.bhitungT);
        tHasilE = findViewById(R.id.thasilt);

        bHitung.setOnClickListener(this);
        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
        }
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.bhitungT);
        String inputAtas = eAtas.getText().toString().trim();
        String inputBawah = eBawah.getText().toString().trim();
        String inputTinggi = eTinggi.getText().toString().trim();

        boolean isEmptyFields = false;
        boolean isInvalidDouble = false;

        if (TextUtils.isEmpty(inputAtas)){
            isEmptyFields = true;
            eAtas.setError("Tidak Boleh Kosong");
        } if (TextUtils.isEmpty(inputBawah)){
            isEmptyFields = true;
            eBawah.setError("Tidak Boleh Kosong");
        } if (TextUtils.isEmpty(inputTinggi)){
            isEmptyFields = true;
            eTinggi.setError("Tidak Boleh Kosong");
        }

        Double atas = toDouble(inputAtas);
        Double bawah = toDouble(inputBawah);
        Double tinggi = toDouble(inputTinggi);

        if (atas == null){
            isInvalidDouble = true;
            eAtas.setError("Nomor harus sesuai");
        } if (bawah == null){
            isInvalidDouble = true;
            eBawah.setError("Nomor harus sesuai");
        } if (tinggi == null){
            isInvalidDouble = true;
            eTinggi.setError("Nomor harus sesuai");
        } if (!isEmptyFields && !isInvalidDouble){
            double volume = (atas + bawah) * tinggi / 2;
            tHasilE.setText(String.valueOf(volume));
        }
    }

    private Double toDouble(String str){
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e){
            return null;
        }
    }

    private static final String STATE_RESULT = "state_result";
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tHasilE.getText().toString());
    }
}