package com.bingo.demoProvider.controller;


import com.bingo.demoProvider.entity.China;
import com.bingo.demoProvider.mapper.ChinaMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "数据源测试")
@RestController
/*
    @RestController 相当于 @RequestBody 和 @Controller 的结合

 */
@RequestMapping(value = "/db")
public class TestDBController {

//    @Autowired(required = false)
    @Resource //Resource 和 Autowired 的区别
    private ChinaMapper chinaMapper;

    /*@Autowired
    // 从Spring Framework 4.3开始，如果目标bean只定义了一个构造函数，
    // 那么这样的构造函数上不再需要@Autowired注释。
    // 但是，如果有几个构造函数可用，
    // 那么至少必须用@Autowired注释一个构造函数，以便指示容器使用哪个构造函数。
    public TestDBController(ChinaMapper chinaMapper){
        this.chinaMapper = chinaMapper;
    }*/

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }

    @ApiOperation(value = "myBatis数据源测试", httpMethod = "POST") // 注意大小写，会从enum查找
    @RequestMapping(value = "/mybatis")
    //@ResponseBody // JSON序列化，再方法上添加@ResponseBody注解，第二种方法
    public China myBatisTest(){

        return chinaMapper.selectOneById(0);

    }

    /*
	@Autowired
	private testMapper test_Mapper;

	@Autowired
	private ArmcPaymentAppDao armcPaymentAppDao;

	@ApiOperation(value = "服务拦截测试", httpMethod = "POST")
	@PostMapping(value = "/interceptTest")
	public String interceptTest() {
		return "this is report server, hello world";
	}

	@ApiOperation(value = "服务链接测试", httpMethod = "POST")
	@PostMapping(value = "/connectTest")
	public ResponseMessage<String> connectTest() {
		return ResponseMessage.build("this is report server, hello world");
	}

	@ApiOperation(value = "myBatis数据源测试", httpMethod = "POST")
	@PostMapping(value = "/myBatisTest")
	public ResponseMessage<IPage<TestPojo>> myBatisTest() {
		TestPojo APojo = test_Mapper.selectList(new QueryWrapper<TestPojo>().eq("USERNAME_","000004013")).get(0);
//		TestPojo BPojo = test_Service.list(new QueryWrapper<TestPojo>().eq("USERNAME_","000004013")).get(0);
		TestPojo CPojo = test_Mapper.selectOne(new QueryWrapper<TestPojo>().eq("USERNAME_","000004013"));
		List<TestPojo> testPojoList = test_Mapper.selectList(new QueryWrapper<TestPojo>().eq("USERNAME_","000004013"));
		IPage<TestPojo> testPojoPage = test_Mapper.selectPage(new Page<TestPojo>(1,10),new QueryWrapper<TestPojo>().eq("USERNAME_","000004013"));

		System.out.println(testPojoPage.toString());
		return ResponseMessage.build(testPojoPage);
	}

	@ApiOperation(value = "jdbc数据源测试", httpMethod = "POST")
	@PostMapping(value = "/jdbcTest")
	public ResponseMessage<ArmcPaymentApp_M> jdbcTest() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("visitorCode", "000004013");
		ArmcPaymentApp_M data = armcPaymentAppDao.selectRecentOne(params);
		System.out.println(data.toString());
		return ResponseMessage.build(data);
	}*/

}
