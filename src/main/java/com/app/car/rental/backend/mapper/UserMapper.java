package com.app.car.rental.backend.mapper;

import com.app.car.rental.backend.domain.User;
import com.app.car.rental.backend.domain.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapper {

    public User mapToUser(UserDto userDto){
        return new User(userDto.getId(), userDto.getName());
    }

    public UserDto mapToUserDto(User user){
        return new UserDto(user.getId(), user.getName());
    }

    public List<User> mapToListUser(List<UserDto> userDtoList){
        return userDtoList.stream()
                .map(t -> new User(t.getId(), t.getName()))
                .collect(Collectors.toList());
    }

    public List<UserDto> mapToListUserDto(List<User> userList){
        return userList.stream()
                .map(t -> new UserDto(t.getId(), t.getName()))
                .collect(Collectors.toList());
    }
}
