package com.example.jessi.mvptest.data.models.simpsonmodels;

import java.util.ArrayList;
import java.util.List;

public class AllCharacters {

    List<SimpsonsCharacter> simpsonsCharacterList;


    public AllCharacters() {
        simpsonsCharacterList = new ArrayList<>();
    }

    public List<SimpsonsCharacter> getSimpsonsCharacterList() {
        return simpsonsCharacterList;
    }

    public void setSimpsonsCharacterList(List<SimpsonsCharacter> simpsonsCharacterList) {
        this.simpsonsCharacterList = simpsonsCharacterList;
    }

    public void addCharacter(SimpsonsCharacter simpsonsCharacter) {
        simpsonsCharacterList.add(simpsonsCharacter);
    }
}
