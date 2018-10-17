package com.example.jessi.mvptest.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jessi.mvptest.R;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    EditText etUserName;
    EditText etPassword;
    TextView tvDisplay;
    MainContract.Presenter presenter;
    String toDoString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            case R.id.btn_set:
                etUserName = findViewById(R.id.et_username);
                etPassword = findViewById(R.id.et_password);
                toDoString = etUserName.getText().toString() + "/" + etPassword.getText().toString();
                presenter.onButtonClicked(view);
                break;
            case R.id.btn_get:
                presenter.onButtonClicked(view);

                break;
        }

    }

    @Override
    public String getToDoString(){
        return this.toDoString;

    }


}