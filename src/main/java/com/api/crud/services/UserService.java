package com.api.crud.services;

import com.api.crud.dto.UserDTO;
import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public List<UserDTO> getAll(){
        List<UserModel> userModelsList = userRepository.findAll();

        List<UserDTO> userDTOsList = new ArrayList<>();

        for (UserModel userModel : userModelsList) {
            UserDTO userDTO = UserModel.userModelToUserDTO(userModel);
            userDTOsList.add(userDTO);
        }
        return userDTOsList;
    }

    public UserDTO save(UserDTO userDTO){
        userRepository.findById(userDTO.getId())
                .ifPresentOrElse(
                    existingUser -> {
                        throw new RuntimeException("The User with ID : " + userDTO.getId() + " ");
                    },
                    () -> {
                        UserModel userToSave = UserDTO.userDTOToUserModel(userDTO);
                        userRepository.save(userToSave);
                    }
                );
        return userDTO;
    }
}
