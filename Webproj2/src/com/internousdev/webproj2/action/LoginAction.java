package com.internousdev.webproj2.action;

import com.internousdev.webproj2.dao.LoginDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;


	/*
	 * javaの大前提：メソッドは宣言したものを各々呼び出して実行されるもの。
	 *               書いた順番には全く左右されない。
	 *               （今回の場合は、struts2の裏処理によってexecuteより先にsetメソッドが
	 *               呼び出されて実行済みになっている。）
	 *
	 */

	public String execute(){ //このexecute()メソッドは、先に下記のsetメソッドで変数に値が渡ってから実行される
		String ret=ERROR;
		LoginDAO dao=new LoginDAO();
		boolean b=dao.select(username, password); //戻り値はLoginDAO.javaのret
		if(b==true){
			ret=SUCCESS;
		}
		else{
			ret=ERROR;
		}
		return ret;
	}
	public String getUsername(){ //ログイン成功し、ページ遷移した際にこのクラスの値を取ってきて使いたいときに、getメソッドを記述する
		return username;        //遷移先のjspで<s:property～>を書けば裏でstrutsさんがメソッド実行してvaluestackを使って値を運んでくれる
	}


	public void setUsername(String username){ //jspから送信⇒valuestackに入力した値が渡る
		this.username = username;			 //⇒actionクラスに書いたsetメソッドが裏で実行される
	}										//⇒フィールドに設定されている変数に値が(valuestack経由で)代入される

	public String getPassword(){
		return password;
	}


	public void setPassword(String password){
		this.password = password;
	}

}
