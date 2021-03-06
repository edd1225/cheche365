package com.cheche365.cheche.cpicuk.payinfo

import com.cheche365.cheche.core.service.IThirdPartyQuoteRecordService
import com.cheche365.cheche.cpicuk.app.config.CpicUKMinTestConfig
import com.cheche365.cheche.test.parser.AParserServiceFT
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Unroll

@Slf4j
@ContextConfiguration(classes = [CpicUKMinTestConfig])
class CpicukQuoteRecordServiceFT extends AParserServiceFT {

    @Autowired
    IThirdPartyQuoteRecordService service

    private final additionalParameters = [quoteRecord:[channel: [id: 8], insuranceCompany: [id: 25000], area: [id: 510100]]]

    @Unroll
    '利用numbers 测试获取报价单接口'() {

        when: '构造发起获取报价单numbers 并且发起请求'
        def list = [
            [commercial: 123, compulsory: 6789, orderNo: 12312, quoteNo: 'QCHDA17Y1418F220098B'],
            [commercial: 123, compulsory: 6789, orderNo: 12313, quoteNo: 'QCHDA17Y1418F220182V']
        ]
        service.getQuoteRecordState(list, additionalParameters)

        then: '检查结果'
        true
    }

}
