package com.ad.productlist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView mTvName;
    private TextView mTvPrice;
    private ImageView mIvAdd;
    private ProductDao mProductDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProductDao = new ProductDao(this);
        mTvName = (TextView) findViewById(R.id.et_pro_name);
        mTvPrice = (TextView) findViewById(R.id.et_pro_price);
        mIvAdd = (ImageView) findViewById(R.id.iv_add);

        mIvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName = mTvName.getText().toString().trim();
                int productPrice = Integer.parseInt(mTvPrice.getText().toString().trim());
                Product product = new Product(productName, productPrice);
                mProductDao.insertProduct(product);

                Log.d("lsx", "写到数据库");
            }
        });

    }

}
