package com.example.jessi.mvptest.ui.main;

import android.view.View;

import com.example.jessi.mvptest.R;
import com.example.jessi.mvptest.data.DataManager;
import com.example.jessi.mvptest.data.IDataManager;
import com.example.jessi.mvptest.data.models.simpsonmodels.AllCharacters;
import com.example.jessi.mvptest.ui.main.MainActivity;
import com.example.jessi.mvptest.ui.main.MainContract;

public class MainPresenter implements MainContract.Presenter, IDataManager.OnResponseListener{

    MainContract.View iView;
    IDataManager iDataManager;

    public MainPresenter(MainActivity mainActivity) {
        iView = mainActivity;
        iDataManager = new DataManager();
    }

    @Override
    public void onButtonClicked(View view) {
        switch(view.getId()){
            case R.id.btn_set:
                this.iView.showToast("Set Button Pressed");
                iDataManager.createRow(iView.getToDoString());
                break;
            case R.id.btn_get:
                this.iView.showToast("Get Button Pressed");
                iDataManager.readRow(this);
                break;
        }
    }

    @Override
    public void getTodoNote(String string){
        iView.showToast(string);
    }

    @Override
    public void callAllCharacters(AllCharacters allCharacters) {

    }
}
