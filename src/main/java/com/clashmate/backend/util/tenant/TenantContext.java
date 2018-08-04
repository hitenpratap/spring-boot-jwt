package com.clashmate.backend.util.tenant;

import com.clashmate.backend.model.tenant.Tenant;

public class TenantContext {

    final public static Tenant DEFAULT_TENANT_ID = null;

    private static ThreadLocal<Tenant> currentTenant = new ThreadLocal<Tenant>() {
        @Override
        protected Tenant initialValue() {
            return DEFAULT_TENANT_ID;
        }
    };

    public static void setCurrentTenant(Tenant tenant) {
        currentTenant.set(tenant);
    }

    public static Tenant getCurrentTenant() {
        return currentTenant.get();
    }

    public static void clear() {
        currentTenant.remove();
    }

}
