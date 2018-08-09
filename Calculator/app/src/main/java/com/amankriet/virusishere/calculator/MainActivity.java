package com.amankriet.virusishere.calculator;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button zero, one, two, three, four, five, six, seven, eight, nine, clear, fact, equalsto, mod, minus, div, plus, mul, del, decimal;
    TextView tv, tv2;
    String txt, result;
    boolean add,sub,prod,divi,per;
    BigDecimal var1, var2;
    BigDecimal final_decresult = new BigDecimal("0");

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
        fact=findViewById(R.id.factb);
        equalsto=findViewById(R.id.equalstob);
        mod=findViewById(R.id.modb);
        minus=findViewById(R.id.minusb);
        div=findViewById(R.id.divb);
        plus=findViewById(R.id.plusb);
        mul=findViewById(R.id.mulb);
        tv=findViewById(R.id.tvc);
        tv2 = findViewById(R.id.tvc2);
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
                    txt = tv.getText().toString() + ".";
                    tv.setText(txt);
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
                    txt = tv.getText() + "0";
                    tv.setText(txt);
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
                    txt = tv.getText() + "1";
                    tv.setText(txt);
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
                    txt = tv.getText() + "2";
                    tv.setText(txt);
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
                    txt = tv.getText() + "3";
                    tv.setText(txt);
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
                    txt = tv.getText() + "4";
                    tv.setText(txt);
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
                    txt = tv.getText() + "5";
                    tv.setText(txt);
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
                    txt = tv.getText() + "6";
                    tv.setText(txt);
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
                    txt = tv.getText() + "7";
                    tv.setText(txt);
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
                    txt = tv.getText() + "8";
                    tv.setText(txt);
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
                    txt = tv.getText() + "9";
                    tv.setText(txt);
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
                tv2.setText("");
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

                if (sub || prod || divi || per || add)
                {
                    sub=false;
                    per=false;
                    prod=false;
                    divi=false;
                    add=true;
                    tv2.setText("+");
                }
                else
                {
                    String str=tv.getText().toString();
                    var1 = new BigDecimal(str);
                    add=true;
                    tv.setText("0");
                    tv2.setText("+");
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (add || prod || divi || per || sub)
                {
                    add=false;
                    per=false;
                    prod=false;
                    divi=false;
                    sub=true;
                    tv2.setText("-");
                }
                else
                {
                    String str=tv.getText().toString();
                    var1 = new BigDecimal(str);
                    sub=true;
                    tv.setText("0");
                    tv2.setText("-");
                }
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (add || sub || divi || per || prod)
                {
                    add=false;
                    per=false;
                    sub=false;
                    divi=false;
                    prod=true;
                    tv2.setText("*");
                }
                else
                {
                    String str=tv.getText().toString();
                    var1 = new BigDecimal(str);
                    prod=true;
                    tv.setText("0");
                    tv2.setText("*");
                }

            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (add || prod || sub || per || divi)
                {
                    add=false;
                    per=false;
                    prod=false;
                    sub=false;
                    divi=true;
                    tv2.setText("/");
                }
                else
                {
                    String str=tv.getText().toString();
                    var1 = new BigDecimal(str);
                    divi=true;
                    tv.setText("0");
                    tv2.setText("/");
                }

            }
        });

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (add || prod || divi || sub || per)
                {
                    add=false;
                    sub=false;
                    prod=false;
                    divi=false;
                    per=true;
                    tv2.setText("%");
                }
                else
                {
                    String str = tv.getText().toString();
                    var1 = new BigDecimal(str);
                    per=true;
                    tv.setText("0");
                    tv2.setText("%");
                }

            }
        });

        fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double i, n;
                final_decresult = BigDecimal.valueOf(1);
                n=Double.parseDouble(tv.getText().toString());
                txt = String.valueOf(n) + "!";
                if (n==0 || n==1)
                {
                    displayresult(txt, "1");

                } else if (n % 1 == 0) {
                    displayresult(txt, "Error: Non-Integer Input!");
                }
                else
                {
                    for (i=n; i>=1; i--)
                    {
                        final_decresult = final_decresult.multiply(new BigDecimal(String.valueOf(i)));
                    }
                    result=final_decresult.stripTrailingZeros().toPlainString();
                    displayresult(txt, result);
                }
            }
        });

        equalsto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = tv.getText().toString();
                var2 = new BigDecimal(str);
                if(add)
                {
                    txt = var1.toString() + "+" + var2.toString();
                    result = var1.add(var2).stripTrailingZeros().toPlainString();
                    displayresult(txt, result);
                    add=false;
                }
                else if(sub)
                {
                    txt = var1.toString() + "-" + var2.toString();
                    result = var1.subtract(var2).stripTrailingZeros().toPlainString();
                    displayresult(txt, result);
                    sub=false;
                }
                else if (prod)
                {
                    txt = var1.toString() + "*" + var2.toString();
                    if (var1.multiply(var2).equals(BigDecimal.ZERO))
                    {
                        displayresult(txt, "0");
                    }
                    else
                    {
                        result = var1.multiply(var2).stripTrailingZeros().toPlainString();
                        displayresult(txt, result);
                    }
                    prod=false;
                }
                else if (divi)
                {
                    txt = var1.toString() + "/" + var2.toString();
                    if (var2.equals(BigDecimal.ZERO))
                    {
                        displayresult(txt, "Not Defined!");
                        divi=false;
                    }
                    else
                    {
                        try {
                            result = var1.divide(var2, 10, RoundingMode.UNNECESSARY).stripTrailingZeros().toPlainString();
                        } catch (ArithmeticException e) {
                            result = var1.divide(var2, 10, RoundingMode.HALF_UP).stripTrailingZeros().toString();
                        }
                        displayresult(txt, result);
                        divi=false;
                    }
                }
                else if (per)
                {
                    if (var2.equals(BigDecimal.ZERO))
                    {
                        txt = var1.toString() + "%";
                        result = var1.divide(new BigDecimal("100"), 10, BigDecimal.ROUND_UNNECESSARY).stripTrailingZeros().toPlainString();
                        displayresult(txt, result);
                        per=false;
                    }
                    else
                    {
                        txt = "(" + var1.toString() + "/" + var2.toString() + ")%";
                        try {
                            result = (var1.divide(var2, 10, RoundingMode.UNNECESSARY).multiply(new BigDecimal("100"))).stripTrailingZeros().toPlainString();
                        } catch (ArithmeticException e) {
                            result = (var1.divide(var2, 10, RoundingMode.HALF_UP).multiply(new BigDecimal("100"))).stripTrailingZeros().toPlainString();
                        }
                        displayresult(txt, result);
                        per=false;
                    }
                }
            }
        });

    }

    public void displayresult(String tv2cal, String tvresult) {
        tv2.setText(tv2cal);
        tv.setText(tvresult);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.about_menu:
                AlertDialog.Builder dialogbox = new AlertDialog.Builder(this);
                dialogbox.setTitle("About");
                dialogbox.setIcon(R.mipmap.ic_info);
                dialogbox.setMessage("This is a simple calculator app with simple UI and for large" +
                        " calculations!\n\n Aman (amankriet@gmail.com)").setCancelable(true);
                Objects.requireNonNull(dialogbox.show().getWindow()).setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                return true;
            case R.id.exit_menu:
                AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
                alertbox.setTitle("Exit");
                alertbox.setIcon(R.mipmap.ic_exit);
                alertbox.setMessage("Are you sure?").setCancelable(true).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("Exit", "Exit Cancelled");
                    }
                });
                Objects.requireNonNull(alertbox.show().getWindow()).setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                return true;
            default:
                Log.d("None Selected", "Nothing selected");
                return true;
        }

    }

}
