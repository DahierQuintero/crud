package com.api.crud.dto;

import com.api.crud.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String firstName;
    private String email;

    public static UserModel userDTOToUserModel(UserDTO userDTO){
        return new UserModel(userDTO.getId(), userDTO.firstName, userDTO.getEmail());
    }
}
