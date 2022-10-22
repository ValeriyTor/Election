public class Candidate {
    String name;
    int voices = 0;

    Candidate(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addVoice()
    {
        voices++;
    }
    public int getVoices()
    {
        return voices;
    }







}
