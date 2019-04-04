package com.cloudlink.inspection.client;

import com.cloudlink.inspection.dto.PriUser;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * description: 演示Feign Client的错误回调方法
 *
 * @author xiefayang
 * 2019/4/3 17:10
 */
@Component
public class UserFeignFallback implements UserFeignClient {

    @Override
    public List<PriUser> getByIds(List<String> userIds) {
        return Lists.newArrayList();
    }
}
