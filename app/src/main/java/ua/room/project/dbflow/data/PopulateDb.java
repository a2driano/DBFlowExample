package ua.room.project.dbflow.data;

import ua.room.project.dbflow.model.Company;
import ua.room.project.dbflow.model.Worker;

/**
 * Created by design on 20.11.2017.
 */

public class PopulateDb {

    public void start(){
        Company company = new Company();
        company.setMCompanyName("VAZ");
        company.save();

        Worker worker = new Worker();
        worker.setMCompany(company);
        worker.setMName("Vasiliy");
        worker.setMPhone("0950005555");
        worker.save();

        company = new Company();
        company.setMCompanyName("BMW");
        company.save();

        worker = new Worker();
        worker.setMCompany(company);
        worker.setMName("Kolya");
        worker.setMPhone("0950005555");
        worker.save();

        worker = new Worker();
        worker.setMCompany(company);
        worker.setMName("Petr");
        worker.setMPhone("0950005555");
        worker.save();

    }
}
