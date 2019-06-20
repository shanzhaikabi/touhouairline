package com.ecust.touhouairline.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "authorityassociation", schema = "flight", catalog = "")
@IdClass(AuthorityassociationEntityPK.class)
public class AuthorityassociationEntity {
    private String characterNo;
    private String auhtorityNo;
    private CharactertableEntity charactertableByCharacterNo;
    private AuthoritytableEntity authoritytableByAuhtorityNo;

    @Id
    @Column(name = "characterNo")
    public String getCharacterNo() {
        return characterNo;
    }

    public void setCharacterNo(String characterNo) {
        this.characterNo = characterNo;
    }

    @Id
    @Column(name = "auhtorityNo")
    public String getAuhtorityNo() {
        return auhtorityNo;
    }

    public void setAuhtorityNo(String auhtorityNo) {
        this.auhtorityNo = auhtorityNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorityassociationEntity that = (AuthorityassociationEntity) o;
        return Objects.equals(characterNo, that.characterNo) &&
                Objects.equals(auhtorityNo, that.auhtorityNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterNo, auhtorityNo);
    }

    @ManyToOne
    @JoinColumn(name = "characterNo", referencedColumnName = "characterNo", nullable = false)
    public CharactertableEntity getCharactertableByCharacterNo() {
        return charactertableByCharacterNo;
    }

    public void setCharactertableByCharacterNo(CharactertableEntity charactertableByCharacterNo) {
        this.charactertableByCharacterNo = charactertableByCharacterNo;
    }

    @ManyToOne
    @JoinColumn(name = "auhtorityNo", referencedColumnName = "auhtorityNo", nullable = false)
    public AuthoritytableEntity getAuthoritytableByAuhtorityNo() {
        return authoritytableByAuhtorityNo;
    }

    public void setAuthoritytableByAuhtorityNo(AuthoritytableEntity authoritytableByAuhtorityNo) {
        this.authoritytableByAuhtorityNo = authoritytableByAuhtorityNo;
    }
}
