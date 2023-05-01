package team.catfarm.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String fullName;
    private String pronouns;
    private int age;
    private String phoneNumber;
    private String emailAddress;
    private String bio;
    private String password;
    private boolean newsletter;
    private String role;
    private boolean active;

    @OneToMany
    private List<Task> userTasks;
    @Lob
    private byte[] profilePicture;

    public User(Long id, String fullName, String pronouns, int age, String phoneNumber, String emailAddress, String bio,
                String password, boolean newsletter, String role, boolean active, List<Task> userTasks, byte[] profilePicture) {
        this.id = id;
        this.fullName = fullName;
        this.pronouns = pronouns;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.bio = bio;
        this.password = password;
        this.newsletter = newsletter;
        this.role = role;
        this.active = active;
        this.userTasks = userTasks;
        this.profilePicture = profilePicture;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPronouns() {
        return pronouns;
    }

    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Task> getUserTasks() {
        return userTasks;
    }

    public void setUserTasks(List<Task> userTasks) {
        this.userTasks = userTasks;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }
}
