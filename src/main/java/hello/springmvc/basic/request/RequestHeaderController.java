package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale,
                          @RequestHeader MultiValueMap<String,String> headerMap,
                          @RequestHeader("host") String host,
                          @CookieValue(value="myCookie",required = false) String cookie
                         ){
        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);
        return "ok";
    }

    /*

        웹브라우저가 WAS에게 Servlet request
        -> WAS는 HttpServletRequest 객체를 생성하여 저장
        응답을 보낼 때 사용하기 위해 HttpServletResponse 객체 생성
        -> Servlet에게 두 객체 전달
        -> doGet, doPost, Service 등과 같은 메서드에 파라미터로 전달되어 사용됨

        HttpServletRequest
        http프로토콜의 request정보를 서블릿에게 전달하기 위해 사용
        헤더정보, 파라미터, 쿠키, URI, URL 등의 정보를 읽어 들이는 메소드 포함
        Body의 Stream을 읽어 들이는 메소드 포함
        HttpServletResponse
        요청을 보낸 클라이언트에게 응답을 보내기 위해 WAS에서 생성되어 서블릿에게 전달됨
        서블릿은 이 객체를 이용하여 content type, 응답코드, 응답 메시지등을 전송
     */
}
