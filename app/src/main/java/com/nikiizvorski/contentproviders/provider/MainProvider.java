package com.nikiizvorski.contentproviders.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.nikiizvorski.contentproviders.helper.DatabaseHelper;

/**
 * Created by nikiizvorski on 08/02/2017.
 */
public class MainProvider extends ContentProvider {
    public static final Uri CONTENT_URI = Uri.parse("content://com.nikiizvorski.contentproviders.provider/" + DatabaseHelper.TABLE_MSG);
    private Context context;
    private SQLiteDatabase database;

    @Override
    public boolean onCreate() {
        context = getContext();
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
        return database != null;
    }

    /**
     * here first you do is to rename your params so you know what you are doing
     * after this you create a query builder
     * after that set the table
     * and return the standart query
     * nothing special
     */

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, String[] columns, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(DatabaseHelper.TABLE_MSG);
        return builder.query(database, columns, selection, selectionArgs, null, null, sortOrder);
    }

    /*
     * show what type of data you have to others
     * if you have html here is what you do "text/html"
     * if it is an image "image/png"
     * you don't have to return anything but if you are more specific
     * you see how it is done
    */
    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        // TODO use F1 to check easy peasy and track the getType method of ContentProvider if need
        return null;
    }

    /*
     * Press F1 on each method to see what you have to return
     * Do your checks and return the data and the URI that you created
     * basicly newly created res with the provider URI
     * Scheme - Package+Provider - TABLE, ROW etc.
     * good practise to return notifyChanges()
    */
    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        long rowId = database.insert(DatabaseHelper.TABLE_MSG, null, values);
        if (rowId > -1){
           Uri newUri = ContentUris.withAppendedId(CONTENT_URI, rowId);
            context.getContentResolver().notifyChange(newUri, null);
            return newUri;
        }
        throw new SQLiteException("Insert Failed for URI: " + uri);
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        // TODO use F1 to check easy peasy and track the delete method of ContentProvider
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        // TODO use F1 to check easy peasy and track the update method of ContentProvider
        return 0;
    }
}
