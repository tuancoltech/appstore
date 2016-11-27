package org.literacyapp.appstore.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import java.util.Set;
import org.literacyapp.appstore.dao.converter.ApplicationStatusConverter;
import org.literacyapp.appstore.dao.converter.LocaleConverter;
import org.literacyapp.appstore.dao.converter.StringSetConverter;
import org.literacyapp.model.enums.Locale;
import org.literacyapp.model.enums.admin.ApplicationStatus;

import org.literacyapp.appstore.model.Application;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "APPLICATION".
*/
public class ApplicationDao extends AbstractDao<Application, Long> {

    public static final String TABLENAME = "APPLICATION";

    /**
     * Properties of entity Application.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Locale = new Property(1, String.class, "locale", false, "LOCALE");
        public final static Property PackageName = new Property(2, String.class, "packageName", false, "PACKAGE_NAME");
        public final static Property LiteracySkills = new Property(3, String.class, "literacySkills", false, "LITERACY_SKILLS");
        public final static Property NumeracySkills = new Property(4, String.class, "numeracySkills", false, "NUMERACY_SKILLS");
        public final static Property ApplicationStatus = new Property(5, String.class, "applicationStatus", false, "APPLICATION_STATUS");
    }

    private final LocaleConverter localeConverter = new LocaleConverter();
    private final StringSetConverter literacySkillsConverter = new StringSetConverter();
    private final StringSetConverter numeracySkillsConverter = new StringSetConverter();
    private final ApplicationStatusConverter applicationStatusConverter = new ApplicationStatusConverter();

    public ApplicationDao(DaoConfig config) {
        super(config);
    }
    
    public ApplicationDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"APPLICATION\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"LOCALE\" TEXT NOT NULL ," + // 1: locale
                "\"PACKAGE_NAME\" TEXT NOT NULL ," + // 2: packageName
                "\"LITERACY_SKILLS\" TEXT," + // 3: literacySkills
                "\"NUMERACY_SKILLS\" TEXT," + // 4: numeracySkills
                "\"APPLICATION_STATUS\" TEXT NOT NULL );"); // 5: applicationStatus
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"APPLICATION\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Application entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, localeConverter.convertToDatabaseValue(entity.getLocale()));
        stmt.bindString(3, entity.getPackageName());
 
        Set literacySkills = entity.getLiteracySkills();
        if (literacySkills != null) {
            stmt.bindString(4, literacySkillsConverter.convertToDatabaseValue(literacySkills));
        }
 
        Set numeracySkills = entity.getNumeracySkills();
        if (numeracySkills != null) {
            stmt.bindString(5, numeracySkillsConverter.convertToDatabaseValue(numeracySkills));
        }
        stmt.bindString(6, applicationStatusConverter.convertToDatabaseValue(entity.getApplicationStatus()));
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Application entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, localeConverter.convertToDatabaseValue(entity.getLocale()));
        stmt.bindString(3, entity.getPackageName());
 
        Set literacySkills = entity.getLiteracySkills();
        if (literacySkills != null) {
            stmt.bindString(4, literacySkillsConverter.convertToDatabaseValue(literacySkills));
        }
 
        Set numeracySkills = entity.getNumeracySkills();
        if (numeracySkills != null) {
            stmt.bindString(5, numeracySkillsConverter.convertToDatabaseValue(numeracySkills));
        }
        stmt.bindString(6, applicationStatusConverter.convertToDatabaseValue(entity.getApplicationStatus()));
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Application readEntity(Cursor cursor, int offset) {
        Application entity = new Application( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            localeConverter.convertToEntityProperty(cursor.getString(offset + 1)), // locale
            cursor.getString(offset + 2), // packageName
            cursor.isNull(offset + 3) ? null : literacySkillsConverter.convertToEntityProperty(cursor.getString(offset + 3)), // literacySkills
            cursor.isNull(offset + 4) ? null : numeracySkillsConverter.convertToEntityProperty(cursor.getString(offset + 4)), // numeracySkills
            applicationStatusConverter.convertToEntityProperty(cursor.getString(offset + 5)) // applicationStatus
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Application entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setLocale(localeConverter.convertToEntityProperty(cursor.getString(offset + 1)));
        entity.setPackageName(cursor.getString(offset + 2));
        entity.setLiteracySkills(cursor.isNull(offset + 3) ? null : literacySkillsConverter.convertToEntityProperty(cursor.getString(offset + 3)));
        entity.setNumeracySkills(cursor.isNull(offset + 4) ? null : numeracySkillsConverter.convertToEntityProperty(cursor.getString(offset + 4)));
        entity.setApplicationStatus(applicationStatusConverter.convertToEntityProperty(cursor.getString(offset + 5)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Application entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Application entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Application entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
