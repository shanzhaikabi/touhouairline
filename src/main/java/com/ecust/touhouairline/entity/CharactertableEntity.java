package com.ecust.touhouairline.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "charactertable", schema = "flight", catalog = "")
public class CharactertableEntity {
    private String characterNo;
    private String characterName;
    private Collection<AuthorityassociationEntity> authorityassociationsByCharacterNo;
    private Collection<CharacterassociationEntity> characterassociationsByCharacterNo;

    @Id
    @Column(name = "characterNo")
    public String getCharacterNo() {
        return characterNo;
    }

    public void setCharacterNo(String characterNo) {
        this.characterNo = characterNo;
    }

    @Basic
    @Column(name = "characterName")
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
        CharactertableEntity that = (CharactertableEntity) o;
        return Objects.equals(characterNo, that.characterNo) &&
                Objects.equals(characterName, that.characterName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterNo, characterName);
    }

    @OneToMany(mappedBy = "charactertableByCharacterNo")
    public Collection<AuthorityassociationEntity> getAuthorityassociationsByCharacterNo() {
        return authorityassociationsByCharacterNo;
    }

    public void setAuthorityassociationsByCharacterNo(Collection<AuthorityassociationEntity> authorityassociationsByCharacterNo) {
        this.authorityassociationsByCharacterNo = authorityassociationsByCharacterNo;
    }

    @OneToMany(mappedBy = "charactertableByCharacterNo")
    public Collection<CharacterassociationEntity> getCharacterassociationsByCharacterNo() {
        return characterassociationsByCharacterNo;
    }

    public void setCharacterassociationsByCharacterNo(Collection<CharacterassociationEntity> characterassociationsByCharacterNo) {
        this.characterassociationsByCharacterNo = characterassociationsByCharacterNo;
    }
}
