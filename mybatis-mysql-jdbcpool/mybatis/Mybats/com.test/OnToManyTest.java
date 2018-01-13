import org.junit.Test;

import com.briup.bean.Order;
import com.briup.bean.User;
import com.briup.onetomany.OneToManyMapper;
import com.mysql.jdbc.PreparedStatement;
import com.utils.MyBatisSqlSessionFactory;


public class OnToManyTest {
	@Test
	public void test1(){
		OneToManyMapper oneToManyMapper = MyBatisSqlSessionFactory.openSession(true).getMapper(OneToManyMapper.class);
		User u=new User();
		u.setUserid(1);
		u.setName("zzd");
		u.setPassword("123");
		
		Order o=new Order();
		o.setOrderid(1);
		o.setSalary(99);
		o.setName("苹果");
		o.setUser(u);
		
		Order o1=new Order();
		o1.setOrderid(2);
		o1.setSalary(100);
		o1.setName("pear");
		o1.setUser(u);
		
		try {
	//		oneToManyMapper.saveUser(u);
	//		oneToManyMapper.saveOrder(o1);
			
//			User user = oneToManyMapper.findAllOrders(1);
//			System.out.println(user);
			
			
			
			Order order = oneToManyMapper.findOrderById(1);
			System.out.println(order);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
