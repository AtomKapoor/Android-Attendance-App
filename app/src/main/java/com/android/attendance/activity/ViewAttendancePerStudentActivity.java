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

import com.android.attendance.bean.AttendanceBean;
import com.android.attendance.bean.FacultyBean;
import com.android.attendance.bean.StudentBean;
import com.android.attendance.context.ApplicationContext;
import com.android.attendance.db.DBAdapter;
import com.example.androidattendancesystem.R;

public class ViewAttendancePerStudentActivity extends Activity {

	ArrayList<AttendanceBean> attendanceBeanList;
	private ListView listView ;  
	private ArrayAdapter<String> listAdapter;

	DBAdapter dbAdapter = new DBAdapter(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.__listview_main);

		listView=(ListView)findViewById(R.id.listview);
		final ArrayList<String> attendanceList = new ArrayList<String>();
		attendanceList.add("Attendence");
		attendanceBeanList=((ApplicationContext)ViewAttendancePerStudentActivity.this.getApplicationContext()).getAttendanceBeanList();

		for(AttendanceBean attendanceBean : attendanceBeanList)
		{
			String users = "";
			
				DBAdapter dbAdapter = new DBAdapter(ViewAttendancePerStudentActivity.this);
				StudentBean studentBean =dbAdapter.getStudentById(attendanceBean.getAttendance_student_id());
				users = attendanceBean.getAttendance_student_id()+". "+studentBean.getStudent_firstname()+" "+studentBean.getStudent_lastname()+"  "+attendanceBean.getAttendance_session_id();
				attendanceList.add(users);
		}

		listAdapter = new ArrayAdapter<String>(this, R.layout.view_attendance_list_per_student, R.id.labelAttendancePerStudent, attendanceList);
		listView.setAdapter( listAdapter ); 

		/*listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					final int position, long arg3) {



				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ViewAttendanceByFacultyActivity.this);

				alertDialogBuilder.setTitle(getTitle()+"decision");
				alertDialogBuilder.setMessage("Are you sure?");

				alertDialogBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {

						facultyList.remove(position);
						listAdapter.notifyDataSetChanged();
						listAdapter.notifyDataSetInvalidated();   

						dbAdapter.deleteFaculty(facultyBeanList.get(position).getFaculty_id());
						facultyBeanList=dbAdapter.getAllFaculty();

						for(FacultyBean facultyBean : facultyBeanList)
						{
							String users = " FirstName: " + facultyBean.getFaculty_firstname()+"\nLastname:"+facultyBean.getFaculty_lastname();
							facultyList.add(users);
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
*/



	}





}
