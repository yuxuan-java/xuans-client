package club.yuxuan.yun.client;

import club.yuxuan.yun.feign.test.TestDto;
import club.yuxuan.yun.feign.test.TestFeign;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    
    @Resource
    private TestFeign testFeign;
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        TestDto dto = new TestDto();
        dto.setParam("success");
        String success = testFeign.printStr(dto);
        return success;
    }
    
}
