package org.alexandraavendano.printerstore.security;

import org.alexandraavendano.printerstore.models.Client;
import org.alexandraavendano.printerstore.models.Employee;
import org.alexandraavendano.printerstore.models.Person;
import org.alexandraavendano.printerstore.service.ClientServicesImpl;
import org.alexandraavendano.printerstore.service.EmployeeServices;
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
    private final ClientServicesImpl clientServices;
    private final EmployeeServices employeeServices;

    public ClientDetailsServiceImpl(ClientServicesImpl clientServices, EmployeeServices employeeServices) {
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


