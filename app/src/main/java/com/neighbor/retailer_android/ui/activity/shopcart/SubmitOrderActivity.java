package com.neighbor.retailer_android.ui.activity.shopcart;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.neighbor.retailer_android.R;

import java.util.zip.Inflater;

public class SubmitOrderActivity extends Activity implements View.OnClickListener{

    private ImageButton back;
    private TextView title;
    private ListView listView;
    private Button submit;
    private LayoutInflater mInflater;
    private View header;
    private View footer;
    private ImageButton addressImg;
    private TextView recName;
    private TextView recPhone;
    private TextView recAddress;
    private TextView wsName;
    private TextView totalPrice;
    private TextView orderCode;
    private TextView orderTime;
    private CheckBox online;
    private CheckBox outline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_order);

        back = (ImageButton)findViewById(R.id.wholesaler_back);
        title = (TextView)findViewById(R.id.wholesaler_title);
        title.setText("确认订单");
        listView = (ListView)findViewById(R.id.order_submit_lv);
        submit = (Button)findViewById(R.id.submit);
        mInflater = LayoutInflater.from(SubmitOrderActivity.this);
        header = mInflater.inflate(R.layout.submit_order_lv_header, null);
        footer = mInflater.inflate(R.layout.submit_order_lv_footer, null);
        listView.addHeaderView(header);
        listView.addFooterView(footer);
        addressImg = (ImageButton)header.findViewById(R.id.chance_address);
        recName = (TextView)header.findViewById(R.id.recive_name);
        recPhone = (TextView)header.findViewById(R.id.recive_phone);
        recAddress = (TextView)header.findViewById(R.id.recive_address);
        wsName = (TextView)header.findViewById(R.id.ws_name);
        totalPrice = (TextView)footer.findViewById(R.id.order_total_price);
        orderCode = (TextView)footer.findViewById(R.id.order_code);
        orderTime = (TextView)footer.findViewById(R.id.order_create_time);
        online = (CheckBox)footer.findViewById(R.id.online_pay);
        outline = (CheckBox)footer.findViewById(R.id.outline_pay);
        back.setOnClickListener(this);
        submit.setOnClickListener(this);
        addressImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.wholesaler_back:
                finish();
                break;
            case R.id.submit:
                //跳转至结算页面
                break;
            case R.id.chance_address:
                //更改地址
                break;
        }
    }
}
