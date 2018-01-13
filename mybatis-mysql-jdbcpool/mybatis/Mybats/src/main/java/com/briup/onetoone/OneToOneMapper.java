package com.briup.onetoone;

import java.util.List;

import com.briup.bean.Hus;
import com.briup.bean.Wife;

/*
 * 一对一的关系
 */
public interface OneToOneMapper {
	void saveWife(Wife wife);
	void saveHus(Hus hus);
	//查询hus级联的查出wife
	Hus findHus();
	Hus findHusById(int id);
	List<Hus> findAllHus();
	//查询wife级联的查出hus
	Wife findWifeById(int id);
	
}
