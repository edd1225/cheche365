package com.cheche365.cheche.core.repository;


import com.cheche365.cheche.core.model.AutoServiceType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shanxf on 2016/10/8.
 */
@Repository
public interface AutoServiceTypeRepository extends PagingAndSortingRepository<AutoServiceType, Long> {

}
