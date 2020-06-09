import java.util.Scanner;
import java.util.ArrayList;

/*This class contains the main method and also the functions for the CYK parser and tree recovery.*/

public class cykparser {
	
	static Grammar t = new Grammar();
	static ArrayList<ArrayList<String>> grammar = t.myGrammar();       
    static ArrayList<Double> pList = t.myProbabilities();
    static ArrayList<String> NTList = t.myNonterms();
    static double finalProb = 0.0;
    
    /*This CYK parser function takes in grammar and sentence as stated in the pseudo-code
     * I passed in the grammar as an ArrayList of ArrayList, while the probabilities are
     * called in from the static ArrayList declared above. When needed, I call the Nonterminals
     * from the static ArrayList declared above via either their index or the term itself
     * */
    public static Node[][][] cykparse(ArrayList<ArrayList<String>> grammar, String sentence){
    	Node[][][] P = new Node[30][30][30]; 
    	String s = sentence.toLowerCase();
		String[] words = s.split("\\W+");
		int N = words.length;
		for(int i = 1; i <= N; i++){
    		String word = words[i-1]; 		
    		for(int j = 18; j < 30;j++){
    			String temp = grammar.get(j).get(1);			
    			if(temp.equals(word)){
    				double prob = pList.get(j);
    				String nonterm = grammar.get(j).get(0);
    				int POS = NTList.indexOf(nonterm);
    				P[POS][i][i]= new Node();
    				P[POS][i][i].phrase = nonterm;
    				P[POS][i][i].startPhrase = i;
    				P[POS][i][i].endPhrase = i;
    				P[POS][i][i].word = word;
    				P[POS][i][i].prob = prob;
    			}
    		}
    	}
		   	
    	for(int length = 2; length<=N;length ++){
    		for(int i = 0; i<=N+1-length; i++){
    			int j = i+length-1;
    			for(String nonterm : NTList){
    				int M = NTList.indexOf(nonterm); 				
    				P[M][i][j]= new Node();
    				P[M][i][j].phrase = nonterm;
    				for(int k =i; k<=j-1; k++){
    					for(int index =0; index<18;index++){
    						if(grammar.get(index).get(0).equals(nonterm)){    							
    							String Y = grammar.get(index).get(1);
    							String Z = grammar.get(index).get(2);
    							double prob = pList.get(index);
    							int nY = NTList.indexOf(Y);
    							int nZ = NTList.indexOf(Z);
    							
    							if(P[nY][i][k] == null){
    								P[nY][i][k] = new Node();
    								P[nY][i][k].phrase = Y;
    							}							
    							if(P[nZ][k+1][j] == null){
    								P[nZ][k+1][j]= new Node();
    								P[nZ][k+1][j].phrase = Z;
    							}
    							
    							double newprob = (P[nY][i][k].prob) *(P[nZ][k+1][j].prob)*prob;
    							if(newprob > P[M][i][j].prob){
    								P[M][i][j].left = P[nY][i][k];
    								P[M][i][j].right = P[nZ][k+1][j];
    								P[M][i][j].prob = newprob;   							
    							}
    						}
    					}
    				}
    			}
    		}
    	}   
    	return P;
    }
    
    
    public static void printTree(Node[][][] P, int N){
    	/*For the example sentences that cannot be parsed on the class web-site,
    	 * I noticed that all they print out is "S".
    	 * So I used that information to catch those sentences which cannot be parsed.*/
    	if(P[0][1][N].left == null && (P[0][1][N].right==null)){
    		System.out.println("This sentence cannot be parsed.");
    		System.exit(0);
    	}
    	
    	printTree1(P[0][1][N], 0);
    	
    	//To record and print only the final probability
    	finalProb = printProb(P[0][1][N]);
    }
    
    /*printTree1 function as in the pseudo-code*/
    public static void printTree1(Node p, int indent){
    	if(p != null){
    		for (int i = 0; i < indent; i++) {
    		    System.out.print(" ");
    		} 
    		System.out.print(p.phrase + " ");
    		if(p.word != null){
    			System.out.print(p.word);
    		}
    		System.out.println();
    		printTree1(p.left, indent+3);
    		printTree1(p.right, indent+3);   		
    	}
    }
    
/*  I wrote this function to get the final probability
 *  because it was easier to write this one rather than changing 
 *  the previous printTree1 to return the final probability. 
 *  This function just asks if the Node & Node.prob is not empty.
 *  If true, it multiplies the probability with the ongoing counter and finally returns it.*/
    public static double printProb(Node p){
    	double counter = 1.0;
    	if(p != null && p.prob != 0.0){
    		counter = counter*p.prob;
    		printProb(p.left);
    		printProb(p.right);
    	}
    	return(counter);
    }
    
    /*Main wrapped in try-catch in case anything comes up while scanning input or otherwise*/
	public static void main(String[] args) {	 		 	
		try{
			Scanner scan = new Scanner(System.in);
			 
		 	System.out.print("Enter your sentence: ");
		 
		 	String sentence = scan.nextLine();	 	
		 	String s = sentence.toLowerCase();	
			String[] words = s.split("\\W+");
			int N = words.length;
			
			//Here I do a simple check if the user only input one word and not sentence.
			//If they input only a word, the program will throw an error and the user will 
			//have to restart the program with new, proper input sentence.
			if (N<=1){
				System.out.print("Please try running program again with more than one word for it to be a sentence.");
				System.exit(0);	
			}
				
			Node[][][] P = cykparse(grammar,sentence);			
			printTree(P, N);
			System.out.println("Probability = " + finalProb);
			scan.close();
		}
		catch(Exception ex) {
			System.out.println();
			System.out.printf("Error: "+ ex);
			System.exit(0);	
		}
    }
}
