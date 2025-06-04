package p3Arboles;

public class main {
	public static void main(String[] args) {
		EDBinaryHeap<Integer> t = new EDBinaryHeap<Integer>(10);
//		t.addNode(50);
//		t.addNode(30);
//		t.addNode(70);
//		t.addNode(20);
//		t.addNode(40);
//		t.addNode(60);
//		t.addNode(80);
//		t.addNode(35);
	
//		t.addNode(2);
//		t.addNode(20);
//		t.addNode(17);
//		t.addNode(4);
//		t.addNode(2);
//		t.addNode(1);
//		t.addNode(3);
//		t.addNode(8);
//		t.addNode(6);
//		t.addNode(5);
//		t.addNode(7);
//		t.addNode(10);
//		t.addNode(11);
//		t.removeNode(1);
//		t.removeNode(3);
//		t.removeNode(4);
//		t.removeNode(7);
//		t.removeNode(11);
//		t.removeNode(10);
		//System.out.println(t.searchNode(6));
		//System.out.println(t.toString());
		//System.out.println(t.preOrder());
		//System.out.println(t.postOrder());
		//System.out.println(t.inOrder());
//		t.addNode(3);
//		t.addNode(-2);
//		t.addNode(-3);
//		t.addNode(1);
//		t.addNode(0);
//		t.addNode(2);
//		t.addNode(-1);
//		t.removeNode(1);
		t.add(12);
		t.add(14);
		t.add(15);
		t.add(20);
		t.add(16);
		t.add(17);
		t.add(19);
		t.add(24);
		t.add(30);
		t.remove(20);
		System.out.println(t.toString());
	}
}
