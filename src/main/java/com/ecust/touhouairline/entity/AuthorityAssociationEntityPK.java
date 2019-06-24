package com.ecust.touhouairline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AuthorityAssociationEntityPK implements Serializable {
    private String characterNo;
    private String authorityNo;

    @Column(name = "characterNo")
    @Id
    public String getCharacterNo() {
        return characterNo;
    }

    public void setCharacterNo(String characterNo) {
        this.characterNo = characterNo;
    }

    @Column(name = "authorityNo")
    @Id
    public String getAuthorityNo() {
        return authorityNo;
    }

    public void setAuthorityNo(String authorityNo) {
        this.authorityNo = authorityNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorityAssociationEntityPK that = (AuthorityAssociationEntityPK) o;
        return Objects.equals(characterNo, that.characterNo) &&
                Objects.equals(authorityNo, that.authorityNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterNo, authorityNo);
    }
}
