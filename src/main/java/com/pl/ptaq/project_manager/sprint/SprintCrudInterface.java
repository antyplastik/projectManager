package com.pl.ptaq.project_manager.sprint;

import java.util.List;

public interface SprintCrudInterface {

    boolean create (SprintDto sprintDto);

    SprintDto read (SprintDto sprintDto);

    boolean isExist(SprintDto sprintDto);

    boolean update(SprintDto sprintDto);

    boolean delete(SprintDto sprintDto);

    static SprintDto map (SprintEntity entity){
        return null;
    }

    static SprintEntity map(SprintDto dto){
        return null;
    }

    static List<SprintDto> mapDtoList(List<SprintEntity> entities){
        return null;
    }

    static List<SprintEntity> mapEntityList(List<SprintDto> dtos){
        return null;
    }
}
