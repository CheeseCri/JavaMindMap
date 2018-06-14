package controller;

import NodeTree.Node;

public class JsonToTextController {
	// 가져온 Node를 TextAreaPane
	private int depth = 0;
	private String buf = "";

	public void JsonToTextConroller() {
		buf = "";
	}

	public String JsonToTextArea(Node parent, int depth) {
		for (int i = 0; i < depth; i++) {
			buf = buf + '\t';
		}
		buf = buf + parent.getName() + '\n';
		if (parent.getChildren().size() != 0) {
			for (Node temp : parent.getChildren()) {
				JsonToTextArea(temp, depth + 1);
			}
		}
		return buf;
	}
}
