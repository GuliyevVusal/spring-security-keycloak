package com.example.security.controller;

import com.example.security.dto.CommonDTO;
import com.example.security.dto.StudentDTO;
import com.example.security.dto.StudentMapper;
import com.example.security.entity.StudentEntity;
import com.example.security.repo.CustomStudentRepo;
import com.example.security.repo.StudentRepoData;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private final StudentRepoData dataRepo;
    private final CustomStudentRepo customRepo;


    public StudentController(StudentRepoData dataRepo, CustomStudentRepo customRepo) {
        this.dataRepo = dataRepo;
        this.customRepo = customRepo;
    }

    @PostMapping
    public CommonDTO insert(@RequestBody StudentDTO studentDto) {
        String passwordRaw = studentDto.getPassword();
        String encryptedPassword = encoder.encode(passwordRaw);
        studentDto.setPassword(encryptedPassword);
        final StudentEntity save = dataRepo.save(StudentMapper.MAPPER.toEntity(studentDto));
        return new CommonDTO()
                .setObj(StudentMapper.MAPPER.toDto(save))
                .setDatetime(LocalDateTime.now())
                .setMessage("successfully inserted");
    }

    @GetMapping
    public CommonDTO getList(@RequestParam(required = false) String name,
                             @RequestParam(required = false) String surname,
                             @RequestParam(required = false) String email,
                             @RequestParam(required = false, name = "university_id") Integer universityId,
                             @RequestParam(required = false) Integer age,
                             JwtAuthenticationToken userPrincipal) {
        return new CommonDTO()
                .setObj(customRepo.getList(name, surname, email, universityId, age)
                        .stream()
                        .map(StudentMapper.MAPPER::toDto)
                        .collect(Collectors.toList()))
                .setDatetime(LocalDateTime.now());
    }

    @PutMapping
    public CommonDTO update(@RequestBody StudentDTO studentDto) {
        String passwordRaw = studentDto.getPassword();
        String encryptedPassword = encoder.encode(passwordRaw);
        studentDto.setPassword(encryptedPassword);
        StudentEntity entity = StudentMapper.MAPPER.toEntity(studentDto);
        final StudentEntity save = dataRepo.save(entity);
        return new CommonDTO()
                .setObj(StudentMapper.MAPPER.toDto(save))
                .setDatetime(LocalDateTime.now())
                .setMessage("successfully updated");
    }


    @DeleteMapping
    public CommonDTO delete(@RequestParam Integer id) {
        dataRepo.deleteById(id);
        return new CommonDTO()
                .setDatetime(LocalDateTime.now())
                .setMessage("successfully deleted");
    }

    @GetMapping("{id}")
    public CommonDTO findById(@PathVariable("id") Integer id) {
        return new CommonDTO().setObj(
                        dataRepo.findById(id).map(StudentMapper.MAPPER::toDto).orElse(new StudentDTO())
                )
                .setDatetime(LocalDateTime.now());
    }

}

