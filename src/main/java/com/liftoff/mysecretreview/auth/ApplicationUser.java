package com.liftoff.mysecretreview.auth;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.liftoff.mysecretreview.models.AbstractEntity;
import com.liftoff.mysecretreview.security.ApplicationUserRole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class ApplicationUser extends AbstractEntity implements UserDetails{

    private int userId;
    private String name;
    private String username;
    private String password;
    private Set<? extends GrantedAuthority> grantedAuthorities;
    private boolean isAccountNonExpired;
    private boolean locked;
    private boolean isCredentialsNonExpired;

    @OneToOne
    @Enumerated(EnumType.STRING)
    private ApplicationUserRole appUserRole;
    private boolean enabled;

    public ApplicationUser(String name,
                           String username,
                           String password,
                           Set<? extends GrantedAuthority> grantedAuthorities,
                           boolean isAccountNonExpired,
                           boolean locked,
                           boolean isCredentialsNonExpired,
                           ApplicationUserRole appUserRole,
                           boolean enabled) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.grantedAuthorities = grantedAuthorities;
        this.isAccountNonExpired = isAccountNonExpired;
        this.locked = locked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.appUserRole = appUserRole;
        this.enabled = enabled;
    }

    @Override
    @OneToMany
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
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
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String  toString() {
        return "User{" +
                "userId=" + userId +
                ", studentName='" + username + '\'' +
                '}';
    }
}
