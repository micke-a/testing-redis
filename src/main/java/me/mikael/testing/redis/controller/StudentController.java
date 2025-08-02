package me.mikael.testing.redis.controller;

import lombok.RequiredArgsConstructor;
import me.mikael.testing.redis.model.Student;
import me.mikael.testing.redis.repository.StudentRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import static me.mikael.testing.redis.configuration.RedisMessagingConfiguration.TEST_CHANNEL;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentRepository studentRepository;
    private final RedisTemplate<String, Student> redisTemplate;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {

        redisTemplate.convertAndSend(TEST_CHANNEL, student.getName());
        return studentRepository.save(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        var bla = redisTemplate.opsForValue().get(id);

        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping
    public Iterable<Student> getAllStudents() {

//        var bla = redisTemplate.
        return studentRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable String id) {
        studentRepository.deleteById(id);
        return "Student deleted";
    }
}
