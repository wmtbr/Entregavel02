package com.wmtbr.entregavel02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wmtbr.entregavel02.model.Receita;
import com.wmtbr.entregavel02.model.ReceitaManager;

import java.util.List;

public class Receitas_Activity extends Activity implements ItemClickListener {

        private RecyclerView mRecyclerView;
        private ReceitasAdapter mAdapter;
        private List<Receita> receita;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.seganda_activity);
            receita = ReceitaManager.getInstance(this.getApplicationContext()).getReceita();
            mRecyclerView = (RecyclerView)findViewById(R.id.lista);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());

            mAdapter = new ReceitasAdapter(receita, R.layout.row_receita, this);
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.setClickListener(this);
        }

        @Override
        public void onClick(View view, int position) {
            final Receita receitas = receita.get(position);
            Intent i = new Intent(this, ReceitaDetailActivity.class);
            i.putExtra("city", receitas.name);
            i.putExtra("desc", receitas.description);
            i.putExtra("image", receitas.imageName);
            startActivity(i);
        }
    }

