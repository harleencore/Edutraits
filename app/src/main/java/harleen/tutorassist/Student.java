package harleen.tutorassist;

public class Student {
    private String name;
    private String level;
    private int age;
    private int thumbnail;

    public Student(){
    }

    public Student(String name, String level, int age, int thumbnail){
        this.name = name;
        this.level = level;
        this.age = age;
        this.thumbnail = thumbnail;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLevel(){
        return level;
    }

    public void setLevel(){
        this.level = level;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getThumbnail(){
        return thumbnail;
    }

    public void setThumbnail(int thumbnail){
        this.thumbnail = thumbnail;
    }


}
