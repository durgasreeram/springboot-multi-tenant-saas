package com.Saas.project.controller;

import com.Saas.project.entity.LeaveRequest;
import com.Saas.project.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping("/all")
    public List<LeaveRequest> getAllLeaves(){
        return leaveService.getAllLeaveRequests();
    }

    @GetMapping("/my")
    public List<LeaveRequest> getMyLeaves(Authentication authentication) {
        String email = authentication.getName();
        return leaveService.getMyLeaveRequests(email);
    }



    @PostMapping
    public LeaveRequest applyLeave(@RequestBody LeaveRequest leaveRequest, Authentication authentication) {

        String email = authentication.getName();
        leaveRequest.setUserEmail(email);
        leaveRequest.setStatus("Pending");

        return leaveService.applyLeave(leaveRequest);
    }



    @PutMapping("/{id}/approve")
    public LeaveRequest approveLeave(@PathVariable String id) {
        return leaveService.updateStatus(id, "Approved");
    }

    @PutMapping("/{id}/reject")
    public LeaveRequest rejectLeave(@PathVariable String id) {
        return leaveService.updateStatus(id, "Rejected");
    }

}
