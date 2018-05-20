package com.yahoo.reservation.service;

import com.yahoo.reservation.entity.User;
import com.yahoo.reservation.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserId(String userId);

    User save(UserRegistrationDto registration);
}
