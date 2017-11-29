package com.codemaicon.donc_app.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.codemaicon.donc_app.R;
import com.codemaicon.donc_app.model.ListaGastos;
import com.codemaicon.donc_app.model.ListaVereadores;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;


public class VereadoresActivity extends AppCompatActivity {

    TextView tvResultado;

    EditText edtInicioMandato;
    EditText edtFimMandato;
    EditText edtNomeCompleto;
    EditText edtPartido;
    EditText edtSexo;
    EditText edtTotalVotos;
    EditText edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vereadores);
        Consulta();

//        tvResultado = (TextView) findViewById(R.id.tvResultado);
    }

    public void Consulta() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://172.28.1.163:8080/web-app/webresources/ws/vereador/list",
                new AsyncHttpResponseHandler() {


                    @Override
                    public void onStart() {
                        super.onStart();
                    }

                    @Override
                    public void onSuccess(int i, Header[] headers, byte[] response) {

                        ListaVereadores listaVereadores = new ListaVereadores();
                        String responseString = "{\"listaVereadores\":" + new String(response) + "}";

                        Toast.makeText(VereadoresActivity.this, responseString, Toast.LENGTH_SHORT).show();

                        Gson g = new Gson();
                        listaVereadores = g.fromJson(responseString, ListaVereadores.class);
                        System.out.println(listaVereadores.getListaVereadores().size());

                        edtInicioMandato = (EditText) findViewById(R.id.etInicioMandato);
                        edtInicioMandato.setText(listaVereadores.getListaVereadores().get(0).getInicio_mandato());

                        edtFimMandato = (EditText) findViewById(R.id.etFimMandato);

                        edtNomeCompleto = (EditText) findViewById(R.id.etNomeCompleto);
                        edtNomeCompleto.setText(listaVereadores.getListaVereadores().get(0).getNome_completo());


                        edtPartido = (EditText) findViewById(R.id.etInicioMandato);
                        edtSexo = (EditText) findViewById(R.id.etSexo);
                        edtTotalVotos = (EditText) findViewById(R.id.etTotalVotos);
                        edtEmail = (EditText) findViewById(R.id.etEmail);

                    }

                    @Override
                    public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {

                    }


                });

    }

    public void consultaGastos(Integer id) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://172.28.1.163:8080/web-app/webresources/ws/gastos_vereador/list?=id"+id,
                new AsyncHttpResponseHandler() {


                    @Override
                    public void onStart() {
                        super.onStart();
                    }

                    @Override
                    public void onSuccess(int i, Header[] headers, byte[] response) {

                        ListaGastos listaGastos = new ListaGastos();
                        String responseString = "{\"listaGastos\":" + new String(response) + "}";

                        Toast.makeText(VereadoresActivity.this, responseString, Toast.LENGTH_SHORT).show();

                        Gson g = new Gson();
//                        listaVereadores = g.fromJson(responseString, ListaVereadores.class);
//                        System.out.println(listaVereadores.getListaVereadores().size());
//
//                        edtInicioMandato = (EditText) findViewById(R.id.etInicioMandato);
//                        edtInicioMandato.setText(listaVereadores.getListaVereadores().get(0).getInicio_mandato());
//
//                        edtFimMandato = (EditText) findViewById(R.id.etFimMandato);
//
//                        edtNomeCompleto = (EditText) findViewById(R.id.etNomeCompleto);
//                        edtNomeCompleto.setText(listaVereadores.getListaVereadores().get(0).getNome_completo());
//
//
//                        edtPartido = (EditText) findViewById(R.id.etInicioMandato);
//                        edtSexo = (EditText) findViewById(R.id.etSexo);
//                        edtTotalVotos = (EditText) findViewById(R.id.etTotalVotos);
//                        edtEmail = (EditText) findViewById(R.id.etEmail);

                    }

                    @Override
                    public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {

                    }


                });
    }
}

