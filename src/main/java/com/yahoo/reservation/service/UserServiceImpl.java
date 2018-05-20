package com.yahoo.reservation.service;

import com.yahoo.reservation.entity.Role;
import com.yahoo.reservation.entity.User;
import com.yahoo.reservation.repository.UserRepository;
import com.yahoo.reservation.web.dto.UserRegistrationDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //UserDetailsServiceの場合、lodaUserByUsername(String)を必ずオーバーライド
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(userId);
        if (user == null){
            throw new UsernameNotFoundException("Invalid userid or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserId(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    public User findByUserId(String userId){
        return userRepository.findByUserId(userId);
    }

    public User save(UserRegistrationDto registration){
        User user = new User();
        user.setUserId(registration.getUserId());
        user.setName(registration.getName());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
