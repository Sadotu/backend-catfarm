package team.catfarm.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.catfarm.Exceptions.FileOperationException;
import team.catfarm.Exceptions.FileUploadException;
import team.catfarm.Models.File;
import team.catfarm.Models.User;
import team.catfarm.Repositories.FileRepository;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class FileService {

    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public List<File> getFilesByLocation(String location) {
        return fileRepository.findByLocation(location);
    }

    public File uploadFileMetadata(File file, User uploadedBy, String location) {
        file.setLocation(location);
        file.setUploadedBy(uploadedBy);
        try {
            return fileRepository.save(file);
        } catch (Exception e) {
            throw new FileUploadException("Failed to upload file metadata: " + e.getMessage());
        }
    }

    public File moveFile(Long fileId, String newLocation) {
        Optional<File> optionalFile = fileRepository.findById(fileId);
        if (optionalFile.isPresent()) {
            File file = optionalFile.get();
            file.setLocation(newLocation);
            return fileRepository.save(file);
        } else {
            throw new FileUploadException("File not found with id: " + fileId);
        }
    }

    public void deleteFileMetadata(List<Long> fileIds) {
        try {
            for (Long fileId : fileIds) {
                Optional<File> optionalFile = fileRepository.findById(fileId);
                if (optionalFile.isPresent()) {
                    fileRepository.delete(optionalFile.get());
                } else {
                    throw new FileNotFoundException("File not found with id: " + fileId);
                }
            }
        } catch (Exception e) {
            throw new FileOperationException("Failed to delete file metadata", e);
        }
    }


}
