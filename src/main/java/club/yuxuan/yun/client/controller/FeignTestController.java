package club.yuxuan.yun.client.controller;

import club.yuxuan.yun.common.base.Response;
import club.yuxuan.yun.common.controller.BaseController;
import club.yuxuan.yun.feign.answer.AnswerFacade;
import club.yuxuan.yun.feign.answer.dto.AnswerReq;
import club.yuxuan.yun.feign.answer.dto.AnswerResp;
import club.yuxuan.yun.feign.test.dto.TestDto;
import club.yuxuan.yun.feign.test.TestFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * Feign测试
 *
 * @author yuxuan.han
 * @date 2019/12/4 23:07
 **/
@RestController
@Api(value = "FeignTestController", tags = "Feign测试Controller")
public class FeignTestController extends BaseController {

    /**
     * House服务的测试Feign
     */
    @Resource
    private TestFeign testFeign;
    
    @Resource
    private AnswerFacade answerFacade;
    
    /**
     * 测试Feign调用
     *
     * @author yuxuan.han
     * @date 2019/12/4 23:08 
     * @param dto
     * @param abc
     * @return java.lang.String
     */
    @ApiOperation("测试Feign调用")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public Response<String> test(@RequestBody TestDto dto, @ApiIgnore String abc) {
        System.out.println(abc);
        String success = testFeign.printStr(dto);
        return success(success);
    }
    
    @ApiOperation("根据主键查询")
    @PostMapping("/queryAnswerByPK")
    public Response<AnswerResp> queryAnswerByPK(@RequestParam("id") String id) {
        Response<AnswerResp> answerRespResponse = answerFacade.selectByPrimaryKey(new AnswerReq(id));
        if (answerRespResponse != null && answerRespResponse.getData() != null) {
            return answerRespResponse;
        }
        return success();
    }
    
}
