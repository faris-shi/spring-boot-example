package com.github.faris.springsecurityformauthexmaple.model;

import com.github.faris.springsecurityformauthexmaple.config.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

@Data
@AllArgsConstructor
public class User implements UserDetails {

    private Long id;

    private String username;

    private String password;

    private Collection<UserRole> roles;

    private boolean isEnabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(UserRole::getPermissions)
                .flatMap(Collection::stream)
                .map(permission -> new SimpleGrantedAuthority(permission.getDescription()))
                .collect(toList());
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
        return isEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isEnabled();
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
