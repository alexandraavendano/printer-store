package com.practicespring.printerstore.security;

import com.practicespring.printerstore.models.Client;
import com.practicespring.printerstore.models.Employee;
import com.practicespring.printerstore.models.Person;
import com.practicespring.printerstore.service.ClientServices;
import com.practicespring.printerstore.service.EmployeeServices;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class ClientDetailsServiceImpl implements UserDetailsService {
    private final ClientServices clientServices;
    private final EmployeeServices employeeServices;

    public ClientDetailsServiceImpl(ClientServices clientServices, EmployeeServices employeeServices) {
        this.clientServices = clientServices;
        this.employeeServices = employeeServices;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> client = clientServices.findBy(username);
        Optional<Employee> employee = employeeServices.findByEmail(username);
        Person validatedUser = null;

        if(employee.isPresent()) {
            validatedUser = employee.get();
        } else if(client.isPresent()){
            validatedUser = client.get();
        } else {
           throw new UsernameNotFoundException(username);
        }

        return new User(validatedUser.getEmail(), validatedUser.getPassword(), Collections.singleton(new SimpleGrantedAuthority(validatedUser.getRole().getName())));

    }
}


