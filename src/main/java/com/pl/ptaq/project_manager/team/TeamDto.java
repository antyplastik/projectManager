package com.pl.ptaq.project_manager.team;

import com.pl.ptaq.project_manager.user.domain.UserDto;
import lombok.*;
import org.joda.time.DateTime;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Data
public class TeamDto {

    private String name;

    private UserDto member;

    private DateTime creationTime;
}
