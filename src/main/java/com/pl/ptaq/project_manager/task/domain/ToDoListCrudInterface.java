package com.pl.ptaq.project_manager.task.domain;

import java.util.List;

interface ToDoListCrudInterface {

    boolean create();

    ToDoListDto read();

    boolean isExist();

    boolean update();

    boolean delete();

    static ToDoListDto map (ToDoListEntity entity){
        return ToDoListMapper.map(entity);
    }

    static ToDoListEntity map (ToDoListDto dto){
        return ToDoListMapper.map(dto);
    }

    static List<ToDoListDto> mapDtoList(List<ToDoListEntity> entities){
        return ToDoListMapper.mapDtoList(entities);
    }

    static List<ToDoListEntity> mapEntityList(List<ToDoListDto> dtos){
        return ToDoListMapper.mapEntityList(dtos);
    }
}
