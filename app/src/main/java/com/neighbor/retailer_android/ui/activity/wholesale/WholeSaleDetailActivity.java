package com.neighbor.retailer_android.ui.activity.wholesale;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neighbor.retailer_android.R;
import com.neighbor.retailer_android.ui.activity.kind.MerchandiseListActivity;

public class WholeSaleDetailActivity extends Activity implements View.OnClickListener{

    private TextView title;
    private ImageButton back;
    private ImageView wholeImg;
    private TextView wholeName;
    private TextView wholeId;
    private TextView wholeCode;
    private TextView wholeAddress;
    private TextView wholePhoneNum;
    private TextView wholeConnectName;
    private TextView wholeMail;
    private TextView wholeKind;
    private LinearLayout wholePhoneBtn;
    private LinearLayout parentLayout;
    private LinearLayout noNetwork;
    private Button shopDetailBtn;
    private Button applyMemberBtn;
    /**
     * 网络错误，重新加载按钮
     */
    private Button doLoddingBtn;
    private String titleName = "幸福便利店";
    private String phoneNum = "15650131931";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whole_sale_detail);

        titleName = getIntent().getStringExtra("NAME");
        initView();
        initListener();
        initValue();
    }

    private void initView(){
        title = (TextView)findViewById(R.id.wholesaler_title);
        back = (ImageButton)findViewById(R.id.wholesaler_back);
        wholeImg = (ImageView)findViewById(R.id.whole_detail_img);
        wholeName = (TextView)findViewById(R.id.whole_detail_name);
        wholeId = (TextView)findViewById(R.id.whole_detail_id);
        wholeCode = (TextView)findViewById(R.id.whole_detail_code);
        wholeAddress = (TextView)findViewById(R.id.whole_address);
        wholePhoneNum = (TextView)findViewById(R.id.whole_detail_connect_phone);
        wholeConnectName = (TextView)findViewById(R.id.whole_detail_connect_name);
        wholeMail = (TextView)findViewById(R.id.whole_detail_mail);
        wholeKind = (TextView)findViewById(R.id.whole_detail_kind);
        wholePhoneBtn = (LinearLayout)findViewById(R.id.whole_phone_btn);
        parentLayout = (LinearLayout)findViewById(R.id.parent_layout);
        noNetwork = (LinearLayout)findViewById(R.id.whole_detail_not_network);
        noNetwork.setVisibility(View.GONE);
        shopDetailBtn = (Button)findViewById(R.id.shop_detail_btn);
        applyMemberBtn = (Button)findViewById(R.id.apply_member_btn);
    }

    private void initListener(){
        back.setOnClickListener(this);
        wholePhoneBtn.setOnClickListener(this);
        shopDetailBtn.setOnClickListener(this);
        applyMemberBtn.setOnClickListener(this);
    }

    private void initValue(){
        title.setText(titleName);
        //设置批发商信息
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.wholesaler_back:
                WholeSaleDetailActivity.this.finish();
                break;
            case R.id.whole_phone_btn:
                //拨打电话
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNum));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                WholeSaleDetailActivity.this.startActivity(intent);
                break;
            case R.id.shop_detail_btn:
                //跳转至商品列表页面
                Intent intent1 = new Intent(WholeSaleDetailActivity.this, MerchandiseListActivity.class);
                intent1.putExtra("KEY",titleName);
                WholeSaleDetailActivity.this.startActivity(intent1);
                WholeSaleDetailActivity.this.finish();
                break;
            case R.id.apply_member_btn:
                //跳转至申请会员页面
                break;
        }
    }
}
