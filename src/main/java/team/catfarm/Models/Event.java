package team.catfarm.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Date date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;
    private String color;

    @OneToMany
    private List<File> eventFiles;
    @OneToMany
    private List<Task> eventTasks;
    @OneToOne
    private User createdBy;

    public Event(Long id, String name, Date date, LocalDateTime startTime, LocalDateTime endTime, String description,
                 String color, List<File> eventFiles, List<Task> eventTasks, User createdBy) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.color = color;
        this.eventFiles = eventFiles;
        this.eventTasks = eventTasks;
        this.createdBy = createdBy;
    }

    public Event() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<File> getEventFiles() {
        return eventFiles;
    }

    public void setEventFiles(List<File> eventFiles) {
        this.eventFiles = eventFiles;
    }

    public List<Task> getEventTasks() {
        return eventTasks;
    }

    public void setEventTasks(List<Task> eventTasks) {
        this.eventTasks = eventTasks;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
