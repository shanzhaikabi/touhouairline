package com.ecust.touhouairline.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Chara {
    public String getCharacterId() {
        return characterId;
    }

    public void setCharacterId(String characterId) {
        this.characterId = characterId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    @Id
    private String characterId;
    private String characterName;
}
