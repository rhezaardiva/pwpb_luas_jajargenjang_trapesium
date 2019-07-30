package org.sandec.aplikasirumusbangundatar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int req_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnjajargenjangA = findViewById(R.id.idjajargenjang);
        btnjajargenjangA.setOnClickListener(this);

        Button btntrapesiumA = findViewById(R.id.idtrapesium);
        btntrapesiumA.setOnClickListener(this);

        Button btnresultdataA = findViewById(R.id.idjajargenjang);
        btnresultdataA.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.idjajargenjang:
                Intent data = new Intent(MainActivity.this, JajarGenjang.class);
                startActivityForResult(data, req_code);
                break;
            case R.id.idtrapesium:
                Intent moveIntentA = new Intent(MainActivity.this, Trapesium.class);
                startActivity(moveIntentA);
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == req_code){
            if (resultCode == RESULT_OK){
                TextView hasilnama = findViewById(R.id.view1);
                hasilnama.setText(data.getData().toString());
            }
        }
    }
}
