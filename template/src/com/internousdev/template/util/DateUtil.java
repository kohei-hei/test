package com.internousdev.template.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public String getDate(){
		Date date =new Date();
		//現在の日時を保持したDate型インスタンスdateを生成

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//SimpleDateFormatクラス(SDFと略す)をSDF(String)のコンストラクタを使ってインスタンス化している

		return simpleDateFormat.format(date);
		//dateインスタンスには現在の日時が入っているが、それをSDFの()内の表記の通りに書き直している
		//(=フォーマットしている)メソッド
	}

}
