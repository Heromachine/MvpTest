package com.example.jessi.mvptest.ui.main;

import android.view.View;

public interface MainContract {

    interface View{

        void showToast(String message);

        void handleMethod(android.view.View view);

        String getToDoString();
    }

    interface Presenter{

        void onButtonClicked(android.view.View view);
    }
}
