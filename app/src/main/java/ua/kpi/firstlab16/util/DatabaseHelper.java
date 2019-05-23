package ua.kpi.firstlab16.util;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.List;

import ua.kpi.firstlab16.domain.Way;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DB_NAME = "lab.db";
    private static final int DB_VERSION = 1;
    private Dao<Way, Integer> wayDao;
    public DatabaseHelper(Context context) {
        super(context, DB_NAME,  null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Way.class);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Way.class, true);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        onCreate(database, connectionSource);
    }

    public Dao<Way, Integer> wayDao() throws SQLException, java.sql.SQLException {
        if (wayDao == null) {
            wayDao = getDao(Way.class);
        }
        return wayDao;
    }

    public void addWay(Way way) throws java.sql.SQLException {
        wayDao();
        wayDao.create(way);
    }

    public List<Way> findAll() throws java.sql.SQLException {
        wayDao();
        return wayDao.queryForAll();
    }
}
