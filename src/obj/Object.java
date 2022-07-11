package obj;

import java.util.ArrayList;

class Lost {
    String name;
    private int time;
    String place;

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
}

class BookLost extends Lost {
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
                new BookLost("龙族",1,"食堂"),
                new BookLost("斗破苍穹",5,"食堂"),
                new BookLost("一念永恒",3,"2教"),
                new BookLost("完美世界",4,"实验楼"),
                new BookLost("星辰变",2,"2教")
        };
        Object solution=new Object();
        solution.sortLost(losts);
        System.out.println(losts[4].name);//斗破苍穹
        Lost[] newArr=solution.selectByKeyword(losts,"2教");//星辰变
        System.out.println(newArr[0].getName());
    }
}
