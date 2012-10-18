import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;

import NER.Gene.Candidate;


public class CandidatePruner extends JCasAnnotator_ImplBase {
	
	/*
	 * Prunes the gene candidates by comparing their score with the average score of hte gene candidates for that particular document.
	 * Sets the IsBoolean to true for the candidates that have a score that is of a particular ratio or higher.
	 * The pruning ratio is set as a parameter 'pruningRatio', takes a double value
	 * 
	 */

	
	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
		
		System.out.println("**In processCas()");
		
		Map<String, Double> avgScores = new HashMap<String, Double>(){};
		
	    try {
	    	FSIterator annotationIter_Outer = jcas.getAnnotationIndex(Candidate.typeIndexID).iterator();
	    	
	        while (annotationIter_Outer.hasNext()) {
	          
	        	Candidate annot = (Candidate) annotationIter_Outer.next();
	        	String docID = annot.getDocumentID();
	        	
	        	if (!avgScores.containsKey(docID)) {
	        		
	        		FSIterator annotationIter_Inner = jcas.getAnnotationIndex(Candidate.typeIndexID).iterator();
	        		annotationIter_Inner.moveToFirst();
	        		
	    	    	
	        		double total_score =0.0;
	        		int total_candidates =0;
	        		
	    	        while (annotationIter_Inner.hasNext()) {
	    	        	
	    	        	Candidate c = (Candidate) annotationIter_Inner.next();
	    	        	if (c.getDocumentID().equalsIgnoreCase(docID)) {
	    	        		total_score += c.getScore();
	    	        		total_candidates += 1;
	    	        	}

	    	        }
	    	        
	    	        avgScores.put(docID, total_score/(double)total_candidates);
	        		
	        	}
          
	        }
	        
	        FSIterator annotationIter_Final = jcas.getAnnotationIndex(Candidate.typeIndexID).iterator();
	        annotationIter_Final.moveToFirst();
	        while (annotationIter_Final.hasNext()) {
		          
	        	Candidate annot = (Candidate) annotationIter_Final.next();
	        	if (annot.getScore() >= 1.9* avgScores.get(annot.getDocumentID()))
	        		annot.setIsGene(true);
	        	//System.out.println(annot.getCoveredText()+" "+annot.getScore()+" "+avgScores.get(annot.getDocumentID())+" "+annot.getDocumentID());
	        	
	        }
	        
	        
	    	
	    	System.out.println(jcas.getDocumentText());
	      } catch (Exception e) {
	    	  	e.printStackTrace();
	      }
		
	}

}
