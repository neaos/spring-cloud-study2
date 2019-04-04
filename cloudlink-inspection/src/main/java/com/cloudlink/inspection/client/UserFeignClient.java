package com.cloudlink.inspection.client;

import com.cloudlink.inspection.dto.PriUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * description: none
 *
 * @author xiefayang
 * 2019/4/3 16:40
 */

@FeignClient(
        name = "cloudlink-user",
        fallback = UserFeignFallback.class
)
public interface UserFeignClient {

    @PostMapping("/priUser/getByIds")
    List<PriUser> getByIds(@RequestBody List<String> userIds);

}
