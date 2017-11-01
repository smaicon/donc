package com.codemaicon.donc_app.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.codemaicon.donc_app.R;
import com.codemaicon.donc_app.model.Vereador;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;


public class VereadoresActivity extends AppCompatActivity {

    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vereadores);

        tvResultado = (TextView) findViewById(R.id.tvResultado);
    }
    public  void Consulta(View view) {
        String url ="http://localhost:8080/DoncWebService/webresources/DONC/vereador/list";

        AsyncHttpClient client = new AsyncHttpClient();
    }



}

