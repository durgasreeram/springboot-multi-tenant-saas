package com.Saas.project.repo;

import java.util.List;
import com.Saas.project.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepo extends JpaRepository<LeaveRequest, String>{
        List<LeaveRequest> findByUserEmail(String email);
}
