package team.catfarm.Models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    private String nameTask;
    private Date deadline;
    private String description;
    private boolean accepted;
    private boolean completed;

    @ElementCollection
    private List<String> toDoList;
    @OneToMany
    private List<User> collaborators;
    @OneToMany
    private List<File> taskFiles;
    @OneToOne
    private User createdBy;

    public Task(Long id, String nameTask, Date deadline, String description, boolean accepted, boolean completed,
                List<User> collaborators, List<File> taskFiles, List<String> toDoList, User createdBy) {
        this.id = id;
        this.nameTask = nameTask;
        this.deadline = deadline;
        this.description = description;
        this.accepted = accepted;
        this.completed = completed;
        this.collaborators = collaborators;
        this.taskFiles = taskFiles;
        this.toDoList = toDoList;
        this.createdBy = createdBy;
    }

    public Task() {

    }

    public Long getId() {
        return id;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public List<User> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<User> collaborators) {
        this.collaborators = collaborators;
    }

    public List<File> getTaskFiles() {
        return taskFiles;
    }

    public void setTaskFiles(List<File> taskFiles) {
        this.taskFiles = taskFiles;
    }

    public List<String> getToDoList() {
        return toDoList;
    }

    public void setToDoList(List<String> toDoList) {
        this.toDoList = toDoList;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
