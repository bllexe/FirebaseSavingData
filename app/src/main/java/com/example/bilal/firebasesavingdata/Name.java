package com.example.bilal.firebasesavingdata;

/**
 * Created by Bilal on 14.06.2017.
 */

public class Name {

    String Id;
    String Name;
    String Job;

  public  Name()
  {  }

    public Name(String id, String name, String job) {
       this. Id = id;
       this.Name = name;
       this.Job = job;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getJob() {
        return Job;
    }
}
