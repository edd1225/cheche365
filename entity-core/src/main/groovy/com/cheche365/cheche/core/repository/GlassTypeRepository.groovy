package com.cheche365.cheche.core.repository

import com.cheche365.cheche.core.model.GlassType
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface GlassTypeRepository extends PagingAndSortingRepository<GlassType, Long> {
    GlassType findFirstByName(String name)
}
