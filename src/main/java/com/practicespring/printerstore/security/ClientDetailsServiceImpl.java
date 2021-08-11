package com.practicespring.printerstore.security;

import com.practicespring.printerstore.models.Client;
import com.practicespring.printerstore.repositories.ClientRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class ClientDetailsServiceImpl implements UserDetailsService {
    private final ClientRepository userRepository;

    public ClientDetailsServiceImpl(ClientRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> client = userRepository.findByEmail(username);
        Client validatedClient = client.orElseThrow(() -> new UsernameNotFoundException(username));
        return new User(validatedClient.getEmail(), validatedClient.getPassword(), Collections.emptyList());
    }
}


