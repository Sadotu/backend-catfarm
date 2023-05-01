package team.catfarm.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Date;

@Entity
public class File {

    @Id
    @GeneratedValue
    private Long id;
    private String fileName;
    private String type;
    private double size;
    private String location;
    private Date uploadDate;
    private Date modifiedDate;
    @OneToOne
    private User UploadedBy;

    public File(Long id, String fileName, String type, double size, String location, Date uploadDate, Date modifiedDate, User uploadedBy) {
        this.id = id;
        this.fileName = fileName;
        this.type = type;
        this.size = size;
        this.location = location;
        this.uploadDate = uploadDate;
        UploadedBy = uploadedBy;
    }

    public File() {

    }

    public Long getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String extension) {
        this.type = extension;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public User getUploadedBy() {
        return UploadedBy;
    }

    public void setUploadedBy(User uploadedBy) {
        UploadedBy = uploadedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
