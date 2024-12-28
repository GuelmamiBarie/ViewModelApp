package vistula.glmbr.viewmodelapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import vistula.glmbr.viewmodelapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    myviewmodel viewModel;
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);


        viewModel = new ViewModelProvider(this)
                .get(myviewmodel.class);

        // Link the Databinding with ViewModel
        mainBinding.setMyviewmodel(viewModel);

        // Observing the LiveData
        viewModel.getCounter().observe(this,
                new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer counter) {
                        // Update the UI when the LiveData Changes
                        mainBinding.textView2.setText(""+counter);
                    }
                });


    }
}