package com.lumen.auth.service;

import cn.hutool.core.collection.CollUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 资源与角色匹配关系管理业务类
 * @author hxy
 */
@Service
public class ResourceServiceImpl {

    private Map<String, List<String>> resourceRolesMap;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @PostConstruct
    public void initData() {
        resourceRolesMap = new TreeMap<>();
        resourceRolesMap.put("/master/mater/areas", CollUtil.toList("admin"));
        resourceRolesMap.put("/**", CollUtil.toList("admin", "TEST"));
        redisTemplate.opsForHash().putAll("RESOURCE_ROLES_MAP", resourceRolesMap);
    }

}
