package com.example.jessi.mvptest.ui.simpsonsvolley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jessi.mvptest.R;
import com.example.jessi.mvptest.data.models.simpsonmodels.AllCharacters;
import com.example.jessi.mvptest.ui.character.CharacterActivity;

import java.util.ArrayList;
import java.util.List;

public class SimpsonsActivity extends AppCompatActivity implements SimpsonsContract.View {
    private static final String TAG = "SimpsonsActivity";
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    List<String> names = new ArrayList<String>();
  AllCharacters allCharacters ;
    SimpsonsContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_simpsons);
        presenter = new SimpsonsPresenter(this);
    }

    @Override
    public void initListAdapter(final AllCharacters allCharacters){
        Log.d(TAG, "initListAdapter: " + allCharacters.getSimpsonsCharacterList().get(0).getDescription());
        this.allCharacters = allCharacters;

        for(int i = 0; i < allCharacters.getSimpsonsCharacterList().size(); i++){
            names.add(allCharacters.getSimpsonsCharacterList().get(i).getName());
        }

        arrayAdapter = new ArrayAdapter<>
                (
                        SimpsonsActivity.this,
                        R.layout.listitem,
                        R.id.tv_character,
                        names
                );
        listView = findViewById(R.id.lv_simpsons_list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(
                        SimpsonsActivity.this,
                        CharacterActivity.class);
                Bundle mBundle = new Bundle();
                mBundle.putString(
                        "Name", allCharacters.getSimpsonsCharacterList().get(i).getName());
                mBundle.putString(
                        "Description", allCharacters.getSimpsonsCharacterList().get(i).getDescription());
                mBundle.putString(
                        "ImageURL", allCharacters.getSimpsonsCharacterList().get(i).getImageUrl());
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });
    }

}
