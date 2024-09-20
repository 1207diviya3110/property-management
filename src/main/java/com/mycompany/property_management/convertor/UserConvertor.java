package com.mycompany.property_management.convertor;

import com.mycompany.property_management.dto.UserDTO;
import com.mycompany.property_management.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor {

    public UserEntity convertDTOtoEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setOwnerEmail(userDTO.getOwnerEmail());
        userEntity.setPhone(userDTO.getPhone());
        userEntity.setPassword(userDTO.getPassword());

        return userEntity;

    }

    public UserDTO convertEntityToDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setOwnerEmail(userEntity.getOwnerEmail());
        userDTO.setPhone(userEntity.getPhone());

        return userDTO;
    }
}
