package ETK;

public class Separation{
    private char[] splits;
    public Separation(char... splits){
        this.splits = splits;
    }
    public boolean containsSeparation(String candidate){
        for (char split : this.splits){
            if (candidate.indexOf(split) > -1){
                return true;
            }
        }
        return false;
    }
    public boolean isSeparation(char candidate){
        for (char split : this.splits){
            if (split == candidate){
                return true;
            }
        }
        return false;
    }
    public boolean isSeparation(String candidate){
        if (candidate.length() == 1){
            char castedCandidate = candidate.charAt(0);
            return isSeparation(candidate);
        }
        return false;
    }
    public static Separation Default(){
        return new Separation(' ', ';', ':', ',', '-');
    }
}