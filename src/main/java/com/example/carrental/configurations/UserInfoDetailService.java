package com.example.carrental.configurations;

import com.example.carrental.models.Authorities;
import com.example.carrental.models.User;
import com.example.carrental.models.dto.UserDetailsDTO;
import com.example.carrental.repositories.AuthoritiesRepository;
import com.example.carrental.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserInfoDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.getByUsername(username);
        Authorities authorities = authoritiesRepository.getByUsername(username);
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO(user.getId(), user.getUsername(),user.getPassword(), authorities.getAuthority());
        UserInfoDetails userInfoDetails = new UserInfoDetails(userDetailsDTO);

        return userInfoDetails;
    }
}
