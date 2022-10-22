import java.util.ArrayList;

public class Voting implements VotingInt{
    String title = "";
    ArrayList<Candidate> candidates;

    Voting(String title, ArrayList<Candidate> candidates)
    {
        this.title = title;
        this.candidates = candidates;
    }


//    int size;
//    Candidate [] Array;
//    void createArray(int size) {
//        candidates = new Candidate[size];
//    }
//    void setArray(Candidate [] array)
//    {
//        for (int i=0; i < array.length; i++)
//        {
//            candidates[i]=array[i];
//        }
//    }
//    int size()
//    {
//        return candidates.length;
//    }
//
//    void added(Candidate el) {
//        Candidate[] newArr = new Candidate[candidates.length+1];
//        for (int i=0; i<candidates.length ; i++)
//            newArr[i]=candidates[i];
//        newArr[candidates.length] = el;
//        createArray(candidates.length+1);
//        setArray(newArr);
//    }


}
