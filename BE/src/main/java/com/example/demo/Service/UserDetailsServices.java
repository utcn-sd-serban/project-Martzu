package com.example.demo.Service;


import com.example.demo.Model.BusinessOwner;
import com.example.demo.Model.Investor;
import com.example.demo.Persistence.API.RepositoryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailsServices implements UserDetailsService {

    private final RepositoryFactory repositoryFactory;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException{
        if(repositoryFactory.createInvestorRepository().findByUsername(s).isPresent())
        {
            Investor investor = repositoryFactory.createInvestorRepository().findByUsername(s).get();
            return new org.springframework.security.core.userdetails.User(investor.getUsername(), investor.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_INVESTOR")));
        }
        else
        {
            if(repositoryFactory.createBusinessOwnerRepository().findByUsername(s).isPresent())
            {
                BusinessOwner owner = repositoryFactory.createBusinessOwnerRepository().findByUsername(s).get();
                return new org.springframework.security.core.userdetails.User(owner.getUsername(), owner.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_OWNER")));
            }

        }
        return new org.springframework.security.core.userdetails.User("", "",
                Collections.singletonList(new SimpleGrantedAuthority("NONE")));

    }

}
