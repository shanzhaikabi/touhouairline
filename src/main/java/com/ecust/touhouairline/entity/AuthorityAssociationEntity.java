package com.ecust.touhouairline.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "authorityassociation", schema = "flight", catalog = "")
@IdClass(AuthorityAssociationEntityPK.class)
public class AuthorityAssociationEntity {
    private String characterNo;
    private String authorityNo;
    private CharacterEntity characterByCharacterNo;
    private AuthorityEntity authorityByAuhtorityNo;

    @Id
    @Column(name = "characterNo")
    public String getCharacterNo() {
        return characterNo;
    }

    public void setCharacterNo(String characterNo) {
        this.characterNo = characterNo;
    }

    @Id
    @Column(name = "authorityNo")
    public String getAuthorityNo() {
        return authorityNo;
    }

    public void setAuthorityNo(String auhtorityNo) {
        this.authorityNo = auhtorityNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorityAssociationEntity that = (AuthorityAssociationEntity) o;
        return Objects.equals(characterNo, that.characterNo) &&
                Objects.equals(authorityNo, that.authorityNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterNo, authorityNo);
    }

    @ManyToOne
    @JoinColumn(name = "characterNo", referencedColumnName = "characterNo", nullable = false)
    public CharacterEntity getCharacterByCharacterNo() {
        return characterByCharacterNo;
    }

    public void setCharacterByCharacterNo(CharacterEntity charactertableByCharacterNo) {
        this.characterByCharacterNo = charactertableByCharacterNo;
    }

    @ManyToOne
    @JoinColumn(name = "auhtorityNo", referencedColumnName = "auhtorityNo", nullable = false)
    public AuthorityEntity getAuthorityByAuhtorityNo() {
        return authorityByAuhtorityNo;
    }

    public void setAuthorityByAuhtorityNo(AuthorityEntity authoritytableByAuhtorityNo) {
        this.authorityByAuhtorityNo = authoritytableByAuhtorityNo;
    }
}
