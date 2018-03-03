package com.jzwx.spring.boot.blog.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //当程序启动时自动装载测试类并加载假数据测试对象的bean
public class HelloControllerTest {

	@Autowired
	private MockMvc mockMvc;//指定假数据进行测试的对象

	@Test
	public void testHello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello") //测试用例请求的接口
				.accept(MediaType.APPLICATION_JSON))  //测试接口返回的数据类型
				.andExpect(status().isOk()) //测试用例返回的结果状态是ok的
				.andExpect(content().string(equalTo("Hello world!"))); //测试用例返回的json字符串内容为"Hello world!"
	}

}
