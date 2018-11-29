package jp.co.internous.action;

public class Test {

	public static void main(String[] args){

		Person taro = new Person();
		taro.name = "山田太郎";
		taro.age = 20;
		taro.phoneNumber = "090-1111-1111";
		taro.address = "東京";

		Person ziro = new Person();
		ziro.name = "木村次郎";
		ziro.age = 18;
		ziro.phoneNumber = "090-2222-2222";
		ziro.address = "千葉";

		Person hanako = new Person();
		hanako.name = "鈴木花子";
		hanako.age = 16;
		hanako.phoneNumber = "090-3333-3333";
		hanako.address = "神奈川";

		Person kohei = new Person();
		kohei.name = "鈴木康平";
		kohei.age = 29;
		kohei.phoneNumber = "090-4444-4444";
		kohei.address = "コンゴ民主共和国";


		Person aibo = new Person();
		aibo.name = "アイボ";

		Person asimo = new Person();
		asimo.name = "アシモ";

		Person pepper = new Person();
		pepper.name = "ペッパー";


		System.out.println(taro.name);
		System.out.println(taro.age);
		System.out.println(taro.phoneNumber);
		System.out.println(taro.address);
		taro.talk();
		taro.walk();
		taro.run();

		System.out.println(ziro.name);
		System.out.println(ziro.age);
		System.out.println(ziro.phoneNumber);
		System.out.println(ziro.address);
		ziro.talk();
		ziro.walk();
		ziro.run();

		System.out.println(hanako.name);
		System.out.println(hanako.age);
		System.out.println(hanako.phoneNumber);
		System.out.println(hanako.address);
		hanako.talk();
		hanako.walk();
		hanako.run();

		System.out.println(kohei.name);
		System.out.println(kohei.age);
		System.out.println(kohei.phoneNumber);
		System.out.println(kohei.address);
		kohei.talk();
		kohei.walk();
		kohei.run();

		aibo.talk();
		aibo.walk();
		aibo.run();

		asimo.talk();
		asimo.walk();
		asimo.run();

		pepper.talk();
		pepper.walk();
		pepper.run();



	}

}
