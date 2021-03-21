package me.afifaniks.springapi.course;

import me.afifaniks.springapi.course.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CourseRepository extends CrudRepository<Course, String> {
    public ArrayList<Course> findCourseByTopicId(String topicId);
}
