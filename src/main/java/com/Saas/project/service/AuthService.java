package com.Saas.project.service;


import com.Saas.project.dto.JoinReq;
import com.Saas.project.dto.LoginReq;
import com.Saas.project.dto.RegisterReq;
import com.Saas.project.entity.Role;
import com.Saas.project.entity.Tenant;
import com.Saas.project.entity.User;
import com.Saas.project.repo.TenantRepo;
import com.Saas.project.repo.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserRepo userRepo;
    private TenantRepo tenantRepo;
    private final PasswordEncoder passwordEncoder;
    private JwtService jwtService;


    public AuthService(UserRepo userRepo, TenantRepo tenantRepo, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepo = userRepo;
        this.tenantRepo = tenantRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }



    public User register(RegisterReq req) {
        if (tenantRepo.findBySlug(req.getSlug()).isPresent()) {
            throw new RuntimeException("Tenant already exists");
        }


        Tenant tenant = new Tenant();
        tenant.setName(req.getCompanyName());
        tenant.setSlug(req.getSlug());
        tenant.setPlan(Tenant.Plan.FREE);

        tenantRepo.save(tenant);

        if (userRepo.findByEmailAndTenant(req.getEmail(), tenant).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setEmail(req.getEmail());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        user.setRole(Role.ADMIN);
        user.setTenant(tenant);

        return userRepo.save(user);
    }

    public User joinTenant(JoinReq req) {
        Tenant tenant = tenantRepo.findBySlug(req.getSlug())
                .orElseThrow(() -> new RuntimeException("Tenant not found"));

        User user = new User();
        user.setEmail(req.getEmail());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        user.setRole(Role.MEMBER);
        user.setTenant(tenant);

        return userRepo.save(user);
    }

    public String login(LoginReq request) {

        Tenant tenant = tenantRepo.findBySlug(request.getSlug())
                .orElseThrow(() -> new RuntimeException("Tenant not found"));

        User user = userRepo.findByEmailAndTenant(request.getEmail(), tenant)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(user);
        return token;    }
}

