package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.*;


@Entity
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private users user;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "idCourse")
    private courses course;
    
    @Column(nullable = true)
    private LocalDate enrollmentDate;
    
    @Column(nullable = false)
    private boolean completed;
    
    @Column(nullable = false)
    private int progress;
    
    	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enrollment(Long id, users user, courses course, LocalDate enrollmentDate, boolean completed,
				int progress) {
			super();
			this.id = id;
			this.user = user;
			this.course = course;
			this.enrollmentDate = enrollmentDate;
			this.completed = completed;
			this.progress = progress;
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public users getUser() {
		return user;
	}

	public void setUser(users user) {
		this.user = user;
	}

	public courses getCourse() {
		return course;
	}

	public void setCourse(courses course) {
		this.course = course;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

    
}
