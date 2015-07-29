package com.ad.productlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/29.
 */
public class ProductDao {
    private MyDBHelper dbHelper;

    public ProductDao(Context context) {
        dbHelper = new MyDBHelper(context, "store.db", 1);
    }

    public List<Product> queryAll() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.query("product", null, null, null, null, null, null);
        List<Product> productsList = new ArrayList<Product>();

        while (c.moveToNext()) {
            long id = c.getLong((c.getColumnIndex("_id")));
            String name = c.getString(c.getColumnIndex("name"));
            int price = c.getInt(c.getColumnIndex("price"));
            productsList.add(new Product(id, name, price));
        }

        db.close();
        return productsList;
    }

    public void insertProduct(Product product) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", product.getName());
        cv.put("price", product.getPrice());
        db.insert("product", null, cv);
        db.close();
    }
}
