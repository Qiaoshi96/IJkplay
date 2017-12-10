package test.bawei.com.ijkplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import static test.bawei.com.ijkplay.R.id.searchView;


public class MainActivity extends AppCompatActivity {
    private String[] mStrs = {"aaa", "bbb", "ccc", "airsaid"};
    private SearchView mSearch;
    private ListView mListView;
//    private EditText textView = (EditText) mSearchView
//            .findViewById(
//                    android.support.v7.appcompat.R.id.search_src_text
//            );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearch = (SearchView) findViewById(searchView);
        mListView = (ListView) findViewById(R.id.listView);


        if(mSearch==null){
            return;
        }else{
//获取到TextView的ID
            int id = mSearch.getContext().getResources().getIdentifier("android:id/search_src_text",null,null);
            int ids = mSearch.getContext().getResources().getIdentifier("android:id/search_mag_icon",null,null);
//            获取图标

//            ImageView search_mag_icon= mSearch.findViewById(R.id.search_mag_icon);
//            search_mag_icon.setImageResource(R.mipmap.ic_launcher_round);
            ImageView imageView=(ImageView) findViewById(ids);
            imageView.setImageResource(R.mipmap.ic_launcher_round);
//获取到TextView的控件
            TextView textView = (TextView) mSearch.findViewById(id);
//设置字体大小为14sp
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);//14sp
//设置字体颜色
            textView.setTextColor(getResources().getColor(R.color.text_ccc));
//设置提示文字颜色
            textView.setHintTextColor(getResources().getColor(R.color.text_ccc));

            android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.bottomMargin = -7;
            textView.setLayoutParams(layoutParams);


        }

        mSearch.setQueryHint(getString(R.string.serach_hint));
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrs));
        mListView.setTextFilterEnabled(true);
        // 设置搜索文本监听
        mSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
                    mListView.setFilterText(newText);
                }else{
                    mListView.clearTextFilter();
                }
                return false;
            }
        });
    }
}
