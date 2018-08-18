package com.lijia.crud.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lijia.crud.bean.Department;
import com.lijia.crud.dao.DepartmentMapper;

/**
 * 
 * @author 李嘉
 *推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 *@ContextConfiguration 指定Spring配置文件的位置
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
 	DepartmentMapper departmentMapper;
	
	
	/**
	 * 测试部门
	 */
	@Test
	public void testCURD() {
		/**
		//创建SpringIOC容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从容器获取mapper
		DepartmentMapper bean = applicationContext.getBean(DepartmentMapper.class);
		*/
		System.out.println(departmentMapper);
		
		
		departmentMapper.insertSelective(new Department(null, "人事部"));
	}
}
