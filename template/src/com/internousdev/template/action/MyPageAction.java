package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.MyPageDAO;
import com.internousdev.template.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;
	public String deleteFlg;
	private String result;
	public String execute() throws SQLException{
		MyPageDAO myPageDAO = new MyPageDAO();
		MyPageDTO myPageDTO = new MyPageDTO();

		//商品履歴を削除しない場合（削除ボタンで飛んできた場合、deleteFlgには1が入っているためfalseになる）
		if(deleteFlg == null){
			String item_transaction_id = session.get("id").toString();
			String user_master_id = session.get("login_user_id").toString();

			myPageDTO = myPageDAO.getMyPageUserInfo(item_transaction_id, user_master_id);

			session.put("buyItem_name", myPageDTO.getItemName());
			session.put("total_price", myPageDTO.getTotalPrice());
			session.put("total_count", myPageDTO.getTotalCount());
			session.put("total_payment", myPageDTO.getPayment());
			session.put("message", "");

		}//商品履歴を削除する場合（削除ボタンで来た場合、1が入っているのでこっちが実行される）
		else if(deleteFlg.equals("1")){
			delete(); //下記のdelete()メソッドが実行されて、その後resultにSUCCESSが入れられてstruts.xmlに返される
		}
		result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException{

		MyPageDAO myPageDAO = new MyPageDAO();

		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString();

		int res = myPageDAO.buyItemHistoryDelete(item_transaction_id, user_master_id);

		if(res > 0){
			session.put("message", "商品情報を正しく削除しました。");
		}

		//上、下どっちのif文も、messageに"商品情報～"の文章を代入している

		else if(res == 0){
			session.put("message", "商品情報の削除に失敗しました。");
		}

	}

	public String getDeleteFlg(){
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg = deleteFlg;
	}

	@Override
	public void setSession(Map<String, Object> loginSessionMap){
		this.session = loginSessionMap;
	}

}
