package com.lumen.common.constants;

import lombok.NoArgsConstructor;

/**
 * 缓存名称定义
 * 格式为 模块.类.方法名
 * 缓存会具体到各个参数的值,可以在注解中使用spel指定参数和缓存条件
 *
 * **为避免缓存滥用,限制以下情形
 *   *** 元数据
 *   *** 查询频繁不经常更改的数据
 *   *** 热点数据,需注意缓存穿透问题
 *   *** 禁止把缓存作为服务与服务之间传递数据的媒介
 *
 * 添加缓存使用 @Cacheable
 * 直接更新缓存使用 @CachePut
 * 删除缓存使用 @CachePut
 * 参数和用法自行查看api
 * @author hxy
 */
@NoArgsConstructor
public class CacheConst {
    /**
     * lumen-resource
     */
    public static final String RESOURCE_SERVICE_GET_ROUTER_TREE_BY_ROLE = "resource_service_get_router_tree_by_role";

    public static final String RESOURCE_SERVICE_GET_ROUTER_TREE = "resource_service_get_router_tree";

    public static final String RESOURCE_SERVICE_GET_ROUTERS = "resource.service.getRouters";

    /**
     * lumen-service-data-handle
     */
    public static final String DATAHANDEL_DAO_GET_DICTIONARY_LIST_BY_GROUP_ID = "datahandel.dao.getDictionaryListByGroupId";

    public static final String DATAHANDEL_DAO_GET_ITEM_BY_VALUE = "datahandel.dao.getItemByValue";

    public static final String DATAHANDEL_DAO_GET_ITEM_BY_KEY = "datahandel.dao.getItemByKey";

    public static final String DATAHANDEL_DAO_GET_NEXT_STATUS = "datahandel.dao.getNextStatus";

    public static final String DATAHANDEL_SERVICE_GET_TRUE_FALSE_LIST = "datahandel.service.getTrueFalseList";

    /**
     * 验光机日程
     */
    public static final String Optometry = "Optometry";

}
