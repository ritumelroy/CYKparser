/*
 * This class creates and initializes the Nodes which are equivalent to the 
 * "tree" in the pseudo-code. These are the objects stored inside the chart in cykparser class.
 */

public class Node {
	String phrase;
	int startPhrase;
	int endPhrase;
	String word;
	Node left;
	Node right;
	double prob;
	
	public Node(){
		phrase = null;
		startPhrase = 0;
		endPhrase =0;
		word = null;
		left = null;
		right = null;
		prob = 0.0;
	}
	
}
