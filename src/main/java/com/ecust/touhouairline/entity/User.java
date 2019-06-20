package com.ecust.touhouairline.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {
    @Id
    private String Id;
    private String AccountName;
    private String Password;
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(Id, user.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
