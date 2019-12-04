package club.yuxuan.yun.client.controller;

import club.yuxuan.yun.feign.test.TestDto;
import club.yuxuan.yun.feign.test.TestFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
public class FeignTestController {

    /**
     * House服务的测试Feign
     */
    @Resource
    private TestFeign testFeign;
    
    /**
     * 测试Feign调用
     *
     * @author yuxuan.han
     * @date 2019/12/4 23:08 
     * @param dto
     * @param abc
     * @return java.lang.String
     */
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "param", value = "测试参数", dataType = "String", required = true)
//    })
    @ApiOperation("测试Feign调用")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(@RequestBody TestDto dto, @ApiIgnore String abc) {
        System.out.println(abc);
        String success = testFeign.printStr(dto);
        return success;
    }
    
}
