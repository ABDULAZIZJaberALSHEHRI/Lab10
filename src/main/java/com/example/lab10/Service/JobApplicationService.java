package com.example.lab10.Service;

import com.example.lab10.Model.JobApplication;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Model.User;
import com.example.lab10.Repository.JobApplicationRepository;
import com.example.lab10.Repository.JobPostRepository;
import com.example.lab10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;
    private final JobPostRepository jobPostRepository;

    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    public boolean addJobApplication(JobApplication jobApplication) {
        User u = userRepository.getOne(jobApplication.getUserId());
        JobPost j = jobPostRepository.getReferenceById(jobApplication.getJobPostId());

        if (u.equals(null) || j.equals(null)){
            return false;
        }
        jobApplicationRepository.save(jobApplication);
        return true;
    }

    public boolean deleteJobApplication(Integer jobApplicationId) {
        JobApplication j = jobApplicationRepository.getReferenceById(jobApplicationId);
        if (j.equals(null)) {
            return false;
        }
        jobApplicationRepository.delete(j);
        return true;
    }

}
