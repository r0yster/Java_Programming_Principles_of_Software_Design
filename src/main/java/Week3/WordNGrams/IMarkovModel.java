package Week3.WordNGrams;

/**
 * Write a description of interface IMarkovModel here.
 *
 * @author Roy Cantu
 * @version 1.0
 */

public interface IMarkovModel {
    public void setTraining(String text);
    
    public void setRandom(int seed);
    
    public String getRandomText(int numChars);

}
