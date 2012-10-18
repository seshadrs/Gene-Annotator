import java.util.Iterator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceProcessException;

import NER.Gene.Candidate;


public class HeuristicScorer extends JCasAnnotator_ImplBase {
	
	
	
	private double score_Length(String candidate)
	{
		return ((float)candidate.length())*((float)candidate.length())/500.00;
	}
	
	
	private double score_StringPattern( String candidate)
	{
		if (candidate.length()<=1)
			return 0.0;
		
		char first_character = candidate.charAt(0);
		char second_character = candidate.charAt(1);
		
		double local_score = 0.0;
		
		
		if ( first_character >='a' && first_character <='z')
		{
			if (second_character >= '0' && second_character <= '9')
				local_score += 1.0;
		}
		
		if ((first_character >='A' && first_character <='Z') || first_character >= '0' && first_character <= '9')	//likely a proper noun
			local_score += 0.5;
		
		if ((first_character =='(' || first_character =='[') && (second_character >='A' && second_character <='Z' ))	//likely a technical proper noun/acronym within brackets 
			local_score += 0.5;
		
		if ((first_character >='A' && first_character <='Z') && (second_character >='A' && second_character <='Z' ))	//likely an acronym
			local_score += 0.5;
		
		return local_score;
	}
	
	

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
		
System.out.println("**In processCas()");
		
		
	    try {
	    	Iterator annotationIter = jcas.getAnnotationIndex(Candidate.typeIndexID).iterator();
	    	
	        while (annotationIter.hasNext()) {
	          
	        	Candidate annot = (Candidate) annotationIter.next();
	        	String aText = annot.getCoveredText();
	        	
	        	annot.setScore(annot.getScore()+score_Length(aText));
	        	annot.setScore(annot.getScore()+score_StringPattern(aText));
	          	          
	        } 
	    	
	    	System.out.println(jcas.getDocumentText());
	      } catch (Exception e) {
	    	  	e.printStackTrace();
	      }
	    
		
	}

}
