package com.example.security.dto;


import com.example.security.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

     StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "lastname", target = "surname")
    StudentDTO toDto(StudentEntity entity);

    @Mapping(source = "surname", target = "lastname")
    StudentEntity toEntity(StudentDTO dto);

}
