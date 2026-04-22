package jp.ac.gifu_u.programmingjissen2;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

//レコードクラス(初期値を変更しないクラス、getterとかを自動で作ってくれるから便利)
public record ButtonActivity(Context context) implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        showToast("Hello");
    }

    public void showToast(String string) {
        Toast t = Toast.makeText(
                context, string, Toast.LENGTH_SHORT);
        t.show();
    }

}
