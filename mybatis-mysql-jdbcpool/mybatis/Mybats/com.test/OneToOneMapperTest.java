import org.junit.Test;

import com.briup.bean.Hus;
import com.briup.bean.Wife;
import com.briup.onetoone.OneToOneMapper;
import com.utils.MyBatisSqlSessionFactory;


public class OneToOneMapperTest {
	@Test
	public void test1(){
		OneToOneMapper oneToOneMapper = MyBatisSqlSessionFactory.openSession(true).getMapper(OneToOneMapper.class);
		
		Wife wife = new Wife();
		wife.setAge(30);
		wife.setName("zhangsan");
		
		Hus hus=new Hus();
		hus.setAge(33);
		hus.setName("lisi");
		hus.setWife(wife);
		
		try {
//			oneToOneMapper.saveWife(wife);
//			oneToOneMapper.saveHus(hus);
			
//			Hus hus2 = oneToOneMapper.findHus();
//			System.out.println(hus2);
			
//			Hus hus3 = oneToOneMapper.findHusById(1);
//			System.out.println(hus3); 
			
			Wife wife1 = oneToOneMapper.findWifeById(1);
			System.out.println(wife1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

