package obj;

import java.util.ArrayList;

class Lost {
    private String name;
    private int time;
    private String place;

    public Lost() {
    }

    public Lost(String name, int time, String place) {
        this.name = name;
        this.time = time;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}

class CardLost extends Lost {
    private int id;
    private String type="card";

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CardLost(int id) {
        this.id = id;
    }

    public CardLost(String name, int time, String place, int id) {
        super(name, time, place);
        this.id = id;
    }
}

class BookLost extends Lost {
    private String type="book";

    public String getType() {
        return type;
    }

    public BookLost(){}

    public BookLost(String name,int time,String place){
        super(name,time,place);
    }
}

public class Object {
    public void sortLost(Lost[] lostArray) {
        int len = lostArray.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <len-i-1; j++) {
                if(lostArray[j].getTime()>lostArray[j+1].getTime()){
                    Lost temp=lostArray[j];
                    lostArray[j]=lostArray[j+1];
                    lostArray[j+1]=temp;
                }
            }
        }
    }

    public Lost[] selectByKeyword(Lost[] lostArray,String keyword){
        ArrayList<Lost> about=new ArrayList<>();
        for (Lost i:
             lostArray) {
            if(i.getPlace().equals(keyword)){
                about.add(i);
            }
        }
        int len=about.size();
        Lost[] newLosts=new Lost[len];
        for (int i = 0; i < len; i++) {
            newLosts[i]=about.get(i);
        }
        return newLosts;
    }

    public static void main(String[] args) {
        Lost[] losts={
                new BookLost("??????",1,"??????"),
                new BookLost("????????????",5,"??????"),
                new BookLost("????????????",3,"2???"),
                new BookLost("????????????",4,"?????????"),
                new BookLost("?????????",2,"2???")
        };
        Object solution=new Object();
        solution.sortLost(losts);
        System.out.println(losts[4].getName());//????????????
        Lost[] newArr=solution.selectByKeyword(losts,"2???");//?????????
        System.out.println(newArr[0].getName());
    }
}
