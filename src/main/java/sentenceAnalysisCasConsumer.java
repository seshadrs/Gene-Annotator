import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.uima.cas.CAS;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;

public class sentenceAnalysisCasConsumer extends CasConsumer_ImplBase {

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

	}

	@Override
	public void processCas(CAS arg0) throws ResourceProcessException {
		// TODO Auto-generated method stub
		System.out.println("**In AE processCas()");
		System.out.println(arg0.getDocumentText());

	}

}
