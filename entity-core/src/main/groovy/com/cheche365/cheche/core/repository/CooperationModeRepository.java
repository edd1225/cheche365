package com.cheche365.cheche.core.repository;

import com.cheche365.cheche.core.model.CooperationMode;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sunhuazhong on 2015/8/25.
 */
@Repository
public interface CooperationModeRepository extends PagingAndSortingRepository<CooperationMode, Long> {
    CooperationMode findFirstByName(String name);
}
