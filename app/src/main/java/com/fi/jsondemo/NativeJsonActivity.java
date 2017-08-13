package com.fi.jsondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fi.jsondemo.bean.DataInfo;
import com.fi.jsondemo.bean.FilmInfo;
import com.fi.jsondemo.bean.ShopInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NativeJsonActivity extends AppCompatActivity implements View.OnClickListener {
    //声明控件对象
    private Button   btn1;
    private Button   btn2;
    private Button   btn3;
    private Button   btn4;
    private TextView tv_before;
    private TextView tv_after;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_json);

        initView();
        initListener();

    }

    //初始化button的点击事件
    private void initListener() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    //初始化控件
    private void initView() {
        title = (TextView) findViewById(R.id.tv_title);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        tv_before = (TextView) findViewById(R.id.tv_befordata);
        tv_after = (TextView) findViewById(R.id.tv_afterdata);

        title.setText("手动Json解析");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //将json对象转换为Java对象
            case R.id.btn1:
                //                Toast.makeText(this,"btn1",Toast.LENGTH_SHORT).show();
                jsonToJavaObjectByNative();
                break;
            //将json数组转换为Java集合
            case R.id.btn2:
                //                Toast.makeText(this,"btn2",Toast.LENGTH_SHORT).show();
                jsonToJavaArrayByNative();
                break;
            //复杂json数据解析
            case R.id.btn3:
                //                Toast.makeText(this, "btn3", Toast.LENGTH_SHORT).show();
                jsonToJavaOfComplex();
                break;
            //特殊json数据解析
            case R.id.btn4:
                //                Toast.makeText(this, "btn4", Toast.LENGTH_SHORT).show();
                jsonToJavaOfSpecial();
                break;
        }
    }

    private void jsonToJavaOfSpecial() {
        //创建或获取json数据
        String json = Constant.JSON4;
        //解析json数据
        FilmInfo filmInfo = new FilmInfo();//创建封装的java对象
        //第一层解析
        try {
            JSONObject jsonObject = new JSONObject(json);
            int code = jsonObject.optInt("code");
            JSONObject list = jsonObject.optJSONObject("list");

            //第一层封装
            filmInfo.setCode(code);
            List<FilmInfo.FilmBean> lists = new ArrayList<>();
            filmInfo.setList(lists);

            //第二层解析
            for (int i = 0; i < list.length(); i++) {
                JSONObject jsonObject1 = list.optJSONObject(i + "");
                if (jsonObject1 != null) {
                    String aid = jsonObject1.optString("aid");
                    String author = jsonObject1.optString("author");
                    int coins = jsonObject1.optInt("coins");
                    String copyright = jsonObject1.optString("copyright");
                    String create = jsonObject1.optString("create");

                    //第二层数据封装
                    FilmInfo.FilmBean filmBean = new FilmInfo.FilmBean();
                    filmBean.setAid(aid);
                    filmBean.setAuthor(author);
                    filmBean.setCoins(coins);
                    filmBean.setCopyright(copyright);
                    filmBean.setCreate(create);

                    lists.add(filmBean);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //显示json数据
        tv_before.setText(json);
        tv_after.setText(filmInfo.toString());
    }

    private void jsonToJavaOfComplex() {
        //创建或获取json数据
        String json = Constant.JSON3;
        //封装java对象
        DataInfo dataInfo = new DataInfo();
        //解析json数据
        //把解析的json数据封装到javabean中...
        try {
            //第一层解析
            JSONObject jsonObject = new JSONObject(json);
            JSONObject data = jsonObject.getJSONObject("data");
            String rs_code = jsonObject.optString("rs_code");
            String rs_msg = jsonObject.optString("rs_msg");

            //第一层封装
            DataInfo.DataEntity dataEntity = new DataInfo.DataEntity();
            dataInfo.setData(dataEntity);
            dataInfo.setRs_code(rs_code);
            dataInfo.setRs_msg(rs_msg);

            //第二层解析
            int count = data.optInt("count");
            JSONArray jsonArray = data.optJSONArray("items");
            //第二层封装
            dataEntity.setCount(count);

            List<DataInfo.DataEntity.ItemsEntity> itemBean = new ArrayList<>();
            dataEntity.setItems(itemBean);

            //第三层解析
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                if (jsonObject1 != null) {
                    int id = jsonObject1.optInt("id");
                    String title = jsonObject1.optString("title");

                    //第三层数据的封装
                    DataInfo.DataEntity.ItemsEntity bean = new DataInfo.DataEntity.ItemsEntity();
                    bean.setId(id);
                    bean.setTitle(title);

                    itemBean.add(bean);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        //显示
        tv_before.setText(json);
        tv_after.setText(dataInfo.toString());
    }

    //将json数组转换为Java集合
    private void jsonToJavaArrayByNative() {
        //创建或获取json数据
        String json = Constant.JSON2;

        ShopInfo shopInfo = null;
        //解析json数据
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject != null) {
                    int id = jsonObject.getInt("id");
                    String name = jsonObject.optString("name");
                    String imagePath = jsonObject.optString("imagePath");
                    double price = jsonObject.optDouble("price");
                    //把json数据封装到javabean中
                    shopInfo = new ShopInfo(id, imagePath, name, price);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //显示数据
        tv_before.setText(json);
        tv_after.setText(shopInfo.toString());
    }

    //将json对象转换为Java对象
    private void jsonToJavaObjectByNative() {
        //创建或者获取json数据
        String json = Constant.JSON1;
        Log.e("NativeJsonActivity", "json==" + json);
        //解析json数据
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int id = jsonObject.optInt("id");
        String imagePath = jsonObject.optString("imagePath");
        String name = jsonObject.optString("name");
        double price = jsonObject.optDouble("price");

        //将解析后的json数据封装到ShopInfo这个javaBean中
        ShopInfo shopInfo = new ShopInfo(id, imagePath, name, price);

        //显示
        tv_before.setText(json);
        tv_after.setText(shopInfo.toString());
    }
}
