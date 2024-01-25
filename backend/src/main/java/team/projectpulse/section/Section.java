package team.projectpulse.section;

import team.projectpulse.course.Course;
import team.projectpulse.instructor.Instructor;
import team.projectpulse.rubric.Rubric;
import team.projectpulse.student.Student;
import team.projectpulse.team.Team;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sectionId;
    private String sectionName;
    private LocalDate startDate;
    private LocalDate endDate;
    @ElementCollection
    private List<String> activeWeeks = new ArrayList<>();
    @ManyToOne
    private Rubric rubric;
    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private List<Team> teams = new ArrayList<>();
    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "section_instructor",
            joinColumns = @JoinColumn(name = "section_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id"))
    private Set<Instructor> instructors = new HashSet<>();
    @ManyToOne
    private Course course;

    public Section() {
    }

    public Section(String sectionName, LocalDate startDate, LocalDate endDate) {
        this.sectionName = sectionName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<String> getActiveWeeks() {
        return activeWeeks;
    }

    public void setActiveWeeks(List<String> activeWeeks) {
        this.activeWeeks = activeWeeks;
    }

    public Rubric getRubric() {
        return rubric;
    }

    public void setRubric(Rubric rubric) {
        this.rubric = rubric;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void addTeam(Team team) {
        this.teams.add(team);
        team.setSection(this);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setSection(this);
    }

    public void addInstructor(Instructor instructor) {
        this.instructors.add(instructor);
        instructor.getSections().add(this);
    }

    public void removeInstructor(Instructor instructor) {
        // Remove the instructor from the teams if the instructor is already assigned to teams in this section
        if (!instructor.getTeams().isEmpty()) {
            // Get the teams that the instructor is assigned to in this section
            List<Team> list = instructor.getTeams().stream().filter(team -> team.getSection().equals(this)).toList();
            if (!list.isEmpty()) {
                list.forEach(team -> team.removeInstructor(instructor));
            }
        }

        instructors.remove(instructor);
        instructor.getSections().remove(this);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
