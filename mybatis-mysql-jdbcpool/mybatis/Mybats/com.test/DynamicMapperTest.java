import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.briup.bean.Stu;
import com.briup.dynamicsql.DynamicSQLMapper;
import com.utils.MyBatisSqlSessionFactory;


public class DynamicMapperTest {
	@Test
	public void test1(){
		try {
			DynamicSQLMapper dynamicSQLMapper = MyBatisSqlSessionFactory.openSession(true).getMapper(DynamicSQLMapper.class);
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("id", 3);
//			map.put("name", "1");
//			map.put("name", "zzd");
			map.put("name", "z%");//模糊查询
			map.put("grader", 99);
			
//			List<Stu> list = dynamicSQLMapper.findStudent(map);
			
			
//			Map<String, Object> map1=new HashMap<String, Object>();
//			map1.put("id", 4);
//			map.put("name", "zzd");
//			
//			List<Stu> list1 = dynamicSQLMapper.findStudent_choose(map1);
//			System.out.println(list1);
			
			
			Map<String, Object> map2=new HashMap<String, Object>();
			ArrayList<Integer> l=new ArrayList<Integer>();
			l.add(3);
			l.add(4);
			map2.put("lists", l);
			
//			List<Stu> list2 = dynamicSQLMapper.findStudent_foreach(map2);
//			System.out.println(list2);
			
//			List<Stu> list3 = dynamicSQLMapper.findStudent_foreach1(map2);
//			System.out.println(list3);
			
			dynamicSQLMapper.updateStu(3, "zzd007");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
