package com.internousdev.webproj2.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.webproj2.util.DBConnector;

public class LoginDAO {


	public String username;
	public String password;


	public boolean select(String username,String password){
		boolean ret=false;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();


		String sql = "select * from users where user_name=? and password=?";

		//もしwelcome.jspで登録していないusername(例：saburo),password(333)を入力した場合、
		//sql文の?にそれらがsetされ、実行してもEmpty setが返ってくる

		//その場合、rsにはEmpty set（値なしの空のテーブル）が代入される。
		//⇒if文の中身rs.next()がfalseになるので実行されないままtryブロックが閉じ、
		//DB接続(con)も閉じ、retはfalseのままactionクラスにreturnされる(bに代入される)

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				//↑rs(取得したテーブルの値が入った箱)の中身の行参照⇒値があったらtrueなので中身の処理実行するよ、の意味
				this.username=rs.getString("user_name");
				this.password=rs.getString("password");

				ret=true;

			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return ret;
	}

}
