import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.axis.utils.StringUtils;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.jcas.JCas;
import org.apache.uima.pear.util.StringUtil;
import org.apache.uima.resource.ResourceInitializationException;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import NER.Gene.*;

public class geneCandidateAnnotator extends JCasAnnotator_ImplBase {
	/*
	 * Uses Stanford POS tagger to find "NN*" part of speech fragments in the sentences.
	 * Ignores bracket characters
	 * Annotates these string fragments as gene candidates and updates the CAS.
	 */
	
	
	private static StanfordCoreNLP pipeline = null;

	public static void InitializeNER() throws ResourceInitializationException {
		Properties props = new Properties();
		props.put("annotators", "tokenize, ssplit, pos");
		pipeline = new StanfordCoreNLP(props);
	}

	public static Map<Integer, Integer> getGeneSpans(String text) {
		
		
		Map<Integer, Integer> begin2end = new HashMap<Integer, Integer>();
		Annotation document = new Annotation(text);
		pipeline.annotate(document);
		List<CoreMap> sentences = document.get(SentencesAnnotation.class);
		for (CoreMap sentence : sentences) {
			List<CoreLabel> candidate = new ArrayList<CoreLabel>();
			for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
				String pos = token.get(PartOfSpeechAnnotation.class);
//				System.out.println(pos);
				if (pos.startsWith("NN")) {
					candidate.add(token);
				} else if (candidate.size() > 0) {
					int begin = candidate.get(0).beginPosition();
					int end = candidate.get(candidate.size() - 1).endPosition();
					begin2end.put(begin, end);
					candidate.clear();
				}
			}
			if (candidate.size() > 0) {
				int begin = candidate.get(0).beginPosition();
				int end = candidate.get(candidate.size() - 1).endPosition();
				begin2end.put(begin, end);
				candidate.clear();
			}
		}
		return begin2end;
	}
	
	
	@Override
	public void process(JCas arg0) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
		
		String whole_document = arg0.getDocumentText();
		String document_ID = whole_document.split(" ")[0];
		Integer document_text_start = whole_document.indexOf(' ')+1;
		String document_text = whole_document.substring(document_text_start);
		
		Integer document_start_location = document_ID.length();

		
		if(pipeline==null)	//if the NER has not been initialized
			try {
				InitializeNER();
			} catch (ResourceInitializationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		  Map<Integer,Integer> genes = getGeneSpans(document_text);
		  
		  for (Map.Entry<Integer, Integer> entry : genes.entrySet())
		  {
//		      System.out.println(entry.getKey() + "-" + entry.getValue());
//		      System.out.println(document_text.substring(entry.getKey(), entry.getValue()));
		      
				NER.Gene.Candidate candidate = new NER.Gene.Candidate(arg0);
				
				int start = entry.getKey()+1;
				int end= entry.getValue();
				
				if (document_text.charAt(start)=='(' || document_text.charAt(start)=='[')
					start += 1;
				
				candidate.setBegin(document_start_location + start);
				candidate.setEnd(document_start_location+ end+1);
				
				candidate.setDocumentID(document_ID);
				
				candidate.setStartOffset(start - StringUtil.countWords(document_text.substring(0,start)) );
				candidate.setEndOffset(end - StringUtil.countWords(document_text.substring(0,start)) );
				
				candidate.setScore(0.0);	//starting score
				
				candidate.setIsGene(false);	//just a default value
				
				candidate.addToIndexes();
		  }
			  
		  }
	}


