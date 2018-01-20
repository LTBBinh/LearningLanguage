package com.nmp.phuc.applearnlanguage;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.nmp.phuc.applearnlanguage.AppRoom.AppDatabase;
import com.nmp.phuc.applearnlanguage.AppRoom.TuVung;
import com.nmp.phuc.applearnlanguage.AppRoom.TuVungDAO;
import com.nmp.phuc.applearnlanguage.Models.CustomAdapter;

import java.util.ArrayList;
import java.util.prefs.Preferences;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link hoctu.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link hoctu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class hoctuUser extends ListFragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ArrayList<TuVung> listTu;
    private ImageView forwordView;
    private Button confirmBtn;
    private Button learnBtn;

    private CustomAdapter mListAdapter;
    private int mCurrentDatabaseIndex=0;

    public hoctuUser() {
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
    public static hoctuUser newInstance(String param1, String param2) {
        hoctuUser fragment = new hoctuUser();
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
        getListTuVung();
        mListAdapter = new CustomAdapter(getActivity(),R.layout.kiemtra_list_item,listTu);
        setListAdapter(mListAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hoctu_user, container, false);

        forwordView = view.findViewById(R.id.forwardView);
        confirmBtn = view.findViewById(R.id.confirmBtn);
        learnBtn = view.findViewById(R.id.learnBtn);

        forwordView.setOnClickListener(this);
        confirmBtn.setOnClickListener(this);
        learnBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
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

    protected void getListTuVung () {
        AppDatabase database = Room.databaseBuilder(getActivity(), AppDatabase.class
                , "hoc-tieng-nhat").build();
        SharedPreferences save = getActivity().getPreferences(Context.MODE_PRIVATE);
        mCurrentDatabaseIndex = save.getInt(getString(R.string.current_database_index),0);
        final TuVungDAO tuVungDAO = database.getTuVungDAO();
        listTu = new ArrayList<TuVung>();
        for (int i = 0; i < 5; i++) {
            final TuVung tu1 = new TuVung("友達", "bạn bè", 2, 2, "2018/02/01", 1);
            listTu.add(tu1);
        }
        SharedPreferences.Editor editor = save.edit();
        editor.putInt(getString(R.string.current_database_index),mCurrentDatabaseIndex);
        editor.commit();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forwardView:
                getListTuVung();
                mListAdapter.notifyDataSetChanged();
                break;
            case R.id.learnBtn:
                Class mClass = hoctuUser.class;
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
            case R.id.confirmBtn:
                MainActivity parent = (MainActivity) getActivity();
                ArrayList<Switch> listSwitch = mListAdapter.getListSwitch();
                parent.resetMissWord();
                for (int i=0;i<listSwitch.size();i++) {
                    if(listSwitch.get(i)!=null) {
                        if (listSwitch.get(i).isChecked()) parent.addDataToMissWord(listTu.get(i).matu);
                    }
                }
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
}
