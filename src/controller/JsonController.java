package controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import NodeTree.Node;
import NodeTree.TreeClass;

public class JsonController {
	//TreeClass의 내용을 Json으로 변환 및 Json String 리턴
	public String setJson(Node parent){
		String json;
		Gson gson = new Gson();
		json = gson.toJson(parent);
		return json;
	}
	//Json의 내용을 TreeClass로 변환 시킨후 리턴 
	public TreeClass getJson(String json) {
		TreeClass tree;
		Gson gson = new Gson();
		tree = gson.fromJson(json, TreeClass.class);
		return tree;
	}
}
