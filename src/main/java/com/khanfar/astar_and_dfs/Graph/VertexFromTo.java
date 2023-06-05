package com.khanfar.astar_and_dfs.Graph;

public class VertexFromTo {

    private Vertex to ;
    private int cost ;

    public VertexFromTo( Vertex w , int cost) {
        this.to = w;
        this.cost = cost;
    }


    public Vertex getTo() {
        return to;
    }

    public void setTo(Vertex to) {
        this.to = to;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((to == null) ? 0 : to.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VertexFromTo other = (VertexFromTo) obj;
        if (to == null) {
            if (other.to != null)
                return false;
        } else if (!to.equals(other.to))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "VertexFromTo{" +
                ", to=" + to +
                ", cost=" + cost +
                '}';
    }

}
