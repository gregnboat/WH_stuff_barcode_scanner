package com.example.scurfid6;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scurfid6.apihelper.BaseApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private Context ctx;
    private List<DataModel> listUser;
    private List<DataModel> listData;
    private int idUser;

    public AdapterData(Context ctx, List<DataModel> listUser) {
        this.ctx = ctx;
        this.listUser = listUser;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = listUser.get(position);

        holder.tvId.setText(String.valueOf(dm.getId()));
        holder.tvName.setText(dm.getName());
        holder.tvPassword.setText(dm.getPassword());
        holder.tvUsername.setText(dm.getUsername());

    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvId, tvName, tvPassword, tvUsername;


        public HolderData(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_id);
            tvName = itemView.findViewById(R.id.tv_fn);
            tvPassword = itemView.findViewById(R.id.tv_password);
            tvUsername = itemView.findViewById(R.id.tv_username);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    AlertDialog.Builder dialogMessage = new AlertDialog.Builder(ctx);
                    dialogMessage.setMessage("Select what you want to do");
                    dialogMessage.setTitle("Attention");
                    dialogMessage.setIcon(R.mipmap.ic_launcher_round);
                    dialogMessage.setCancelable(true);

                    idUser = Integer.parseInt(tvId.getText().toString());

                    dialogMessage.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            deleteData();
                            dialogInterface.dismiss();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    ((OrganizeActivity) ctx).retrieveData();
                                }
                            }, 1000);

                        }
                    });


                    dialogMessage.setNegativeButton("Change", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            getData();
                            dialogInterface.dismiss();
                        }
                    });

                    dialogMessage.show();

                    return false;
                }
            });
        }

        private void deleteData() {
            BaseApiService ardData = RetroServer.connectRetrofit().create(BaseApiService.class);
            Call<ResponseModel> deleteData = ardData.ardDeleteData(idUser);

            deleteData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    int code = response.body().getCode();
                    String message = response.body().getMessage();

                    Toast.makeText(ctx, "Code : " + code + " | Message : " + message, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(ctx, "Failed to connect to Server : " + t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }

        private void getData() {
            BaseApiService ardData = RetroServer.connectRetrofit().create(BaseApiService.class);
            Call<ResponseModel> getData = ardData.ardGetData(idUser);

            getData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    int code = response.body().getCode();
                    String message = response.body().getMessage();
                    listData = response.body().getData();

                    int varIdData = listData.get(0).getId();
                    String varName = listData.get(0).getName();
                    String varUsername = listData.get(0).getUsername();
                    String varPassword = listData.get(0).getPassword();

                    //Toast.makeText(ctx, "Code : "+code+" | Message : "+message+ " | Data : " + ""+varIdData+ " | "+varName+ " | "+varUsername+ " | "+varPassword, Toast.LENGTH_SHORT).show();

                    Intent send = new Intent(ctx, ChangeActivity.class);
                    send.putExtra("xId", varIdData);
                    send.putExtra("xName", varName);
                    send.putExtra("xUsername", varUsername);
                    send.putExtra("xPassword", varPassword);
                    ctx.startActivity(send);
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(ctx, "Failed to connect to Server : " + t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
    }
}