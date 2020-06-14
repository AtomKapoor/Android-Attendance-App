package com.android.attendance.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.attendance.bean.FacultyBean;
import com.android.attendance.bean.StudentBean;
import com.android.attendance.db.DBAdapter;
import com.example.androidattendancesystem.R;

public class ViewStudentByBranchYear extends Activity {

	ArrayList<StudentBean> studentBeanList;
	private ListView listView ;  
	private ArrayAdapter<String> listAdapter;
	String branch;
	String year;
	

	DBAdapter dbAdapter = new DBAdapter(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.__listview_main);

		listView=(ListView)findViewById(R.id.listview);
		final ArrayList<String> studentList = new ArrayList<String>();
		
		 branch=getIntent().getExtras().getString("branch");
		 year =getIntent().getExtras().getString("year");

		studentBeanList=dbAdapter.getAllStudentByBranchYear(branch, year);

		for(StudentBean studentBean : studentBeanList)
		{
			String users = studentBean.getStudent_firstname()+","+studentBean.getStudent_lastname();
					
			studentList.add(users);
			Log.d("users: ", users); 

		}

		listAdapter = new ArrayAdapter<String>(this, R.layout.view_student_list, R.id.label, studentList);
		listView.setAdapter( listAdapter ); 

		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					final int position, long arg3) {



				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ViewStudentByBranchYear.this);

				alertDialogBuilder.setTitle(getTitle()+"decision");
				alertDialogBuilder.setMessage("Are you sure?");

				alertDialogBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {

						studentList.remove(position);
						listAdapter.notifyDataSetChanged();
						listAdapter.notifyDataSetInvalidated();   

						dbAdapter.deleteStudent(studentBeanList.get(position).getStudent_id());
						studentBeanList=dbAdapter.getAllStudentByBranchYear(branch, year);

						for(StudentBean studentBean : studentBeanList)
						{
							String users = " FirstName: " + studentBean.getStudent_firstname()+"\nLastname:"+studentBean.getStudent_lastname();
							studentList.add(users);
							Log.d("users: ", users);

						}
					}

				});

				alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// cancel the alert box and put a Toast to the user
						dialog.cancel();
						Toast.makeText(getApplicationContext(), "You choose cancel", 
								Toast.LENGTH_LONG).show();
					}
				});

				AlertDialog alertDialog = alertDialogBuilder.create();
				// show alert
				alertDialog.show();





				return false;
			}
		});




	}





}
