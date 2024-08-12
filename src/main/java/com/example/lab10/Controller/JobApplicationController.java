package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.ApiResponse;
import com.example.lab10.Model.JobApplication;
import com.example.lab10.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/job-application")
@RequiredArgsConstructor
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;

    @GetMapping("/get-AllJob-Applications")
    public ResponseEntity getAllJobApplications() {
        return ResponseEntity.status(200).body(jobApplicationService.getAllJobApplications());
    }


    @PostMapping("/Apply-for-job")
    public ResponseEntity ApplyForJob(@Valid @RequestBody JobApplication jobApplication, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isApplied = jobApplicationService.addJobApplication(jobApplication);
        if (isApplied) {
            return ResponseEntity.status(200).body(new ApiResponse("Job application added successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Apply for job went wrong"));
    }

    @DeleteMapping("/withdraw-job-application/{jobApplicationId}")
    public ResponseEntity withdrawJobApplication(@PathVariable Integer jobApplicationId) {
        boolean isDeleted = jobApplicationService.deleteJobApplication(jobApplicationId);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("Job application withdraw successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("withdraw Job application went wrong"));
    }
}
