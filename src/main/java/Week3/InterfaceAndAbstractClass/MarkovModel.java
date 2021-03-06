package Week3.InterfaceAndAbstractClass;
/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MarkovModel extends AbstractMarkovModel{
    private int model;
    
    public MarkovModel(int n){
        myRandom = new Random();
        model = n;
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public String toString(String s){
        return "MarkovModel of order " + model;
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - model);
        String key = myText.substring(index, index+model);
        sb.append(key);
        for(int k=0; k < numChars - model; k++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size() == 0){
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }        
        return sb.toString();
    }
}
