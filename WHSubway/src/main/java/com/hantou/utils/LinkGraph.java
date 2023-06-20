package com.hantou.utils;

//邻接表类
public class LinkGraph {
    private int numInputV, numInputE;//输入的点和边的总数
    VertextNode vtNode[];
    Boolean kind = false;//是否为有向图

    public LinkGraph(int sizeVertexes, Boolean kind) {
        if (sizeVertexes > 0 && sizeVertexes < 65535) {
            vtNode = new VertextNode[sizeVertexes];//初始化顶点域
            numInputV = numInputE = 0;
            for (int i = 0; i < sizeVertexes; i++) {
                //顶点域置空
                vtNode[i] = null;
            }
        } else {
            new RuntimeException("创建失败");
        }
        this.kind = kind;
    }

    //输入头节点
    public void InsertVertextes(String ev) {
        VertextNode vt = new VertextNode();
        vt.setData(ev);
        vt.setFirstEdge(null);
        vt.setId(numInputV);

        vtNode[numInputV] = vt;
        numInputV++;
    }

    //建立边表_头插法，把边的next指向顶点的firstedge，顶点的firstedge指向eNode的getNext()
    public void InsertEdges(String start, String end, int weight ){
        int pos = getVertexPos(start);
        if (pos != -1) {
            EdgeNode en = new EdgeNode();
            en.setAdjvex(end);
//            en.setEdgeInfo(ID);
            en.setWeight(weight);
            en.setNext(vtNode[pos].getFirstEdge());
            vtNode[pos].setFirstEdge(en);
            numInputE++;
        }
        if (!kind) {//无向图
            int posEnd = getVertexPos(end);
            if (posEnd != -1) {
                EdgeNode enStart = new EdgeNode();
                enStart.setAdjvex(start);
//                enStart.setEdgeInfo(ID);
                enStart.setWeight(weight);
                enStart.setNext(vtNode[posEnd].getFirstEdge());
                vtNode[posEnd].setFirstEdge(enStart);
                numInputE++;
            }
        }
    }

    public int getVertexPos(String vertx) {
        //给出顶点vertex在图中的位置
        for (int i = 0; i < numInputV; i++)
            if (vtNode[i].getData().equals(vertx))
                return i;
        return -1;
    }

    public String GetFirstNeighbor(String vertx) {

        int pos = getVertexPos(vertx);
        if (pos != -1) {
            EdgeNode en = vtNode[pos].getFirstEdge();
            return en.getAdjvex();
        }
        return null;
    }

    //给出顶点v的邻接点w，求下一个邻接点
    public String GetSecNeighbor(String start, String next) {

        int pos1 = getVertexPos(start);
        int pos2 = getVertexPos(next);

        if (pos1 != -1 && pos2 != -1) {
            EdgeNode en = vtNode[pos1].getFirstEdge();

            while (en != null && en.getAdjvex() != next) {
                en = en.getNext();
            }
            if (en.getNext() != null) {
                return en.getNext().getAdjvex();
            }
        }
        return null;
    }

    public int getNumInputV() {
        return numInputV;
    }

    public void setNumInputV(int numInputV) {
        this.numInputV = numInputV;
    }

    public int getNumInputE() {
        return numInputE;
    }

    public void setNumInputE(int numInputE) {
        this.numInputE = numInputE;
    }

    public VertextNode[] getVtNode() {
        return vtNode;
    }

    public void setVtNode(VertextNode[] vtNode) {
        this.vtNode = vtNode;
    }
}