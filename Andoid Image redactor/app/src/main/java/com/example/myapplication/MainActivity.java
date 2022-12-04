package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.graphics.Color;

import java.util.function.IntToDoubleFunction;


public class MainActivity extends AppCompatActivity {
    private Button bt1;
    private ImageView iv1;
    private ImageView iv2;

    public double x, y;
    public int OldX, OldY, MouseX, MouseY; // начальные и текущие координаты
    public int Regim;
    public int Type=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt1=(Button)findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                iv1.setImageResource(R.drawable.ris1);
                //ShowImage();
            }
        });
        iv1=(ImageView)findViewById(R.id.iv1);
        iv2=(ImageView)findViewById(R.id.iv2);
        iv1.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                x = event.getX();   // координаты пальца
                y = event.getY();
                //
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN: // нажатие пальца
                        OldX=(int)Math.round(x);
                        OldY=(int)Math.round(y);
                        MouseX=OldX;
                        MouseY=OldY;
                        Regim=1;

                        break;
                    case MotionEvent.ACTION_MOVE: // движение пальца
                        if(Regim==1)
                        {
                            MouseX=(int)Math.round(x);
                            MouseY=(int)Math.round(y);
                        }
                        break;
                    case MotionEvent.ACTION_UP: // отпускание пальца
                        if(Regim==1)
                        {
                            MouseX=(int)Math.round(x);
                            MouseY=(int)Math.round(y);
                            Regim=0;
// выделен прямоугольник OldX,OldY - MouseX,MouseY
// здесь будет обработка выделенного прямоугольника
                            Type=1; // дорисовать
                            ShowImage();
                        }
                        break;
//  case MotionEvent.ACTION_CANCEL:  ? для неправильных действий
                }
                return true;
            }
        });

    }
    public void ShowImage()
    {
        int w=iv1.getWidth();  // размеры ImageView
        int h=iv1.getHeight();
        Bitmap bm= Bitmap.createBitmap(w, h,  Bitmap.Config.ARGB_8888); // чистая битовая карта
        // ARGB_8888 - для прозрачности, R, G, B - по 8 бит. Прозрачность [0-255] -
        // 0 - прозрачная, 255 - не прозрачная
        Canvas cn = new Canvas(bm);  // холст от чистой битовой карты
        Bitmap bm1 = BitmapFactory.decodeResource(getResources(),
                R.drawable.ris1); // битовая карта ris1.jpg
        int width = bm1.getWidth();   // размеры ris1.jpg
        int height = bm1.getHeight();
        Rect rs=new Rect();
        Rect rd=new Rect();

        Integer s1;








        // прямоугольник из iv1
        rs.left = OldX;
        rs.top = OldY; //левый верхний
        rs.right = MouseX;
        rs.bottom = MouseY; // нижний правый
        // прямоугольник от ImageView (отображается в ImageView2)
        rd.left = OldX;
        rd.top = OldY;
        rd.right = MouseX;
        rd.bottom = MouseY;

        cn.drawBitmap(bm1, rs, rd, null);  // рисование на холсте части изображения



        int i,j;
        int NewX,NewY;
        int pColor = 0,pRed,pGreen,pBlue;
        if(Type==1)
// копия фрагмента, смещение
        {
            NewX=OldX;
            w=MouseX-OldX;
            NewX=OldX;
            for(i=OldX; i<=MouseX; i++)
            {
                NewY=OldY;
                for(j=OldY;j<=MouseY;j++)
                {

                    double sp=20*Math.sin(Math.PI*2*j/128);


                        // pColor=bm.getPixel(i, j); // цвет текущей точки
                        if (i+sp>=OldX&&i+sp<MouseX &&sp >= 0) {
                            pColor = bm.getPixel(i + (int) sp, j);
                            bm.setPixel(NewX, NewY, pColor);
                        } // цвет тот же
                        else if( MouseX-i+sp>=OldX && MouseX-i+sp<=MouseX){
                            pColor = bm.getPixel(MouseX - i + (int) sp, j);
                            bm.setPixel(MouseX - NewX, NewY, pColor);
                        } // цвет тот же
                        //else bm.setPixel(NewX, NewY, 0);




                    //bm.setPixel(NewX, NewY, pColor); // цвет тот же
                    NewY++;
                }
                NewX++;
            }

            Type=0;
        }


        iv2.setImageDrawable(new BitmapDrawable(getResources(), bm));
    }
}
