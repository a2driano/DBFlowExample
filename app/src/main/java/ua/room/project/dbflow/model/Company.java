package ua.room.project.dbflow.model;

import java.util.List;

/**
 * Created by kunde on 15.11.2017.
 */

public class Company {
    private long id;
    private String mCompanyName;
    private List<Worker> mWorkerList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getmCompanyName() {
        return mCompanyName;
    }

    public void setmCompanyName(String mCompanyName) {
        this.mCompanyName = mCompanyName;
    }

    public List<Worker> getmWorkerList() {
        return mWorkerList;
    }

    public void setmWorkerList(List<Worker> mWorkerList) {
        this.mWorkerList = mWorkerList;
    }
}
