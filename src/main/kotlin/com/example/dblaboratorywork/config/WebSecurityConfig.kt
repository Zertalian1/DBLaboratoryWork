package com.example.dblaboratorywork.config

import com.example.dblaboratorywork.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@EnableWebSecurity
@Configuration
@EnableMethodSecurity
class WebSecurityConfig(var passwordEncoder: PasswordEncoder,
                        val userService: UserService
) {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        return http
            .csrf().disable()
            .authorizeHttpRequests(
                Customizer { auth ->
                    auth
                        .requestMatchers("/registration", "/login").anonymous()
                        .requestMatchers("/newWorker").hasRole("ADMIN")
                        .requestMatchers("/manager**").hasRole("MANAGER")
                        .requestMatchers("/style/**", "/scripts/**").permitAll()
                        .anyRequest().authenticated()
                }
            )
            .formLogin { formLogin: FormLoginConfigurer<HttpSecurity?> ->
                formLogin
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .permitAll()
            }
            .logout { logout: LogoutConfigurer<HttpSecurity?> ->
                logout
                    .permitAll()
                    .logoutSuccessUrl("/")
            }
            .headers().frameOptions().sameOrigin()
            .and()
            .build()
    }

    @Autowired
    protected fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService<UserDetailsService>(userService).passwordEncoder(passwordEncoder)
    }
}