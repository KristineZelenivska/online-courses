package com.example.onlinecourses.security;

import com.example.onlinecourses.model.OCGroup;
import com.example.onlinecourses.model.OCUser;
import com.example.onlinecourses.model.OCUserGroups;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OCUserDetails implements UserDetails {
    private String username;
    private String password;

    private OCUser user;

    public OCUserDetails(OCUser ocUser) {
        user = ocUser;
        username = ocUser.getUsername();
        password = ocUser.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authList = new ArrayList<>();
        for (OCUserGroups group : user.getUserGroups()) {
            authList.add(new SimpleGrantedAuthority(group.getGroup().getName()));
        }
        return authList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
