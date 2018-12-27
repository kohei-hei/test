package jp.co.internous.action;

public class Test {

	public static void main(String[] args){

		Person taro = new Person(); //Personクラスをインスタンス化し、コンストラクタ①を利用

		taro.name = "taro";
		taro.age = 18;
		System.out.println(taro.name);
		System.out.println(taro.age);


		Person jiro = new Person("jiro",20);//Personクラスをjiroという名でインスタンス化し、コンストラクタ②を利用
		System.out.println(jiro.name);      //したことによって、引数指定するだけでname,ageフィールドに値が代入出来た！
		System.out.println(jiro.age);


		Person saburo = new Person("saburo");
		System.out.println(saburo.name);
		System.out.println(saburo.age);


		Person nanashi = new Person(25);
		System.out.println(nanashi.name);
		System.out.println(nanashi.age);


		Person hanako = new Person(17,"hanako");
		System.out.println(hanako.name);
		System.out.println(hanako.age);


	}

}
