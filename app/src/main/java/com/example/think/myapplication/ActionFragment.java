package com.example.think.myapplication;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ActionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ActionFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private EditText name;
    public ActionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_action,container,false);
        name=(EditText)view.findViewById(R.id.inputname);
        Button add=(Button)view.findViewById(R.id.add);
        Button open=(Button)view.findViewById(R.id.open);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              onButtonPressed();
            }
        });
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
onButton2Pressed();
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {
            if(!name.getText().toString().equals(""))
            mListener.onFragmentInteraction(name.getText().toString());
        }
    }
    public void onButton2Pressed() {
        if (mListener != null) {
                mListener.openActivity();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String name);
        public void openActivity();
    }

}
