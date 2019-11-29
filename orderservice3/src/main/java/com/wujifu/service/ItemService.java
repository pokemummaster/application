package com.wujifu.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wujifu.entity.Item;
import com.wujifu.feign.ItemFeignClient;
import com.wujifu.properties.OrderProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemService {

    // Spring框架对RESTful方式的http请求做了封装，来简化操作
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    OrderProperties orderProperties;

    public Item queryItemById(Long id) {

        // 该方法走eureka注册中心调用(去注册中心根据app-item查找服务，这种方式必须先开启负载均衡@LoadBalanced)
        String itemUrl = "http://app-item/item/{id}";
        Item result = restTemplate.getForObject(itemUrl, Item.class, id);
        System.out.println("订单系统调用商品服务,result:" + result);
        return result;
    }
    @Autowired
    private ItemFeignClient itemFeignClient;

  //  @HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod")
    public Item queryItemById2(Long id) {
        Item result = itemFeignClient.queryItemById(id);
        System.out.println("===========HystrixCommand queryItemById-线程池名称：" + Thread.currentThread().getName() + "订单系统调用商品服务,result:" + result);
        return result;
    }



}



