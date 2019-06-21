package com.ecust.touhouairline.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "flight", catalog = "")
public class UserEntity {
  @Id
  private String username;
  private String password;
  private String userPhone;
  private String email;
  private String nickname;
  private Integer credit;
  private CharacterassociationEntity characterassociationsByUsername;
  private Collection<OrdermasterEntity> ordermastersByUsername;
  private Collection<PassengerEntity> passengersByUsername;

  @Id
  @Column(name = "userNo")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Basic
  @Column(name = "password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Basic
  @Column(name = "userPhone")
  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }

  @Basic
  @Column(name = "email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Basic
  @Column(name = "nickName")
  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickName) {
    this.nickname = nickName;
  }

  @Basic
  @Column(name = "credit")
  public Integer getCredit() {
    return credit;
  }

  public void setCredit(Integer credit) {
    this.credit = credit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserEntity that = (UserEntity) o;
    return Objects.equals(username, that.username) &&
            Objects.equals(password, that.password) &&
            Objects.equals(userPhone, that.userPhone) &&
            Objects.equals(email, that.email) &&
            Objects.equals(nickname, that.nickname) &&
            Objects.equals(credit, that.credit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, nickname, password, userPhone, email, credit);
  }

  @OneToOne(mappedBy = "userByUserNo")
  public CharacterassociationEntity getCharacterassociationsByUsername() {
    return characterassociationsByUsername;
  }

  public void setCharacterassociationsByUsername(CharacterassociationEntity characterassociationsByUsername) {
    this.characterassociationsByUsername = characterassociationsByUsername;
  }

  @OneToMany(mappedBy = "userByUserNo")
  public Collection<OrdermasterEntity> getOrdermastersByUsername() {
    return ordermastersByUsername;
  }

  public void setOrdermastersByUsername(Collection<OrdermasterEntity> ordermastersByUsername) {
    this.ordermastersByUsername = ordermastersByUsername;
  }

  @OneToMany(mappedBy = "userByUserNo")
  public Collection<PassengerEntity> getPassengersByUsername() {
    return passengersByUsername;
  }

  public void setPassengersByUsername(Collection<PassengerEntity> passengersByUsername) {
    this.passengersByUsername = passengersByUsername;
  }
}
