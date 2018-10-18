package com.example.jessi.mvptest.data.network;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jessi.mvptest.data.IDataManager;
import com.example.jessi.mvptest.data.models.simpsonmodels.AllCharacters;
import com.example.jessi.mvptest.data.models.simpsonmodels.Simpsons;
import com.example.jessi.mvptest.data.models.simpsonmodels.SimpsonsCharacter;
import com.example.jessi.mvptest.data.network.retrofit.ApiService;
import com.example.jessi.mvptest.data.network.retrofit.RetrofitInstance;
import com.example.jessi.mvptest.util.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


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
                            listener.callAllVolleyCharacters(allCharacters);
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
    public void retrofitCall(final IDataManager.OnResponseListener listener, String url) {
        Log.d(TAG, "retrofitCall: ");
        ApiService apiService = RetrofitInstance.getRetrofitInstance()
                .create(ApiService.class);
        Call<Simpsons> simpsonsCall = apiService.getRelatedTopics();
        simpsonsCall.enqueue(new Callback<Simpsons>() {
            @Override
            public void onResponse(Call<Simpsons> call, retrofit2.Response<Simpsons> response) {
                Log.d(TAG, "onResponse: Started");
                final List<String> names = new ArrayList<>();
                final AllCharacters allCharacters = new AllCharacters();
                Simpsons simpsons = response.body();
                for(int i = 0; i < simpsons.getRelatedTopicsList().size(); i++){
                    SimpsonsCharacter simpsonsCharacter = new SimpsonsCharacter(
                            response.body().getRelatedTopicsList().get(i).getText(),
                            response.body().getRelatedTopicsList().get(i).getIcons().getURL());
                    names.add(simpsonsCharacter.getName());
                    allCharacters.addCharacter(simpsonsCharacter);
                }
                Log.d(TAG, "onResponse: Finished" + allCharacters.getSimpsonsCharacterList().get(0).getDescription() );
                listener.callAllRetrofitCharacters(allCharacters);
            }

            @Override
            public void onFailure(Call<Simpsons> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    @Override
    public void updateRow() {

    }

    @Override
    public void deleteRow() {

    }
}
