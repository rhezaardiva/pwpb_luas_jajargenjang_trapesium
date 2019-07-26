package org.sandec.aplikasirumusbangundatar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class JajarGenjang extends AppCompatActivity implements View.OnClickListener {
    private EditText eAlas;
    private EditText eTinggi;
    private Button bHitung;
    private TextView tHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jajar_genjang);

        eAlas = findViewById(R.id.idalas);
        eTinggi = findViewById(R.id.idtinggi);
        bHitung = findViewById(R.id.idhitung);
        tHasil = findViewById(R.id.idhasil);

        bHitung.setOnClickListener(this);
        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
        }
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.idhitung);
        String inputAlas =eAlas.getText().toString().trim();
        String inputTinggi = eTinggi.getText().toString().trim();

        boolean isEmptyFields = false;
        boolean isInvalidDouble = false;

        if (TextUtils.isEmpty(inputAlas)){
            isEmptyFields = true;
            eAlas.setError("Tidak Boleh Kosong");
        } if (TextUtils.isEmpty(inputTinggi)){
            isEmptyFields = true;
            eTinggi.setError("Tidak Boleh Kosong");
        }

        Double alas = toDouble(inputAlas);
        Double tinggi = toDouble(inputTinggi);

        if (alas == null){
            isInvalidDouble = true;
            eAlas.setError("Nomor harus sesuai");
        } if (tinggi == null){
            isInvalidDouble = true;
            eTinggi.setError("Nomor harus sesuai");
        } if (!isEmptyFields && !isInvalidDouble){
            double volume = alas * tinggi;
            tHasil.setText(String.valueOf(volume));
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
        outState.putString(STATE_RESULT, tHasil.getText().toString());
    }
}
