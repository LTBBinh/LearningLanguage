package com.nmp.phuc.applearnlanguage;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nmp.phuc.applearnlanguage.AppRoom.TuVung;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link hoctu.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link hoctu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class flashcard extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ArrayList<TuVung> listTuSai;

    private ImageView left;
    private ImageView right;
    private TextView flashcard;
    private Button okBtn;

    private int mCurrentIndex;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public flashcard() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment hoctu.
     */
    // TODO: Rename and change types and number of parameters
    public static flashcard newInstance(String param1, String param2) {
        flashcard fragment = new flashcard();
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
        mCurrentIndex = 0;
        listTuSai = new ArrayList<>();
        getTuSai();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flashcard, container, false);

        left = view.findViewById(R.id.leftFlashcardView);
        right = view.findViewById(R.id.rightFlashcardView);
        flashcard = view.findViewById(R.id.flashcard);
        okBtn = view.findViewById(R.id.okButton);

        left.setOnClickListener(this);
        right.setOnClickListener(this);
        flashcard.setOnClickListener(this);
        okBtn.setOnClickListener(this);

        if (listTuSai.get(mCurrentIndex)!=null) flashcard.setText(listTuSai.get(0).toString());

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.leftFlashcardView:
                if(mCurrentIndex>0) mCurrentIndex--;
                flashcard.setText(listTuSai.get(mCurrentIndex).toString());
                break;
            case R.id.rightFlashcardView:
                if(mCurrentIndex<listTuSai.size()-1) mCurrentIndex++;
                flashcard.setText(listTuSai.get(mCurrentIndex).toString());
                break;
            case R.id.flashcard:
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(),R.animator.rotate);
                set.setTarget(flashcard);
                set.start();
                break;
            case R.id.okButton:
                Class mClass = hoctu.class;
                Fragment fgmHocTuUser = null;
                try {
                    fgmHocTuUser = (Fragment) mClass.newInstance();
                } catch (java.lang.InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flcontent,fgmHocTuUser ).commit();
                break;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    public void getTuSai () {
        MainActivity parent = (MainActivity) getActivity();
        ArrayList<Integer> idTuSai = parent.getMissWord();
        TuVung a = new TuVung("a","ng",2,3,"2017/12/02",1);
        listTuSai.add(a);
    }
}
