package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lessons")
class LessonsController {

    private final LessonRepository lessonRepository;

    LessonsController(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    // CREATE
    @PostMapping("")
    Lesson create(@RequestBody Lesson lesson) {
        return this.lessonRepository.save(lesson);
    }

    // READ
    @GetMapping("/{id}")
    Lesson one(@PathVariable Long id) {
        return this.lessonRepository.findOne(id);
    }

    // UPDATE, if the request body doesn't have an id that matches an already existing id
    // in the DB, a new entity will be added with the next available sequential id.
    // Your request body better be accurate.
    @PatchMapping("/{id}")
    Lesson update(@RequestBody Lesson lesson) {
        return this.lessonRepository.save(lesson);
    }

    // DELETE
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        this.lessonRepository.delete(id);
    }

    // LIST
    @GetMapping("")
    Iterable<Lesson> all() {
        return this.lessonRepository.findAll();
    }

}