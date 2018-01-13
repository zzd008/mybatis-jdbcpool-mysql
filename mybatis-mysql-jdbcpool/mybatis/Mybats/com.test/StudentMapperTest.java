import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.briup.bean.Student;
import com.briup.dao.StudentMapper;
import com.utils.MyBatisSqlSessionFactory;

public class StudentMapperTest {
	@Test
	public void testCreateStudent(){
		
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml"); 
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			SqlSessionFactory testsqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"test"); //指定用哪个数据库环境
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			Student s = new Student(888,"zzd007",20,new Date());
//			studentMapper.saveStudent(s);//增加
//			studentMapper.deleteStudent(3);//删除
//			studentMapper.updateStudent(new Student(4,"tom",20,new Date()));//修改
			//查询一条
//			Student s1 = studentMapper.findStudentById(1);//mybatis会自动把查询出来的值传给对象，通过反射调用getxxx和setxxx方法
//			System.out.println(s1.toString());
//			List<Student> list = studentMapper.findAllStudent();//查询多条
//			System.out.println(list.getClass());
//			System.out.println(list);
			
//			List<Map<Object, Object>> list1 = studentMapper.findAllStudent1();//返回多个map
//			System.out.println(list1);
			
//			Map<Object, Object> map = studentMapper.findAllStudent2();//会报错，因为返回两个map
//			System.out.println(map);
			
			/*
			 * 封装后
			 */
			/*StudentMapper studentMapper2 = MyBatisSqlSessionFactory.openSession(true).getMapper(StudentMapper.class);
			List<Student> list3 = studentMapper2.findAllStudent();
			System.out.println(list3);*/
//			studentMapper2.findAllStudent(); //会使用sqlSession的一级缓存
			
			
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
