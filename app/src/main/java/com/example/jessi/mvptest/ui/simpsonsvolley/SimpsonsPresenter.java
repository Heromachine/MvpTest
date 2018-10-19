package com.example.jessi.mvptest.ui.simpsonsvolley;

import android.content.Context;
import android.util.Log;

import com.example.jessi.mvptest.BuildConfig;
import com.example.jessi.mvptest.data.DataManager;
import com.example.jessi.mvptest.data.IDataManager;
import com.example.jessi.mvptest.data.models.simpsonmodels.AllCharacters;

public class SimpsonsPresenter implements SimpsonsContract.Presenter, IDataManager.OnResponseListener {

    private static final String TAG = "SimpsonsPresenter";
    SimpsonsContract.View iView;
    IDataManager iDataManager;
    Context context;
    private final static String jSonUrl = BuildConfig.SERVER_URL_SIMP;

    public SimpsonsPresenter(SimpsonsActivity activity) {
        this.iView = activity;
        iDataManager = new DataManager();
        context = activity;
        //TODO FIX CALLS
        if(BuildConfig.FLAVOR.equals("volley"))
        {

            Log.d(TAG, "SimpsonsPresenter: VolleyCall ");
            iDataManager.volleyCall(this,jSonUrl );
        }
        else if(BuildConfig.FLAVOR.equals("retrofit")){
            Log.d(TAG, "SimpsonsPresenter: RetrofitCall");
            iDataManager.retrofitCall(this, "");
        }
    }

    @Override
    public void getTodoNote(String string) {
    }

    @Override
    public void callAllVolleyCharacters(AllCharacters allCharacters) {
        Log.d(TAG, "callAllVolleyCharacters: "+ allCharacters.getSimpsonsCharacterList().get(0).getDescription());
        this.iView.initListAdapter(allCharacters);
    }

    @Override
    public void callAllRetrofitCharacters(AllCharacters allCharacters) {
        Log.d(TAG, "callAllVolleyCharacters: "+ allCharacters.getSimpsonsCharacterList().get(0).getDescription());
        this.iView.initListAdapter(allCharacters);
    }
}
