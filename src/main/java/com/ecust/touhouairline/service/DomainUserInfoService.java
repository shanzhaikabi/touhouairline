package com.ecust.touhouairline.service;

import com.ecust.touhouairline.consts.DomainUserInfoConsts;
import com.ecust.touhouairline.entity.PassengerEntity;
import com.ecust.touhouairline.entity.UserEntity;
import com.ecust.touhouairline.entity.UserEntityTmp;
import com.ecust.touhouairline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author 李霄
 * 创建日期：2019-6-19
 **/
@Service
public class DomainUserInfoService {
    @Autowired
    UserRepository userRepository;

    public String changeUserInfo(UserEntity user, UserEntityTmp result){
        if (!result.getPassword().isEmpty() || !result.getPasswordAgain().isEmpty()) {
            if (result.getPassword().length() < 6 || result.getPassword().length() > 33) return "密码长度在6～11位";
            if (!result.getPassword().equals(result.getPasswordAgain())) return "两次密码不一致";
            user.setPassword(result.getPassword());
        }
        if (!result.getNickname().isEmpty()) user.setNickName(result.getNickname());
        if (!result.getEmail().isEmpty()) user.setEmail(result.getEmail());
        if (!result.getPhone().isEmpty()) user.setUserPhone(result.getPhone());
        userRepository.save(user);
        return DomainUserInfoConsts.USER_CHANGE_SUCCESS;
    }

    public Collection<PassengerEntity> showPassages(UserEntity user){
        return user.getPassengersByUserNo();
    }

    public String addPassenger(UserEntity user, PassengerEntity passenger){
        if (passenger.getPassengerName().isEmpty()) return DomainUserInfoConsts.PASSENGER_NAME_ERROR;
        if (passenger.getPassengerType().isEmpty()) return DomainUserInfoConsts.PASSENGER_TYPE_ERROR;
        if (passenger.getSex().isEmpty()) return DomainUserInfoConsts.PASSENGER_SEX_ERROR;
        addPassengerToUser(user,passenger);
        userRepository.save(user);
        return DomainUserInfoConsts.PASSENGER_ADD_SUCCESS;
    }

    public String changePassenger(UserEntity user, PassengerEntity passenger){
        if (passenger.getPassengerName().isEmpty()) return DomainUserInfoConsts.PASSENGER_NAME_ERROR;
        if (passenger.getPassengerType().isEmpty()) return DomainUserInfoConsts.PASSENGER_TYPE_ERROR;
        if (passenger.getSex().isEmpty()) return DomainUserInfoConsts.PASSENGER_SEX_ERROR;
        reloadPassengerToUser(user,passenger);
        userRepository.save(user);
        return DomainUserInfoConsts.PASSENGER_CHANGE_SUCCESS;
    }

    public String deletePassenger(UserEntity user, PassengerEntity passenger){
        if (removePassengerToUser(user,passenger)) return DomainUserInfoConsts.PASSENGER_DELETE_SUCCESS;
        return DomainUserInfoConsts.PASSENGER_NOT_FOUND_ERROR;
    }

    private void addPassengerToUser(UserEntity user, PassengerEntity passenger){
        user.getPassengersByUserNo().add(passenger);
    }

    private void reloadPassengerToUser(UserEntity user, PassengerEntity passenger){
        for (PassengerEntity passengerEntity : user.getPassengersByUserNo()) {
            if (passengerEntity.getPassengerNo().equals(passenger.getPassengerNo())){
                user.getPassengersByUserNo().remove(passengerEntity);
                user.getPassengersByUserNo().add(passenger);
                return;
            }
        }
        addPassenger(user,passenger);
    }

    private boolean removePassengerToUser(UserEntity user, PassengerEntity passenger){
        for (PassengerEntity passengerEntity : user.getPassengersByUserNo()) {
            if (passengerEntity.getPassengerNo().equals(passenger.getPassengerNo())){
                user.getPassengersByUserNo().remove(passengerEntity);
                return true;
            }
        }
        return false;
    }

}
