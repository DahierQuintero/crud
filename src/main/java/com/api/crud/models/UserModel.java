package com.api.crud.models;

import com.api.crud.dto.UserDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserModel {
    @Id
    private Long id;
    @Column
    private String firstName;
    @Column
    private String email;

    public static UserDTO userModelToUserDTO(UserModel userModel){
        return new UserDTO(userModel.getId(),userModel.firstName, userModel.getEmail());
    }
}
