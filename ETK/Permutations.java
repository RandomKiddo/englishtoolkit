package ETK;

import java.util.ArrayList;
import java.util.Collections;

public class Permutations{
    private String original;
    private ArrayList<String> permutations;
    public Permutations(String original){
        this.original = original;
        this.permutations = new ArrayList<String>(factorial(original.length()));
    }
    private int factorial(int num){
        if (num <= 1){
            return 1;
        }
        return num * factorial(num - 1);
    }
    public String[] getPermutations(){
        permutations(this.original.toCharArray(), 0);
        Collections.sort(this.permutations);
        Object[] shallowCopy = this.permutations.toArray();
        return castCopy(shallowCopy);
    }
    private void permutations(char[] chars, int index){
        if (index == chars.length - 1){
            this.permutations.add(String.valueOf(chars));
        }
        for (int i = index; i < chars.length; i++){
            swap(chars, index, i);
            permutations(chars, index + 1);
            swap(chars, index, i);
        }
    }
    private void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    private String[] castCopy(Object[] shallowCopy){
        String[] castCopy = new String[shallowCopy.length];
        for (int i = 0; i < shallowCopy.length; i++){
            castCopy[i] = shallowCopy[i].toString();
        }
        return castCopy;
    }
}