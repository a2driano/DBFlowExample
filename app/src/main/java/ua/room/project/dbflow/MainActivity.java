package ua.room.project.dbflow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import ua.room.project.dbflow.data.PopulateDb;
import ua.room.project.dbflow.model.Company;
import ua.room.project.dbflow.model.Worker;
import ua.room.project.dbflow.model.Worker_Table;

import static ua.room.project.dbflow.provider.MyContentProvider.DATA_BASE_NAME;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (SQLite.select().from(Company.class).queryList().size() == 0) {
            new PopulateDb().start();
        }
        List<Company> allCompaniesList = SQLite.select().from(Company.class).queryList();
        List<Worker> allWorkersList = SQLite.select().from(Worker.class).queryList();

        List<Worker> workersListBmw = SQLite.select().from(Worker.class).where(Worker_Table.mCompany_id.eq(2L)).queryList();


        Log.d("tag", "total companies count:: " + allCompaniesList.size());
        Log.d("tag", " total workers count: " + allWorkersList.size());
        for (Worker worker : allWorkersList) {
            Log.d("tag", "all workers " + worker.toString());
        }
        for (Worker worker : workersListBmw) {
            Log.d("tag", "workers from bmw " + worker.toString());
        }

    }
}
