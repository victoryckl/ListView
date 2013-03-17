package com.example.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SimpleAdapterActivity extends Activity {
	private ListView mList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_adapter);

		mList = (ListView) findViewById(R.id.simplelist);

		SimpleAdapter adapter = new SimpleAdapter(this, getData(),
				R.layout.simple_item, new String[] { "text" },
				new int[] { R.id.text });
		mList.setAdapter(adapter);
	}

	private int mCount = 100;

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < mCount; i++) {
			list.add(getOneItem("item " + i));
		}
		return list;
	}

	private Map<String, Object> getOneItem(String text) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("text", text);
		return map;
	}
}
