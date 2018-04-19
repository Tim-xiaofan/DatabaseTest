package com.example.zhong.databasetest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by DELL on 2018/4/18.
 */

public class MyProvider extends ContentProvider{

    public static final int TABLE1_DIR = 0;

    public static final int TABLE1_ITEM= 1;

    public static final int TABLE2_DIR = 2;

    public static final int TABLE2_ITEM = 3;

    public static UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example.zhong.provider","tablet1",TABLE1_DIR);
        uriMatcher.addURI("com.example.zhong.provider","tablet1/#",TABLE1_ITEM);
        uriMatcher.addURI("com.example.zhong.provider","tablet2",TABLE2_DIR);
        uriMatcher.addURI("com.example.zhong.provider","tablet2/#",TABLE2_ITEM);
    }

    @Override
    public boolean onCreate() {
        return false;
    }
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        switch(uriMatcher.match(uri)){
            case TABLE1_DIR:
                //All data in tablet1
                break;
            case TABLE1_ITEM:
                //One data in tablet1
                break;
            case TABLE2_DIR:
                //All data in tablet2
                break;
            case TABLE2_ITEM:
                //One data in tablet2
                break;
            default:
                break;
        }
        return null;
    }

    @Override
    public String getType(Uri uri) {
        switch(uriMatcher.match(uri)){
            case TABLE1_DIR:
                return "vnd.android.cursor.dir/vnd.come.example.zhong.app.provider.tablet1";
            case TABLE1_ITEM:
                return "vnd.android.cursor.item/vnd.come.example.zhong.app.provider.tablet1";
            case TABLE2_DIR:
                return "vnd.android.cursor.dir/vnd.come.example.zhong.app.provider.tablet2";
            case TABLE2_ITEM:
                return "vnd.android.cursor.item/vnd.come.example.zhong.app.provider.tablet2";
            default:
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[]
            selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return 0;
    }
}
