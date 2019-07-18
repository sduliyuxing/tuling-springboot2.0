package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Registration registration;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) throws Exception {

        // // 测试1 服务降级
        // // 注意: order调用user服务,降级的逻辑是在order服务里完成的
        // // 测试项目:
        // //      06-02-ms-consumer-order-ribbon-hystrix-customizing  命令模式,继承HystrixCommand类 做服务降级
        // //      06-03-ms-consumer-order-ribbon-hystrix-fallback  注解@HystrixCommand方式 做服务降级
        // // 测试过程:
        // //      启动 user服务提供者,order服务消费者,order服务调用user服务测试OK后
        // //      直接关闭  user服务,测试 服务降级
        // log.info("用户中心接口：查询用户" + id + "信息");
        // return userRepository.findById(id).get();
        // // ==================================================================================

        // // 测试2: 超时回退--也属于服务降级
        // //      hystrix默认超时时间为2秒,测试:  随机等待2000毫秒,再加上处理时间,有可能高于2秒,触发服务降级
        // // 测试项目:
        // //      06-02-ms-consumer-order-ribbon-hystrix-customizing  命令模式,继承HystrixCommand类 做服务降级
        // //      06-03-ms-consumer-order-ribbon-hystrix-fallback  注解@HystrixCommand方式 做服务降级
        // // 测试过程:
        // //      启动 user服务提供者,order服务消费者,order服务调用user服务测试
        // log.info("用户中心接口：查询用户" + id + "信息");
        // int sleepTime = new Random().nextInt(2000);  // hystrix默认超时时间为2秒,
        // log.info("sleepTime:" + sleepTime); // 随机等待 2000毫秒,再加上处理时间
        // Thread.sleep(sleepTime);            // 有可能高于2秒,触发服务降级
        // return userRepository.findById(id).get();
        // // ==================================================================================
        //
        // // 测试3: 配置默认超时时间,延长默认的超时时间,然后再来执行测试2代码
        // // 注意:默认超时时间是在  服务调用端customer配置,order服务端配置
        // // hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds = 6000
        // // ==================================================================================

        // // 测试4:  熔断 ,传入不存在的用户id, 模拟异常情况
        // // 测试项目:
        // //      06-04-ms-consumer-order-ribbon-hystrix-fusing
        // // 测试过程及效果:
        // //      启动 user服务提供者,order服务消费者,order服务调用user服务测试
        // //      当id=1时可以获取数据,当id=10出现异常,服务降级
        // //      连续请求id=10的访问20次, 再来请求id=1的访问,服务还是降级的,说明已经熔断了
        // //      等待5秒后,再次请求id=1的访问,可以获取数据.熔断关闭
        // // 这里的: 20次和5秒是默认的,可以配置
        // log.info("用户中心接口：查询用户" + id + "信息");
        // if (id == 10) {
        //     throw new NullPointerException();
        // }
        // return userRepository.findById(id).get();
        // // ==================================================================================
        //
        // // 测试5:  熔断配置 ,传入不存在的用户id, 模拟异常情况
        // // 测试项目:
        // //      06-04-ms-consumer-order-ribbon-hystrix-fusing
        // // 配置熔断参数
        // //      hystrix.command.default.circuitBreaker.requestVolumeThreshold=3   # 默认20次
        // //      hystrix.command.default.circuitBreaker.sleepWindowInMilliseconds=10000  # 默认5000毫秒
        // // 配置参数后,再来执行测试4代码
        // // 测试过程及效果:
        // //      启动 user服务提供者,order服务消费者,order服务调用user服务测试
        // //      当id=1时可以获取数据,当id=10出现异常,服务降级
        // //      连续请求id=10的访问3次, 再来请求id=1的访问,服务还是降级的,说明已经熔断了
        // //      等待10秒后,再次请求id=1的访问,可以获取数据.熔断关闭
        // // 这里的: 3次和10秒是配置的
        // // ==================================================================================

        // 测试6:  限流, 线程资源隔离,模拟系统执行速度很慢的情况,线程隔离,预防雪崩
        // 测试项目:
        //      06-05-ms-consumer-order-ribbon-hystrix-thread-isolation
        // 测试配置:
        //      因为因为服务提供方 要用 Thread.sleep(3000); 模拟系统执行速度很慢的情况
        //      来测试 Hystrix 限流, 线程资源隔离,所以服务消费方为测试将timeoutInMilliseconds放大20秒,防止服务超时降级
        //          hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds = 20000
        // 测试6.1:
        //      服务消费方请求默认什么都不配
        //          @HystrixCommand(fallbackMethod = "findByIdFallback")
        //          @GetMapping("/user/{id}")
        //          public User findById(@PathVariable Long id) {
        // 测试过程及效果:
        //      JMeter压力测试:  线程数12 ,周期0,  循环次数1,查看结果树
        //       默认不配置的情况下, 先出来2降级的,然后再出来10个查询结果
        //       结论 @HystrixCommand 默认做了线程池的隔离,默认只开10个线程,
        //       所以压力测试12个,10个可以稍后执行出来,但是另外2个立即服务降级

        // 知识点:
        /*
            @HystrixCommand(fallbackMethod = "findByIdFallback",
                    groupKey = "orderUserGroup",
                    threadPoolKey = "orderUserIdThreadPool")
            @GetMapping("/user/{id}")
            public User findById(@PathVariable Long id) {
                log.info("================请求用户中心接口，用户id:" + id + "==============");
                return restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
            }

            @HystrixCommand(fallbackMethod = "findByIdFallback",
                    groupKey = "orderUserGroup",
                    threadPoolKey = "orderUserNameThreadPool")
            @GetMapping("/user/{name}")
            public User findByName(@PathVariable String name) {
                log.info("================请求用户中心接口，用户id:" + name + "==============");
                return restTemplate.getForObject("http://microservice-provider-user/" + name, User.class);
            }
            一个根据用户id查,一个根据用户name查,
            groupKey一样说明他们是同一个线程组,
                当threadPoolKey不一样时, 分别都有10个线程大小的线程池
                当threadPoolKey一样时, 分别公用一个 10个线程大小的线程池
         */

        // 测试6.2:
        //  服务消费方请求,配置线程池大小为2
        //      @HystrixCommand(fallbackMethod = "findByIdFallback",
        //              groupKey = "orderUserGroup",
        //              threadPoolKey = "orderUserIdThreadPool",
        //              threadPoolProperties = {
        //                      @HystrixProperty(name = "coreSize", value = "2")})   // 配置 线程池大小为2
        //      @GetMapping("/user/{id}")
        //      public User findById(@PathVariable Long id) {
        //  测试过程及效果:
        //      JMeter压力测试:  线程数6 ,周期0,  循环次数1,查看结果树
        //       配置线程池大小为2的情况下, 先出来4降级的,然后再出来2个查询结果

        // 测试6.3:
        //  服务消费方请求,配置队列等待
        //      @HystrixCommand(fallbackMethod = "findByIdFallback",
        //              groupKey = "orderUserGroup",
        //              threadPoolKey = "orderUserIdThreadPool",
        //              threadPoolProperties = {
        //                      @HystrixProperty(name = "coreSize", value = "2"),
        //                      @HystrixProperty(name = "maxQueueSize", value = "2"),
        //                      @HystrixProperty(name = "queueSizeRejectionThreshold", value = "1")})
        //      @GetMapping("/user/{id}")
        //      public User findById(@PathVariable Long id) {
        //  测试过程及效果:
        //      JMeter压力测试:  线程数8 ,周期0,  循环次数1,查看结果树
        //      配置线程池大小为2,等待队列里的线程大小为1的情况下,
        //      先出来5降级的,然后等待3秒再出来2个查询结果,在等待3秒出来等待队列里的1个查询结果

        log.info("用户中心接口：查询用户" + id + "信息");
        Thread.sleep(3000);
        return userRepository.findById(id).get();
    }

    @GetMapping("/getIpAndPort")
    public String findById() {
        return registration.getHost() + ":" + registration.getPort();
    }
}