package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages = {

            {"Uprise-03 10001u Capsule","","","","300"},
            { "ParacetaMol 500mg Tablet","","","","400"},
            { "AmoxiCillin 250mg Syrup","","","","500"},
            { "LorataDine 10mg Tablet","","","","550"},
            { "OmepraZole 20mg Capsule","","","","450"},
            {"Aspirin 100mg Tablet","","","","350"},
            {"Ibuprofen 200mg Tablet","","","","330"},
            {"Cetirizine 10mg Tablet","","","","340"},
            {"Gaviscon Extra Strength Liquid","","","","370"}
};
    private String[] package_details =
            {
                "Used for treating vitamin D deficiency.\n"+
                " A common pain reliever and fever reducer.\n",
                " An antibiotic used to treat bacterial infections.\n",
                "Provides relief from allergies and hay fever symptoms.\n",
                " Helps reduce stomach acid and treat acid reflux.\n",
                "Used for pain relief and to prevent heart attacks.\n"+
                "Nonsteroidal anti-inflammatory drug (NSAID) for pain relief and reducing inflammation.\n",
                "Antihistamine used to relieve allergy symptoms such as sneezing, itching, and runny nose.\n",
                " Provides relief from heartburn, acid indigestion, and gastroesophageal reflux.\n",
                "Bronchodilator medication used to treat and prevent asthma symptoms.\n",
                " - Oral medication for managing type 2 diabetes.\n"+
                "Helps lower cholesterol and triglyceride levels in the blood.\n"
};
    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst=findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String, String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Cons Fees:"+packages[i][4]+"/-");
            list.add(item);
        }
        sa =new SimpleAdapter(this,list,
                R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e,}
        );
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text2",packages[i][0]);
                it.putExtra("text3",package_details[i]);
                it.putExtra("text4",packages[i][4]);
                startActivity(it);
            }
        });
    }
}