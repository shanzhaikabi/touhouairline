package com.ecust.touhouairline.entity;

public class UserEntityTmp{
    private UserEntity userEntity;
    private String passwordAgain;

    public UserEntityTmp(String username, String password, String passwordAgain, String email, String phone,String nickname) {
        this.userEntity = new UserEntity();
        userEntity.setUserName(username);
        userEntity.setPassword(password);
        userEntity.setNickName(nickname);
        userEntity.setEmail(email);
        userEntity.setUserPhone(phone);
        userEntity.setCredit(0);
        this.passwordAgain = passwordAgain;
    }

    public void setCharacterEntity(CharacterEntity entity){
        this.userEntity.setCharacterByUserNo(entity);
    }

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public String getUsername(){
        return userEntity.getUserName();
    }

    public String getPassword(){
        return userEntity.getPassword();
    }

    public String getEmail(){
        return userEntity.getEmail();
    }

    public String getPhone(){
        return userEntity.getUserPhone();
    }

    public String getNickname() {return userEntity.getNickName();}

    public UserEntity getUserEntity(){
        return userEntity;
    }
}