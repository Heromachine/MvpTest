package com.example.jessi.mvptest.data.network;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DialogTitle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jessi.mvptest.data.IDataManager;
import com.example.jessi.mvptest.data.models.simpsonmodels.AllCharacters;
import com.example.jessi.mvptest.data.models.simpsonmodels.SimpsonsCharacter;
import com.example.jessi.mvptest.util.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DBHelper implements IDBHelper{

    private static final String TAG = "DBHelper";
    String networkString = null;

    public DBHelper() {
    }

    @Override
    public void createRow(String string) {
        networkString = string;
    }

    @Override
    public void readRow(IDataManager.OnResponseListener listener) {
        if(networkString == null) {
            networkString = "Network not Working";
        }
        else {
            listener.getTodoNote(networkString);
        }
    }

    @Override
    public void volleyCall(final IDataManager.OnResponseListener listener, String url)
    {
        Log.d(TAG, "jSonCall: "+ url);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "onResponse: ");
                        try {
                            JSONArray jSonArrRelatedTopics = response.getJSONArray("RelatedTopics");
                            final List<String> names = new ArrayList<String>();
                            final AllCharacters allCharacters = new AllCharacters();
                            for (int i = 0; i < jSonArrRelatedTopics.length(); i++) {
                                JSONObject jsonObject1 = jSonArrRelatedTopics.getJSONObject(i);
                                JSONObject jSonObjIcon = jSonArrRelatedTopics.getJSONObject(i).getJSONObject("Icon");
                                String url = jSonObjIcon.getString("URL");
                                SimpsonsCharacter character = new SimpsonsCharacter(jsonObject1.getString("Text"), url);
                                names.add((i+1) +")"+character.getName());
                                allCharacters.addCharacter(character);
                            }
                            listener.callAllCharacters(allCharacters);
                        } catch (JSONException e) {
                            Log.d(TAG, "onResponse: Exception"+ e.getMessage());
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: Error" + error.getMessage());
                error.printStackTrace();
            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }

    @Override
    public void updateRow() {

    }

    @Override
    public void deleteRow() {

    }
}
