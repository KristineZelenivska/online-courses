package com.example.onlinecourses.service;

import com.example.onlinecourses.dto.OCCourseDto;
import com.example.onlinecourses.model.OCCourse;
import com.example.onlinecourses.model.OCPerson;
import com.example.onlinecourses.model.OCPersonCourses;
import com.example.onlinecourses.repository.OCPersonCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OCCourseService {

    @Autowired
    private OCPersonCoursesRepository personCoursesRepository;

    public List<OCCourseDto> getPersonCourses(String email) {
        List<OCCourseDto> result = new ArrayList<>();
        List<OCPersonCourses> tempCourses = personCoursesRepository.findByPerson_User_Email(email);
        for (OCPersonCourses personCourse : tempCourses) {
            OCPerson teacher = getTeacher(personCourse.getCourse());
            result.add(createCourseDto(personCourse.getCourse(), teacher));
        }
        return result;
    }

    private OCPerson getTeacher(OCCourse course) {
        List<OCPersonCourses> persons = personCoursesRepository.findByCourseAndResponsibleTrue(course);
        if (persons.size() == 1) {
            return persons.get(0).getPerson();
        }
        return null;
    }

    private OCCourseDto createCourseDto(OCCourse course, OCPerson teacher) {
        String teacherName = null;
        if (teacher != null) {
            teacherName = teacher.getFullName();
        }
        return new OCCourseDto(
                course.getSysId(),
                course.getName(),
                course.getOpenCourse(),
                course.getDescription(),
                course.getPrice(),
                teacherName,
                course.getCourseCategory().getName());
    }
}
