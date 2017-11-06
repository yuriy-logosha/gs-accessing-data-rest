package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import service.domain.Person;

import java.util.Collection;

import static java.util.Arrays.asList;

@Service
public class FakeUserDetailsService implements UserDetailsService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String ssn) throws UsernameNotFoundException {
        Person person = personRepository.findBySsn(ssn);
        if (person == null) {
            throw new UsernameNotFoundException("Username " + ssn + " not found");
        }
        return new User(ssn, "password", getGrantedAuthorities(ssn));
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(String ssn) {
        Collection<? extends GrantedAuthority> authorities;
        if (ssn.equals("170483-18001")) {
            authorities = asList(() -> "ROLE_ADMIN", () -> "ROLE_BASIC");
        } else {
            authorities = asList(() -> "ROLE_BASIC");
        }
        return authorities;
    }
}
