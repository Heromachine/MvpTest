package com.example.jessi.mvptest.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jessi.mvptest.BuildConfig;
import com.example.jessi.mvptest.R;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    MainContract.Presenter presenter;
    String toDoString;
    Button btnRetrofit;
    Button btnJSon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simposn_intro);
        btnJSon = findViewById(R.id.btn_json);
        btnRetrofit = findViewById(R.id.btn_retrofit);



        if(BuildConfig.FLAVOR.equals("volley")) {

            btnRetrofit.setEnabled(false);

        }else if(BuildConfig.FLAVOR.equals("retrofit")) {

            btnJSon.setEnabled(false);
        }

        presenter = new MainPresenter(this);
    }

    @Override
    public void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void handleMethod(View view){
        switch(view.getId())
        {
            case R.id.btn_json:
                presenter.onButtonClicked(view);
                break;
            case R.id.btn_retrofit:
                presenter.onButtonClicked(view);
                break;
        }
    }

    @Override
    public String getToDoString(){
        return this.toDoString;

    }
}