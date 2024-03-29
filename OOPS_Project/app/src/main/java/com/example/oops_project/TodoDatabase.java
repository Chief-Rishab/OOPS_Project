package com.example.oops_project;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Database(entities = {Todo.class}, version = 3)
public abstract class TodoDatabase extends RoomDatabase {

    private static TodoDatabase instance3;

    public abstract TodoDoa todoDoa();

    public static synchronized TodoDatabase getInstance(Context context) {
        if (instance3 == null) {
            instance3 = Room.databaseBuilder(context.getApplicationContext()
                    , TodoDatabase.class, "todo_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance3;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance3).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private com.example.oops_project.TodoDoa TodoDoa;

        private PopulateDbAsyncTask(TodoDatabase db) {
            TodoDoa = db.todoDoa();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            //Calendar calendar = Calendar.getInstance();
            //String currentDate  = DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar.getTime());

//            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
//            String result = currentDate+", "+sdf.format(Calendar.getInstance().getTime());
//            System.out.println(result);

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
            String date = dateFormat.format(calendar.getTime());
            String ntime = timeFormat.format(calendar.getTime());
            String time = ntime.replace("am", "AM").replace("pm", "PM");
            TodoDoa.insert(new Todo("Title 1", "Description 1", "High", 3, date, time));
            TodoDoa.insert(new Todo("Title 2", "Description 2", "Medium", 2, date, time));
            TodoDoa.insert(new Todo("Title 3", "Description 3", "Low", 1, date, time));
            return null;
        }
    }

}