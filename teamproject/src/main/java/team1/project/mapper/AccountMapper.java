package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Account;

@Mapper
public interface AccountMapper {
	
	public List<Account> getAccountList();

}
