package com.ibm.test.first_project.services.impl;

import com.ibm.test.first_project.data.models.User;
import com.ibm.test.first_project.data.repositories.UserRepository;
import com.ibm.test.first_project.utils.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException(String.format("User with username '%s' does not exist", user));
        }

        return new CustomUserDetails(user.get());
    }
}
