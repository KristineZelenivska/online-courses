package com.example.onlinecourses.service;

import com.example.onlinecourses.dto.OCCourseDto;
import com.example.onlinecourses.dto.OCFeedbackDto;
import com.example.onlinecourses.model.OCCourse;
import com.example.onlinecourses.model.OCPerson;
import com.example.onlinecourses.model.OCPersonCourses;
import com.example.onlinecourses.repository.OCCourseRepository;
import com.example.onlinecourses.repository.OCPersonCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OCCourseService extends OCAbstractService{

    @Autowired
    private OCPersonCoursesRepository personCoursesRepository;

    @Autowired
    private OCCourseRepository courseRepository;

    public List<OCCourseDto> getPersonCoursesDTO(String email) {
        List<OCCourseDto> result = new ArrayList<>();
        List<OCPersonCourses> tempCourses = getPersonCourses(email);
        for (OCPersonCourses personCourse : tempCourses) {
            OCPerson teacher = getTeacher(personCourse.getCourse());
            result.add(createCourseDto(personCourse.getCourse(), teacher));
        }
        return result;
    }

    public OCCourseDto getCourse(Long sysId){
        //TODO
        return null;
    }

    public List<OCFeedbackDto> getCourseFeedback(Long sysId) {
        return getFeedback(getCourseImpl(sysId));
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

    private List<OCPersonCourses> getPersonCourses(String email){
        return personCoursesRepository.findByPerson_User_Email(email);
    }
    private OCCourse getCourseImpl(Long sysId) {
        return courseRepository.findById(sysId).get();
    }
}
