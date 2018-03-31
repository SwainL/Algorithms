package practice;

public class TrieNode {
    int paths; // indicate the number of nodes that get across this edge
    //int ends; // indicate the number of nodes ending with this node
    TrieNode[] links; // indicate links connected to its lower level nodes

    public TrieNode() {
        links = new TrieNode[2];
    }
}
