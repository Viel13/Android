package com.example.logonpf.fipe;

import android.util.Log;
import android.widget.ArrayAdapter;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by logonrm on 18/05/2017.
 */

public class RequestVeiculo implements Response.Listener<JSONArray> {

    private ArrayAdapter<Veiculo> adpVeiculo;


    public RequestVeiculo(ArrayAdapter<Veiculo> adpVeiculo){
        this.adpVeiculo = adpVeiculo;

    }

    @Override
    public void onResponse(JSONArray response) {

        for (int i = 0; i < response.length(); i++) {
            try {

                JSONObject obj = response.getJSONObject(i);
                adpVeiculo.add(new Veiculo(obj.getInt("id"), obj.getString("name")));

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


        Log.i("FIPE", response.toString());

    }
}
