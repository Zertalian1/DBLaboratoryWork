package com.example.dblaboratorywork.details

import com.example.dblaboratorywork.entity.User
import com.example.dblaboratorywork.enums.Role
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails

data class UserDetailsImpl(
    private var user: User
): UserDetails
{
    private var email: String  = user.email
    private var password: String = user.password
    private var role: Role = user.roles

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return AuthorityUtils.createAuthorityList(role.toString());
    }

    override fun getPassword(): String = password

    override fun getUsername(): String = email

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}