package com.example.a112121062_task1;
import static android.view.View.*;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private TextView n1text1;
    private TextView n1text2;
    private TextView n1text3;
    private TextView n1text4;
    private TextView n1text5;
    private TextView n2text1;
    private TextView n2text2;
    private TextView n2text3;
    private TextView n2text4;
    private TextView n2text5;
    private TextView n3text1;
    private TextView n3text2;
    private TextView n3text3;
    private TextView n3text4;
    private TextView n3text5;
    private TextView rand1;
    private TextView rand2;
    private TextView rand3;
    private TextView rand4;
    private TextView rand5;
    private TextView rand6;
    private TextView rand7;
    private TextView rand8;
    private TextView rand9;
    private TextView rand10;
    private TextView symbol1;
    private TextView symbol2;
    private TextView symbol3;
    private TextView symbol4;
    private TextView symbol5;
    private TextView equal1;
    private TextView equal2;
    private TextView equal3;
    private TextView equal4;
    private TextView equal5;
    private Button button;
    private EditText lives;
    private EditText scoree;


    public static int rand() {
        return (int) ((Math.random() * (20)+1));
    }
    private static Integer  l=0;
    private static Integer o=0;
    public static ArrayList<Integer> ngen() {
        ArrayList<Integer> list=new ArrayList<Integer>(2);
        list.add(rand());
        list.add(rand());

        return list;
    }
    public static void checkeqn(){}

            static final class ChoiceTouchListener implements OnTouchListener {
                @SuppressLint({"NewApi", "ClickableViewAccessibility"})
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        /*
                         * Drag details: we only need default behavior
                         * - clip data could be set to pass data as part of drag
                         * - shadow can be tailored
                         */
                        ClipData data = ClipData.newPlainText("", "");
                        DragShadowBuilder shadowBuilder = new DragShadowBuilder(view);
                        //start dragging the item touched
                        view.startDrag(data, shadowBuilder, view, 0);
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            @SuppressLint("NewApi")
            class ChoiceDragListener implements OnDragListener
            {

                @Override
                public boolean onDrag(View v, DragEvent event)
                {
                    switch (event.getAction())
                    {
                        case DragEvent.ACTION_DRAG_STARTED:
                            //no action necessary
                            break;
                        case DragEvent.ACTION_DRAG_ENTERED:
                            //no action necessary
                            break;
                        case DragEvent.ACTION_DRAG_EXITED:
                            //no action necessary
                            break;
                        case DragEvent.ACTION_DROP:

                            //handle the dragged view being dropped over a drop view
                            View view = (View) event.getLocalState();
                            //view dragged item is being dropped on
                            TextView dropTarget = (TextView) v;
                            //view being dragged and dropped
                            TextView dropped = (TextView) view;
//                            //checking whether first character of dropTarget equals first character of dropped
//                            if(dropTarget.getText().toString().charAt(0) == dropped.getText().toString().charAt(0))
//                            {
                            //stop displaying the view where it was before it was dragged
                            view.setVisibility(INVISIBLE);
//                            ((TextView) view).setText("");
                            //update the text in the target view to reflect the data being dropped
                            dropTarget.setText(dropTarget.getText().toString() + dropped.getText().toString());
                            //make it bold to highlight the fact that an item has been dropped
                            dropTarget.setTypeface(Typeface.DEFAULT_BOLD);
                            //if an item has already been dropped here, there will be a tag
                            Object tag = dropTarget.getTag();
                            //if there is already an item here, set it back visible in its original place
                            if (tag != null) {
                                //the tag is the view id already dropped here
                                int existingID = (Integer) tag;
                                //set the original view visible again
                                findViewById(existingID).setVisibility(VISIBLE);
                            }
                            //set the tag in the target view being dropped on - to the ID of the view being dropped
                            dropTarget.setTag(dropped.getId());
                            //remove setOnDragListener by setting OnDragListener to null, so that no further drag & dropping on this TextView can be done
                            dropTarget.setOnDragListener(null);

//                            else
//                                //displays message if first character of dropTarget is not equal to first character of dropped
//                                Toast.makeText(MainActivity.this, dropTarget.getText().toString() + "is not " + dropped.getText().toString(), Toast.LENGTH_LONG).show();
//                            break;
                    case DragEvent.ACTION_DRAG_ENDED:
                    //no action necessary
                    break;
                    default:
                    break;
                    }
                     return true;
                    }
                }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int[] life = {3};
        final int[] score = {0};
        n1text1 = findViewById(R.id.n1text1);
        n1text2 = findViewById(R.id.n1text2);
        n1text3 = findViewById(R.id.n1text3);
        n1text4 = findViewById(R.id.n1text4);
        n1text5 = findViewById(R.id.n1text5);
        n2text1 = findViewById(R.id.n2text1);
        n2text2 = findViewById(R.id.n2text2);
        n2text3 = findViewById(R.id.n2text3);
        n2text4 = findViewById(R.id.n2text4);
        n2text5 = findViewById(R.id.n2text5);
        n3text1 = findViewById(R.id.n3text1);
        n3text2 = findViewById(R.id.n3text2);
        n3text3 = findViewById(R.id.n3text3);
        n3text4 = findViewById(R.id.n3text4);
        n3text5 = findViewById(R.id.n3text5);
        rand1 = findViewById(R.id.rand1);
        rand2 = findViewById(R.id.rand2);
        rand3 = findViewById(R.id.rand3);
        rand4 = findViewById(R.id.rand4);
        rand5 = findViewById(R.id.rand5);
        rand6 = findViewById(R.id.rand6);
        rand7 = findViewById(R.id.rand7);
        rand8 = findViewById(R.id.rand8);
        rand9 = findViewById(R.id.rand9);
        rand10 = findViewById(R.id.rand10);
        symbol1 = findViewById(R.id.symbol1);
        symbol2 = findViewById(R.id.symbol2);
        symbol3 = findViewById(R.id.symbol3);
        symbol4 = findViewById(R.id.symbol4);
        symbol5 = findViewById(R.id.symbol5);
        equal1 = findViewById(R.id.equal1);
        equal2 = findViewById(R.id.equal2);
        equal3 = findViewById(R.id.equal3);
        equal4 = findViewById(R.id.equal4);
        equal5 = findViewById(R.id.equal5);
        lives=findViewById(R.id.lives);
        scoree = findViewById(R.id.score);
        button=findViewById(R.id.SUBMIT);
//        rand1.setOnClickListener();



        rand1.setOnTouchListener(new ChoiceTouchListener());
        rand2.setOnTouchListener(new ChoiceTouchListener());
        rand3.setOnTouchListener(new ChoiceTouchListener());
        rand4.setOnTouchListener(new ChoiceTouchListener());
        rand5.setOnTouchListener(new ChoiceTouchListener());
        rand6.setOnTouchListener(new ChoiceTouchListener());
        rand7.setOnTouchListener(new ChoiceTouchListener());
        rand8.setOnTouchListener(new ChoiceTouchListener());
        rand9.setOnTouchListener(new ChoiceTouchListener());
        rand10.setOnTouchListener(new ChoiceTouchListener());
//        rand1.setOnDragListener(new ChoiceDragListener());
//        rand1.setOnDragListener(new ChoiceDragListener());
//        rand2.setOnDragListener(new ChoiceDragListener());
//        rand3.setOnDragListener(new ChoiceDragListener());
//        rand4.setOnDragListener(new ChoiceDragListener());
//        rand5.setOnDragListener(new ChoiceDragListener());
//        rand6.setOnDragListener(new ChoiceDragListener());
//        rand7.setOnDragListener(new ChoiceDragListener());
//        rand8.setOnDragListener(new ChoiceDragListener());
//        rand9.setOnDragListener(new ChoiceDragListener());
//        rand10.setOnDragListener(new ChoiceDragListener());
        n1text1.setOnDragListener(new ChoiceDragListener());
        n1text2.setOnDragListener(new ChoiceDragListener());
        n1text3.setOnDragListener(new ChoiceDragListener());
        n1text4.setOnDragListener(new ChoiceDragListener());
        n1text5.setOnDragListener(new ChoiceDragListener());
        n2text1.setOnDragListener(new ChoiceDragListener());
        n2text2.setOnDragListener(new ChoiceDragListener());
        n2text3.setOnDragListener(new ChoiceDragListener());
        n2text4.setOnDragListener(new ChoiceDragListener());
        n2text5.setOnDragListener(new ChoiceDragListener());
        n3text1.setOnDragListener(new ChoiceDragListener());
        n3text2.setOnDragListener(new ChoiceDragListener());
        n3text3.setOnDragListener(new ChoiceDragListener());
        n3text4.setOnDragListener(new ChoiceDragListener());
        n3text5.setOnDragListener(new ChoiceDragListener());
//        n1text1.setOnTouchListener(new ChoiceTouchListener());
//        n1text2.setOnTouchListener(new ChoiceTouchListener());
//        n1text3.setOnTouchListener(new ChoiceTouchListener());
//        n1text4.setOnTouchListener(new ChoiceTouchListener());
//        n1text5.setOnTouchListener(new ChoiceTouchListener());
//        n2text1.setOnTouchListener(new ChoiceTouchListener());
//        n2text2.setOnTouchListener(new ChoiceTouchListener());
//        n2text3.setOnTouchListener(new ChoiceTouchListener());
//        n2text4.setOnTouchListener(new ChoiceTouchListener());
//        n2text1.setOnTouchListener(new ChoiceTouchListener());
//        n3text2.setOnTouchListener(new ChoiceTouchListener());
//        n3text3.setOnTouchListener(new ChoiceTouchListener());
//        n3text4.setOnTouchListener(new ChoiceTouchListener());
//        n3text5.setOnTouchListener(new ChoiceTouchListener());


        ArrayList<Integer> nlist = new ArrayList<>(10);
        symbol1.setText("+");
        ArrayList<Integer> x = ngen();
        nlist.addAll(x);
        n3text1.setText(String.valueOf(x.get(0) + x.get(1)));
        symbol2.setText("-");
        ArrayList<Integer> x1 = ngen();
        nlist.addAll(x1);
        n3text2.setText(String.valueOf(x1.get(0) - x1.get(1)));
        symbol3.setText("x");
        ArrayList<Integer> x2 = ngen();
        nlist.addAll(x2);
        n3text3.setText(String.valueOf(x2.get(0) * x2.get(1)));
        symbol4.setText("/");
        ArrayList<Integer> x3 = ngen();
        nlist.addAll(x3);
        n3text4.setText(String.valueOf(x3.get(0) / x3.get(1)));
        symbol5.setText("+");
        ArrayList<Integer> x4 = ngen();
        nlist.addAll(x4);
        n3text5.setText(String.valueOf(x4.get(0) + x4.get(1)));
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<TextView> box = new ArrayList<TextView>(10);
        box.add(rand1);
        box.add(rand2);
        box.add(rand3);
        box.add(rand4);
        box.add(rand5);
        box.add(rand6);
        box.add(rand7);
        box.add(rand8);
        box.add(rand9);
        box.add(rand10);
        while (!box.isEmpty()) {
            int rando = (int) (Math.random() * (9 - o));
            box.get(rando).setText(String.valueOf(nlist.get(o)));
            box.remove(rando);
            o++;
        }

    button.setOnClickListener(new OnClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View V) {
            //Toast.makeText(MainActivity.this,"qjjfdq",Toast.LENGTH_SHORT).show();
                if (Integer.parseInt(n1text1.toString())+ Integer.parseInt(n2text1.toString())==Integer.parseInt(n3text1.toString())&Integer.parseInt(n1text2.toString())+ Integer.parseInt(n2text2.toString())==Integer.parseInt(n3text2.toString())&Integer.parseInt(n1text3.toString())+ Integer.parseInt(n2text3.toString())==Integer.parseInt(n3text3.toString())&Integer.parseInt(n1text4.toString())+ Integer.parseInt(n2text4.toString())==Integer.parseInt(n3text4.toString())&Integer.parseInt(n1text5.toString())+ Integer.parseInt(n2text5.toString())==Integer.parseInt(n3text5.toString()))
                {
                   score[0] +=1;
                    //lives.setText("worked");
                }
                else {
                    life[0] -=1;

//                    Toast.makeText(MainActivity.this,"qjjfdq",Toast.LENGTH_SHORT).show();
//                    lives.setText("worked bt wrong");

                }

        }
    });
    }

}



