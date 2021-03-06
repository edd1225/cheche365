package com.cheche365.cheche.core.repository;

import com.cheche365.cheche.core.model.InternalUser;
import com.cheche365.cheche.core.model.InternalUserRelation;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunhuazhong on 2015/5/6.
 */
@Repository
public interface InternalUserRelationRepository extends PagingAndSortingRepository<InternalUserRelation, Long>, JpaSpecificationExecutor<InternalUserRelation> {
    List<InternalUserRelation> findByCustomerUser(InternalUser customerUser);

    List<InternalUserRelation> findByInternalUser(InternalUser internalUser);

    InternalUserRelation findFirstByCustomerUserAndInternalUserAndExternalUser(
        InternalUser customerUser, InternalUser internalUser, InternalUser externalUser);

    InternalUserRelation findFirstByCustomerUser_IdAndInternalUser_IdAndExternalUser_Id(
        Long customerUserId, Long internalUserId, Long externalUserId);
}
