package com.cheche365.cheche.baoxian

import org.springframework.boot.autoconfigure.EnableAutoConfiguration

/**
 * 北京
 */
@EnableAutoConfiguration
class Baoxian430100changshaFT extends ABaoXianFT {

    @Override
    protected final getAreaProperties() {
        [id: 430100L, name: '长沙']
    }

}
