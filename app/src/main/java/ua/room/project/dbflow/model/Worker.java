package ua.room.project.dbflow.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import ua.room.project.dbflow.data.AppDataBase;

/**
 * Created by kunde on 15.11.2017.
 */
@Table(database = AppDataBase.class)
public class Worker extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column
    private long id;

    @Column
    private String mName;

    @Column
    private String mPhone;

    @Column
    private long mDataBirth;

    @ForeignKey(saveForeignKeyModel = true)
    private Company mCompany;



    public String getMPhone() {
        return mPhone;
    }

    public void setMPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public long getMDataBirth() {
        return mDataBirth;
    }

    public void setMDataBirth(long mDataBirth) {
        this.mDataBirth = mDataBirth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public Company getMCompany() {
        return mCompany;
    }

    public void setMCompany(Company mCompany) {
        this.mCompany = mCompany;
    }

    @Override
    public String toString() {
        return id + " "
        + mName + " " +
        mCompany.toString() + " " +
        mPhone;
    }
}
