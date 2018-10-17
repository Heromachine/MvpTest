package com.example.jessi.mvptest.data.network;

import com.example.jessi.mvptest.data.IDataManager;

public interface IDBHelper {

    void createRow(String string);
    void readRow(IDataManager.OnResponseListener listener);
    void volleyCall(IDataManager.OnResponseListener listener, String url);
    void updateRow();
    void deleteRow();
}
