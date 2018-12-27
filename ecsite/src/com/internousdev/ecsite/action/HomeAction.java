package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;


public class HomeAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	public String execute(){

		String result ="login";
		if(session.containsKey("id")){
			//↑ここは"login_user_id"で判定する方が適切（これだと商品テーブルのidを使ってる）

			BuyItemDAO buyItemDAO = new BuyItemDAO();
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());

			/*
			 * ↑これらの処理は、最初にログイン認証⇒buyItem.jspへ遷移を行ったときにすでに値自体はセットされて残っていて、
			 * それを保持したままhome.jspに戻ってくるが、最初にログインした時と再突入した時のタイムラグで
			 * 商品情報が更新（新商品の追加etc...）されている可能性があるので、
			 * 最新の状態に更新してページ遷移がなされるように 全く同じ処理をもう一度している。
			 * （紐付けた商品情報テーブルの値が消えちゃってるわけじゃない！）
			 */

			result = SUCCESS;
		}
		return result;

	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public Map<String,Object> getSession(){
		return this.session;
	}

}
