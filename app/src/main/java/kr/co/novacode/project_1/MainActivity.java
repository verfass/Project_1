package kr.co.novacode.project_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	int counter;				//사용자 입력 횟수
	int n;						//난수 발생용
	EditText edit;				//사용자 입력 컨트롤
	TextView tResult;			//처리결과 입력 컨트롤

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//변수 초기화
		counter = 0;
		n = new Random().nextInt(501) + 500;
		edit = (EditText)findViewById(R.id.editText01);
		tResult = (TextView)findViewById(R.id.textView02);

		findViewById(R.id.button01).setOnClickListener(myButtonClick);
	}

	Button.OnClickListener myButtonClick = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			String s = "";
			counter++;

			int p = Integer.parseInt(edit.getText().toString());

			if (p < 500 || p > 1000) {
				s = "입력한 값이 500~1000을 벗어났습니다.";
			} else if (p == n) {
				s = counter + "번째에 맞추셨습니다.";
			} else if (p > n) {
				s = p + " 보다 작습니다.";
			} else if (p < n) {
				s = p + " 보다 큽니다.";
			}
			tResult.setText(s);
		}
	};
}
