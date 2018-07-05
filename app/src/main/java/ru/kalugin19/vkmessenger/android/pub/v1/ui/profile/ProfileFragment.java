package ru.kalugin19.vkmessenger.android.pub.v1.ui.profile;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import ru.kalugin19.vkmessenger.android.pub.v1.R;
import ru.kalugin19.vkmessenger.android.pub.v1.data.entity.Profile;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.base.view.fragments.BaseFragment;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.profile.contract.IProfileContract;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.util.ViewUtil;

public class ProfileFragment extends BaseFragment implements IProfileContract.View {

    @Inject
    IProfileContract.Presenter presenter;

    @BindView(R.id.photoProfile)
    CircleImageView circleImageView;

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.university_name)
    TextView universityName;

    @BindView(R.id.bdayText)
    TextView bDay;

    @BindView(R.id.love_partner)
    TextView partner;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public ProfileFragment() {
        // Required empty public constructor
    }


    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, v);
        presenter.attachView(this);
        return v;
    }



    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
        presenter.loadProfile();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void setProfile(Profile profile) {
        ViewUtil.loadProfilePhoto(getActivity(), circleImageView, profile.getThumbPhoto());
        name.setText(getString(R.string.first_last_name, profile.getFirstName(), profile.getLastName()));
        universityName.setText(profile.getUniversityName());
        partner.setText(profile.getRelationPartner());
        bDay.setText(profile.getBirthday());
    }
}
