package com.example.demo;


import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class LoginController implements WebMvcConfigurer {


@Autowired
PassCheck passCheck;

//ログ出力するファイル（LoginLog.txt）のパス（C直下にdemoを入れている場合を設定、それ以外の人はインポート時に上書き必須）
String filePass = "C:demo\\src\\main\\resources\\log\\LoginLog.txt";


	//ログイン時の入力画面を表示
	@RequestMapping("/login")
	public String hello(Model model) {
		model.addAttribute("errorMessage", "");
		return "Hellow";
	}

	//ログイン情報が入力された際の処理
	@PostMapping("/test")
	public String checkPersonInfo(LoginForm personForm, Model model) {

        //xmlファイルの情報を取得
        ApplicationContext app = new ClassPathXmlApplicationContext("beans2.xml");
        //xmlに紐づいたキー情報のインスタンスを生成
        LoginForm loginBean = app.getBean("login", LoginForm.class );

        //テスト用にセッターの処理を追加
        loginBean.setLoginID(personForm.getLoginID());
        loginBean.setPassword(personForm.getPassword());

        //
		String loginIDForm = loginBean.getLoginID();
		String passwordForm = loginBean.getPassword();
		model.addAttribute("loginID", loginIDForm);
		model.addAttribute("password", passwordForm);

        //ユーザ名、パスワードのログ出力（半角チェックを通ったもののみ）
		try {
	        Logger logger = Logger.getLogger("loginlog");
	        FileHandler fHandler;
			fHandler = new FileHandler(filePass,true);
			fHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fHandler);
			ConsoleHandler cHandler = new ConsoleHandler();
			logger.addHandler(cHandler);

			logger.log(Level.INFO,"ログインID：" + loginIDForm);
			logger.log(Level.INFO,"パスワード：" + passwordForm);
			logger.log(Level.INFO,"---------------------------------------------------");

		} catch (SecurityException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if( passCheck.check(loginIDForm,passwordForm) ) {
			model.addAttribute("name",passCheck.getUsedName());
			return "Saccess";
		}

		model.addAttribute("errorMessage","ログインIDとパスワードの組み合わせが間違っています");
		return "Hellow";
	}

	//戻るボタンが押された際の動き
	@PostMapping("/return")
	public String returnForm() {
		return "Hellow";
	}
}