package com.mydomain.product.web.api.v1.config;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.mydomain.product.domain.Course;
import com.mydomain.product.domain.CourseRepository;
import com.mydomain.product.domain.Department;
import com.mydomain.product.domain.DepartmentRepository;
import com.mydomain.product.domain.School;
import com.mydomain.product.domain.SchoolRepository;
import com.mydomain.product.domain.Student;
import com.mydomain.product.domain.StudentRepository;
import com.mydomain.product.domain.StudyBuddy;
import com.mydomain.product.domain.StudyBuddyRepository;
import com.mydomain.product.domain.Subject;
import com.mydomain.product.domain.SubjectRepository;
import com.mydomain.product.domain.Teacher;
import com.mydomain.product.domain.TeacherRepository;
import com.mydomain.product.persistence.impl.neo4j.Neo4jCourseRepositoryImpl;
import com.mydomain.product.persistence.impl.neo4j.Neo4jDepartmentRepositoryImpl;
import com.mydomain.product.persistence.impl.neo4j.Neo4jSchoolRepositoryImpl;
import com.mydomain.product.persistence.impl.neo4j.Neo4jStudentRepositoryImpl;
import com.mydomain.product.persistence.impl.neo4j.Neo4jStudyBuddyRepositoryImpl;
import com.mydomain.product.persistence.impl.neo4j.Neo4jSubjectRepositoryImpl;
import com.mydomain.product.persistence.impl.neo4j.Neo4jTeacherRepositoryImpl;
import io.innerloop.guice.perist.neo4j.Neo4jPersistModule;


/**
 * Created by markangrish on 10/04/2016.
 */
public class GuiceConfigModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        String url = System.getProperty("neo4j.ogm.url");
        String username = System.getProperty("neo4j.ogm.username");
        String password = System.getProperty("neo4j.ogm.password");

        install(new Neo4jPersistModule( url, username, password, "com.mydomain.product.domain"));

        bind(CourseRepository.class).to(Neo4jCourseRepositoryImpl.class).in(Singleton.class);
        bind(DepartmentRepository.class).to(Neo4jDepartmentRepositoryImpl.class).in(Singleton.class);
        bind(SchoolRepository.class).to(Neo4jSchoolRepositoryImpl.class).in(Singleton.class);
        bind(StudentRepository.class).to(Neo4jStudentRepositoryImpl.class).in(Singleton.class);
        bind(StudyBuddyRepository.class).to(Neo4jStudyBuddyRepositoryImpl.class).in(Singleton.class);
        bind(SubjectRepository.class).to(Neo4jSubjectRepositoryImpl.class).in(Singleton.class);
        bind(TeacherRepository.class).to(Neo4jTeacherRepositoryImpl.class).in(Singleton.class);

        requestStaticInjection(Course.class,
                               Department.class,
                               School.class,
                               Student.class,
                               StudyBuddy.class,
                               Subject.class,
                               Teacher.class);
    }
}
