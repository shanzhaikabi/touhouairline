package com.ecust.touhouairline.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "authoritytable", schema = "flight", catalog = "")
public class AuthorityEntity implements Serializable {
    private String authorityNo;
    private String authorityName;

    @Id
    @Column(name = "authorityno")
    public String getAuthorityNo() {
        return authorityNo;
    }

    public void setAuthorityNo(String authorityNo) {
        this.authorityNo = authorityNo;
    }

    @Basic
    @Column(name = "authorityname")
    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorityEntity that = (AuthorityEntity) o;
        return Objects.equals(authorityNo, that.authorityNo) &&
                Objects.equals(authorityName, that.authorityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorityNo, authorityName);
    }
}
