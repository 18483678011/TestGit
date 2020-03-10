
public class laoying extends huangs {
	public laoying(String minzi) {// 构造函数
		this.minzi = "老鹰";
		yanse = "灰色";
	}

	String yanse;
	String minzi;

	public void tsee() {// 集成输出函数。
		yumao();
		chifan();
		fanzi();
		yidong();
	}

	public void yumao() {// 老鹰羽毛颜色
		// TODO 自动生成的方法存根
		
		System.out.println(minzi + yanse + "的羽毛");

	}

	public void chifan() {// 老鹰觅食食物
		// TODO 自动生成的方法存根
		System.out.println(minzi + "吃肉");
	}
	/*
	 * public void fanzi() { System.out.println(minzi+"繁殖是下蛋。"); }
	 */

	public void yidong() {// 移动具体实现方法
		// TODO 自动生成的方法存根
		System.out.println(minzi + "移动靠飞翔。");
	}

	@Override
	public void yumao(String mao) {
		// TODO 自动生成的方法存根

	}

}
