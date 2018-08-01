package com.wmtbr.entregavel02.model;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.wmtbr.entregavel02.R;

import java.util.ArrayList;
import java.util.List;

public class ReceitaManager extends Application {
        public final static String NAME_PREFIX = "name_";
        public final static String DESC_PREFIX = "desc_";

        private Context context;
        private static String[] receitakeyArray = {""};
        private static ReceitaManager mInstance;
        private List<Receita> receitas;

        public ReceitaManager(Context c) {
            this.context = c;
            this.receitakeyArray = c.getResources().getStringArray(R.array.receita_keys);
        }

        public static ReceitaManager getInstance(Context c) {
            if (mInstance == null) {mInstance = new ReceitaManager(c);}
            return mInstance;
        }

        public List<Receita> getReceita() {
            if (receitas == null) {
                receitas = new ArrayList<Receita>();
                for (String receitaKey : receitakeyArray) {
                    Receita receita = new Receita();

                    Resources res = context.getResources();
                    String packageName = context.getPackageName();
                    int id = res.getIdentifier(NAME_PREFIX + receitaKey, "string", packageName);
                    receita.name = context.getString(id);
                    receita.description = context.getString(context.getResources().getIdentifier(DESC_PREFIX + receitaKey, "string", context.getPackageName()));
                    receita.imageName = receitaKey.toLowerCase();
                    receitas.add(receita);
                }
            }
            return  receitas;
        }
    }

