package com.hantou.utils;

//邻接表的边结点类
public class EdgeNode {
        private String Adjvex;//邻接点域，存储该顶点对应下标
        private int weight;//权重
        private EdgeNode next;
//        private int edgeInfo;//边值

//        public int getEdgeInfo() {
//            return edgeInfo;
//        }
//        public void setEdgeInfo(int edgeInfo) {
//            this.edgeInfo = edgeInfo;
//        }
        public String getAdjvex() {
            return Adjvex;
        }
        public void setAdjvex(String adjvex) {
            Adjvex = adjvex;
        }
        public int getWeight() {
            return weight;
        }
        public void setWeight(int weight) {
            this.weight = weight;
        }
        public EdgeNode getNext() {
            return next;
        }
        public void setNext(EdgeNode next) {
            this.next = next;
        }

}
