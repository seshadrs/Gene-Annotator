import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.examples.SourceDocumentInformation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.ProcessTrace;

import NER.Gene.Candidate;
import NER.Gene.Candidate_Type;

public class geneAnnotationsCasConsumer extends CasConsumer_ImplBase {

	File outFile;
	FileWriter fileWriter;

	/**
	 * Initializes this CAS Consumer with the parameters specified in the
	 * descriptor.
	 * 
	 * @throws ResourceInitializationException
	 *             if there is error in initializing the resources
	 */
	public void initialize() throws ResourceInitializationException {
		System.out.println("**In CC initialize()");
		
		// extract configuration parameter settings
		String oPath = (String) getUimaContext().getConfigParameterValue(
				"outputFile");

		// Output file should be specified in the descriptor
		if (oPath == null) {
			throw new ResourceInitializationException(
					ResourceInitializationException.CONFIG_SETTING_ABSENT,
					new Object[] { "outputFile" });
		}
		// If specified output directory does not exist, try to create it
		outFile = new File(oPath.trim());
		if (outFile.getParentFile() != null
				&& !outFile.getParentFile().exists()) {
			if (!outFile.getParentFile().mkdirs())
				throw new ResourceInitializationException(
						ResourceInitializationException.RESOURCE_DATA_NOT_VALID,
						new Object[] { oPath, "outputFile" });
		}
		try {
			fileWriter = new FileWriter(outFile);
		} catch (IOException e) {
			throw new ResourceInitializationException(e);
		}
	}

	@Override
	public void processCas(CAS arg0) throws ResourceProcessException {
		// TODO Auto-generated method stub
		System.out.println("**In processCas()");
		
		JCas jcas;
	    try {
	    	jcas = arg0.getJCas();
	    
//	    	fileWriter.write(jcas.getDocumentText()+"\n");
	    	
	    	
	    	//Iterator annotationIter = jcas.getAnnotationIndex().iterator();
	    	Iterator annotationIter = jcas.getAnnotationIndex(Candidate.typeIndexID).iterator();
//	    	System.out.println("%%Got a handle on annotator");
	    	
	        while (annotationIter.hasNext()) {
	          
	        	//Annotation annot = (Annotation) annotationIter.next();
	        	Candidate annot = (Candidate) annotationIter.next();
	          // get the text that is enclosed within the annotation in the CAS
	          String aText = annot.getCoveredText();
	          
//	          System.out.println( annot.getType().getName() + " "+aText + " from "+annot.getStartOffset()+"-"+annot.getEndOffset()+" in "+annot.getDocumentID() +" "+ annot.getIsGene() +" "+ annot.getBegin()+" "+ annot.getEnd());
	          if (annot.getIsGene())
	        	  fileWriter.write(annot.getDocumentID()+"|"+annot.getStartOffset()+" "+annot.getEndOffset()+"|"+aText+"\n");
	          
	        } 
	    	
	    	System.out.println(jcas.getDocumentText());
	      } catch (Exception e) {
	        throw new ResourceProcessException(e);
	      }
	    

	}
	
	/**
	   * Called when the entire collection is completed.
	   * 
	   * @param aTrace
	   *          ProcessTrace object that will log events in this method.
	   * @throws ResourceProcessException
	   *           if there is an error in processing the Resource
	   * @throws IOException
	   *           if there is an IO Error
	   * @see org.apache.uima.collection.CasConsumer#collectionProcessComplete(ProcessTrace)
	   */
	  public void collectionProcessComplete(ProcessTrace aTrace) throws ResourceProcessException,
	          IOException {
	    if (fileWriter != null) {
	      fileWriter.close();
	    }
	  }
	  
	  
	

}
