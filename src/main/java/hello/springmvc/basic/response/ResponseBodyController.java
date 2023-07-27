package hello.springmvc.basic.response;
import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@Controller
//@ResponseBody
@RestController
public class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException
    {
        response.getWriter().write("ok");
    }

    /**
     * HttpEntity, ResponseEntity(Http Status 추가)
     * @return
     * `ResponseEntity`는 Spring Framework에서 HTTP 응답을 나타내는 클래스입니다.
     * 일반적으로 Spring 애플리케이션에서 컨트롤러 메서드에서 데이터를 반환할 때 사용되며,
     * 이를 통해 HTTP 응답의 상태 코드, 헤더, 본문(body) 등을 직접 설정할 수 있습니다.

     * `ResponseEntity`는 제네릭 클래스로, 반환할 데이터의 타입을 지정할 수 있습니다.
     * 예를 들어, `ResponseEntity<String>`은 `String` 타입의 데이터를 의미합니다.
     *
     * 또한 `ResponseEntity`는 HTTP 응답의 상태 코드를 나타내는 `HttpStatus` 객체와 함께 사용됩니다. `
     * HttpStatus`는 여러 상태 코드들을 상수로 가지고 있으며, HTTP 응답의 상태를 정의하는 데 사용됩니다.
     * 예를 들어 `HttpStatus.OK`는 상태 코드 200을 나타냅니다.
     *
     * `ResponseEntity`를 사용하여 컨트롤러 메서드에서 HTTP 응답을 반환하면, Spring은 `ResponseEntity`
     * 객체에 설정된 상태 코드, 헤더, 본문 등을 기반으로 실제 HTTP 응답을 생성하여 클라이언트에게 반환합니다.
     
     * 예시로 주어진 코드인 `responseBodyV2` 메서드는 `ResponseEntity<String>`을 반환하고,
     * 상태 코드를 `HttpStatus.OK`로 설정하고, 본문으로 "ok"라는 문자열을 담고 있습니다. 따라서 이 메서드를 호출하면 "ok"라는 문자열과 상태 코드 200(OK)을 가진 HTTP 응답이 클라이언트로 전달될 것입니다.
     */
    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() {

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "ok";
    }

    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);
        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    /**
     * @ResponseBody를 하면 ResponseEntity와 다르게 status상태값을 보낼 수 없어서 
     * @ResponseStatus라는 어노테이션을 지원
     * 개념추가
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);
        return helloData;
    }
}