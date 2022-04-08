package com.example.scurfid6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterData2 extends RecyclerView.Adapter<AdapterData2.MyViewHolder> {

    private Context mContext2;
    private List<ModelClass> mData2;

    public AdapterData2(Context mContext2, List<ModelClass> mData2) {
        this.mContext2 = mContext2;
        this.mData2 = mData2;
    }

    @NonNull
    @Override
    public AdapterData2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext2);
        v = inflater.inflate(R.layout.bc_details_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.TABLE_NAME.setText(mData2.get(position).getTABLE_NAME());
        holder.BARCODE.setText(mData2.get(position).getBARCODE());
        holder.OLD_LOCATION2.setText(mData2.get(position).getOLD_LOCATION2());
        holder.STORAGE_LOCATION2.setText(mData2.get(position).getSTORAGE_LOCATION2());
        holder.OLD_LOCATION.setText(mData2.get(position).getOLD_LOCATION());
        holder.STORAGE_LOCATION.setText(mData2.get(position).getSTORAGE_LOCATION());
        holder.NEW_LOCATION.setText(mData2.get(position).getNEW_LOCATION());
        holder.STORAGE_AT.setText(mData2.get(position).getSTORAGE_AT());
        holder.CLIENT_ID.setText(mData2.get(position).getCLIENT_ID());
        holder.ORDER_STATE.setText(mData2.get(position).getORDER_STATE());
        holder.OBJECT_ID.setText(mData2.get(position).getOBJECT_ID());
        holder.SURAT_DATA_BARU.setText(mData2.get(position).getSURAT_DATA_BARU());
        holder.DATE_IN.setText(mData2.get(position).getDATE_IN());
        holder.DATE_OUT.setText(mData2.get(position).getDATE_OUT());
        holder.CODE_CHARGE.setText(mData2.get(position).getCODE_CHARGE());
        holder.CHECK_DATE.setText(mData2.get(position).getCHECK_DATE());
        holder.CHECK_BY.setText(mData2.get(position).getCHECK_BY());
        holder.MEDIUM.setText(mData2.get(position).getMEDIUM());
        holder.RFID.setText(mData2.get(position).getRFID());
        holder.LOCATION_INIT.setText(mData2.get(position).getLOCATION_INIT());



    }

    @Override
    public int getItemCount() {
        return mData2.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView TABLE_NAME;
        TextView BARCODE;
        TextView OLD_LOCATION2;
        TextView STORAGE_LOCATION2;
        TextView OLD_LOCATION;
        TextView STORAGE_LOCATION;
        TextView NEW_LOCATION;
        TextView STORAGE_AT;
        TextView CLIENT_ID;
        TextView ORDER_STATE;
        TextView OBJECT_ID;
        TextView SURAT_DATA_BARU;
        TextView DATE_IN;
        TextView DATE_OUT;
        TextView CODE_CHARGE;
        TextView CHECK_DATE;
        TextView CHECK_BY;
        TextView MEDIUM;
        TextView RFID;
        TextView LOCATION_INIT;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            TABLE_NAME = itemView.findViewById(R.id.table_name_txt);
            BARCODE = itemView.findViewById(R.id.barcode_txt);
            OLD_LOCATION2 = itemView.findViewById(R.id.old_location2_txt);
            STORAGE_LOCATION2 = itemView.findViewById(R.id.storage_location2_txt);
            OLD_LOCATION = itemView.findViewById(R.id.old_location_txt);
            STORAGE_LOCATION = itemView.findViewById(R.id.storage_location_txt);
            NEW_LOCATION = itemView.findViewById(R.id.new_location_txt);
            STORAGE_AT = itemView.findViewById(R.id.storage_at_txt);
            CLIENT_ID = itemView.findViewById(R.id.client_id_txt);
            ORDER_STATE = itemView.findViewById(R.id.order_state_txt);
            OBJECT_ID = itemView.findViewById(R.id.object_id_txt);
            SURAT_DATA_BARU = itemView.findViewById(R.id.surat_data_baru_txt);
            DATE_IN = itemView.findViewById(R.id.date_in_txt);
            DATE_OUT = itemView.findViewById(R.id.date_out_txt);
            CODE_CHARGE = itemView.findViewById(R.id.code_charge_txt);
            CHECK_DATE = itemView.findViewById(R.id.check_date_txt);
            CHECK_BY = itemView.findViewById(R.id.check_by_txt);
            MEDIUM = itemView.findViewById(R.id.medium_txt);
            RFID = itemView.findViewById(R.id.rfid_txt);
            LOCATION_INIT = itemView.findViewById(R.id.location_init_txt);
        }
    }
}
