import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.bean.Customer;
import com.briup.dao.CustomerMapper;
import com.utils.MyBatisSqlSessionFactory;


public class CustomerMapperTest {
	@Test
	public void test1(){
		try {
			//基于ssqlsession插入数据
			SqlSession session = MyBatisSqlSessionFactory.openSession(true);
//			session.insert("com.briup.dao.CustomerMapper.insertCustomer",new Customer(4,"zzd",20));
			
			CustomerMapper customerMapper = MyBatisSqlSessionFactory.openSession(true).getMapper(CustomerMapper.class);
			Customer cus=new Customer(5,"zzd",20);
			
//			customerMapper.insertCustomer(cus);
			
//			customerMapper.autoInsertCustomer(cus);
//			System.out.println(cus.getId());//获取主键的值
			
//			customerMapper.updatCustomer(cus);
//			Customer customer = customerMapper.findCustomerById(5);
//			Customer customer = customerMapper.findCustomerModelById(5);
//			System.out.println(customer);
			
//			SqlSession session1 = MyBatisSqlSessionFactory.openSession(true);
////			session1.selectOne(arg0);//查询一个
//			List<Object> list = session1.selectList("com.briup.dao.CustomerMapper.findAllCustomer");
//			System.out.println(list);
			
//			Customer cus1 = customerMapper.findOneCustomerById(1);
//			System.out.println(cus1);
			
			Customer customer2 = customerMapper.findCustomerByIdNameAge(1,"zzd",20);
			System.out.println(customer2);
			
//			Map<Integer, Customer> map = customerMapper.findCustomerByName(); 不能这样写，因为不能指定返回的key
//			Map<Integer, Customer> map = session.selectMap("com.briup.dao.CustomerMapper.findCustomerByName", "id");//第一个参数为方法名，第二个参数指定为map中的哪一列为key，来源于java类中的属性名
//			System.out.println(map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
