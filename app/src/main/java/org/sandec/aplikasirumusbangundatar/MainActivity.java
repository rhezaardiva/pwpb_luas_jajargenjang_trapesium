package org.sandec.aplikasirumusbangundatar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnjajargenjangA = findViewById(R.id.idjajargenjang);
        btnjajargenjangA.setOnClickListener(this);

        Button btntrapesiumA = findViewById(R.id.idtrapesium);
        btntrapesiumA.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.idjajargenjang:
                Intent moveIntent = new Intent(MainActivity.this, JajarGenjang.class);
                startActivity(moveIntent);
            break;
            case R.id.idtrapesium:
                Intent moveIntentA = new Intent(MainActivity.this, Trapesium.class);
                startActivity(moveIntentA);
        }
    }
}
