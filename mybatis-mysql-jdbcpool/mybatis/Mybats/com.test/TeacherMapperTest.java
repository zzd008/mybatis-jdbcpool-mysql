import java.util.List;

import org.junit.Test;

import com.briup.bean.Phone;
import com.briup.bean.Teacher;
import com.briup.dao.StudentMapper;
import com.briup.dao.TeacherMapper;
import com.utils.MyBatisSqlSessionFactory;


public class TeacherMapperTest {
	public static void main(String[] args) {
		TeacherMapper teacherMapper = MyBatisSqlSessionFactory.openSession(true).getMapper(TeacherMapper.class);
//		teacherMapper.insertTeacher(new Teacher(1,"zzd",new Phone("15979072805")));
		List<Teacher> list = teacherMapper.selectAllTeacher();
		for(Teacher t:list){
			System.out.println(t);
		}
	}
}
