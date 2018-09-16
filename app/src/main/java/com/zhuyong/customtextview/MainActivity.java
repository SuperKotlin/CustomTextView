package com.zhuyong.customtextview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_demo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_demo = (RecyclerView) findViewById(R.id.rv_demo);
        rv_demo.setLayoutManager(new LinearLayoutManager(this));
        rv_demo.setAdapter(new MyAdapter(this));
    }

    private class MyAdapter extends RecyclerView.Adapter {
        private Context mContext;

        public MyAdapter(Context mContext) {
            this.mContext = mContext;
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_demo, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holderParent, final int position) {
            final ViewHolder holder = (ViewHolder) holderParent;

            holder.ct_demo.setmText("角标" + position);
            if (position % 2 == 0) {
                holder.ct_demo.setmTextBgColor(ContextCompat.getColor(mContext, R.color.colorAccent));
            } else {
                holder.ct_demo.setmTextBgColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
            }
        }

        @Override
        public int getItemCount() {
            return 10;
        }

        private class ViewHolder extends RecyclerView.ViewHolder {
            private CustomTextView ct_demo;

            public ViewHolder(View itemView) {
                super(itemView);
                ct_demo = itemView.findViewById(R.id.ct_demo);
            }
        }
    }
}
