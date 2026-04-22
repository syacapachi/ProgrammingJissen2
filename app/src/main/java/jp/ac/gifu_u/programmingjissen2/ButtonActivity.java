package jp.ac.gifu_u.programmingjissen2;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

//レコードクラス(初期値を変更しないクラス、getterとかを自動で作ってくれるから便利)
public record ButtonActivity(Activity activity) implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        showToast("Finish");
        activity.finish();
    }

    public void showToast(String string) {
        Toast t = Toast.makeText(
                activity, string, Toast.LENGTH_SHORT);
        t.show();
    }

}
