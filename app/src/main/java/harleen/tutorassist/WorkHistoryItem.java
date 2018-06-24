package harleen.tutorassist;

public class WorkHistoryItem {
    private String title;
    private String type;
    private int durn;
    private int rating;

    public WorkHistoryItem(){
    }

    public WorkHistoryItem(String title, String type, int durn, int rating){
        this.title = title;
        this.type = type;
        this.durn = durn;
        this.rating = rating;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String name){
        this.title = title;
    }

    public String getType(){
        return type;
    }

    public void setType(){
        this.type = type;
    }

    public int getDurn(){
        return durn;
    }

    public void setDurn(int durn){
        this.durn = durn;
    }

    public int getRating(){
        return rating;
    }

    public void setRating(int rating){
        this.rating = rating;
    }


}
