package com.cis436.ewalletprototype.Report;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cis436.ewalletprototype.R;

import java.util.ArrayList;
import java.util.List;

public class ReportListAdapter extends ArrayAdapter<ReportSample> {

    private Context mContext;
    int mResource;

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

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tvCName = convertView.findViewById(R.id.contactName);
        TextView tvCPhone = convertView.findViewById(R.id.contactPhone);
        TextView tvCEmail = convertView.findViewById(R.id.contactEmail);
        TextView tvCCompany = convertView.findViewById(R.id.contactCompany);
        TextView tvSalesDate = convertView.findViewById(R.id.salesDate);
        TextView tvTransactionAmt = convertView.findViewById(R.id.transactionAmt);
        TextView tvTransactionId = convertView.findViewById(R.id.transactionId);

        tvCName.setText(contactName);
        tvCPhone.setText(contactPhone);
        tvCEmail.setText(contactEmail);
        tvCCompany.setText(contactCompany);
        tvSalesDate.setText(salesDate);
        tvTransactionAmt.setText(transactionAmt);
        tvTransactionId.setText(transactionId);

        return convertView;
    }
}
