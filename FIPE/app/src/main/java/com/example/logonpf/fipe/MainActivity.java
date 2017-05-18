package com.example.logonpf.fipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spMarca;
    private ArrayAdapter<Marca> adpMarca;
    private List<Marca> marcas = new ArrayList<Marca>();
    private Spinner spVeiculo;
    private ArrayAdapter<Veiculo> adpVeiculo;
    private List<Veiculo> veiculos = new ArrayList<Veiculo>();
    private Marca m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spMarca = (Spinner) findViewById(R.id.spMarca);


        adpMarca = new ArrayAdapter<Marca>(this,
                android.R.layout.simple_spinner_dropdown_item,
                marcas);
        spMarca.setAdapter(adpMarca);
    spMarca.setOnItemSelectedListener(this);


        spVeiculo = (Spinner) findViewById(R.id.spVeiculos);

        adpVeiculo = new ArrayAdapter<Veiculo>(this, android.R.layout.simple_spinner_dropdown_item,veiculos);
        spVeiculo.setAdapter(adpVeiculo);
       spVeiculo.setOnItemSelectedListener(this);

        carregarMarca();
    }

    private void carregarMarca() {

        String urlTXT = "http://fipeapi.appspot.com/api/1/carros/marcas.json";

        JsonArrayRequest req = new JsonArrayRequest(urlTXT,
                                                    new RequestMarca(adpMarca),
                                                    new RequestError());
        RequestQueue q = Volley.newRequestQueue(this);
        q.add(req);

    }




    private void carregarVeiculo(int idMarca){
        String urlTXT = "http://fipeapi.appspot.com/api/1/carros/veiculos/"+ idMarca + ".json";

        JsonArrayRequest req = new JsonArrayRequest(urlTXT, new RequestVeiculo(adpVeiculo), new RequestError());

        RequestQueue q = Volley.newRequestQueue(this);
        q.add(req);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Object sel = parent.getItemIdAtPosition(position);
       adpVeiculo.clear();
        if(sel instanceof Marca){
            int idMarca =  ((Marca) sel).getId();
            Toast.makeText(this, "IDmarca = " + idMarca, Toast.LENGTH_LONG).show();
            carregarVeiculo(idMarca);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
