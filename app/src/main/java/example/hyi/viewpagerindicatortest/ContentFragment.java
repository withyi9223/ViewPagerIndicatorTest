package example.hyi.viewpagerindicatortest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by HY大大i on 2016/10/21.
 */
public class ContentFragment extends Fragment {
    @Bind(R.id.tv)
    TextView tv;

    public static ContentFragment newInstance(String msg) {
        ContentFragment contentFragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("msg", msg);
        contentFragment.setArguments(bundle);
        return contentFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment, null);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        String msg = bundle.getString("msg");
        tv.setText(msg);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.tv)
    public void onClick() {
    }
}
