package com.zhy.Pojo;

public class Dishes {
    private int did;
    private String dname;
    private String details;
    private int count;
    private int num;
    private double price;

    public Dishes() {
    }

    @Override
    public String toString() {
        return
                "序号："+did+ "\n菜名："+ dname +"\n介绍：" + details +"\n已卖：" + count+"  剩余：" + num +"  价格："+ price +"\n\n" ;
    }
    public String toMenuString(){
        return did+","+dname+","+details+","+count+","+num+","+price+"\n";
    }


    public Dishes(int did, String dname, String details, int count, int num, double price) {
        this.did = did;
        this.dname = dname;
        this.details = details;
        this.count = count;
        this.num = num;
        this.price = price;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
