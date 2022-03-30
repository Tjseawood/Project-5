public class Itunes extends ServiceCommunicator {
    private String itunes;

    //constructor
    public Itunes(String itunes) {
        super("https://itunes.apple.com/search?term=" + itunes + "&limit=1");
        this.itunes = itunes;
    }

    public String getResults(String itunes){
        return super.getResults("https://itunes.apple.com/search?term=" + itunes);
    }

    //Getters and Setters

    public String getItunes() {
        return itunes;
    }

    public void setItunes(String itunes) {
        this.itunes = itunes;
    }


    //Test the class
    public static void main(String[] args) {
        Itunes i = new Itunes("beyonce");
//        i.connect();
//        String response = i.get();
//        System.out.println("Itunes RESULTS: ");
//        System.out.println(response);
        System.out.println("ITUNES: " + i.getResults("beyonce"));

    }
}

