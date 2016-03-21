package org.feathersjs.feathersdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import org.feathersjs.client.FeathersService;

import com.smixxtape.feathersdemo.R;

import org.feathersjs.feathersdemo.models.Todo;

import java.util.ArrayList;
//import java.util.Iterator;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class MainActivity extends Activity {

    @Bind(R.id.my_recycler_view)
    RecyclerView mRecyclerView;

    @Bind(R.id.textbox)
    EditText mEditText;

    private RecyclerView.Adapter mAdapter;
    FeathersService<Todo> todoService;
    ArrayList<Todo> todos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        todos = new ArrayList<>();

        initializeAdapter();

        // Or pass in the URL as the last param for this service
        //Feathers.use("todos", TodoNew.class, Constants.URL_API_BASE);

//        FeathersService<Article> articleService = Feathers.service("posts");
//        articleService.find(new FeathersService.FeathersCallback<Result<Article>>() {
//            @Override
//            public void onSuccess(Result<Article> result) {
//                Log.d("Article:find:success", result.toString());
//            }
//
//            @Override
//            public void onError(String errorMessage) {
//                Log.d("Article:find:error", errorMessage);
//            }
//        });

//        todoService = Feathers.service("todos");
//        //todoService = new FeathersService<>(Constants.URL_API_BASE, "todos", TodoNew.class);
//
//        todoService.onCreated(new FeathersService.FeathersEventCallback<Todo>() {
//            @Override
//            public void onSuccess(final Todo todoNew) {
//                Log.d("onCreated", todoNew.id + "|" + todoNew.text);
//
//                runOnUiThread(new Runnable() {
//                    public void run() {
//                        todos.add(todoNew);
//                        mAdapter.notifyDataSetChanged();
//                    }
//                });
//            }
//        });
        //setupEvents();

//        fetchTodos();
    }

    /*
    private void setupEvents() {
        todoService.onCreated(new FeathersService.FeathersEventCallback<Todo>() {
            @Override
            public void onSuccess(final Todo todoNew) {
                Log.d("onCreated", todoNew.id + "|" + todoNew.text);

                runOnUiThread(new Runnable() {
                    public void run() {
                        getTodo(todoNew.id + "");
                        todos.add(todoNew);
                        mAdapter.notifyDataSetChanged();
                    }
                });
            }
        });

        todoService.onRemoved(new FeathersService.FeathersEventCallback<Todo>() {
            @Override
            public void onSuccess(final Todo todoNew) {
                Log.d("onRemoved", todoNew.id + "|" + todoNew.text);
                runOnUiThread(new Runnable() {
                    public void run() {
                        for (Todo todo : todos) {
                            if (todoNew.id == todo.id) {
                                todos.remove(todo);
                                mAdapter.notifyDataSetChanged();
                            }
                        }

                    }
                });
            }
        });

        todoService.onUpdated(new FeathersService.FeathersEventCallback<Todo>() {
            @Override
            public void onSuccess(final Todo todoNew) {
                Log.d("onUpdated", todoNew.id + "|" + todoNew.text);
                runOnUiThread(new Runnable() {
                    public void run() {
                        for (Todo todo : todos) {
                            if (todoNew.id == todo.id) {
                                todo.text = todoNew.text;
                                todo.complete = todoNew.complete;
                                mAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                });
            }
        });

        todoService.onPatched(new FeathersService.FeathersEventCallback<Todo>() {
            @Override
            public void onSuccess(final Todo todoNew) {
                Log.d("onPatched", todoNew.id + "|" + todoNew.text);
                runOnUiThread(new Runnable() {
                    public void run() {
                        for (Todo todo : todos) {
                            if (todoNew.id == todo.id) {
                                todo.text = todoNew.text;
                                todo.complete = todoNew.complete;
                                mAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                });
            }
        });
    }


    private void fetchTodos() {
//        todoService.find(new FeathersService.FeathersCallback<List<Todo>>() {
//            @Override
//            public void onSuccess(List<Todo> list) {
//                Log.d("onSuccess", list.size() + "");
//                todos.addAll(list);
//                runOnUiThread(new Runnable() {
//                    public void run() {
//                        mAdapter.notifyDataSetChanged();
//                    }
//                });
//            }
//
//            @Override
//            public void onError(String errorMessage) {
//                Log.d("onError", errorMessage);
//            }
//        });
    }


    private void getTodo(final String id) {
        todoService.get(id, new FeathersService.FeathersCallback<Todo>() {
            @Override
            public void onSuccess(Todo todo) {
                Log.d("getTodo:onSuccess", todo.toString());
                Log.d("getTodo:onSuccess", todo.id + "");
                Log.d("getTodo:onSuccess", todo.text + "");
//                deleteTodo(id);
            }

            @Override
            public void onError(String errorMessage) {
                Log.d("getTodo:onError", errorMessage);
            }
        });
    }

    private void deleteTodo(String id) {
        todoService.remove(id, new FeathersService.FeathersCallback<Todo>() {
            @Override
            public void onSuccess(Todo todo) {
                Log.d("getTodo:onSuccess", todo.toString());
                Log.d("getTodo:onSuccess", todo.id + "");
                Log.d("getTodo:onSuccess", todo.text + "");
            }

            @Override
            public void onError(String errorMessage) {
                Log.d("deleteTodo:onError", errorMessage);
            }
        });
    }
*/

    private void initializeAdapter() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

        mAdapter = new TodoAdapter(todos);

        //mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.sendButton)
    void addTodo() {
        //fetchTodos();
//        TodoNew todo = new TodoNew();
//        todo.text = mEditText.getText().toString();
//        todo.complete = false;
//        todoService.create(todo, new Feathers.FeathersCallback<TodoNew>() {
//            @Override
//            public void onSuccess(TodoNew todoNew) {
//
//            }
//
//            @Override
//            public void onError(String errorMessage) {
//
//            }
//        });
    }
}