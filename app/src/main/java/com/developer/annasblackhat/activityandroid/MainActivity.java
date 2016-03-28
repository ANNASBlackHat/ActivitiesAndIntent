package com.developer.annasblackhat.activityandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtData = (EditText) findViewById(R.id.editText);
        Button btnGo = (Button) findViewById(R.id.btnGo);
        Button btnPhone = (Button) findViewById(R.id.btnPhone);
        Button btnmap = (Button) findViewById(R.id.btnMap);

        btnGo.setOnClickListener(this);
        btnPhone.setOnClickListener(this);
        btnmap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGo :
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("data",edtData.getText().toString());
                intent.putExtra("umur", 18);
                startActivity(intent);
                break;
            case R.id.btnPhone :
                Intent intentPhone = new Intent(Intent.ACTION_DIAL);
                intentPhone.setData(Uri.parse("tel:085742257881"));
                startActivity(intentPhone);
                break;
            case R.id.btnMap :
                Intent intentMap = new Intent(Intent.ACTION_VIEW);
                intentMap.setData(Uri.parse("geo:0,0?q=Hartono Mall"));
                intentMap.setPackage("com.google.android.apps.maps");
                if(intentMap.resolveActivity(getPackageManager())!= null)
                    startActivity(intentMap);
                else
                    Toast.makeText(this, "Google maps belom di install",
                            Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
