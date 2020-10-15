package apssdc.in.githubjobs;

public class Job {
    // This is POJO CLASS
    // Plain Old Java Object

    String type;
    String company_url;
    String title;
    String location;

    public Job(String type, String company_url, String title, String location) {
        this.type = type;
        this.company_url = company_url;
        this.title = title;
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public String getCompany_url() {
        return company_url;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }
}
