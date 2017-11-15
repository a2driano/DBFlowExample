package ua.room.project.dbflow.model;

import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import ua.room.project.dbflow.data.AppDataBase;

/**
 * Created by kunde on 15.11.2017.
 */
@Table(database = AppDataBase.class)
public class Worker {
    @PrimaryKey(autoincrement = true)
    private long id;
    private String mName;
    private String mPhone;
    private long mDataBirth;
    private Company mCompany;

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public long getmDataBirth() {
        return mDataBirth;
    }

    public void setmDataBirth(long mDataBirth) {
        this.mDataBirth = mDataBirth;
    }

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
