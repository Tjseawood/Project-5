public class TV extends ServiceCommunicator {
        private String tvinfo;

    public TV (String tvinfo) {
        super("http://api.tvmaze.com/singlesearch/shows?q=" + tvinfo);
        this.tvinfo = tvinfo;
    }


    public String getTvinfo() {
        return tvinfo;
    }

    public void setTvinfo(String tvinfo) {
        this.tvinfo = tvinfo;
    }

    public static void main(String[] args) {
        TV t = new TV ("glee");
        t.connect();
        String resp = t.get();
        System.out.println(resp);


    }
}
