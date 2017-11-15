package ua.room.project.dbflow.data;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by kunde on 15.11.2017.
 */
@Database(name = AppDataBase.NAME, version = AppDataBase.VERSION)
public class AppDataBase {

    public static final String NAME = "AppDataBase";

    public static final int VERSION = 1;
}
