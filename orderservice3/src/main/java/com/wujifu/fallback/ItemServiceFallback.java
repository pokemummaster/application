package com.wujifu.fallback;

import com.wujifu.entity.Item;
import com.wujifu.feign.ItemFeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class ItemServiceFallback  implements ItemFeignClient {
    /**
     * 服务降级的方法要和原方法一致(名称、参数列表)
     * @param id
     * @return
     */
    @Override
    public Item queryItemById(@PathVariable("id") Long id) {
        return new Item(00000, "服务降级方法queryItemById", null, "服务降级方法queryItemById", null);
    }
}

