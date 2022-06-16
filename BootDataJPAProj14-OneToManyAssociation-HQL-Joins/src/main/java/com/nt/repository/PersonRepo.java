package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {
	
//	@Query("select p.pid,p.pname,p.address,ph.regNo,ph.numberType,ph.provider,ph.phoneNumber from Person as p inner join p.phonesInfo as ph where p.pid=:id")
//	public List<Object[]> getDataByJoins(@Param("id") Integer gg);

	//inner join 
	@Query("select p.pid,p.pname,p.address,ph.regNo,ph.numberType,ph.provider,ph.phoneNumber from Person as p inner join p.phonesInfo as ph")
	public List<Object[]> innerJoins();
	
	//left outer join
	@Query("select p.pid,p.pname,p.address,ph.regNo,ph.numberType,ph.provider,ph.phoneNumber from Person as p left join p.phonesInfo as ph")
	public List<Object[]> leftJoins();
	
	//right outer join 
	@Query("select p.pid,p.pname,p.address,ph.regNo,ph.numberType,ph.provider,ph.phoneNumber from Person as p right join p.phonesInfo as ph")
	public List<Object[]> rightJoins();
	
	//full outer join 
/*	@Query("select p.pid,p.pname,p.address,ph.regNo,ph.numberType,ph.provider,ph.phoneNumber from Person as p full join p.phonesInfo as ph")
	public List<Object[]> fullJoins();  */
}
