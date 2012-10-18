

/* First created by JCasGen Wed Oct 17 12:41:16 EDT 2012 */
package NER.Gene;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Oct 17 16:28:47 EDT 2012
 * XML source: /Users/sesha7/EclipseWorkspace/SE/hw1/hw1-seshadrs/src/main/resources/CandidatePrunerDescriptor.xml
 * @generated */
public class Candidate extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Candidate.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Candidate() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Candidate(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Candidate(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Candidate(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: length

  /** getter for length - gets 
   * @generated */
  public int getLength() {
    if (Candidate_Type.featOkTst && ((Candidate_Type)jcasType).casFeat_length == null)
      jcasType.jcas.throwFeatMissing("length", "NER.Gene.Candidate");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Candidate_Type)jcasType).casFeatCode_length);}
    
  /** setter for length - sets  
   * @generated */
  public void setLength(int v) {
    if (Candidate_Type.featOkTst && ((Candidate_Type)jcasType).casFeat_length == null)
      jcasType.jcas.throwFeatMissing("length", "NER.Gene.Candidate");
    jcasType.ll_cas.ll_setIntValue(addr, ((Candidate_Type)jcasType).casFeatCode_length, v);}    
   
    
  //*--------------*
  //* Feature: isGene

  /** getter for isGene - gets 
   * @generated */
  public boolean getIsGene() {
    if (Candidate_Type.featOkTst && ((Candidate_Type)jcasType).casFeat_isGene == null)
      jcasType.jcas.throwFeatMissing("isGene", "NER.Gene.Candidate");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((Candidate_Type)jcasType).casFeatCode_isGene);}
    
  /** setter for isGene - sets  
   * @generated */
  public void setIsGene(boolean v) {
    if (Candidate_Type.featOkTst && ((Candidate_Type)jcasType).casFeat_isGene == null)
      jcasType.jcas.throwFeatMissing("isGene", "NER.Gene.Candidate");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((Candidate_Type)jcasType).casFeatCode_isGene, v);}    
   
    
  //*--------------*
  //* Feature: documentID

  /** getter for documentID - gets the document the gene candidate came from
   * @generated */
  public String getDocumentID() {
    if (Candidate_Type.featOkTst && ((Candidate_Type)jcasType).casFeat_documentID == null)
      jcasType.jcas.throwFeatMissing("documentID", "NER.Gene.Candidate");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Candidate_Type)jcasType).casFeatCode_documentID);}
    
  /** setter for documentID - sets the document the gene candidate came from 
   * @generated */
  public void setDocumentID(String v) {
    if (Candidate_Type.featOkTst && ((Candidate_Type)jcasType).casFeat_documentID == null)
      jcasType.jcas.throwFeatMissing("documentID", "NER.Gene.Candidate");
    jcasType.ll_cas.ll_setStringValue(addr, ((Candidate_Type)jcasType).casFeatCode_documentID, v);}    
   
    
  //*--------------*
  //* Feature: startOffset

  /** getter for startOffset - gets start offset of the gene candidate -- number of non white chars preceeding mention
   * @generated */
  public int getStartOffset() {
    if (Candidate_Type.featOkTst && ((Candidate_Type)jcasType).casFeat_startOffset == null)
      jcasType.jcas.throwFeatMissing("startOffset", "NER.Gene.Candidate");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Candidate_Type)jcasType).casFeatCode_startOffset);}
    
  /** setter for startOffset - sets start offset of the gene candidate -- number of non white chars preceeding mention 
   * @generated */
  public void setStartOffset(int v) {
    if (Candidate_Type.featOkTst && ((Candidate_Type)jcasType).casFeat_startOffset == null)
      jcasType.jcas.throwFeatMissing("startOffset", "NER.Gene.Candidate");
    jcasType.ll_cas.ll_setIntValue(addr, ((Candidate_Type)jcasType).casFeatCode_startOffset, v);}    
   
    
  //*--------------*
  //* Feature: endOffset

  /** getter for endOffset - gets end offset -- number of non space characters preceeding the end of the string mention.
   * @generated */
  public int getEndOffset() {
    if (Candidate_Type.featOkTst && ((Candidate_Type)jcasType).casFeat_endOffset == null)
      jcasType.jcas.throwFeatMissing("endOffset", "NER.Gene.Candidate");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Candidate_Type)jcasType).casFeatCode_endOffset);}
    
  /** setter for endOffset - sets end offset -- number of non space characters preceeding the end of the string mention. 
   * @generated */
  public void setEndOffset(int v) {
    if (Candidate_Type.featOkTst && ((Candidate_Type)jcasType).casFeat_endOffset == null)
      jcasType.jcas.throwFeatMissing("endOffset", "NER.Gene.Candidate");
    jcasType.ll_cas.ll_setIntValue(addr, ((Candidate_Type)jcasType).casFeatCode_endOffset, v);}    
   
    
  //*--------------*
  //* Feature: score

  /** getter for score - gets the score for this gene candidate -- updated by the various heuristics used to prune gene candidates
   * @generated */
  public double getScore() {
    if (Candidate_Type.featOkTst && ((Candidate_Type)jcasType).casFeat_score == null)
      jcasType.jcas.throwFeatMissing("score", "NER.Gene.Candidate");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Candidate_Type)jcasType).casFeatCode_score);}
    
  /** setter for score - sets the score for this gene candidate -- updated by the various heuristics used to prune gene candidates 
   * @generated */
  public void setScore(double v) {
    if (Candidate_Type.featOkTst && ((Candidate_Type)jcasType).casFeat_score == null)
      jcasType.jcas.throwFeatMissing("score", "NER.Gene.Candidate");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Candidate_Type)jcasType).casFeatCode_score, v);}    
  }

    