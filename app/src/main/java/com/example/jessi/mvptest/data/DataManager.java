package com.example.jessi.mvptest.data;

import com.example.jessi.mvptest.data.network.DBHelper;
import com.example.jessi.mvptest.data.network.IDBHelper;

public class DataManager implements IDataManager {

    IDBHelper idbHelper;

    public DataManager() {
        idbHelper = new DBHelper();
    }

    @Override
    public void createRow(String string) {
        idbHelper.createRow(string);

    }

    @Override
    public void readRow(OnResponseListener listener) {

        idbHelper.readRow(listener);
    }

    @Override
    public void volleyCall(OnResponseListener listener, String url) {
        idbHelper.volleyCall(listener, url);
    }

    @Override
    public void updateRow() {

    }

    @Override
    public void deleteRow() {

    }

    @Override
    public void getNote(OnResponseListener onResponseListener) {

    }

    @Override
    public void getAllCharacters(OnResponseListener onResponseListener) {

    }
}
