package com.ecust.touhouairline.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "charactertable", schema = "flight", catalog = "")
public class CharacterEntity {
    private String characterNo;
    private String characterName;
    private Collection<AuthorityEntity> authorityByCharacterNo;

    @Id
    @Column(name = "characterno")
    public String getCharacterNo() {
        return characterNo;
    }

    public void setCharacterNo(String characterNo) {
        this.characterNo = characterNo;
    }

    @Basic
    @Column(name = "charactername")
    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterEntity that = (CharacterEntity) o;
        return Objects.equals(characterNo, that.characterNo) &&
                Objects.equals(characterName, that.characterName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterNo, characterName);
    }

    @ManyToMany
    @JoinTable(name = "authorityassociation",joinColumns = {
            @JoinColumn(name = "characterno",referencedColumnName = "characterno")},
            inverseJoinColumns = {
            @JoinColumn(name = "authorityno",referencedColumnName = "authorityno")
    })
    public Collection<AuthorityEntity> getAuthorityByCharacterNo() {
        return authorityByCharacterNo;
    }

    public void setAuthorityByCharacterNo(Collection<AuthorityEntity> authorityByCharacterNo) {
        this.authorityByCharacterNo = authorityByCharacterNo;
    }

}
