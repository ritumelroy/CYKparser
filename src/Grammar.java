import java.util.ArrayList;

/*
 * In this class I put all the grammar in various ArrayLists.
 * I then call on these ArrayLists in the beginning of the 
 * CYK parser class to process the information.
 */

public class Grammar {
	
	//Contains all the grammar and lexicons except the probabilities and special symbols("[","]","->")
	public ArrayList<ArrayList<String>> myGrammar()    {
        ArrayList<ArrayList<String>> grammar = new ArrayList<ArrayList<String>>();
        ArrayList<String> inner1 = new ArrayList<String>();
        ArrayList<String> inner2 = new ArrayList<String>();
        ArrayList<String> inner3 = new ArrayList<String>();
        ArrayList<String> inner4 = new ArrayList<String>();
        ArrayList<String> inner5 = new ArrayList<String>();
        ArrayList<String> inner6 = new ArrayList<String>();
        ArrayList<String> inner7 = new ArrayList<String>();
        ArrayList<String> inner8 = new ArrayList<String>();
        ArrayList<String> inner9 = new ArrayList<String>();
        ArrayList<String> inner10 = new ArrayList<String>();
        ArrayList<String> inner11= new ArrayList<String>();
        ArrayList<String> inner12 = new ArrayList<String>();
        ArrayList<String> inner13 = new ArrayList<String>();
        ArrayList<String> inner14 = new ArrayList<String>();
        ArrayList<String> inner15 = new ArrayList<String>();
        ArrayList<String> inner16 = new ArrayList<String>();
        ArrayList<String> inner17 = new ArrayList<String>();
        ArrayList<String> inner18 = new ArrayList<String>();
        ArrayList<String> inner19 = new ArrayList<String>();
        ArrayList<String> inner20 = new ArrayList<String>();
        ArrayList<String> inner21 = new ArrayList<String>();
        ArrayList<String> inner22 = new ArrayList<String>();
        ArrayList<String> inner23= new ArrayList<String>();
        ArrayList<String> inner24 = new ArrayList<String>();
        ArrayList<String> inner25 = new ArrayList<String>();
        ArrayList<String> inner26 = new ArrayList<String>();
        ArrayList<String> inner27 = new ArrayList<String>();
        ArrayList<String> inner28 = new ArrayList<String>();
        ArrayList<String> inner29 = new ArrayList<String>();
        ArrayList<String> inner30 = new ArrayList<String>();
        inner1.add("S");inner1.add("Noun");inner1.add("Verb");
        grammar.add(inner1);
        inner2.add("S");inner2.add("Noun");inner2.add("VerbAndObject");
        grammar.add(inner2);
        inner3.add("S");inner3.add("Noun");inner3.add("VPWithPPList");
        grammar.add(inner3);
        inner4.add("S");inner4.add("NP");inner4.add("Verb");
        grammar.add(inner4);
        inner5.add("S");inner5.add("NP");inner5.add("VerbAndObject");
        grammar.add(inner5);
        inner6.add("S");inner6.add("NP");inner6.add("VPWithPPList");
        grammar.add(inner6);
        inner7.add("NP");inner7.add("Noun");inner7.add("PP");
        grammar.add(inner7);
        inner8.add("NP");inner8.add("Noun");inner8.add("PPList");
        grammar.add(inner8);
        inner9.add("PP");inner9.add("Prep");inner9.add("Noun");
        grammar.add(inner9);
        inner10.add("PP");inner10.add("Prep");inner10.add("NP");
        grammar.add(inner10);
        inner11.add("PPList");inner11.add("PP");inner11.add("PP");
        grammar.add(inner11);
        inner12.add("PPList");inner12.add("PP");inner12.add("PPList");
        grammar.add(inner12);
        inner13.add("VerbAndObject");inner13.add("Verb");inner13.add("Noun");
        grammar.add(inner13);
        inner14.add("VerbAndObject");inner14.add("Verb");inner14.add("NP");
        grammar.add(inner14);
        inner15.add("VPWithPPList");inner15.add("Verb");inner15.add("PP");
        grammar.add(inner15);
        inner16.add("VPWithPPList");inner16.add("Verb");inner16.add("PP");
        grammar.add(inner16);
        inner17.add("VPWithPPList");inner17.add("Verb");inner17.add("PPList");
        grammar.add(inner17);
        inner18.add("VPWithPPList");inner18.add("VerbAndObject");inner18.add("PP");
        grammar.add(inner18);
        inner19.add("Noun");inner19.add("amy");inner19.add(null);
        grammar.add(inner19);
        inner20.add("Noun");inner20.add("dinner");inner20.add(null);
        grammar.add(inner20);
        inner21.add("Noun");inner21.add("fish");inner21.add(null);
        grammar.add(inner21);
        inner22.add("Noun");inner22.add("streams");inner22.add(null);
        grammar.add(inner22);
        inner23.add("Noun");inner23.add("swim");inner23.add(null);
        grammar.add(inner23);
        inner24.add("Noun");inner24.add("tuesday");inner24.add(null);
        grammar.add(inner24);
        inner25.add("Prep");inner25.add("for");inner25.add(null);
        grammar.add(inner25);
        inner26.add("Prep");inner26.add("in");inner26.add(null);
        grammar.add(inner26);
        inner27.add("Prep");inner27.add("on");inner27.add(null);
        grammar.add(inner27);
        inner28.add("Verb");inner28.add("ate");inner28.add(null);
        grammar.add(inner28);
        inner29.add("Verb");inner29.add("streams");inner29.add(null);
        grammar.add(inner29);
        inner30.add("Verb");inner30.add("swim");inner30.add(null);
        grammar.add(inner30);
        
        return(grammar);
	 }
	
	//Contains all the probabilities
	public ArrayList<Double> myProbabilities()    {
	    ArrayList<Double> prob = new ArrayList<Double>();
	    prob.add(0.2);
	    prob.add(0.3);
	    prob.add(0.1);
	    prob.add(0.2);
	    prob.add(0.1);
	    prob.add(0.1);
	    prob.add(0.8);
	    prob.add(0.2);
	    prob.add(0.6);
	    prob.add(0.4);
	   
	    prob.add(0.6);
	    prob.add(0.4);
	    prob.add(0.5);
	    prob.add(0.5);
	    prob.add(0.3);
	    prob.add(0.1);
	    prob.add(0.4);
	    prob.add(0.2);
	    prob.add(0.1);
	    prob.add(0.2);
	    
	    prob.add(0.2);
	    prob.add(0.1);
	    prob.add(0.2);
	    prob.add(0.2);
	    prob.add(0.5);
	    prob.add(0.3);
	    prob.add(0.2);
	    prob.add(0.7);
	    prob.add(0.1);
	    prob.add(0.2);
	    return(prob);
	 }
	
	//A list of all the nonterminals 
	public ArrayList<String> myNonterms() {
		ArrayList<String> NT = new ArrayList<String>();
		NT.add("S");
		NT.add("Noun");
		NT.add("Verb");
		NT.add("VerbAndObject");
		NT.add("VPWithPPList");
		NT.add("NP");
		NT.add("PP");
		NT.add("PPList");
		NT.add("Prep");
		return NT;
	}
}
