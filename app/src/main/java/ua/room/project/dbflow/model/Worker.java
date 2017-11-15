package ua.room.project.dbflow.model;

/**
 * Created by kunde on 15.11.2017.
 */

public class Worker {
    private long id;
    private String mName;
    private Company mCompany;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Company getmCompany() {
        return mCompany;
    }

    public void setmCompany(Company mCompany) {
        this.mCompany = mCompany;
    }
}
