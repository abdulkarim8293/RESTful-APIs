package com.abdulkarim.restfulapis;


import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdulkarim.restfulapis.user_model.User;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<User> userList;
    private Context context;


    public MyAdapter(List<User> userList, Context context){
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_user_recycler_view,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.MyViewHolder holder, final int position) {


        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        List<Address> addresses;

        double latitude = Double.valueOf(userList.get(position).getAddress().getGeo().getLat());
        double longitude  = Double.valueOf(userList.get(position).getAddress().getGeo().getLat());

        try {
            addresses = geocoder.getFromLocation(latitude,longitude,1);
            holder.location.setText(""+addresses.get(0).getFeatureName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        holder.name.setText(userList.get(position).getName());
        holder.email.setText(userList.get(position).getEmail());
        holder.userName.setText(userList.get(position).getUsername());
        holder.street.setText(userList.get(position).getAddress().getStreet());
        holder.suite.setText(userList.get(position).getAddress().getSuite());
        holder.city.setText(userList.get(position).getAddress().getCity());
        holder.zipCode.setText(userList.get(position).getAddress().getZipcode());
        holder.phone.setText(userList.get(position).getPhone());
        holder.website.setText(userList.get(position).getWebsite());
        holder.companyName.setText(userList.get(position).getCompany().getName());
        holder.companyCatchPhrase.setText(userList.get(position).getCompany().getCatchPhrase());
        holder.companyBs.setText(userList.get(position).getCompany().getBs());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name,email,userName,street,suite,city,zipCode,location,phone,website,companyName,companyCatchPhrase,companyBs;

        public MyViewHolder(@NonNull final View itemView) {

            super(itemView);

            name = itemView.findViewById(R.id.nameTextView);
            email = itemView.findViewById(R.id.userEmailTextView);
            userName = itemView.findViewById(R.id.userNameTextView);
            street = itemView.findViewById(R.id.userStreetTextView);
            suite = itemView.findViewById(R.id.userSuiteTextView);
            city = itemView.findViewById(R.id.userCityTextView);
            zipCode = itemView.findViewById(R.id.userZipCodeTextView);
            location = itemView.findViewById(R.id.userLocationTextView);
            phone = itemView.findViewById(R.id.userPhoneTextView);
            website = itemView.findViewById(R.id.userWebsiteTextView);
            companyName = itemView.findViewById(R.id.userCompanyNameTextView);
            companyCatchPhrase = itemView.findViewById(R.id.userCompanyCatchPhraseTextView);
            companyBs = itemView.findViewById(R.id.userCompanyBsTextView);

        }

    }


}
