public class DisjointSet {
    int[] parent;
    int[] size;

    public DisjointSet(int totalNode){
        this.parent = new int[totalNode+1];
        this.size = new int[totalNode+1];

        for(int i = 0; i <= totalNode; i++){
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public int findUParent(int node){
        // itself is a parent
        if(node == parent[node]){
            return node;
        }

        // path compression
        int ultimateParent = findUParent(parent[node]);
        return parent[node] = ultimateParent;
    }

    public boolean unionBySize(int U, int V){
        int ultimateParentU = findUParent(U);
        int ultimateParentV = findUParent(V);

        // both have same parent that is its already connected and is one component, 
        // so Either skip or do what you want
        if(ultimateParentU == ultimateParentV){
            return false;
        }

        if(size[ultimateParentU] < size[ultimateParentV]){
            parent[ultimateParentU] = ultimateParentV;
            size[ultimateParentV] += size[ultimateParentU];
        }
        else{
            parent[ultimateParentV] = ultimateParentU;
            size[ultimateParentU] += size[ultimateParentV];
        }
        return true;
    }
}
