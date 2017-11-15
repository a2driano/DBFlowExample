package ua.room.project.dbflow.model;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import java.util.List;

import ua.room.project.dbflow.data.AppDataBase;

/**
 * Created by kunde on 15.11.2017.
 */
@Table(database = AppDataBase.class)
public class Company {
    @PrimaryKey(autoincrement = true)
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
