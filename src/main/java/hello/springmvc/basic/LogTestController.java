package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
// restController를 쓰면 return String형을 view로 반환하는게 아니고 진짜 문자열로 반환한다.
public class LogTestController {
    //private final Logger log = LoggerFactory.getLogger(getClass());  -> s1f4j에서의 lombok이 이 부분은 자동으로 해줘서 지워도됨

    @RequestMapping("/log-test")
    public String logTest(){
        String name ="Spring";
        System.out.println("name= " + name);

        log.info(" info log={}",name);
        log.debug(" info log={}",name);
        log.info(" info log={}",name);
        log.warn(" info log={}",name);
        log.error(" info log={}",name);

        return "ok";
    }
}
