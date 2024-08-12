package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.ApiResponse;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/job-post")
@AllArgsConstructor
public class JobPostController {
    private JobPostService jobPostService;

    @GetMapping("/get-job-posts")
    public ResponseEntity GetJobPosts() {
        return ResponseEntity.status(200).body(jobPostService.getJobPosts());
    }

    @PostMapping("/add-job-post")
    public ResponseEntity AddJobPost(@Valid @RequestBody JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jobPostService.addJob(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("Job post added successfully"));
    }

    @PutMapping("/update-job-post/{jobid}")
    public ResponseEntity UpdateJobPost(@PathVariable Integer jobid,@Valid @RequestBody JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = jobPostService.updateUser(jobid, jobPost);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Job post updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Job post update failed"));
    }

    @DeleteMapping("/delete-job-post/{jobid}")
    public ResponseEntity DeleteJobPost(@PathVariable Integer jobid) {
        boolean isDeleted = jobPostService.deleteUser(jobid);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("Job post deleted successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Job post delete failed"));
    }
}
