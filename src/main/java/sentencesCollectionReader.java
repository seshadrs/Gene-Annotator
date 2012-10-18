import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.StringArray;
import org.apache.uima.pear.util.FileUtil;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;




public class sentencesCollectionReader extends CollectionReader_ImplBase {
	/*
	 * Reads sentences/documents from the input file specified as the parameter 'InputFile'
	 * reads documents one by one into the pipeline
	 * 
	 */

	ArrayList<String> allDocuments; // all document content (text and ID)
	Integer currentIndex; // current document being processed

	@Override
	public void initialize() {
		System.out.println("**In initialize()");

		currentIndex = 0; // set index to first document

		String dataFilename = (String) getConfigParameterValue("InputFile");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					dataFilename));
			allDocuments = new ArrayList<String>();
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {

//					System.out.println("--Processing " + line);
					allDocuments.add(line); // adds both the document-text and
											// the document ID

				}
			} finally {
				reader.close();
			}
		} catch (IOException ioe) {
			System.err.println("oops " + ioe.getMessage());
		}
		
		System.out.println(allDocuments.size());
	}

	@Override
	public void getNext(CAS arg0) throws CollectionException {
		// TODO Auto-generated method stub

		System.out.println("**In CR getNext()");

		JCas jcas;
		try {
			if (allDocuments.size() >= currentIndex - 1) {

				jcas = arg0.getJCas();
				String whole_document = allDocuments.get(currentIndex);
				
				currentIndex += 1;
				jcas.setDocumentText(whole_document);

			} 
			else {
				throw new CollectionException(); // there is no more document to
													// read. hence exception
			}

		} catch (CASException e) {
			throw new CollectionException(e);
		}

	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		allDocuments = null; // just delete the object. not needed anymore

	}

	@Override
	public Progress[] getProgress() {
		// TODO Auto-generated method stub

		System.out.println("**In getProgress()");
		return new Progress[] { new ProgressImpl(currentIndex,
				allDocuments.size(), Progress.ENTITIES) };
	}

	@Override
	public boolean hasNext() throws IOException, CollectionException {
		// TODO Auto-generated method stub
		// Check if there are more files to be read
		System.out.println("**In hasNext()");
		
		if (allDocuments.size()>0) {
		if (allDocuments.size() <= currentIndex)
			return false;
		else
			return true;
		}
		else
			return false;

	}

}
