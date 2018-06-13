package Listener;

import NodeTree.*;
import ui.MainUI;

public class TreeManagement {
	private Node root = MainUI.getTreeClass().getRoot();
	//외부에서 인자 안넣어도 되게
	public void MakeParent(){
		for(Node temp : root.getChildren()) {
			temp.setParent(root);
			MakeParent2(temp);
		}
	}
	
	public void MakeParent2(Node cur){
		for(Node temp : cur.getChildren()){
			temp.setParent(cur);
			MakeParent2(temp);
		}
	}
}
