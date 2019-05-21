package com.pl.ptaq.project_manager.team;

import java.util.List;

public interface TeamCrudInterface {

    boolean create(TeamDto dto);

    TeamDto read(TeamDto dto);

    boolean isExist(TeamDto dto);

    boolean update(TeamDto dto);

    boolean delete(TeamDto dto);

    static TeamDto map (TeamEntity entity){
        return TeamMapper.map(entity);
    }

    static TeamEntity map (TeamDto dto){
        return TeamMapper.map(dto);
    }

    static List<TeamDto> mapDtoList(List<TeamEntity> entities){
        return TeamMapper.mapDtoList(entities);
    }

    static List<TeamEntity> mapEntityList(List<TeamDto> dtos){
        return TeamMapper.mapEntityList(dtos);
    }
}
