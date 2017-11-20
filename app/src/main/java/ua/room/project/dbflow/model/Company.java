package ua.room.project.dbflow.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

import ua.room.project.dbflow.data.AppDataBase;

/**
 * Created by kunde on 15.11.2017.
 */
@Table(database = AppDataBase.class)
public class Company extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column
    private long id;

    @Column
    private String mCompanyName;

    private List<Worker> mWorkerList;


//    @OneToMany(methods = OneToMany.Method.ALL, variableName = "mWorkerList")
//    public List<Worker> getMWorkerList() {
//        if (mWorkerList == null) {
//            mWorkerList = SQLite.select()
//                    .from(Worker.class)
//                    .where(Worker_Table.mCompany_id.eq(id))
//                    .queryList();
//        }
//        return mWorkerList;
//    }
//
//    @Override
//    public boolean save() {
//        boolean res = super.save();
//        if (mWorkerList != null) {
//            for (Worker s : mWorkerList) {
//                s.setMCompany(this);
//                s.save();
//            }
//        }
//        return res;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMCompanyName() {
        return mCompanyName;
    }

    public void setMCompanyName(String mCompanyName) {
        this.mCompanyName = mCompanyName;
    }

    public List<Worker> getmWorkerList() {
        return mWorkerList;
    }

    public void setMWorkerList(List<Worker> mWorkerList) {
        this.mWorkerList = mWorkerList;
    }

    @Override
    public String toString() {
        return mCompanyName;
    }
}
