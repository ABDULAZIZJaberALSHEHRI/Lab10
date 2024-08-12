package com.example.lab10.Service;

import com.example.lab10.Model.JobPost;
import com.example.lab10.Model.User;
import com.example.lab10.Repository.JobPostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobPostService {
    private JobPostRepository jobPostRepository;

    public List<JobPost> getJobPosts() {
        return jobPostRepository.findAll();
    }

    public void addJob(JobPost jobPost) {
        jobPostRepository.save(jobPost);
    }

    public boolean deleteUser(Integer jobPostID) {
        JobPost jobPost = jobPostRepository.getReferenceById(jobPostID);
        if (jobPost.equals(null)) {
            return false;
        }
        jobPostRepository.delete(jobPost);
        return true;
    }

    public boolean updateUser(Integer jobPostId,JobPost jobPost) {
        JobPost j = jobPostRepository.getReferenceById(jobPostId);
        if (j == null) {
            return false;
        }

        j.setTitle(jobPost.getTitle());
        j.setDescription(jobPost.getDescription());
        j.setLocation(jobPost.getLocation());
        j.setSalary(jobPost.getSalary());
        j.setPostingDate(j.getPostingDate());
        jobPostRepository.save(j);
        return true;
    }

}
