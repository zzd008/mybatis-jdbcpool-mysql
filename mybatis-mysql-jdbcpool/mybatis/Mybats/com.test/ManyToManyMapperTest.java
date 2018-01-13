import org.junit.Test;

import com.briup.bean.*;
import com.briup.manytomany.ManyToManyMapper;
import com.briup.onetomany.OneToManyMapper;
import com.utils.MyBatisSqlSessionFactory;


public class ManyToManyMapperTest {
	@Test
	public void test1(){
		try {
			ManyToManyMapper manyToManyMapper = MyBatisSqlSessionFactory.openSession(true).getMapper(ManyToManyMapper.class);
			Stu s=new Stu("zzd","man","rjkf","99");
			Stu s1=new Stu("tom","man","rjkf","88");
			
			Course c=new Course("1","java");
			Course c1=new Course("2","c#");
			Course c2=new Course("3","math");
					
//			manyToManyMapper.saveStu(s);
//			manyToManyMapper.saveStu(s1);
			
//			manyToManyMapper.saveCourse(c);
//			manyToManyMapper.saveCourse(c1);
//			manyToManyMapper.saveCourse(c2);
			
//			manyToManyMapper.selectCourse(s, c);
//			manyToManyMapper.selectCourse(s, c1);
//			manyToManyMapper.selectCourse(s, c2);
//			
//			manyToManyMapper.selectCourse(s1, c);
//			manyToManyMapper.selectCourse(s1, c1);
//			manyToManyMapper.selectCourse(s1, c2);
			
//			System.out.println(s.getId());
			
//			Stu stu = manyToManyMapper.findStuById(3);
//			System.out.println(stu);
			
			Course course = manyToManyMapper.findCourseById(4);
			System.out.println(course);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
