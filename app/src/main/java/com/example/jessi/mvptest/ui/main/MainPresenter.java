package com.example.jessi.mvptest.ui.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.jessi.mvptest.R;
import com.example.jessi.mvptest.data.DataManager;
import com.example.jessi.mvptest.data.IDataManager;
import com.example.jessi.mvptest.ui.simpsonsvolley.SimpsonsActivity;

public class MainPresenter implements MainContract.Presenter{

    MainContract.View iView;
    IDataManager iDataManager;
    Context context;

    public MainPresenter(MainActivity mainActivity) {
        iView = mainActivity;
        iDataManager = new DataManager();
        context = mainActivity;
    }

    @Override
    public void onButtonClicked(View view) {

        switch(view.getId()){
            case R.id.btn_json:
                this.iView.showToast("Volley Selected");
                Intent vIntent = new Intent(
                        context,
                        SimpsonsActivity.class);
                context.startActivity(vIntent);
                break;
            case R.id.btn_retrofit:
                this.iView.showToast("Retrofit Selected");
                Intent rIntent = new Intent(
                        context,
                        SimpsonsActivity.class);
                context.startActivity(rIntent);
                break;
        }    }

}
