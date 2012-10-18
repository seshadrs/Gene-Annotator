
/* First created by JCasGen Wed Oct 17 12:41:16 EDT 2012 */
package NER.Gene;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Wed Oct 17 16:28:47 EDT 2012
 * @generated */
public class Candidate_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Candidate_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Candidate_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Candidate(addr, Candidate_Type.this);
  			   Candidate_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Candidate(addr, Candidate_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Candidate.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("NER.Gene.Candidate");
 
  /** @generated */
  final Feature casFeat_length;
  /** @generated */
  final int     casFeatCode_length;
  /** @generated */ 
  public int getLength(int addr) {
        if (featOkTst && casFeat_length == null)
      jcas.throwFeatMissing("length", "NER.Gene.Candidate");
    return ll_cas.ll_getIntValue(addr, casFeatCode_length);
  }
  /** @generated */    
  public void setLength(int addr, int v) {
        if (featOkTst && casFeat_length == null)
      jcas.throwFeatMissing("length", "NER.Gene.Candidate");
    ll_cas.ll_setIntValue(addr, casFeatCode_length, v);}
    
  
 
  /** @generated */
  final Feature casFeat_isGene;
  /** @generated */
  final int     casFeatCode_isGene;
  /** @generated */ 
  public boolean getIsGene(int addr) {
        if (featOkTst && casFeat_isGene == null)
      jcas.throwFeatMissing("isGene", "NER.Gene.Candidate");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_isGene);
  }
  /** @generated */    
  public void setIsGene(int addr, boolean v) {
        if (featOkTst && casFeat_isGene == null)
      jcas.throwFeatMissing("isGene", "NER.Gene.Candidate");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_isGene, v);}
    
  
 
  /** @generated */
  final Feature casFeat_documentID;
  /** @generated */
  final int     casFeatCode_documentID;
  /** @generated */ 
  public String getDocumentID(int addr) {
        if (featOkTst && casFeat_documentID == null)
      jcas.throwFeatMissing("documentID", "NER.Gene.Candidate");
    return ll_cas.ll_getStringValue(addr, casFeatCode_documentID);
  }
  /** @generated */    
  public void setDocumentID(int addr, String v) {
        if (featOkTst && casFeat_documentID == null)
      jcas.throwFeatMissing("documentID", "NER.Gene.Candidate");
    ll_cas.ll_setStringValue(addr, casFeatCode_documentID, v);}
    
  
 
  /** @generated */
  final Feature casFeat_startOffset;
  /** @generated */
  final int     casFeatCode_startOffset;
  /** @generated */ 
  public int getStartOffset(int addr) {
        if (featOkTst && casFeat_startOffset == null)
      jcas.throwFeatMissing("startOffset", "NER.Gene.Candidate");
    return ll_cas.ll_getIntValue(addr, casFeatCode_startOffset);
  }
  /** @generated */    
  public void setStartOffset(int addr, int v) {
        if (featOkTst && casFeat_startOffset == null)
      jcas.throwFeatMissing("startOffset", "NER.Gene.Candidate");
    ll_cas.ll_setIntValue(addr, casFeatCode_startOffset, v);}
    
  
 
  /** @generated */
  final Feature casFeat_endOffset;
  /** @generated */
  final int     casFeatCode_endOffset;
  /** @generated */ 
  public int getEndOffset(int addr) {
        if (featOkTst && casFeat_endOffset == null)
      jcas.throwFeatMissing("endOffset", "NER.Gene.Candidate");
    return ll_cas.ll_getIntValue(addr, casFeatCode_endOffset);
  }
  /** @generated */    
  public void setEndOffset(int addr, int v) {
        if (featOkTst && casFeat_endOffset == null)
      jcas.throwFeatMissing("endOffset", "NER.Gene.Candidate");
    ll_cas.ll_setIntValue(addr, casFeatCode_endOffset, v);}
    
  
 
  /** @generated */
  final Feature casFeat_score;
  /** @generated */
  final int     casFeatCode_score;
  /** @generated */ 
  public double getScore(int addr) {
        if (featOkTst && casFeat_score == null)
      jcas.throwFeatMissing("score", "NER.Gene.Candidate");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_score);
  }
  /** @generated */    
  public void setScore(int addr, double v) {
        if (featOkTst && casFeat_score == null)
      jcas.throwFeatMissing("score", "NER.Gene.Candidate");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_score, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Candidate_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_length = jcas.getRequiredFeatureDE(casType, "length", "uima.cas.Integer", featOkTst);
    casFeatCode_length  = (null == casFeat_length) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_length).getCode();

 
    casFeat_isGene = jcas.getRequiredFeatureDE(casType, "isGene", "uima.cas.Boolean", featOkTst);
    casFeatCode_isGene  = (null == casFeat_isGene) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_isGene).getCode();

 
    casFeat_documentID = jcas.getRequiredFeatureDE(casType, "documentID", "uima.cas.String", featOkTst);
    casFeatCode_documentID  = (null == casFeat_documentID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_documentID).getCode();

 
    casFeat_startOffset = jcas.getRequiredFeatureDE(casType, "startOffset", "uima.cas.Integer", featOkTst);
    casFeatCode_startOffset  = (null == casFeat_startOffset) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_startOffset).getCode();

 
    casFeat_endOffset = jcas.getRequiredFeatureDE(casType, "endOffset", "uima.cas.Integer", featOkTst);
    casFeatCode_endOffset  = (null == casFeat_endOffset) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_endOffset).getCode();

 
    casFeat_score = jcas.getRequiredFeatureDE(casType, "score", "uima.cas.Double", featOkTst);
    casFeatCode_score  = (null == casFeat_score) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_score).getCode();

  }
}



    