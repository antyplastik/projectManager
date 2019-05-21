package com.pl.ptaq.project_manager.team;

import com.pl.ptaq.project_manager.user.domain.UserCrudInterface;

import java.util.List;
import java.util.stream.Collectors;

class TeamMapper {

    public static TeamDto map(TeamEntity entity) {
        if (entity != null)
            return new TeamDto().builder()
                    .name(entity.getName())
                    .member(UserCrudInterface.map(entity.getMember()))
                    .creationTime(entity.getCreationTime())
                    .build();
        else
            return null;
    }

    public static TeamEntity map(TeamDto dto) {
        if (dto != null)
        return new TeamEntity().builder()
                .name(dto.getName())
                .member(UserCrudInterface.map(dto.getMember()))
                .creationTime(dto.getCreationTime())
                .build();
        else
            return null;
    }

    public static List<TeamDto> mapDtoList(List<TeamEntity> entities) {
        return entities.stream()
                .map(entity -> map(entity))
                .collect(Collectors.toList());
    }

    public static List<TeamEntity> mapEntityList(List<TeamDto> dtos) {
        return dtos.stream()
                .map(dto -> map(dto))
                .collect(Collectors.toList());
    }
}
