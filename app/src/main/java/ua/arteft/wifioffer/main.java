package ua.arteft.wifioffer;

import android.app.Activity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.*;


public class main extends Activity implements OnClickListener {
    private Button btnStart;
    private Button btnStop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        btnStart = (Button)findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStart:
                startService(new Intent(this, services.class));
                break;
            case R.id.btnStop:
               stopService(new Intent(this, services.class));
                break;
        }

    }
}
