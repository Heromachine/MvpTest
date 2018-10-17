package com.example.jessi.mvptest.ui.simpsons.simpsonmain;

import com.example.jessi.mvptest.data.models.simpsonmodels.AllCharacters;

public interface SimpsonsContract {

    interface View{
        void initListAdapter(AllCharacters allCharacters);
    }
    interface Presenter{}
}
