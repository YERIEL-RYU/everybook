package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.AccountMapper;
import team1.project.vo.Account;

@Service
@Transactional
public class AccountService {
	
	@Autowired private AccountMapper accountMapper;
	
	public List<Account> getAccountList(){
		return accountMapper.getAccountList();
	}
}
