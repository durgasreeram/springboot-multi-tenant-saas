package com.Saas.project.service;


import com.Saas.project.entity.Tenant;
import com.Saas.project.repo.TenantRepo;
import org.springframework.stereotype.Service;

@Service
public class TenantService {

    private final TenantRepo tenantRepo;

    public TenantService(TenantRepo tenantRepo) {
        this.tenantRepo = tenantRepo;
    }

    public Tenant createTenant(String Name) {

        Tenant tenant = new Tenant();
        tenant.setName(Name);
        tenant.setPlan(Tenant.Plan.FREE);

        return tenantRepo.save(tenant);
    }

}
