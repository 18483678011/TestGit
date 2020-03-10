
public abstract class huangs extends Test{//继承一个动物
String minzi;//名字

public huangs() {//构造函数
	
	System.out.println("创建了一个鸟。");
	
}
public  void fanzi() {//繁殖
	System.out.println("鸟繁殖是下蛋。");
}
public abstract void yumao(String mao) ;//抽象函数羽毛颜色


}
