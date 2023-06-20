package com.hantou.utils;

//邻接表头结点类
public class VertextNode {
    private String data;//顶点域
    private EdgeNode firstEdge;
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public EdgeNode getFirstEdge() {
        return firstEdge;
    }
    public void setFirstEdge(EdgeNode firstEdge) {
        this.firstEdge = firstEdge;
    }
}
