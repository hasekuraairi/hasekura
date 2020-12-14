package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PassCheck {

	private Account[] list = {new Account("早川　哲平","te-hayakawa","0821"),
			new Account("金岡　亮弥","ry-kanaoka","0804"),
			new Account("坂田　浩太","ko-sakata","0765"),
			new Account("鈴木　保","ta-suzuki","0622"),
			new Account("谷村　直哉","na-tanimura","0582"),
			new Account("橋口　昌治","ma-hashiguchi","0771"),
			new Account("田熊　有哉","yu-taguma","0726"),
			new Account("西島　海斗","ka-nishijima","0820"),
			new Account("高井　正樹","masaki-takai","0227")};

	private Account usedAccount = null;

	public boolean check(String uname, String password) {

		for(Account account : list) {
			if(uname.equals(account.getUname()) && password.equals(account.getPass())){
				usedAccount = account;
				return true;
			}
		}

		return false;
	}

	public String getUsedName() {
		return usedAccount.getName();
	}

}