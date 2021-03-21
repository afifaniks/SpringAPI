package me.afifaniks.springapi.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId) {
        ArrayList<Course> courseList = new ArrayList<>();

        courseRepository.findCourseByTopicId(topicId).forEach(courseList::add);

        return courseList;
    }

    public Optional<Course> getCourse(String id) {
        return courseRepository.findById(id);
    }

    public void addCourse(Course topic) {
        courseRepository.save(topic);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void delCourse(String id) {
        courseRepository.deleteById(id);
    }
}
