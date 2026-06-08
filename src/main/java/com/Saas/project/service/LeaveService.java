package com.Saas.project.service;

import com.Saas.project.entity.LeaveRequest;
import com.Saas.project.repo.LeaveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LeaveService {

        @Autowired
        private LeaveRepo leaveRepo;

        public LeaveRequest applyLeave(LeaveRequest leaveRequest){
            leaveRequest.setStatus("Pending");
            leaveRequest.setCreatedAt(LocalDateTime.now());
            return leaveRepo.save(leaveRequest);
        }

        public List<LeaveRequest> getMyLeaveRequests(String email){
            return leaveRepo.findByUserEmail(email);
        }

        public List<LeaveRequest> getAllLeaveRequests(){
            return leaveRepo.findAll();
        }

        public LeaveRequest rejectLeave(String id){
            LeaveRequest leave = leaveRepo.findById(id).orElseThrow();
            leave.setStatus("Rejected");
            return leaveRepo.save(leave);
        }

        public LeaveRequest approveLeave(String id){
            LeaveRequest leave = leaveRepo.findById(id).orElseThrow();
            leave.setStatus("Approved");
            return leaveRepo.save(leave);
        }

    public LeaveRequest updateStatus(String id, String status) {
        LeaveRequest leave = leaveRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave not found"));

        leave.setStatus(status);
        return leaveRepo.save(leave);
    }

}
