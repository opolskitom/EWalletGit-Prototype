package com.cis436.ewalletprototype.Report;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cis436.ewalletprototype.R;

import java.util.ArrayList;


public class ReportListAdapter extends ArrayAdapter<ReportSample> {

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    static class ViewHolder {
        TextView contactName;
        TextView contactPhone;
        TextView contactEmail;
        TextView contactCompany;
        TextView salesDate;
        TextView transactionAmt;
        TextView transactionId;

    }

    public ReportListAdapter(Context context, int resource, ArrayList<ReportSample> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get Report Information
        String contactName = getItem(position).getContactName();
        String contactPhone = getItem(position).getContactPhone();
        String contactEmail = getItem(position).getContactEmail();
        String contactCompany = getItem(position).getContactCompany();
        String salesDate = getItem(position).getSalesDate();
        String transactionAmt = getItem(position).getTransactionAmt();
        String transactionId = getItem(position).getTransactionId();

        //View result for showing animation
        final View result;

        //ViewHolder Object
        ViewHolder holder;

        //Loading few at a time
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource,parent,false);
            holder = new ViewHolder();
            holder.contactName = convertView.findViewById(R.id.contactName);
            holder.contactPhone = convertView.findViewById(R.id.contactPhone);
            holder.contactEmail = convertView.findViewById(R.id.contactEmail);
            holder.contactCompany = convertView.findViewById(R.id.contactCompany);
            holder.salesDate = convertView.findViewById(R.id.salesDate);
            holder.transactionAmt = convertView.findViewById(R.id.transactionAmt);
            holder.transactionId = convertView.findViewById(R.id.transactionId);

            result = convertView;

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        //Animation scrolling logic
        Animation animationScroll = AnimationUtils.loadAnimation(mContext,
                (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        Animation animationFade = AnimationUtils.loadAnimation(mContext, R.anim.fade_in_anim);
        animationFade.setFillBefore(true);

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(animationFade);
        animationSet.addAnimation(animationScroll);

        result.startAnimation(animationSet);
        lastPosition = position;

        holder.contactName.setText(contactName);
        holder.contactPhone.setText(contactPhone);
        holder.contactEmail.setText(contactEmail);
        holder.contactCompany.setText(contactCompany);
        holder.salesDate.setText(salesDate);
        holder.transactionAmt.setText(transactionAmt);
        holder.transactionId.setText(transactionId);

        return convertView;
    }
}
