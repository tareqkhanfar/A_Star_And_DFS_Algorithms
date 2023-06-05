package com.khanfar.astar_and_dfs.Graph;

public class Vertex implements Comparable<Vertex>{

    private String Label ;
    private boolean isVisited ;
    private Vertex parent ;
    private double H_Cost =0;
    private double G_Cost = 0 ;
    private double F_Cost=0 ;

    public double getF_Cost() {
        return F_Cost;
    }

    public void setF_Cost(double f_Cost) {
        F_Cost = f_Cost;
    }

    public double getG_Cost() {
        return G_Cost;
    }

    public void setG_Cost(double g_Cost) {
        this.G_Cost = g_Cost;

    }

    public Vertex(){

    }
    public Vertex(String Label , int Hcost) {

        this.isVisited = false ;
        this.Label = Label;
        this.H_Cost = Hcost ;
        this.G_Cost = Integer.MAX_VALUE;
        this.F_Cost = Integer.MAX_VALUE;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public double getH_Cost() {
        return H_Cost;
    }

    public void setH_Cost(double h_Cost) {
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

    @Override
    public String toString() {
        return "Vertex{" +
                "Label='" + Label + '\'' +
                ", isVisited=" + isVisited +
                ", parent=" + parent +
                ", H_Cost=" + H_Cost +
                ", cost=" + G_Cost +
                '}';
    }

    @Override
    public int compareTo(Vertex o) {
        return (int)(this.getF_Cost() - o.getF_Cost());
    }
}
