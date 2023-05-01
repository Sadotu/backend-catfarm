package team.catfarm.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.catfarm.Models.File;
import team.catfarm.Models.User;
import team.catfarm.Services.FileService;
import team.catfarm.Services.UserService;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;
    @Autowired
    private UserService userService;

    @GetMapping("/{location}")
    public List<File> getFilesByLocation(@PathVariable String location) {
        return fileService.getFilesByLocation(location);
    }

    @PostMapping("/upload/{location}")
    public ResponseEntity<File> uploadFileMetadata(@RequestBody File file, @PathVariable String location, Principal principal) {
        User uploadedBy = userService.getUserByUsername(principal.getName());
        File uploadedFile = fileService.uploadFileMetadata(file, uploadedBy, location);
        return ResponseEntity.ok(uploadedFile);
    }

    @PutMapping("/{fileId}/move/{newLocation}")
    public ResponseEntity<File> moveFile(@PathVariable Long fileId, @PathVariable String newLocation) {
        File movedFile = fileService.moveFile(fileId, newLocation);
        return ResponseEntity.ok(movedFile);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteFileMetadata(@RequestParam List<Long> fileIds) {
        fileService.deleteFileMetadata(fileIds);
        return ResponseEntity.ok().build();
    }

}

