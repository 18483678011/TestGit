package 数据结构;

public class 二叉树 {

	public static void main(String[] args) {
		rootHeroNode heroNode = new rootHeroNode();
		heroNode node = new heroNode(1, "张三");
		heroNode node1 = new heroNode(2, "李四");
		heroNode node2 = new heroNode(3, "王五");
		heroNode node3 = new heroNode(4, "赵瑞");
		heroNode node4 = new heroNode(5, "罗琦");
		heroNode.setRoot(node);
		node.setLeft(node1);// 左
		node1.setRight(node2);// 右
		node.setRight(node3);
		node3.setLeft(node4);
		heroNode.postOrder();// 前序遍历
		heroNode testHeroNode=null;
		int no=5;
		testHeroNode=	heroNode.postheroNodeSelect(no);
		if (testHeroNode!=null) {
			System.out.println("已经查找到no="+no+"，的数据 { "+testHeroNode.toString()+" }");
		}else {
			System.out.println("抱歉，没有查找到no="+no+"的数据");
		}
	
	}
}

//根节点
class rootHeroNode {
	public heroNode root;

	protected void setRoot(heroNode root) {
		this.root = root;
	}

	// 前序遍历
	public void PreOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("没有找到该数据");
		}
	}

	// 中序遍历
	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("没有找到该数据");
		}
	}

	// 后序遍历
	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("没有找到该数据");
		}
	}
//前序查找
	public heroNode preheroNodeSelect(int no) {
		if (root!=null) {
			return root.preSelect(no);
		}else {
			return null;
		}
	}
	public heroNode infixheroNodeSelect(int no) {
		if (root!=null) {
			return root. infixSelect(no);
		}else {
			return null;
		}
	}
	public heroNode postheroNodeSelect(int no) {
		if (root!=null) {
			return root.postSelect(no);
		}else {
			return null;
		}
	}
}

class heroNode {
	private int no;
	private String name;
	private heroNode left;// 左
	private heroNode right;// 右

	public heroNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	// 前序遍历

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public heroNode getLeft() {
		return left;
	}

	public void setLeft(heroNode left) {
		this.left = left;
	}

	public heroNode getRight() {
		return right;
	}

	public void setRight(heroNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "heroNode [no=" + no + ", name=" + name + "]";
	}

	// 前序遍历
	public void preOrder() {
		System.out.println(this);
		// 递归左
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	// 中序遍历
	public void infixOrder() {
		// 递归左
		if (this.left != null) {
			this.left.preOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	// 后序遍历
	public void postOrder() {
		// 递归左
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
		System.out.println(this);
	}

//	前序查找
	public heroNode preSelect(int no) {
		if (this.no == no) {
			return this;
		}
		heroNode node = null;
		if (this.left != null) {
			node = this.left.preSelect(no);
		}
		if (node != null) {
			return node;
		}
		if (this.right != null) {
			node = this.right.preSelect(no);
		}
		if (node != null) {
			return node;
		}
		return node;

	}
//	中序查找
	public heroNode infixSelect(int no) {
		
		heroNode node = null;
		if (this.left != null) {
			node = this.left.infixSelect(no);
		}
		if (node != null) {
			return node;
		}
		if (this.no == no) {
			return this;
		}
		if (this.right != null) {
			node = this.right.infixSelect(no);
		}
		if (node != null) {
			return node;
		}
		return node;
		
	}
//	后序查找
	public heroNode postSelect(int no) {
	
		heroNode node = null;
		if (this.left != null) {
			node = this.left.postSelect(no);
		}
		if (node != null) {
			return node;
		}
		if (this.right != null) {
			node = this.right.postSelect(no);
		}
		if (node != null) {
			return node;
		}
		if (this.no == no) {
			return this;
		}
		return node;
		
	}
}