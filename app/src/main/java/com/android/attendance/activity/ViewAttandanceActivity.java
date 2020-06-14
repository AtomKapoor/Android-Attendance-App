package com.android.attendance.activity;

import com.example.androidattendancesystem.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class ViewAttandanceActivity extends Activity {

	Spinner spinnerbranch,spinneryear;
	String userrole,branch,year;
	private String[] branchString = new String[] { "cse"};
	private String[] yearString = new String[] {"SE","TE","BE"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewstudent);
		
		spinnerbranch=(Spinner)findViewById(R.id.spinnerbranchView);
		spinneryear=(Spinner)findViewById(R.id.spinneryearView);
		
		
		spinnerbranch.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View view,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
				branch =(String) spinnerbranch.getSelectedItem();

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});

		ArrayAdapter<String> adapter_branch = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, branchString);
		adapter_branch
		.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerbranch.setAdapter(adapter_branch);

		///......................spinner2

		spinneryear.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View view,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
				year =(String) spinneryear.getSelectedItem();

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});

		ArrayAdapter<String> adapter_year = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, yearString);
		adapter_year
		.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinneryear.setAdapter(adapter_year);

		

	}

}
