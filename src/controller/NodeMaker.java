package controller;

import java.util.ArrayList;
import java.util.StringTokenizer;

import NodeTree.Node;
import NodeTree.TreeClass;
import ui.MainUI;

public class NodeMaker {
	private String text;
	
	public NodeMaker(String text) {
		this.text = text;
	}
	
	public void makeTree() {
		String line;
		String root;
		int id = 1;
		TreeClass treeClass = null;
		StringTokenizer stk = new StringTokenizer(text, "\n");
		if(stk.hasMoreTokens()) {
			root = stk.nextToken();
			treeClass = new TreeClass(root);
		} else {
			System.out.println("NO TOKEN");
			return;
		} // set Root in Tree
		
		ArrayList<Integer> idList = new ArrayList<Integer>();
		idList.add(0,treeClass.getParent().getId());
	
		while(stk.hasMoreTokens()) {
			line = stk.nextToken();
//			System.out.println(idList.size());
			if(idList.size() == getTapCount(line)) { // 그 단꼐가 이전에 없었을 때
				int parentId = idList.get(idList.size() - 1);
				Node parentNode = treeClass.searchNodeById(parentId);
				parentNode.add(line.trim(), id);
				
				idList.add(id);
				
//				System.out.println(idList.get(idList.size()-1));
			} else { // 이미 있었던 거일때
				int parentId = idList.get(getTapCount(line) -1);
				Node parentNode = treeClass.searchNodeById(parentId);
				parentNode.add(line.trim(), id);
				
				idList.set(getTapCount(line),id);
				
			}
			id++;
			
		}
		MainUI.setTreeClass(treeClass);
	}

	private int getTapCount(String text) {
		int count = 0;
		count = (text.length() - text.trim().length()) / "\t".length();
		return count;
	}
	
}
