package com.cheche365.cheche.core.repository

import com.cheche365.cheche.core.model.abao.InsuranceQuotePerson
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

/**
 * Created by mahong on 2017/1/3.
 */
@Repository
interface InsuranceQuotePersonRepository extends PagingAndSortingRepository<InsuranceQuotePerson, Long>, JpaSpecificationExecutor<InsuranceQuotePerson> {

}
