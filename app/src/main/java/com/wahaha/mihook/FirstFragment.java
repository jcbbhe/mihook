package com.wahaha.mihook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.wahaha.mihook.utils.MiUIInfo;
import com.wahaha.mihook.utils.RuntimeParam;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView miuiVersionTextView = view.findViewById(R.id.miui_version);
        TextView xposedStatusTextView = view.findViewById(R.id.xposed_status);
        if (MiUIInfo.isMiUI(getContext())) {
            miuiVersionTextView.setText(getString(R.string.miui_version, MiUIInfo.getMiUIVersion(getContext())));
        }
        if (RuntimeParam.XposedIsActive) {
            xposedStatusTextView.setText(getString(R.string.xposed_status, "已激活"));
        } else {
            xposedStatusTextView.setText(getString(R.string.xposed_status, "未激活"));
        }


        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}