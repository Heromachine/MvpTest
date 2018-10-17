package com.example.jessi.mvptest.ui.simpsons.simpsonmain;

import android.content.Context;
import android.util.Log;

import com.example.jessi.mvptest.data.DataManager;
import com.example.jessi.mvptest.data.IDataManager;
import com.example.jessi.mvptest.data.models.simpsonmodels.AllCharacters;

public class SimpsonsPresenter implements SimpsonsContract.Presenter, IDataManager.OnResponseListener {

    private static final String TAG = "SimpsonsPresenter";
    SimpsonsContract.View iView;
    IDataManager iDataManager;
    Context context;
    private final static String jSonUrl = "http://api.duckduckgo.com/?q=simpsons+characters&format=json";
    public SimpsonsPresenter(SimpsonsActivity activity) {
        this.iView = activity;
        iDataManager = new DataManager();
        context = activity;
        iDataManager.volleyCall(this,jSonUrl );
    }

    @Override
    public void getTodoNote(String string) {

    }

    @Override
    public void callAllCharacters(AllCharacters allCharacters) {
        Log.d(TAG, "callAllCharacters: "+ allCharacters.getSimpsonsCharacterList().get(0).getDescription());
        this.iView.initListAdapter(allCharacters);


    }
}
