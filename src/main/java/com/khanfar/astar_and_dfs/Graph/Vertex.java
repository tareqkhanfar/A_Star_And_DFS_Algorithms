package com.khanfar.astar_and_dfs.Graph;

public class Vertex {

    private String Label ;
    private boolean isVisited ;
    private Vertex parent ;
    private int H_Cost ;


    public Vertex(String Label , int Hcost) {

        this.isVisited = false ;
        this.Label = Label;
        this.H_Cost = Hcost ;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public int getH_Cost() {
        return H_Cost;
    }

    public void setH_Cost(int h_Cost) {
        H_Cost = h_Cost;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }
}
