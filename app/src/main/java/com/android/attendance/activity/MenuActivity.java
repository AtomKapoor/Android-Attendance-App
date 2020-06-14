package com.android.attendance.activity;

import java.util.ArrayList;

import com.android.attendance.bean.AttendanceBean;
import com.android.attendance.context.ApplicationContext;
import com.android.attendance.db.DBAdapter;
import com.example.androidattendancesystem.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity {

	Button addStudent;
	Button addFaculty;
	Button viewStudent;
	Button viewFaculty;
	Button logout;
	Button attendancePerStudent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		addStudent =(Button)findViewById(R.id.buttonaddstudent);
		addFaculty =(Button)findViewById(R.id.buttonaddfaculty);
		viewStudent =(Button)findViewById(R.id.buttonViewstudent);
		viewFaculty =(Button)findViewById(R.id.buttonviewfaculty);
		logout =(Button)findViewById(R.id.buttonlogout);
		
		addStudent.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent =new Intent(MenuActivity.this,AddStudentActivity.class);
				startActivity(intent);
			}
		});
		
		addFaculty.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent =new Intent(MenuActivity.this,AddFacultyActivity.class);
				startActivity(intent);
			}
		});
		
		viewFaculty.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent =new Intent(MenuActivity.this,ViewFacultyActivity.class);
				startActivity(intent);
			}
		});


		viewStudent.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent =new Intent(MenuActivity.this,ViewStudentActivity.class);
				startActivity(intent);
			}
		});
		logout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent =new Intent(MenuActivity.this,LoginActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		attendancePerStudent=(Button)findViewById(R.id.attendancePerStudentButton);
		attendancePerStudent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				DBAdapter dbAdapter = new DBAdapter(MenuActivity.this);
				ArrayList<AttendanceBean> attendanceBeanList=dbAdapter.getAllAttendanceByStudent();
				((ApplicationContext)MenuActivity.this.getApplicationContext()).setAttendanceBeanList(attendanceBeanList);
				
				Intent intent = new Intent(MenuActivity.this,ViewAttendancePerStudentActivity.class);
				startActivity(intent);
				
			}
		});
		

	}


}
