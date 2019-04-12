package com.thank.cloudlinkuser.web.controller;

import com.thank.cloudlinkuser.domain.PriUser;
import com.thank.cloudlinkuser.repository.PriUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * description: none
 *
 * @author xiefayang
 * 2019/4/3 10:34
 */
@Slf4j
@RestController
@RequestMapping("priUser")
public class PriUserController {

    @Autowired
    private PriUserRepository priUserRepository;

    @PostMapping("save")
    public ResponseEntity save(@RequestParam String name, @RequestParam Integer age) {
        PriUser priUser = new PriUser(name, age);
        priUser.setId(UUID.randomUUID().toString());
        this.priUserRepository.save(priUser);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("login")
    public String login(HttpServletRequest request, @RequestParam String username) {
        HttpSession session = request.getSession();
        log.warn("session id: {}", session.getId());
        session.setAttribute("username", username);
        return HttpStatus.OK.name();
    }

    @GetMapping("get")
    public String get(HttpServletRequest request) {
        HttpSession session = request.getSession();
        log.warn("session id:{}", session.getId());
        return String.valueOf(session.getAttribute("username"));
    }

    @GetMapping("getAll")
    public ResponseEntity<List<PriUser>> getAll(HttpServletRequest request) {
        HttpSession session = request.getSession();
        log.warn("session id: {}", session.getId());
        this.cookiesLog(request);
        List<PriUser> priUserList = this.priUserRepository.findAll();
        return new ResponseEntity<>(priUserList, HttpStatus.OK);
    }


    @GetMapping("ignoreFromGateway")
    public String 测试网关的忽略该路由() {
        return "测试ignore";
    }


    /**
     * for cloudlink-inspection micro service
     */
    @PostMapping("getByIds")
    public List<PriUser> getByIds(@RequestBody List<String> userIds) {

        // test hystrix of feign timeout
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//        }
//
//        throw new IllegalArgumentException();
        return this.priUserRepository.findAllById(userIds);
    }


   private void cookiesLog(HttpServletRequest request) {
       Cookie[] cookies = request.getCookies();
       if (null != cookies && cookies.length > 0) {
           for (Cookie cookie : cookies) {
               log.warn("cookie name:{}, value:{}", cookie.getName(), cookie.getValue());
           }
       }
   }
}
