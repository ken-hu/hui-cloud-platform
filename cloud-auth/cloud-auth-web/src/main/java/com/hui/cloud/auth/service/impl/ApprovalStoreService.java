package com.hui.cloud.auth.service.impl;

import org.springframework.security.oauth2.provider.approval.Approval;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * <code>ApprovalStore</code>
 * <desc>
 * <p>
 * <desc/>
 * Creation Time: 2019/9/19 23:45.
 *
 * @author Gary.Hu
 */
@Component
public class ApprovalStoreService implements ApprovalStore {
    @Override
    public boolean addApprovals(Collection<Approval> approvals) {
        return false;
    }

    @Override
    public boolean revokeApprovals(Collection<Approval> approvals) {
        return false;
    }

    @Override
    public Collection<Approval> getApprovals(String userId, String clientId) {
        return null;
    }
}
