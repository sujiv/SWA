package greet.greetingservice.Domain;

public class Greeting {
    private String content;

    public Greeting(String msg) {
        this.content = msg;
    }

    public void setContent(String msg) {
        this.content = msg;
    }

    public String getContent(){
        return this.content;
    }

}
