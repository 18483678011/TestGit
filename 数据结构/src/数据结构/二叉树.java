package ���ݽṹ;

public class ������ {

	public static void main(String[] args) {
		rootHeroNode heroNode = new rootHeroNode();
		heroNode node = new heroNode(1, "����");
		heroNode node1 = new heroNode(2, "����");
		heroNode node2 = new heroNode(3, "����");
		heroNode node3 = new heroNode(4, "����");
		heroNode node4 = new heroNode(5, "����");
		heroNode.setRoot(node);
		node.setLeft(node1);// ��
		node1.setRight(node2);// ��
		node.setRight(node3);
		node3.setLeft(node4);
		heroNode.postOrder();// ǰ�����
		heroNode testHeroNode=null;
		int no=5;
		testHeroNode=	heroNode.postheroNodeSelect(no);
		if (testHeroNode!=null) {
			System.out.println("�Ѿ����ҵ�no="+no+"�������� { "+testHeroNode.toString()+" }");
		}else {
			System.out.println("��Ǹ��û�в��ҵ�no="+no+"������");
		}
	
	}
}

//���ڵ�
class rootHeroNode {
	public heroNode root;

	protected void setRoot(heroNode root) {
		this.root = root;
	}

	// ǰ�����
	public void PreOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("û���ҵ�������");
		}
	}

	// �������
	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("û���ҵ�������");
		}
	}

	// �������
	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("û���ҵ�������");
		}
	}
//ǰ�����
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
	private heroNode left;// ��
	private heroNode right;// ��

	public heroNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	// ǰ�����

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

	// ǰ�����
	public void preOrder() {
		System.out.println(this);
		// �ݹ���
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	// �������
	public void infixOrder() {
		// �ݹ���
		if (this.left != null) {
			this.left.preOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	// �������
	public void postOrder() {
		// �ݹ���
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
		System.out.println(this);
	}

//	ǰ�����
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
//	�������
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
//	�������
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