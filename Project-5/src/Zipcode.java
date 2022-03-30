public class Zipcode extends ServiceCommunicator {
    private String zipcode;

    //constructor
    public Zipcode(String zipcode) {
        super(" http://api.zippopotam.us/us/" + zipcode);
        this.zipcode = zipcode;
    }

    public String getResults(String zipcode){
       return super.getResults("http://api.zippopotam.us/us/" + zipcode);
    }

    //Getters and Setters

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


    //This main  to test our class
     public static void main(String[] args) {
        Zipcode z = new Zipcode("90815");
        z.connect();
        String response = z.get();
        System.out.println("ZIP RESULTS: " + z.getResults("60413"));
        System.out.println(response);

        System.out.println(z.getResults("60466"));
    }
}
