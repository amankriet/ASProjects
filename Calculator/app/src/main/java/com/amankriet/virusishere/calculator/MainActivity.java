package com.amankriet.virusishere.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String msg="Android";
    Button zero,one,two,three,four,five,six,seven,eight,nine,clear,xsquare,xcube,fact,equalsto,mod,minus,div,plus,mul,del,decimal;
    TextView tv;
    boolean add,sub,prod,divi,per;
    Double var1,var2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zero=findViewById(R.id.zerob);
        one=findViewById(R.id.oneb);
        two=findViewById(R.id.twob);
        three=findViewById(R.id.threeb);
        four=findViewById(R.id.fourb);
        five=findViewById(R.id.fiveb);
        six=findViewById(R.id.sixb);
        seven=findViewById(R.id.sevenb);
        eight=findViewById(R.id.eightb);
        nine=findViewById(R.id.nineb);
        clear=findViewById(R.id.clearb);
        xsquare=findViewById(R.id.xsquareb);
        xcube=findViewById(R.id.xcubeb);
        fact=findViewById(R.id.factb);
        equalsto=findViewById(R.id.equalstob);
        mod=findViewById(R.id.modb);
        minus=findViewById(R.id.minusb);
        div=findViewById(R.id.divb);
        plus=findViewById(R.id.plusb);
        mul=findViewById(R.id.mulb);
        tv=findViewById(R.id.tvc);
        del=findViewById(R.id.deli);
        decimal=findViewById(R.id.decimal);

        tv.setText("0");

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = tv.getText().toString();
                int x;
                x=str.indexOf(".");
                if (x<0)
                {
                    tv.setText(tv.getText().toString()+".");
                }

            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tv.getText().toString().equals("") || tv.getText().toString().equals("0"))
                {
                    tv.setText("0");
                }
                else
                {
                    tv.setText(tv.getText()+"0");
                }
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tv.getText().toString().equals("") || tv.getText().toString().equals("0"))
                {
                    tv.setText("1");
                }
                else
                {
                    tv.setText(tv.getText()+"1");
                }
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tv.getText().toString().equals("") || tv.getText().toString().equals("0"))
                {
                    tv.setText("2");
                }
                else
                {
                    tv.setText(tv.getText()+"2");
                }
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tv.getText().toString().equals("") || tv.getText().toString().equals("0"))
                {
                    tv.setText("3");
                }
                else
                {
                    tv.setText(tv.getText()+"3");
                }
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tv.getText().toString().equals("") || tv.getText().toString().equals("0"))
                {
                    tv.setText("4");
                }
                else
                {
                    tv.setText(tv.getText()+"4");
                }
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tv.getText().toString().equals("") || tv.getText().toString().equals("0"))
                {
                    tv.setText("5");
                }
                else
                {
                    tv.setText(tv.getText()+"5");
                }
            }
        });


        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tv.getText().toString().equals("") || tv.getText().toString().equals("0"))
                {
                    tv.setText("6");
                }
                else
                {
                    tv.setText(tv.getText()+"6");
                }
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tv.getText().toString().equals("") || tv.getText().toString().equals("0"))
                {
                    tv.setText("7");
                }
                else
                {
                    tv.setText(tv.getText()+"7");
                }
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tv.getText().toString().equals("") || tv.getText().toString().equals("0"))
                {
                    tv.setText("8");
                }
                else
                {
                    tv.setText(tv.getText()+"8");
                }
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tv.getText().toString().equals("") || tv.getText().toString().equals("0"))
                {
                    tv.setText("9");
                }
                else
                {
                    tv.setText(tv.getText()+"9");
                }
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str=tv.getText().toString();
                if (str.length()<2)
                {
                    tv.setText("0");
                }
                else
                {
                    str=str.substring(0,str.length()-1);
                    tv.setText(str);
                }

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv.setText("0");
                add=false;
                sub=false;
                prod=false;
                divi=false;
                per=false;
            }
        });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (sub || prod || divi || per)
                {
                    sub=false;
                    per=false;
                    prod=false;
                    divi=false;
                    add=true;
                }
                else
                {
                    String str=tv.getText().toString();
                    var1=Double.parseDouble(str);
                    add=true;
                    tv.setText("0");
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (add || prod || divi || per)
                {
                    add=false;
                    per=false;
                    prod=false;
                    divi=false;
                    sub=true;
                }
                else
                {
                    String str=tv.getText().toString();
                    var1=Double.parseDouble(str);
                    sub=true;
                    tv.setText("0");
                }
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (add || sub || divi || per)
                {
                    add=false;
                    per=false;
                    sub=false;
                    divi=false;
                    prod=true;
                }
                else
                {
                    String str=tv.getText().toString();
                    var1=Double.parseDouble(str);
                    prod=true;
                    tv.setText("0");
                }

            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (add || prod || sub || per)
                {
                    add=false;
                    per=false;
                    prod=false;
                    sub=false;
                    divi=true;
                }
                else
                {
                    String str=tv.getText().toString();
                    var1=Double.parseDouble(str);
                    divi=true;
                    tv.setText("0");
                }

            }
        });

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (add || prod || divi || sub)
                {
                    add=false;
                    sub=false;
                    prod=false;
                    divi=false;
                    per=true;
                }
                else
                {
                    var1=Double.parseDouble(tv.getText().toString());
                    per=true;
                    tv.setText("0");
                }

            }
        });

        xsquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                var1=Double.parseDouble(tv.getText().toString());
                tv.setText((var1*var1)+"");

            }
        });

        xcube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                var1=Double.parseDouble(tv.getText().toString());
                tv.setText((var1*var1*var1)+"");

            }
        });

        fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double i,n,ans;
                ans=1.0;
                n=Double.parseDouble(tv.getText().toString());
                if (n==0 || n==1)
                {
                    tv.setText("1");

                }
                else
                {
                    for (i=n; i>=1; i--)
                    {
                        ans*=i;
                    }
                    tv.setText(ans+"");
                }

            }
        });

        equalsto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                var2=Double.parseDouble(tv.getText()+"");
                if(add)
                {

                    tv.setText((var1+var2)+"");
                    add=false;
                }
                else if(sub)
                {
                    tv.setText((var1-var2)+"");
                    sub=false;
                }
                else if (prod)
                {
                    if (var1*var2==0)
                    {
                        tv.setText("0");
                    }
                    else
                    {
                        tv.setText((var1*var2)+"");
                    }
                    prod=false;
                }
                else if (divi)
                {
                    if (var2==0)
                    {
                        tv.setText("Not Defined!");
                        divi=false;
                    }
                    else
                    {
                        tv.setText((var1/var2)+"");
                        divi=false;
                    }
                }
                else if (per)
                {
                    if (var2==0)
                    {
                        tv.setText((var1/100)+"");
                        per=false;
                    }
                    else
                    {
                        tv.setText(((var1/var2)*100)+"");
                        per=false;
                    }
                }
            }
        });

        Log.d(msg, "onCreate: The onCreate event");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "onStart: The onStart() event");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "onResume: The onResume() event");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "onPause: The onPause event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "onStop: The onStop event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(msg, "onDestroy: See ya soon buddy!");
    }
}
