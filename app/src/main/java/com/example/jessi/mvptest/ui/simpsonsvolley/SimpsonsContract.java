package com.example.jessi.mvptest.ui.simpsonsvolley;

import com.example.jessi.mvptest.data.models.simpsonmodels.AllCharacters;

public interface SimpsonsContract {

    interface View{
        void initListAdapter(AllCharacters allCharacters);
    }
    interface Presenter{}
}
