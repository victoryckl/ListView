package com.example.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleAdapterActivity extends Activity {
	private ListView mList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_adapter);

		mList = (ListView) findViewById(R.id.simplelist);

		List<Map<String, Object>> listdata = getData();
		setListAdapter(listdata);
		
		setListEmptyView();
		
		findViewById(R.id.add_item).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				List<Map<String, Object>> listdata = (List<Map<String, Object>>)mList.getTag();
				int count = listdata.size();
				listdata.add(getOneItem("item " + count));
				setListAdapter(listdata);
			}
		});
		
		findViewById(R.id.delete_item).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				List<Map<String, Object>> listdata = (List<Map<String, Object>>)mList.getTag();
				int count = listdata.size();
				if (count > 0) {
					listdata.remove(count - 1);
					setListAdapter(listdata);
				} else {
					Toast.makeText(getBaseContext(), "no item!", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	
	private void setListAdapter(List<Map<String, Object>> listdata) {
		SimpleAdapter adapter = new SimpleAdapter(
				getBaseContext(), 
				listdata,
				R.layout.simple_item, 
				new String[] { "text" },
				new int[] { R.id.text });
		mList.setAdapter(adapter);
		mList.setTag(listdata);
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 10; i++) {
			list.add(getOneItem("item " + i));
		}
		return list;
	}

	private Map<String, Object> getOneItem(String text) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("text", text);
		return map;
	}
	
	//------------------------------
	private void setListEmptyView() {
		/*
		TextView emptyView = new TextView(getBaseContext());
		emptyView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		emptyView.setText("This appears when the list is empty");
		emptyView.setVisibility(View.GONE);
		((ViewGroup)mList.getParent()).addView(emptyView);
		mList.setEmptyView(emptyView);
		*/
		View emptyView = findViewById(R.id.empty);
		mList.setEmptyView(emptyView);
	}
}
