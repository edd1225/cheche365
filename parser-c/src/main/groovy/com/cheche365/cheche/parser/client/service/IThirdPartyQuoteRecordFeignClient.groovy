package com.cheche365.cheche.parser.client.service

import com.cheche365.cheche.parser.dto.RequestObjectForList
import com.cheche365.cheche.parser.dto.RequestObjectForMap
import com.cheche365.cheche.parser.dto.ResponseObjectForMap
import org.springframework.web.bind.annotation.RequestBody



/**
 * 第三方保险平台客户端订单状态接口
 */
interface IThirdPartyQuoteRecordFeignClient {

    ResponseObjectForMap getQuoteRecordState(@RequestBody RequestObjectForList body)

}
