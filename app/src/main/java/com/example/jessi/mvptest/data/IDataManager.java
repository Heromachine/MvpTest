package com.example.jessi.mvptest.data;

import com.example.jessi.mvptest.data.models.simpsonmodels.AllCharacters;
import com.example.jessi.mvptest.data.network.IDBHelper;

public interface IDataManager extends IDBHelper {

    void getNote(OnResponseListener onResponseListener);
    void getAllCharacters(OnResponseListener onResponseListener);

    interface OnResponseListener {
        void getTodoNote(String string);
        void callAllCharacters(AllCharacters allCharacters);
    }
}
