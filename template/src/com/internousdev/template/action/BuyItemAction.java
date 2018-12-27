package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class BuyItemAction extends ActionSupport implements SessionAware {

	private int stock;
	private String pay;
	public Map<String, Object> session;
	private String result;

	public String execute(){
		result = SUCCESS;

		session.put("stock", stock); //←右のstockの値は、buyItem.jspで自分で選んだ値（selectタグ内のvalue）

		int intStock = Integer.parseInt(session.get("stock").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());

		//↑"stock"と"buyItem_price"をint型変数に変換して、←ちがうっぽい
		//↑session.get(key)の形なので、それぞれ"stock""buyItem～"に紐付けられた値が取り出されてる
		//で、その値がObject型になってるので、一旦String型に変換(.toStringメソッド)してから、int型に変換(.parseInt)してる
		//そうしないと、"buyItem_price"の方でエラーになってしまうらしい(値を定義したときにString型にしてるため(BuyItemDTO参照))

		//int intStock = (Integer)session.get("stock"); ←ちなみにstockの方はこの書き方でもいける

		//それぞれintStock,intPriceに代入してる

		session.put("buyItem_price",intStock * intPrice);
		//↑なのでここで購入金額算出の掛け算が出来る
		String payment;

		if(pay.equals("1")){

			payment = "現金払い";
			session.put("pay", payment);
		}
		else{

			payment = "クレジットカード";
			session.put("pay", payment);
		}
		return result;
	}

	public int getStock(){
		return stock;
	}

	public void setStock(int stock){
		this.stock = stock;
	}

	public String getPay(){
		return pay;
	}


	public void setPay(String pay){
		this.pay = pay;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

}
