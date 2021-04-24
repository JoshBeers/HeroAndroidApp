package com.devslopes.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.devslopes.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerFragment.PickPowerInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Button[] buttons=new Button[6];
    int[] buttonDrawables=new int[6];

    Button submitButton;


    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Button b=(Button)v;

            boolean toggle=false;
            if(b.getAlpha()==.999f)
                toggle=true;

            clearButtons();



            int leftDrawable=0;

            for(int i=0;i<6;i++){
                if(b.equals(buttons[i])){
                    leftDrawable=buttonDrawables[i];
                }
            }

            if(toggle){
                b.setAlpha(1f);
            }else {
                b.setAlpha(.999f);
                b.setCompoundDrawablesWithIntrinsicBounds(leftDrawable, 0, R.drawable.itemselected, 0);
            }

            boolean usableSubmit=false;
            for(int i=0;i<6;i++){
                if (buttons[i].getAlpha()==.999f)
                    usableSubmit=true;
            }

            if(usableSubmit)
                submitButton.setAlpha(1f);
            else
                submitButton.setAlpha(.5f);

            submitButton.setEnabled(usableSubmit);


        }
    };

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private PickPowerInteractionListener mListener;

    public PickPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickPowerFragment newInstance(String param1, String param2) {
        PickPowerFragment fragment = new PickPowerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        buttonDrawables[0]=R.drawable.turtlepower;
        buttonDrawables[1]=R.drawable.thorshammer;
        buttonDrawables[2]=R.drawable.supermancrest;
        buttonDrawables[3]=R.drawable.spiderweb;
        buttonDrawables[4]=R.drawable.laservision;
        buttonDrawables[5]=R.drawable.superstrength;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_pick_power, container, false);

        for(int i=0;i<6;i++){
            int s=R.id.a1;
            buttons[i]=view.findViewById(s+i);
            buttons[i].setOnClickListener(onClickListener);
        }

        submitButton=view.findViewById(R.id.yes);
        submitButton.setAlpha(.5f);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Log.v("stuff","sumbit Button powers");

            }
        });
        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        clearButtons();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onPickPowerFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowerInteractionListener) {
            mListener = (PickPowerInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    private void clearButtons(){
        for(int i=0;i<6;i++){
            buttons[i].setCompoundDrawablesWithIntrinsicBounds(buttonDrawables[i],0,0,0);
            buttons[i].setAlpha(1f);
        }
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
    public interface PickPowerInteractionListener {
        // TODO: Update argument type and name
        void onPickPowerFragmentInteraction(Uri uri);
    }
}
