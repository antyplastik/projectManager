package com.pl.ptaq.project_manager.user.domain;

import lombok.*;

import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "Users")
class User {

    @NotNull
    private String login;

    @NotNull
    private String password;

    @Email
    private String email;

    @NotNull
    private String nick;
}
