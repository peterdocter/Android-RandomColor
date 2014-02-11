package app.akexorcist.randomcolor;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Main extends Activity {
	int[] imageViewId = { R.id.imageView1, R.id.imageView2
			, R.id.imageView3, R.id.imageView4, R.id.imageView5 };
	
	String[] colorCode = { "#d4e51a", "#9ac929", "#4bc929"
			, "#2fb672", "#2faeb6", "#2f7bb6", "#2f4fb6"
			, "#4848a1", "#6748a1", "#9941a3", "#b84290"
			, "#d3419e", "#d60668", "#df002f", "#f54615"
			, "#ff7e00", "#ffae00", "#ffcc00", "#fff000" };
	
	ImageView[] imageView = new ImageView[imageViewId.length];
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		for(int i = 0 ; i < imageViewId.length ; i++) 
			imageView[i] = (ImageView)findViewById(imageViewId[i]);

		Button buttonRandom = (Button)findViewById(R.id.buttonRandom);
		buttonRandom.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int[] data = randomIntArray(imageViewId.length
						, 0, colorCode.length - 1);
				for(int i = 0 ; i < data.length ; i++) {
					int color = Color.parseColor(colorCode[data[i]]);
					imageView[i].setImageDrawable(new ColorDrawable(color));
				}
			}
		});
	}
	
	public int[] randomIntArray(int count, int min, int max) {
		Random r = new Random();
		int[] data = new int[count];
		for(int i = 0 ; i < count ; i++) 
			data[i] = -1;
		for(int i = 0 ; i < count ; i++) {
			int n = -1;
	    	boolean st = true; 
			while(st) {
				st = false;
				n = r.nextInt((max - min) + 1) + min;
				for(int j = 0 ; j < data.length ; j++) 
					if(n == data[j]) 
						st = true;
			}
			data[i] = n;
		}
		return data;
	}
}
