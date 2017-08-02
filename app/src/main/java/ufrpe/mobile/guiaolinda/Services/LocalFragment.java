package ufrpe.mobile.guiaolinda.Services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.UUID;

import ufrpe.mobile.guiaolinda.DB.LocalLab;
import ufrpe.mobile.guiaolinda.GUI.MapsActivity;
import ufrpe.mobile.guiaolinda.R;

public class LocalFragment extends Fragment {
    private static final String ARG_LOCAL_ID = "crime_id";

    private Local mLocal;
    private TextView mNameField;
    private TextView mAddressField;
    private TextView mFoneField;
    private TextView mFaxField;
    private TextView mSiteField;
    private TextView mEmailField;
    private Button goToMaps;
    private ImageView mImgLocal;


    public static LocalFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_LOCAL_ID, crimeId);

        LocalFragment fragment = new LocalFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID localId = (UUID) getArguments().getSerializable(ARG_LOCAL_ID);
        mLocal = LocalLab.get(getActivity()).getLocal(localId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_local, container, false);

        mImgLocal = (ImageView)v.findViewById(R.id.local_image);
        mImgLocal.setImageResource(mLocal.getImagem());

        mNameField = (TextView)v.findViewById(R.id.local_name);
        if(!mLocal.get_nome_local().equals("")){
            mNameField.setText(mLocal.get_nome_local());
        }else {
            mNameField.setVisibility(getView().GONE);
        }

        mAddressField = (TextView)v.findViewById(R.id.local_endereco);
        if(!mLocal.getEndereco().equals("")){
            mAddressField.setText(mLocal.getEndereco());
        }else {
            mAddressField.setVisibility(getView().GONE);
        }

        mFoneField = (TextView)v.findViewById(R.id.local_fone);
        if(!mLocal.getTelefone().equals("")){
            mFoneField.setText(mLocal.getTelefone());
        }else {
            mFoneField.setVisibility(getView().GONE);
        }

        mFaxField = (TextView)v.findViewById(R.id.local_fax);
        if(!mLocal.getHorario().equals("")){
            mFaxField.setText(mLocal.getHorario());
        }else {
            mFaxField.setVisibility(getView().GONE);
        }

        mSiteField = (TextView)v.findViewById(R.id.local_site);
        if (!mLocal.getSite().equals("")){
            mSiteField.setText(mLocal.getSite());
        }else {
            mSiteField.setVisibility(getView().GONE);
        }

        mEmailField = (TextView)v.findViewById(R.id.local_email);
        if(!mLocal.getEmail().equals("")){
            mEmailField.setText(mLocal.getEmail());
        }else {
            mSiteField.setVisibility(getView().GONE);
        }


        goToMaps = (Button)v.findViewById(R.id.go_to_maps);
        goToMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LocalFragment.this.getActivity(), MapsActivity.class);
                startActivity(intent);
            }
        });

        return  v;
    }
}
